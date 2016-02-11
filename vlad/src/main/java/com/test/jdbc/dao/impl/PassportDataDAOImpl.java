package com.test.jdbc.dao.impl;

import com.sun.corba.se.spi.orbutil.fsm.Guard;
import com.test.jdbc.dao.JDBCConnector;
import com.test.jdbc.model.PassportData;
import com.test.jdbc.dao.PassportDataDAO;
import org.springframework.core.JdkVersion;

import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vladimir on 10.02.16.
 */
public class PassportDataDAOImpl implements PassportDataDAO {

    @Override
    public void addPassportDataToDB(String firstTwoNumbers, int lastNumbers, int inn) {
        String sql = "INSERT INTO passport_data (first_two_numbers, last_numbers, inn) VALUES (?,?,?);";
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstTwoNumbers);
            preparedStatement.setInt(2, lastNumbers);
            preparedStatement.setInt(3, inn);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PassportData readPassportDataFromDB(long id) {
        String sql = "SELECT * FROM passport_data WHERE id=?";
        PassportData passportData = null;
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long passportId = resultSet.getLong("id");
                String firstTwoNumbers = resultSet.getString("first_two_numbers");
                int lastNumbers = resultSet.getInt("last_numbers");
                int inn = resultSet.getInt("inn");
                passportData = new PassportData(passportId, firstTwoNumbers, lastNumbers, inn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passportData;
    }

    @Override
    public void updatePassportData(long id, String firstTwoNumbers, int lastNumbers, int inn) {
        String sql = "UPDATE passport_data SET first_two_numbers=?,last_numbers=?,inn=? WHERE id=?";
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstTwoNumbers);
            preparedStatement.setInt(2, lastNumbers);
            preparedStatement.setInt(3, inn);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePassportDataFromDB(long id) {
        String sql = "DELETE FROM passport_data WHERE id=?";
        try (Connection connection = JDBCConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            boolean b = preparedStatement.execute();
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
