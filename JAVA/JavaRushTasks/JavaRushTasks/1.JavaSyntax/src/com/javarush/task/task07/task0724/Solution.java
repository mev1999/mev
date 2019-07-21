package com.javarush.task.task07.task0724;

/* 
Семейная перепись
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
6. Выведи созданные объекты на экран.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFather1 = new Human("Semen", true, 80);
        Human grandFather2 = new Human("Matvey", true, 75);
        Human grandMother1 = new Human("Avdotya", false, 81);
        Human grandMother2 = new Human("Pelageya", false, 73);
        Human father = new Human("Boris", true, 50, grandFather1, grandMother1);
        Human mother = new Human("Natalya", false, 43, grandFather2, grandMother2);
        Human child1 = new Human("Polina", false, 13, father, mother);
        Human child2 = new Human("Artem", true, 18, father, mother);
        Human child3 = new Human("Denis", true, 18, father, mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















