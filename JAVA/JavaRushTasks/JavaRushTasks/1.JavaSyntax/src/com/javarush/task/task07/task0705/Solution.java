package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
         int[] arrayBig = new int[20];
         int[] arraySmall1 = new int[10], arraySmall2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) arrayBig[i] = Integer.parseInt(reader.readLine());

        for (int i = 0; i < 10; i++) arraySmall1[i] = arrayBig[i];
        for (int i = 10; i < 20; i++) arraySmall2[i-10] = arrayBig[i];

        for (int i = 0; i < 10; i++) System.out.println(arraySmall2[i]);
    }
}
