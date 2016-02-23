package TaskOne;

import entity.Human;
import entity.PassportData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLTaskOne {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/employees";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            sql = "SELECT * FROM humans;";
            resultSet = statement.executeQuery(sql);
            List<Human> humansList = new ArrayList<>();
            while (resultSet.next())
            {
                Human human = new Human();
                human.setId(resultSet.getLong("id"));
                human.setLastName(resultSet.getString("lastName"));
                human.setFirstName(resultSet.getString("firstName"));
                human.setAge(resultSet.getInt("age"));
                human.setHeight(resultSet.getDouble("height"));
                human.setWeight(resultSet.getDouble("weight"));
                human.setPassport(resultSet.getInt("passport"));
                humansList.add(human);
            }
            sql = "SELECT * FROM passport_data;";
            resultSet = statement.executeQuery(sql);
            List<PassportData> passport_dataList = new ArrayList<>();
            while (resultSet.next()) {
                PassportData passport = new PassportData();
                passport.setId(resultSet.getLong("id"));
                passport.setPassportFirstTwoNumber(resultSet.getString("first_two_num"));
                passport.setPassportLastNumber(resultSet.getInt("last_num"));
                passport.setInnCode(resultSet.getInt("inn"));
                passport_dataList.add(passport);
            }
            System.out.println(humansList);
            System.out.println(passport_dataList);
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
