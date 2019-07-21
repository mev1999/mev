package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        String element;
        int endOfList = list.size(); // фиксируем размер списка для проверки
        //напишите тут ваш код
        for (int i = 0; i < endOfList; ) { // переменную цикла будем увеличивать внутри
            element = list.get(i);
            if (element.contains("р") && element.contains("л")) i++;
            else {
                if (element.contains("р")) {
                    list.remove(i);
                    endOfList--;
                }
                else {
                    if (element.contains("л")) list.add(list.get(i));
                    i++;
                }
             }
        }
        return list;
    }
}