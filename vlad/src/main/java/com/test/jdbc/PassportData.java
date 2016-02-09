package com.test.jdbc;

/**
 * Created by vladimir on 06.02.16.
 */
public class PassportData {
    private int id;
    private String first_two_numbers;
    private int last_numbers;
    private int inn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
