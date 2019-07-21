package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

import java.util.ArrayList;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex; // true - man, false - woman
        private String address;
        private Human mother;
        private Human father;
// 1  все знаем
        public Human(String name, int age, boolean sex, String address, Human mother, Human father) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.mother = mother;
            this.father = father;
        }
//2 имя, пол
        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
//3 имя, возраст, пол
        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
//4 ничего не знаем
        public Human() {
}

//5 знаем родителей
        public Human(Human mother, Human father) {
            this.mother = mother;
            this.father = father;
        }
//6 знаем все, кроме родителей
        public Human(String name, int age, boolean sex, String address) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }
//7 копия человека
        public Human(Human human) {
            this.name = human.name;
            this.age = human.age;
            this.sex = human.sex;
            this.address = human.address;
            this.mother = human.mother;
            this.father = human.father;
        }
// 8 знаем пол и родителей
        public Human(boolean sex, Human mother, Human father) {
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }
// 9 знаем имя, пол, родителей
        public Human(String name, boolean sex, Human mother, Human father) {
            this.name = name;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
}
// 10 знаем все, кроме возраста
        public Human(String name, boolean sex, String address, Human mother, Human father) {
            this.name = name;
            this.sex = sex;
            this.address = address;
            this.mother = mother;
            this.father = father;
}
    }
}
