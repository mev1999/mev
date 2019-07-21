package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* 
CRUD 2
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if(args.length > 0) { // есть аргументы
            switch(args[0]) {
                case "-c":
                    if ( ((args.length -1) % 3) == 0) {
                        int numAdd = (args.length -1) / 3; // количество добавляемых
                        for (int i = 0; i < numAdd; i++) {
                            String name = args[i*3+1];
                            Sex sex = ("м".equals(args[i*3+2]) ? Sex.MALE : ("ж".equals(args[i*3+2]) ? Sex.FEMALE : null));
                            if (sex == null) {
                                System.out.println("Неверный пол (м/ж)");
                                return;
                            }
                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date birthday = format.parse(args[i*3+3]);
                            synchronized (allPeople) {
                                if (sex == Sex.MALE) allPeople.add(Person.createMale(name, birthday));
                                if (sex == Sex.FEMALE) allPeople.add(Person.createFemale(name, birthday));
                                System.out.println(allPeople.size() - 1);
                            }
                        }
                    } else System.out.println("Неверное количество аргументов -c");
                    break;
                case "-u":
                    if ( ((args.length -1) % 4) == 0) {
                        int numAdd = (args.length -1) / 4; // количество добавляемых
                        for (int i = 0; i < numAdd; i++) {
                            int id = Integer.parseInt(args[i * 4 + 1]);
                            String name = args[i * 4 + 2];
                            Sex sex = ("м".equals(args[i * 4 + 3]) ? Sex.MALE : ("ж".equals(args[i * 4 + 3]) ? Sex.FEMALE : null));
                            if (sex == null) {
                                System.out.println("Неверный пол (м/ж)");
                                return;
                            }
                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date birthday = format.parse(args[i * 4 + 4]);
                            synchronized (allPeople) {
                                if (sex == Sex.MALE) allPeople.set(id, Person.createMale(name, birthday));
                                if (sex == Sex.FEMALE) allPeople.set(id, Person.createFemale(name, birthday));
                            }
                        }
                    } else System.out.println("Неверное количество аргументов -u");
                    break;
                case "-d":
                    if ( args.length > 1) {
                        int numAdd = (args.length -1); // количество добавляемых
                        for (int i = 0; i < numAdd; i++) {
                            int id = Integer.parseInt(args[i + 1]);
                            Person nullPerson = Person.createFemale(null, null);
                            nullPerson.setSex(null);
                            synchronized (allPeople) {
                                allPeople.set(id, nullPerson);
                            }
                        }
                    } else System.out.println("Неверное количество аргументов -d");
                    break;
                case "-i":
                    if ( args.length > 1) {
                        int numAdd = (args.length -1); // количество добавляемых
                        synchronized (allPeople) {
                            for (int i = 0; i < numAdd; i++)
                                System.out.println(allPeople.get(Integer.parseInt(args[i + 1])));
                        }
                    } else System.out.println("Неверное количество аргументов -i");
                    break;
            }
        }
    }
}
