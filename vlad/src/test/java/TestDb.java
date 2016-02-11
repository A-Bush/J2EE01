import com.test.jdbc.model.Human;
import com.test.jdbc.model.PassportData;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 09.02.16.
 */

public class TestDb {
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/test_test";

    @Test
    public void testDBParsingPassport() {
        String sql = "SELECT * FROM passport_data";
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ArrayList<PassportData> passportDatas = new ArrayList<>();

            while (resultSet.next()) {
                PassportData ps = new PassportData();
                ps.setId(resultSet.getInt("id"));
                ps.setFirst_two_numbers(resultSet.getString("first_two_numbers"));
                ps.setLast_numbers(resultSet.getInt("last_numbers"));
                ps.setInn(resultSet.getInt("inn"));
                passportDatas.add(ps);
            }
            System.out.println(passportDatas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDbConnectionStatement() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        String sql = "SELECT * FROM human";
        Statement statement = connection.createStatement();

        Statement statement1 = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        List<Human> humanList = new ArrayList<>();
        while (resultSet.next()) {
            Human human = new Human();
            human.setId(resultSet.getLong("id"));
            human.setName(resultSet.getString("first_name"));
            human.setSecondName(resultSet.getString("second_Name"));
            human.setAge(resultSet.getInt("age"));
            human.setHeight(resultSet.getDouble("height"));
            human.setWeight(resultSet.getDouble("weight"));
            humanList.add(human);
        }
        System.out.println(humanList);
    }
}
