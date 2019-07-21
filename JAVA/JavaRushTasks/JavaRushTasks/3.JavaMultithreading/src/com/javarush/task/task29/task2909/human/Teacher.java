package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {
    private int numberOfStudents;
//    private String university;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
/*        this.name = name;
        this.age = age;*/
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public void live() {
        teach();
    }

    public void teach() {
    }

/*    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
*/
    @Override
    public String getPosition() {
        return "Преподаватель";
    }
/*
    public void printData() {
        System.out.println(getPosition() +": " + name);
    }
*/

}