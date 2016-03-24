package examples.servlets;


import examples.entity.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class LoginFilter implements Filter {
    private final String userID = "admin";
    private final String password = "password";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        UserDTO dto = new UserDTO();
        if(userID.equals(user) && password.equals(pwd)){
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            session.setAttribute("user", "Pankaj");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
        }else{
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
