package com.test.io_java8;

/**
 * Created by vladimir on 27.01.16.
 */
public class Employee {

    private String name;
    private String surName;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String surName, int salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
