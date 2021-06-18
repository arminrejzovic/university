package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Student {
    private int quiz1;
    private int quiz2;
    private int quiz3;
    private int midterm;
    private int finalExam;
    private int overallScore;
    private char letterGrade;

    public Student(int quiz1, int quiz2, int quiz3, int midterm, int finalExam, int overallScore, char letterGrade) {
        setQuiz1(quiz1);
        setQuiz2(quiz2);
        setQuiz3(quiz3);
        setMidterm(midterm);
        setFinalExam(finalExam);
        setOverallScore(overallScore);
        setLetterGrade(letterGrade);
    }

    public Student() {
        quiz1 = 0;
        quiz2 = 0;
        quiz3 = 0;
        midterm = 0;
        finalExam = 0;
        overallScore = 0;
        letterGrade = 'F';
    }

    public int getQuiz1() {
        return quiz1;
    }

    public int getQuiz2() {
        return quiz2;
    }

    public int getQuiz3() {
        return quiz3;
    }

    public int getMidterm() {
        return midterm;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setQuiz1(int quiz1) {
        if (quiz1>=0 && quiz1<=10){
            this.quiz1 = quiz1;
        }
        else {
            System.out.println("Error: Quiz grade must be between 0 and 10");
            System.exit(0);
        }
    }

    public void setQuiz2(int quiz2) {
        if (quiz2>=0 && quiz2<=10){
            this.quiz2 = quiz2;
        }
        else {
            System.out.println("Error: Quiz grade must be between 0 and 10");
            System.exit(0);
        }
    }

    public void setQuiz3(int quiz3) {
        if (quiz3>=0 && quiz3<=10){
            this.quiz3 = quiz3;
        }
        else {
            System.out.println("Error: Quiz grade must be between 0 and 10");
            System.exit(0);
        }
    }

    public void setMidterm(int midterm) {
        if (midterm>=0 && midterm<=100){
            this.midterm = midterm;
        }
        else {
            System.out.println("Error: Midterm grade must be between 0 and 100");
            System.exit(0);
        }
    }

    public void setFinalExam(int finalExam) {
        if (finalExam>=0 && finalExam<=100){
            this.finalExam = finalExam;
        }
        else {
            System.out.println("Error: Final exam grade must be between 0 and 100");
            System.exit(0);
        }
    }

    public void setOverallScore(int overallScore) {
        if (overallScore>=0 && overallScore<=100){
            this.overallScore = overallScore;
        }
        else {
            System.out.println("Error: Overall score must be between 0 and 100");
            System.exit(0);
        }
    }

    public void setLetterGrade(char letterGrade) {
        if (letterGrade=='A' || letterGrade=='B' || letterGrade=='C' || letterGrade=='D' || letterGrade=='F'){
            this.letterGrade = letterGrade;
        }
        else{
            System.out.println("Error: Letter grade must be either A, B, C, D or F");
        }
    }

    private void calculateOverallScore(){
        double overall;
        overall=((quiz1+quiz2+quiz3)/30.0)*25+(midterm/100.0)*35+(finalExam/100.0)*40;
        setOverallScore((int)overall);
    }

    private void calculateLetterGrade(){
        if (overallScore>=90){
            setLetterGrade('A');
        }
        else if (overallScore>=80){
            setLetterGrade('B');
        }
        else if (overallScore>=70){
            setLetterGrade('C');
        }
        else if (overallScore>=60){
            setLetterGrade('D');
        }
        else {
            setLetterGrade('F');
        }
    }

    @Override
    public String toString() {
        return "STUDENT REPORT: " +
                "Quiz 1: " + quiz1 +
                ", Quiz 2: " + quiz2 +
                ", Quiz 3: " + quiz3 +
                ", Midterm: " + midterm +
                ", Final Exam: " + finalExam +
                ", Overall Score: " + overallScore +
                ", Letter Grade: " + letterGrade;
    }

    public boolean equals(Student student) {
        if (student==null) return false;
        else{
            return (quiz1==student.quiz1 && quiz2==student.quiz2 && quiz3==student.quiz3 && midterm==student.midterm
                    && finalExam==student.finalExam && overallScore==student.overallScore && letterGrade==student.letterGrade);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setQuiz1(7);
        student1.setQuiz2(5);
        student1.setQuiz3(8);
        student1.setMidterm(90);
        student1.setFinalExam(75);
        student1.calculateOverallScore();
        student1.calculateLetterGrade();

        System.out.println(student1);

        Student student2 = new Student(7,5,8,90,75,78,'C');

        if (student1.equals(student2)){
            System.out.println("Student1 and Student 2 are equal");
        }

        Student student3 = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Quiz1 score: ");
        student3.setQuiz1(scanner.nextInt());
        System.out.println("Input Quiz2 score: ");
        student3.setQuiz2(scanner.nextInt());
        System.out.println("Input Quiz3 score: ");
        student3.setQuiz3(scanner.nextInt());
        System.out.println("Input Midterm score: ");
        student3.setMidterm(scanner.nextInt());
        System.out.println("Input Final exam score: ");
        student3.setFinalExam(scanner.nextInt());

        student3.calculateOverallScore();
        student3.calculateLetterGrade();

        System.out.print(student3);

    }

}
