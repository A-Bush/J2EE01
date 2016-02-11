package com.test.jdbc.dao;

import com.test.jdbc.model.PassportData;

/**
 * Created by vladimir on 10.02.16.
 */
public interface PassportDataDAO {
    void addPassportDataToDB(String firstTwoNumbers, int lastNumbers, int inn);
    PassportData readPassportDataFromDB(long id);
    void updatePassportData(long id, String firstTwoNumbers, int lastNumbers, int inn);
    void deletePassportDataFromDB(long id);
}
