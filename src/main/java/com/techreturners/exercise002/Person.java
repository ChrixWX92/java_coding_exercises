package com.techreturners.exercise002;

public class Person {

    private final String name;
    private final String occupation;
    private final String city;
    private final int age;

    public Person(String name, String occupation, String city, int age) {
        this.name = name;
        this.occupation = occupation;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCity() { return city; }

    public int getAge() { return age; }

}