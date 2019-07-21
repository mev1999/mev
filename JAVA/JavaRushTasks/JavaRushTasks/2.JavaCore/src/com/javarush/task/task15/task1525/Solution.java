package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    
    static {
        try {
          FileReader inStream = new FileReader(Statics.FILE_NAME);
    	  BufferedReader reader = new BufferedReader(inStream);
    	  while(reader.ready())
              lines.add(reader.readLine());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
