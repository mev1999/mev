package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
1. В классе Money должно содержаться приватное поле amount типа double.
2. В классе Money должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение переменной amount согласно переданному параметру.
3. В классе Money должен быть реализован публичный метод getAmount, который будет возвращать значение поля amount.
4. Классы Hrivna, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах.
5. В классах Hrivna, Ruble и USD должен быть реализован метод getCurrencyName.
6. Метод getCurrencyName должен возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, HRN, RUB).
7. В классах Hrivna, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение поля amount класса Money
путем вызова конструктора класса родителя c тем же пара
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //напишите тут ваш код
            allMoney.add(new USD(100.25));
            allMoney.add(new Ruble(10033.00));
            allMoney.add(new Hrivna(1400.78));
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
