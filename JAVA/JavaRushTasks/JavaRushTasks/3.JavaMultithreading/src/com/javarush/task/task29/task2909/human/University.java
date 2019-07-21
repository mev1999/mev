package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class University {

    private List<Student> students = new ArrayList<Student>();
  
    private int age;
    private String name;

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public List<Student> getStudents() {
//        return Collections.unmodifiableList(students);
        return students;
    }
    
    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for(Student student : students) 
         if(student.getAverageGrade() == averageGrade) return student;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student stMaxAG = null;
        double maxAG = 0;
        for(Student student : students) 
         if(student.getAverageGrade() > maxAG) {
            stMaxAG = student;
            maxAG = student.getAverageGrade();
         }     
        return stMaxAG;
    }

/*
    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }
    */
 
    public Student getStudentWithMinAverageGrade() {
        
        Student stMinAG;
        double minAG;
        
        if(students.size() > 0)  {
                minAG = students.get(0).getAverageGrade();
                stMinAG = students.get(0);
        }    
        else return null;
        
        for(Student student : students) 
         if(student.getAverageGrade() < minAG) {
            stMinAG = student;
            minAG = student.getAverageGrade();
         }     
        return stMinAG;
    }
 
 // отчислить выбранного студента
    public void expel(Student student) {
         if (students.indexOf(student) != -1) students.remove(student);
    }
    
}