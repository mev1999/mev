package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] arrayS = new String[10];
        int[] arrayN = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10 ; i++) {
            arrayS[i] = reader.readLine();
            arrayN[i] = arrayS[i].length();
        }
        for (int i = 0; i < 10 ; i++) System.out.println(arrayN[i]);
    }
}
