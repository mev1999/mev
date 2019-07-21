package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //напишите тут ваш код
        for (int i = 0; i < s.length(); i++)
            if( (i > 0 && " ".equals(s.substring(i-1,i))) || i == 0 )
                 System.out.print(s.substring(i,i+1).toUpperCase());
            else System.out.print(s.charAt(i));

    }
}
