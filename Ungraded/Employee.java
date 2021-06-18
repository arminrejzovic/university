package Ungraded;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;
    private String designation;


    public Employee(int id, String name, double salary, String department, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.designation = designation;
    }

    public Employee() {
        id=0;
        name = "No name";
        salary = 0.0;
        department = "No department";
        designation = "No designation";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        return Objects.equals(designation, employee.designation);
    }

    @Override
    public String toString() {
        return  "ID:" + id +
                ", Name: " + name +
                ", Salary: " + salary +
                ", Department: " + department +
                ", Designation: " + designation;
    }

    public void displayEmployee(){
        System.out.println("EMPLOYEE DETAILS:\n" + this.toString());
    }

    public double addBonus(){
        int bonus = 200;
        return this.salary+bonus;
    }

}
