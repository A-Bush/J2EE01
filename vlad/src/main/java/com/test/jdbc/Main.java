package com.test.jdbc;

import com.test.jdbc.dao.impl.HumanDAOImpl;
import com.test.jdbc.dao.impl.PassportDataDAOImpl;

/**
 * Created by vladimir on 10.02.16.
 */
public class Main {
    public static void main(String[] args) {
        PassportDataDAOImpl passportDataDAO = new PassportDataDAOImpl();
        //passportDataDAO.addPassportDataToDB("ME", 525412, 568976533);
        //passportDataDAO.updatePassportData(3, "DE", 3335566, 987456123);
        //passportDataDAO.deletePassportDataFromDB(4);
    }
}
