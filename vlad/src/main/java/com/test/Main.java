package com.test;

/**
 * Created by vladimir on 27.01.16.
 */
public class Main {
    public static void main(String[] args) {

        EmployeeController employeeController = new EmployeeController();

        employeeController.listCreation();

        employeeController.writeIntoFile();

        employeeController.readFromFile("vlad/Employees.txt");

        System.out.println(employeeController.counteringOfDuplicates());
        System.out.println(employeeController.countUniqueEmployees());

        System.out.println(employeeController.sumOfSalaries());

        employeeController.writeToAnotherFile();

        EmployeeJava8 employeeJava8 = new EmployeeJava8();
        employeeJava8.readFromFile();
    }
}
