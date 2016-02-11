package com.test.jdbc.dao.impl;

import com.test.jdbc.dao.HumanDAO;
import com.test.jdbc.dao.JDBCConnector;
import com.test.jdbc.model.Human;

import java.sql.*;

/**
 * Created by vladimir on 10.02.16.
 */
public class HumanDAOImpl implements HumanDAO {

    @Override
    public void addHumanToDB(String firstName, String secondName, int age, double height, double weight) {
        String sql = "INSERT INTO human (first_name,second_name,age,height,weight) VALUES(?,?,?,?,?);";
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setInt(3, age);
            preparedStatement.setDouble(4, height);
            preparedStatement.setDouble(5, weight);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Human readHumanFromDB(long id) {
        String sql = "SELECT * FROM human WHERE id=?";
        Human human = null;
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long humanId = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                int age = resultSet.getInt("age");
                double height = resultSet.getDouble("height");
                double weight = resultSet.getDouble("weight");
                human = new Human(humanId, firstName, secondName, age, height, weight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return human;
    }

    @Override
    public void updateHuman(long id, String firstName, String secondName, int age, double height, double weight) {
        String sql = "UPDATE human SET first_name=?,second_name=?,age=?,height=?,weight=? WHERE id=?;";
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setInt(3, age);
            preparedStatement.setDouble(4, height);
            preparedStatement.setDouble(5, weight);
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHumanFromDB(long id) {
        String sql = "DELETE FROM human  WHERE id=?;";
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
