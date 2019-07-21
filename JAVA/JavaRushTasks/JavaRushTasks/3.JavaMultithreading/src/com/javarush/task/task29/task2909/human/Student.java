package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private double averageGrade;
//   private String university;
    private Date beginningOfSession;
    private Date endOfSession;

    private int course;


    public Student(String name, int age, double averageGrade) {
        super(name, age);
/*        this.name = name;
        this.age = age;*/
        this.averageGrade = averageGrade;
    }

    @Override
    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

    public String getPosition() {
        return "Студент";
    }
    
/*
    public void printData() {
        System.out.println(getPosition() +": " + name);
    }
*/
 /*
    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }
*/    
 
// 9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для доступа к averageGrade.
    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setCourse(int course) {
        this.course = course;
    }    
    
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

/*    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }
*/

// 7.4. Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,чтобы они вместо набора параметров принимали по одному объекту даты.
//    public void setBeginningOfSession(int day, int month, int year) {
    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

//    public void setEndOfSession(int day, int month, int year) {
    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}