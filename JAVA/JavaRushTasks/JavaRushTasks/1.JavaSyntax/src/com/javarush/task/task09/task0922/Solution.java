package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "08/18/2013"
Вывести на экран эту дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, YYYY", ENGLISH);
        Date date = new Date();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        SimpleDateFormat inputFormat = new SimpleDateFormat("mm/dd/yyyy");
        date = new Date(reader.readLine());
        System.out.println(format.format(date).toUpperCase());
    }
}
