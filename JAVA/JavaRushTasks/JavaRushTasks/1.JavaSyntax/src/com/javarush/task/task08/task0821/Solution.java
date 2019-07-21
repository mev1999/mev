package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Мальков", "Евгений"); // 1
        map.put("Меняйло", "Евгений"); // 2
        map.put("Мальков", "Сергей");  // 3
        map.put("Таравков", "Роман");  // 4
        map.put("Астафьева", "Анастасия"); // 5
        map.put("Новикова", "Анастасия"); // 6
        map.put("Гассан", "Анастасия"); // 7
        map.put("Колпакова", "Татьяна"); // 8
        map.put("Крамер", "Татьяна"); // 9
        map.put("Никулин", "Александр"); // 10

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
