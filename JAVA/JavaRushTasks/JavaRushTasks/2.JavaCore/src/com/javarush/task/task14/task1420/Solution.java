package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        int num1, num2;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            num1 = Integer.parseInt(reader.readLine());
            num2 = Integer.parseInt(reader.readLine());
            if (num1 <= 0 || num2 <= 0) throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            System.out.println("Необходимо ввести 2 положительных целых числа");
            throw e;
        }

        int nod = 1;

        int end = num1 < num2 ? num1 : num2;
        int n1 = num1, n2 = num2;

        for (int i = 2; i <= end; i++)
            if ( (( n1 % i) == 0) && ((n2 % i) == 0)) {
                nod *= i;
                end /= i;
                n1 /= i;
                n2 /= i;
                i = 2;
            }
        System.out.println(nod);
    }
}
