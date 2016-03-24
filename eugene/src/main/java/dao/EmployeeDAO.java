package dao;

import model.Employee;

import java.util.Collection;

public interface EmployeeDAO {
    void save(Employee employee);

    void delete(Long id);

    void update(Employee employee);

    Employee get(Long id);

    Collection<Employee> getAll();
}
