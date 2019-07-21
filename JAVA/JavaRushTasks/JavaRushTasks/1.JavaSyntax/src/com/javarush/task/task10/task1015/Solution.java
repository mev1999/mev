package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Random;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] array =  new ArrayList[10];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            int num = rnd.nextInt(10);
            array[i] = new ArrayList<String>();
            for (int j = 0; j < num; j++) {
                array[i].add(Integer.toString(i) + " " + Integer.toString(j));
            }
        }
        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}