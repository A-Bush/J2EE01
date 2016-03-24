package examples.controllers;


import examples.entity.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements ICommandRequest {
    @Override
    public String executeCommand(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        UserDTO user = new UserDTO(name, lastName);
        request.setAttribute("user", user);
        return "/jsp/user.jsp";
    }
}
