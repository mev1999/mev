package com.javarush.task.task05.task0507;

import java.io.*;
/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count = 0;
        int n = 0;
        while(n != -1){
     		n = Integer.parseInt(reader.readLine());
            count++;
            sum += n;
        }
        double avg = 0;
        if (count>1) avg = 1.0*(sum +1)/(count-1);
        System.out.println(avg);
    }
}

