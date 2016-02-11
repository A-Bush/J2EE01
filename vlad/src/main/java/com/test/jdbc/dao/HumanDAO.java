package com.test.jdbc.dao;

import com.test.jdbc.model.Human;


/**
 * Created by vladimir on 10.02.16.
 */
public interface HumanDAO {
    void addHumanToDB(String firstName, String secondName, int age, double height, double weight);
    Human readHumanFromDB(long id);
    void updateHuman(long id,String firstName, String secondName, int age, double height, double weight);
    void deleteHumanFromDB(long id);
}
