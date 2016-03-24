package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "department")
    private String department;

    @Column(name = "email")
    private String email;

    public Employee(String firstname, String lastname, LocalDate birthday, Integer salary, String department, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthday;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }

    public Employee(Long id, String firstname, String lastname, LocalDate birthday, Integer salary, String department, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthday;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }

    public Employee(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthdate;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthdate = birthday;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
