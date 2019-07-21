package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        HashMap<String, String> parameters = new HashMap<String, String>();

        url = url.substring(url.indexOf("?")+1);
//        System.out.println(url);
        String parameter, value;
        do {
                if(url.contains("&")) {
                    parameter = url.substring(0,url.indexOf("&"));
                    value = "";
                    if(parameter.contains("=")) {
                        parameter = parameter.substring(0,parameter.indexOf("="));
                        value = url.substring(url.indexOf("=")+1,(url.contains("&") ? url.indexOf("&"): url.length()-1));
//                    System.out.println(parameter + " - " + value);
                        parameters.put(parameter, value);
                    }

                }
                if(url.contains("&") ) url = url.substring(url.indexOf("&")+1);
                else break;
            } while(true);

        boolean first = true; // чтобы убрать пробел в конце при выводе параметров

        for (HashMap.Entry<String, String> pair : parameters.entrySet()) {
            if(!first) System.out.print(" "); // перед первым элементом пробел не добавляем, иначе пробел
            else first = false;
            System.out.print(pair.getKey());
        }

        System.out.println("");

        for (HashMap.Entry<String, String> pair : parameters.entrySet())
            if("obj".equals(pair.getKey())) {
                String value1 = pair.getValue();
                double valueDouble;
                try {
                    valueDouble = Double.parseDouble(value1);
                    alert(valueDouble);
                }
                catch (NumberFormatException e) {
                    alert(value1);
                }
            }
/*        map.put("Мальков", "Евгений"); // 1

            if(pair.getValue().equals(name)) count++;
        if(pair.getKey().equals(lastName)) count++;
*/
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
