package examples.servlets;

import com.jdbc.dao.CrudGeneralDao;
import com.jdbc.dao.HumanDaoImpl;
import com.jdbc.entity.Human;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HumanServlet extends HttpServlet {
    CrudGeneralDao<Long, Human> dao;

    @Override
    public void init() {
        dao = new HumanDaoImpl();
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> queryString = getQueryMap(request.getQueryString());
        if (!queryString.isEmpty()) {
            List<Human> humans = getHumanById(Long.valueOf(queryString.get("id")));
            request.setAttribute("human", humans);
            request.getRequestDispatcher("jsp/human.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("html/hello.html")
                    .forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        saveHuman(request);

        request.getRequestDispatcher("html/hello.html")
                .forward(request, response);
    }

    public List<Human> getHumanById(Long id) {
        return dao.select(id);
    }

    public void saveHuman(HttpServletRequest request) {
        Human human = new Human();
        human.setName(request.getParameter("name"));
        human.setLastName(request.getParameter("lastName"));
        human.setAge(Integer.parseInt(request.getParameter("age")));
        human.setHeight(Double.parseDouble(request.getParameter("height")));
        human.setWeight(Double.parseDouble(request.getParameter("weight")));
        dao.insert(human);
    }

    public static Map<String, String> getQueryMap(String query) {
        if (query == null) return Collections.emptyMap();
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    public void destroy() {
        // do nothing.
    }
}
