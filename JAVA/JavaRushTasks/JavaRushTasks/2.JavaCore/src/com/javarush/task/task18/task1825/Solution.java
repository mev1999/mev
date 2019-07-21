package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> files = new TreeSet<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileStart = null;

        String str;
        while(!"end".equals(str=reader.readLine())) {
            String[] parts;
            parts = str.split("\\.");
            if(fileStart == null) fileStart = str.substring(0, str.length() - parts[parts.length - 1].length() - 1);
            files.add(Integer.parseInt(parts[parts.length - 1].substring(4)));
        }

        FileOutputStream out = new FileOutputStream(fileStart);

        for (Integer num: files) {
            FileInputStream in = new FileInputStream(fileStart + ".part" + num);
            byte[] buffer = new byte[in.available()];
            int len = in.read(buffer);
            out.write(buffer,0, len);
            in.close();
        }
        out.close();
    }
}
