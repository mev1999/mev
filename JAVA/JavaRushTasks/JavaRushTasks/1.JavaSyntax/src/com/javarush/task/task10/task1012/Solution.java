package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        // напишите тут ваш код
        int[] numAbc = new int[33];
        int index; // номер текущего символа в массиве
        for (String s:list)
            for (int i = 0; i < s.length(); i++) {
                index = alphabet.indexOf(s.charAt(i));
                if (index >= 0) numAbc[index]++;
            }
        for (int i = 0; i < abcArray.length; i++) System.out.println(abcArray[i] + " " + numAbc[i]);
    }

}
