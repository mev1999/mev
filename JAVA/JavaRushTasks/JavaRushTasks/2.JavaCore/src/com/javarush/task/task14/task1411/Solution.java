package com.javarush.task.task14.task1411;

import com.javarush.task.task14.task1411.Person.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Loser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        while(true)
        {
            key = reader.readLine();
            //создаем объект, пункт 2
            if("user".equals(key)) person = new User();
            else
                if("loser".equals(key)) person = new Loser();
                else
                    if("coder".equals(key)) person = new Coder();
                    else
                        if("proger".equals(key)) person = new Coder();
                        else break;
            doWork(person); //вызываем doWork
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof User) ((User) person).live();
        if(person instanceof Loser) ((Loser) person).doNothing();
        if(person instanceof Coder) ((Coder) person).coding();
        if(person instanceof Proger) ((Proger) person).enjoy();
    }
}
