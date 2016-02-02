import com.test.Employee;
import com.test.EmployeeController;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by vladimir on 30.01.16.
 */
public class TestEmployeeController {

    @Test
    public void ifSumIsCool() {
        EmployeeController employeeController = new EmployeeController();
        employeeController.readFromFile("/home/vladimir/Documents/j2ee/J2EE01/vlad/Employees.txt");
        int result = employeeController.sumOfSalaries();
        Assert.assertEquals(75500, result);
    }
    @Test
    public void ifListIsCreatedTest() {
        EmployeeController employeeController = new EmployeeController();
        employeeController.listCreation();

        ArrayList<Employee> result = employeeController.getEmployeeArrayList();

//        result.add(new Employee("Vasia", "Pupkin", 4500));
//        result.add(new Employee("Kolia", "Zopkin", 5000));
//        result.add(new Employee("Mulia", "Sumkin", 5500));
//        result.add(new Employee("Mawa", "Gavri4", 6500));
//        result.add(new Employee("Galia", "Su", 4000));
//        result.add(new Employee("Samara", "Klin", 8000));
//        result.add(new Employee("Hi", "Kilogram", 7000));
//        result.add(new Employee("Vasia", "Pupkin", 4500));
//        result.add(new Employee("Vasia", "Pupkin", 4500));
//        result.add(new Employee("Jim", "Puskin", 2500));
//        result.add(new Employee("Jimbo", "Pushkin", 10000));
//        result.add(new Employee("Vano", "Pupkin", 4500));
//        result.add(new Employee("Ogogo", "Lolipop", 7500));
//        result.add(new Employee("Ololo", "Emocii", 1500));
        Assert.assertTrue(CollectionUtils.isEqualCollection(result, employeeController.getEmployeeArrayList()));
    }
}
