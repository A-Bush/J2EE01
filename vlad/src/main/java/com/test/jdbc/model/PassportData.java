package com.test.jdbc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 06.02.16.
 */
public class PassportData {
    private long id;
    private String first_two_numbers;
    private int last_numbers;
    private int inn;

    public PassportData() {
    }

    public PassportData(long id, String first_two_numbers, int last_numbers, int inn) {
        this.id = id;
        this.first_two_numbers = first_two_numbers;
        this.last_numbers = last_numbers;
        this.inn = inn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_two_numbers() {
        return first_two_numbers;
    }

    public void setFirst_two_numbers(String first_two_numbers) {
        this.first_two_numbers = first_two_numbers;
    }

    public int getLast_numbers() {
        return last_numbers;
    }

    public void setLast_numbers(int last_numbers) {
        this.last_numbers = last_numbers;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "id=" + id +
                ", first_two_numbers='" + first_two_numbers + '\'' +
                ", last_numbers=" + last_numbers +
                ", inn=" + inn +
                '}';
    }
}
