package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) strings.add(reader.readLine());
        int minLen = strings.get(0).length();
        int len;
        for (int i = 1; i < 5; i++){
            len = strings.get(i).length();
            if(minLen > len) minLen = len;
        }
        for (int i = 0; i < 5; i++)
            if(strings.get(i).length() == minLen) System.out.println(strings.get(i));
    }
}
