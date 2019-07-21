package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arrayHouse = new int[15];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 15; i++) arrayHouse[i] = Integer.parseInt(reader.readLine());
        int odd = 0, even = 0;

        for (int i = 0; i < 15 ; i+=2) even += arrayHouse[i];
        for (int i = 1; i < 15 ; i+=2) odd += arrayHouse[i];
        System.out.println( "В домах с " + (odd > even ? "не": "") +"четными номерами проживает больше жителей.");
    }
}
