package examples.servlets;

import com.jdbc.dao.CrudGeneralDao;
import com.jdbc.dao.HumanDaoImpl;
import com.jdbc.entity.Human;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloWorld extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("html/hello.html")
               .forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException{
        saveHuman(request);

        request.getRequestDispatcher("html/hello.html")
                .forward(request, response);
    }

    public void saveHuman(HttpServletRequest request) {
        Human human = new Human();
        human.setName(request.getParameter("name"));
        human.setLastName(request.getParameter("lastName"));
        human.setAge(Integer.parseInt(request.getParameter("age")));
        human.setHeight(Double.parseDouble(request.getParameter("height")));
        human.setWeight(Double.parseDouble(request.getParameter("weight")));
        CrudGeneralDao<String, Human> dao = new HumanDaoImpl();
        dao.insert(human);
    }

    public void destroy() {
        // do nothing.
    }
}
