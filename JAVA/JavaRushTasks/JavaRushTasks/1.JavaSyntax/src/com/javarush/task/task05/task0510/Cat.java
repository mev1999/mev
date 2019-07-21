package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
1. Программа не должна считывать данные с клавиатуры.
2. У класса Cat должна быть переменная name с типом String.
3. У класса Cat должна быть переменная age с типом int.
4. У класса Cat должна быть переменная weight с типом int.
5. У класса Cat должна быть переменная address с типом String.
6. У класса Cat должна быть переменная color с типом String.
7. У класса должен быть метод initialize, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
8. У класса должен быть метод initialize, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
9. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
10. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
11. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public void initialize(String name){
        this.name = name;
        this.age = 1;
        this.weight = 2;
        this.color = "Red";
    }

    public void initialize(String name,  int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "Red";
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 2;
        this.color = "Red";
    }
    public void initialize(int weight, String color){
        this.age = 1;
        this.weight = weight;
        this.color = color;
    }
    public void initialize(int weight, String color, String address){
        this.age = 1;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
