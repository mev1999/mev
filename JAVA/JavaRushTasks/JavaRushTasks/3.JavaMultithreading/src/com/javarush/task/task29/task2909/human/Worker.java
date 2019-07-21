package com.javarush.task.task29.task2909.human;

public class Worker extends Human {
//  private Human human;
    private double salary;
//9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
//    public String company;
    private String company;
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public Worker(String name, int age) {
        super(name,age);
    }

/*
    public void live() {
        human.live();
    }
*/
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}