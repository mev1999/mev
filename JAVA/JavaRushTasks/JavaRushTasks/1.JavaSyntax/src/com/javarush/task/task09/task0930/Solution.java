package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
3. Выведенные слова должны быть упорядочены по возрастанию.
4. Выведенные числа должны быть упорядочены по убыванию.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        String tempStr;
        for (int i = 0; i < array.length; i++)
            for (int j = i; j < array.length; j++) {
                if(isNumber(array[i])) { // сортируем числа
                    if(isNumber(array[j]))  // встретили число
                        if(Integer.parseInt(array[j]) > Integer.parseInt(array[i])) {
                            tempStr = array[i];
                            array[i] = array[j];
                            array[j] = tempStr;
                        }
                }
                else { // сортируем строки
                    if(!isNumber(array[j]))  // встретили строку
                        if(isGreaterThan(array[i],array[j])) {
                            tempStr = array[i];
                            array[i] = array[j];
                            array[j] = tempStr;
                        }
                }

            }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
