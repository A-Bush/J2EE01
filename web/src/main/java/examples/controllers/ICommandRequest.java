package examples.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ICommandRequest {

    String executeCommand(HttpServletRequest request, HttpServletResponse response);
}
