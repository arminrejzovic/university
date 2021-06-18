package com.company;

public class Employee {
    private String name;
    private int age;
    private String position;

    public Employee(String name, int age, String position) {
        this.name = name;

        if (age<0){
            System.out.println("Error, age can't be negative");
            System.exit(0);
        }
        else{
            this.age = age;
        }
        this.position = position;
    }

    public Employee(){
        name = "n/a";
        age = 0;
        position = "n/a";
    }

    public Employee(String name) {
        this.name = name;
        this.age = 0;
        position = "n/a";
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
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", age: " + age +
                ", position: " + position + '\'';
    }
}
