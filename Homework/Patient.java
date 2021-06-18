package Homework;

import java.util.Objects;

public class Patient extends Person {
    private Doctor physician;

    public Patient(String name, Doctor physician) {
        super(name);
        this.physician = new Doctor(physician);
    }

    public Patient() {
        super();
        physician = new Doctor();
    }

    public Patient(Patient other) {
        super(other);
        this.physician = new Doctor(other.physician);
    }

    public Doctor getPhysician() {
        return new Doctor(physician);
    }

    public void setPhysician(Doctor physician) {
        this.physician = new Doctor(physician);
    }

    public String toString() {
        return "Patient " + super.toString()+ ", Physician: " + physician;


    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return physician.equals(((Patient) o).physician);
    }

}


