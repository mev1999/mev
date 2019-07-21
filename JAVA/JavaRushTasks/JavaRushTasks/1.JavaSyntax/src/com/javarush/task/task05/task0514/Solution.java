package com.javarush.task.task05.task0514;

/* 
Программист создает человека
1. Программа не должна считывать данные с клавиатуры.
2. У класса Person должна быть переменная name с типом String.
3. У класса Person должна быть переменная age с типом int.
4. У класса Person должен быть метод initialize, принимающий в качестве параметра имя, возраст и инициализирующий соответствующие переменные класса.
5. Необходимо создать объект типа Person.
6. Необходимо вызвать метод initialize у созданного объекта и передать в него какие-либо параметры.*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Person vasya = new Person();
        vasya.initialize("Vasya", 27);
    }

    static class Person {
        //напишите тут ваш код
        private String name;
        private int age;

        public void initialize(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
