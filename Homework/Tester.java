package Homework;

import com.company.Date;

import javax.print.Doc;

import static Homework.Billing.getIncome;

public class Tester {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("Gregory House",new Date("January",10,2003),100,"Infectologist",50);
        Doctor doctor2 = new Doctor("Eric Foreman",new Date("February",20,2005),80,"Neurologist",40);
        Doctor doctor3 = new Doctor("James Wilson",new Date("March",15,2004),90,"Oncologist",45);

        Patient patient1 = new Patient("Michael Tritter",doctor1);
        Patient patient2 = new Patient("Derek Hoyt",doctor2);
        Patient patient3 = new Patient("Tucker",doctor3);

        Billing billing1 = new Billing(patient1,doctor1,0);
        billing1.calculateDue();

        Billing billing2 = new Billing(patient2,doctor2,0);
        billing2.calculateDue();

        Billing billing3 = new Billing(patient3,doctor3,0);
        billing3.calculateDue();

        System.out.println(doctor1+"\n");
        System.out.println(patient1+"\n");
        System.out.println(billing1+"\n");

        System.out.println("Other Billings:\n"+billing2+"\n"+billing3+"\n");

        System.out.println("Total clinic earnings: "+ getIncome());

        System.out.println("*****************");

        Patient patient4 = new Patient(patient2);
        patient4.setPhysician(doctor1);

        if (patient2.equals(patient4)){
            System.out.println("The patient files patient2 and patient4 are identical");
        }
        else{
            System.out.println("The patient files patient2 and patient4 are different");
        }

        Doctor doctor4 = new Doctor(doctor2);
        doctor4.setName("Robert Chase");
        doctor4.setSpecialization("Surgeon");

        if (doctor2.equals(doctor4)){
            System.out.println("The doctor files doctor2 and doctor4 are identical");
        }
        else{
            System.out.println("The patient files doctor2 and doctor4 are different");
        }

    }
}
