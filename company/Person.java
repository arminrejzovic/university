package com.company;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

        setName(name);
        setAge(age);

    }

    public Person() {
        this.name = "John Doe";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>0){
            this.age = age;
        }
        else {
            System.out.println("Age cannot be negative");
            System.exit(1);
        }
    }

    @Override
    public String toString() {
        return  "Name: " + name +
                ", age: " + age;
    }

    public boolean equals(Person p) {
        if (p==null)
            return false;
        else
            return (p.name.equals(this.name) && p.age==this.age);
    }
}
