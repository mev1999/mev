package com.javarush.task.task19.task1920;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
 где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.
*/

import java.io.*;
import java.util.TreeMap;
import java.util.Map;


public class Solution {
    public static void main(String[] args) throws Exception {

        Map<String, Double> zp = new TreeMap<String, Double>();

        FileReader reader = new FileReader(args[0]);

        BufferedReader bufferedReader = new BufferedReader(reader);
        
        String line;
        double maxValue = 0;
        
        while ( (line = bufferedReader.readLine()) != null) { //пока есть непрочитанные байты в потоке ввода
            String[] data = line.split(" ");
            Double value = Double.parseDouble(data[1]);
            if(zp.containsKey(data[0])) value += zp.get(data[0]); // добавляем значение
            
            if(maxValue < value) maxValue = value; // обновляем максимум
            
            zp.put(data[0], value);
        }
        bufferedReader.close();

// имена уже отсортированы по алфавиту
        for (Map.Entry<String, Double> pair : zp.entrySet()) 
            if(pair.getValue() == maxValue) System.out.println(pair.getKey());
    }
}
