package com.test;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by vladimir on 28.01.16.
 */
public class EmployeeController {

    private ArrayList<Employee> employeeArrayList;
    private ArrayList<String> listFromFile;

    // creating ArrayList
    public void listCreation() {
        employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Vasia", "Pupkin", 4500));
        employeeArrayList.add(new Employee("Kolia", "Zopkin", 5000));
        employeeArrayList.add(new Employee("Mulia", "Sumkin", 5500));
        employeeArrayList.add(new Employee("Mawa", "Gavri4", 6500));
        employeeArrayList.add(new Employee("Galia", "Su", 4000));
        employeeArrayList.add(new Employee("Samara", "Klin", 8000));
        employeeArrayList.add(new Employee("Hi", "Kilogram", 7000));
        employeeArrayList.add(new Employee("Vasia", "Pupkin", 4500));
        employeeArrayList.add(new Employee("Vasia", "Pupkin", 4500));
        employeeArrayList.add(new Employee("Jim", "Puskin", 2500));
        employeeArrayList.add(new Employee("Jimbo", "Pushkin", 10000));
        employeeArrayList.add(new Employee("Vano", "Pupkin", 4500));
        employeeArrayList.add(new Employee("Ogogo", "Lolipop", 7500));
        employeeArrayList.add(new Employee("Ololo", "Emocii", 1500));
    }

    // write array list into file
    public void writeIntoFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("vlad/Employees.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            for (Employee employee : employeeArrayList) {
                bufferedWriter.write(employee.getName() + " : " + employee.getSurName() + " : " + employee.getSalary() + "\r\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read from file
    public void readFromFile(String fileName) {
        listFromFile = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (bufferedReader.ready()) {
                listFromFile.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Count duplicates
    public Integer counteringOfDuplicates() {
        int counter = 0;
        ArrayList<String> tmpList = new ArrayList();

        for (Employee employee : getEmployeeArrayList()) {
            String employeeString = employee.getName() + " : " + employee.getSurName() + " : " + employee.getSalary();
            tmpList.add(employeeString);
        }
        //   ArList - String(From File)
        //   ArList - String(from EmployeeList)

        for (String string : tmpList) {
            counter = 0;
            for (String innerString : getListFromFile()) {

                if (string.equals(innerString)) {
                    counter++;
                }

            }
            if (counter > 1) {
                return counter; // 3
            }
        }
        return counter;
    }
    // count unique lines
    public Integer countUniqueEmployees() {
        int counter = 0;
        ArrayList<String> tmpList = new ArrayList();

        for (Employee employee : getEmployeeArrayList()) {
            String employeeString = employee.getName() + " : " + employee.getSurName() + " : " + employee.getSalary();
            tmpList.add(employeeString);
        }

        for (String string : tmpList) {
            counter = 0;
            for (String innerString : getListFromFile()) {

                if (!string.equals(innerString)) {
                    counter++;
                }

            }
            if (counter > 1) {
                return counter; // 3
            }
        }
        return counter;
    }

    // Count sum
    public int sumOfSalaries() {
        int sum = 0;
        for (int i = 0; i < listFromFile.size(); i++) {
            sum += Integer.parseInt(listFromFile.get(i).split(" : ")[2]);
        }
        return sum;
    }

    // read From File and Write to another File
    public void writeToAnotherFile() {
        try (FileInputStream fileInputStream = new FileInputStream("vlad/Employees.txt")) {
            FileOutputStream fileOutputStream = new FileOutputStream("vlad/Employees2.txt");
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public ArrayList<String> getListFromFile() {
        return listFromFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeController that = (EmployeeController) o;

        if (employeeArrayList != null ? !employeeArrayList.equals(that.employeeArrayList) : that.employeeArrayList != null)
            return false;
        return listFromFile != null ? listFromFile.equals(that.listFromFile) : that.listFromFile == null;

    }

    @Override
    public int hashCode() {
        int result = employeeArrayList != null ? employeeArrayList.hashCode() : 0;
        result = 31 * result + (listFromFile != null ? listFromFile.hashCode() : 0);
        return result;
    }
}
