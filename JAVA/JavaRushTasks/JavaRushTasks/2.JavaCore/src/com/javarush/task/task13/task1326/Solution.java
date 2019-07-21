package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream inStream = new FileInputStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));

        ArrayList<Integer> array = new ArrayList<Integer>();

        while (fileReader.ready())
        {
            String line = fileReader.readLine();
            int data = Integer.parseInt(line); //читаем строку - число из потока для чтения (файла)
            if(data % 2 == 0) array.add(data);
        }
        inStream.close(); //закрываем потоки
        reader.close();
        fileReader.close();
        Collections.sort(array);
        for (int value : array) System.out.println(value);
    }
}
