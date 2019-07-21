package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Cat1", new Cat("Cat1"));
        map.put("Cat2", new Cat("Cat1"));
        map.put("Cat3", new Cat("Cat1"));
        map.put("Cat4", new Cat("Cat1"));
        map.put("Cat5", new Cat("Cat1"));
        map.put("Cat6", new Cat("Cat1"));
        map.put("Cat7", new Cat("Cat1"));
        map.put("Cat8", new Cat("Cat1"));
        map.put("Cat9", new Cat("Cat1"));
        map.put("Cat10", new Cat("Cat10"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> cats = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet()) cats.add(pair.getValue());
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
