package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Программа запускается с одним из следующих наборов параметров:

-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        if(args.length > 0) { // есть аргументы
            if("-c".equals(args[0])) {
                if(args.length == 4) {
                    String name = args[1];
                    Sex sex = ("м".equals(args[2]) ? Sex.MALE : ("ж".equals(args[2]) ? Sex.FEMALE : null));
                    if(sex == null) {
                        System.out.println("Неверный пол (м/ж)");
                        return;
                    }
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date birthday = format.parse(args[3]);
                    if(sex == Sex.MALE) allPeople.add(Person.createMale(name, birthday));
                    if(sex == Sex.FEMALE) allPeople.add(Person.createFemale(name, birthday));
                    System.out.println(allPeople.size()-1);
                }
                else System.out.println("Неверное количество аргументов -с");
            }
            if("-u".equals(args[0])) {
                if(args.length == 5) {
                    int id = Integer.parseInt(args[1]);
                    String name = args[2];
                    Sex sex = ("м".equals(args[3]) ? Sex.MALE : ("ж".equals(args[3]) ? Sex.FEMALE : null));
                    if(sex == null) {
                        System.out.println("Неверный пол (м/ж)");
                        return;
                    }
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date birthday = format.parse(args[4]);
                    if(sex == Sex.MALE) allPeople.set(id,Person.createMale(name, birthday));
                    if(sex == Sex.FEMALE) allPeople.set(id,Person.createFemale(name, birthday));
                }
                else System.out.println("Неверное количество аргументов -u");
            }
            if("-d".equals(args[0])) {
                if (args.length == 2) {
                    int id = Integer.parseInt(args[1]);
                    Person nullPerson = Person.createFemale(null, null);
                    nullPerson.setSex(null);
                    allPeople.set(id,nullPerson);
                }
                else System.out.println("Неверное количество аргументов -d");
            }

            if("-i".equals(args[0])) {
                if (args.length == 2) {
                    int id = Integer.parseInt(args[1]);
                    System.out.println(allPeople.get(id));
//                    allPeople.remove(id);
                }
                else System.out.println("Неверное количество аргументов -i");
            }
        }
    }
}
