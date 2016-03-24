package examples.controllers;


import examples.entity.StringSearchDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetBeanExample implements ICommandRequest {
    @Override
    public String executeCommand(HttpServletRequest request, HttpServletResponse response) {
        StringSearchDTO dto = new StringSearchDTO("test");

        return null;
    }
}
