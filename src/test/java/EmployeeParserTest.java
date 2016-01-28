import org.junit.Test;
import webcamp.j2ee01.entity.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeParserTest {


    @Test
    public void testReadEmployeeFileStream() {
        try {
            Map<Employee, Long> sum = Files.readAllLines(Paths.get("src/test.txt"))
                    .stream()
                    .map(s -> s.split("[\\p{Punct}\\s]+"))
                    .map(array -> new Employee(array[0], array[1],
                            Integer.parseInt(array[2]), Double.parseDouble(array[3])))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something get wrong " + e.getMessage());
        }
    }

    @Test
    public void testMethodReference() {
        try {
            List<Employee> employee = Files.readAllLines(Paths.get("src/test.txt"))
                    .stream()
                    .map(line -> line.split("[\\p{Punct}\\s]+"))
                    .map(array -> new Employee(array[0], array[1],
                            Integer.parseInt(array[2]), Double.parseDouble(array[3])))
                    .collect(Collectors.toList());
            employee.stream().forEach(System.out::println);
            employee.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testReadEmployeeFileLoop() {
        try {
            List<String> strings = Files.readAllLines(Paths.get("src/test.txt"));
            List<Employee> employees = new ArrayList<>();
            for (String line : strings) {
                String[] array = line.split("[\\p{Punct}\\s]+");
                Employee employee = new Employee(array[0], array[1],
                        Integer.parseInt(array[2]), Double.parseDouble(array[3]));
                employees.add(employee);
            }
            System.out.println(employees);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something get wrong " + e.getMessage());
        }
    }

}
