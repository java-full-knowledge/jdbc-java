package com.jfk.entity;


/**
 * @author William Arustamyan
 */


public class Employee extends BaseEntity {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
