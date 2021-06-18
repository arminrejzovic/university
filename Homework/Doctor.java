package Homework;

import com.company.Date;

import java.util.Objects;

public class Doctor extends SalariedEmployee {
    private String specialization;
    private double office_fee;

    public Doctor(String theName, Date theDate, double theSalary, String specialization, double office_fee) {
        super(theName, theDate, theSalary);
        this.specialization = specialization;
        this.office_fee = office_fee;
    }

    public Doctor() {
        super();
        specialization = "None";
        office_fee = 0.0;
    }

    public Doctor(Doctor other) {
        super(other);
        this.specialization = other.specialization;
        this.office_fee = other.office_fee;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getOffice_fee() {
        return office_fee;
    }

    public void setOffice_fee(double office_fee) {
        this.office_fee = office_fee;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return office_fee==((Doctor) o).office_fee && specialization.equals(doctor.specialization);
    }

    public String toString() {
        return super.getName()+" MD, "+specialization;
    }
}
