package com.test.jdbc.model;

import java.sql.Timestamp;

/**
 * Created by vladimir on 04.02.16.
 */
public class Human {
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private double height;
    private double weight;
    private Timestamp created_date;

    public Human() {}

    public Human(Long id, String name, String secondName, int age, double height, double weight) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", created_date=" + created_date +
                '}';
    }
}
