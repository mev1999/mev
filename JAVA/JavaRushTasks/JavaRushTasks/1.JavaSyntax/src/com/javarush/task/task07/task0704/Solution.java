package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayNum = new int[10];
        for (int i = 0; i < 10; i++) arrayNum[i] = Integer.parseInt(reader.readLine());
        int num;
        for (int i = 0; i < arrayNum.length / 2; i++) {
            num = arrayNum[i];
            arrayNum[i] = arrayNum[arrayNum.length - 1 - i];
            arrayNum[arrayNum.length - 1 - i] = num;
        }
        for (int i = 0; i < 10; i++) System.out.println(arrayNum[i]);
    }
}

