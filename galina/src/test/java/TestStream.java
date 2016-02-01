import org.junit.Test;
import webcamp.j2ee01.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by randriyanov on 28.01.16.
 */
public class TestStream {
    //get List of uniq records
    @Test
    public void testGetUniqRecords(){
        try (Stream<String> stream = Files.lines(Paths.get("employees.txt"))) {
            List<String> uniqRecords = stream.distinct().collect(Collectors.toList());
            System.out.println(uniqRecords);
        } catch (IOException b) {
            System.out.println("IOException when getting Uniq Records in testing");
        }
    }

    //count salary including dublicated
    @Test
    public void testCountSalary() {
        try {
            double salary = Files.readAllLines(Paths.get("employees.txt"))
                    .stream()
                    .map((line) -> line.split(":"))
                    .map((array) -> new Employee(array[0], array[1],
                            Integer.parseInt(array[2]), Double.parseDouble(array[3])))
                    .collect(Collectors.toList())
                    .stream()
                    .mapToDouble((e) -> e.getSalary()).sum();
            System.out.println(salary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //deleting dublicates and write to new file
    @Test
    public void testWriteUniqToFile() {
        try(FileWriter fos = new FileWriter("uniqlines.txt", false)) {
            Files.readAllLines(Paths.get("employees.txt"))
                    .stream()
                    .distinct()
                    .forEach((line) -> {
                        try {
                            fos.write(line);
                            fos.write("\n");
                        } catch (IOException e) {
                            System.out.println("Inner exception in testWriteUniqToFile");
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO count dublicated records
    @Test
    public void testCountDublicated() {
        try{
            Files.readAllLines(Paths.get("employees.txt"))
                    .stream()
                    .collect(Collectors.groupingBy(Function.<String>identity(), Collectors.counting()));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
