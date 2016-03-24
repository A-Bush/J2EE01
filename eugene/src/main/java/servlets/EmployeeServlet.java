package servlets;

import dao.EmployeeDAOImpl;
import model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/", "/employees"})
public class EmployeeServlet extends HttpServlet{

    private EmployeeDAOImpl employeeDAOimpl;

    @Override
    public void init() throws ServletException {
        employeeDAOimpl = new EmployeeDAOImpl();
        employeeDAOimpl.save(new Employee("Eugene", "Deyneka", LocalDate.of(1992, 12, 26), 15000, "IT","deyneko55@gmail.com"));
        employeeDAOimpl.save(new Employee("Eugene", "Deyneka", LocalDate.of(1992, 12, 26), 15000, "IT","deyneko55@gmail.com"));
        employeeDAOimpl.save(new Employee("Eugene", "Deyneka", LocalDate.of(1992, 12, 26), 15000, "IT","deyneko55@gmail.com"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = (req.getParameter("id")).isEmpty() ? 0 : Long.parseLong(req.getParameter("id"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        String department = req.getParameter("department");
        String email = req.getParameter("email");

        if (id == 0) {
            employeeDAOimpl.save(new Employee(firstname, lastname, birthday, salary, department, email));
        } else {
            employeeDAOimpl.update(new Employee(id, firstname, lastname, birthday, salary, department, email));
        }

        resp.sendRedirect("employees");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null){
            Long employeeID = Long.parseLong(req.getParameter("id"));
            switch (action) {
                case "delete":
                    employeeDAOimpl.delete(employeeID);
                    resp.sendRedirect("employees");
                    break;
                case "update":
                    Employee updatedEmployee = employeeDAOimpl.get(employeeID);
                    req.setAttribute("updatedEmployee", updatedEmployee);
                    req.setAttribute("employeeList", employeeDAOimpl.getAll());
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
            }
        } else {
            req.setAttribute("employeeList", employeeDAOimpl.getAll());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
