package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int num[] = new int[5];

        for (int i = 0; i < 5; i++) num[i] = Integer.parseInt(reader.readLine());

        int c;
        for (int i = 0; i < 5; i++)
            for (int j = i+1; j < 5 ; j++)
               if(num[i] > num[j]) {
                   c = num[i];
                   num[i] = num[j];
                   num[j] = c;
               }
        for (int i = 0; i < 5; i++) System.out.println(num[i]);
    }
}
