package com.test.io_java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by vladimir on 29.01.16.
 */
public class EmployeeJava8 {

    public void readFromFile() {
        try {
            Files.readAllLines(Paths.get("vlad/Employees.txt")).stream()
                    .map(s -> s.split(":"))
                    .map(array -> new Employee(array[0], array[1], Integer.parseInt(array[3])));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            Map<Employee, Long> sum = Files.readAllLines(Paths.get("vlad/Employees.txt"))
//                    .stream()
//                    .map(s -> s.split("[\\p{Punct}\\s]+"))
//                    .map(array -> new Employee(array[0], array[1],
//                            Integer.parseInt(array[2])))
//                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//            System.out.println(sum);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Something get wrong " + e.getMessage());
//        }
    }
}
