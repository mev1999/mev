package com.javarush.task.task10.task1002;

/* 
Задача №2 на преобразование целых типов
Расставьте правильно операторы приведения типа, чтобы получился ответ: d=3.765
*/

public class Solution {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        float c = (float)a / b;
        double d = (double)a * 1e-3 + c;

        System.out.println(d);
    }
}
