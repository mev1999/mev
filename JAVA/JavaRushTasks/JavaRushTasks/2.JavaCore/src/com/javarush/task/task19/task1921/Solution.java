package com.javarush.task.task19.task1921;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
 где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        
/*
// тест
        String line = "Иванов Иван Иванович 31 12 1987";
        
        String[] data = line.split(" ");
        int dlen = data.length;
        
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String str = data[dlen - 3] + "." + data[dlen - 2] + "." + data[dlen - 1];
        Date birtday = df.parse(data[dlen - 3] + "." + data[dlen - 2] + "." + data[dlen - 1]);
        
        System.out.println(line);
        System.out.println(str);
        System.out.println(birtday);
*/        

        FileReader reader = new FileReader(args[0]);

        BufferedReader bufferedReader = new BufferedReader(reader);
        
        String line;
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        
        while ( (line = bufferedReader.readLine()) != null) { //пока есть непрочитанные байты в потоке ввода
            String[] data = line.split(" ");
            int dlen = data.length;
            
            Date birtday = df.parse(data[dlen - 3] + "." + data[dlen - 2] + "." + data[dlen - 1]);
            StringBuffer sb = new StringBuffer("");
            for(int i = 0; i < dlen - 3; i++ ) sb.append( ( (i == dlen - 4) ? data[i] : data[i] + " ")); // собираем имя, последняя часть без пробела 
            
            PEOPLE.add(new Person(sb.toString(), birtday));
        }
        bufferedReader.close();
    }
}
