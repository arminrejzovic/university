package Homework;

import java.util.Objects;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        name = "No name";
    }

    public Person(Person other) {
        this.name = other.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        Person person = (Person) otherObject;
        return name.equals(person.name);
    }
}
