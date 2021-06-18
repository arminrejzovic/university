package Homework;

import javax.print.Doc;

public class Billing {
    private Patient patient;
    private Doctor doctor;
    private double due;

    private static double income;

    public Billing(Patient patient, Doctor doctor, double due) {
        this.patient = new Patient(patient);
        this.doctor = new Doctor(doctor);
        this.due = due;
    }

    public Billing() {
        patient = new Patient();
        doctor = new Doctor();
        due=0.0;
    }

    public Patient getPatient() {
        return new Patient(patient);
    }

    public void setPatient(Patient patient) {
        this.patient = new Patient(patient);
    }

    public Doctor getDoctor() {
        return new Doctor(doctor);
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = new Doctor(doctor);
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        if (due>=0){
            this.due = due;
            income+=due;
        }
        else {
            System.out.println("Error: Due amount cannot be negative");
            System.exit(0);
        }
    }

    public void calculateDue(){
        setDue(this.doctor.getOffice_fee());
    }

    public static double getIncome(){
        return income;
    }

    @Override
    public String toString() {
        return "BILLING: " +
                "Patient: " + patient +
                ", Doctor: " + doctor +
                ", due=" + due;
    }
}
