package examples.servlets;


import examples.controllers.FactoryController;
import examples.controllers.ICommandRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "main", value = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html/userform.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("command");
        ICommandRequest command = FactoryController.getController(value);

        String getUrl = command.executeCommand(request, response);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(getUrl);
        dispatcher.forward(request, response);
    }
}
