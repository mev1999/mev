package com.javarush.task.task13.task1309;

/* 
Всё, что движется
1. В классе Solution должен быть объявлен интерфейс Movable.
2. В классе Solution должен быть объявлен интерфейс Flyable.
3. Интерфейс Flyable должен наследоваться от интерфейса Movable.
4. В интерфейсе Movable должен быть объявлен метод speed без параметров и с типом возвращаемого значения Double.
5. В интерфейсе Flyable должен быть объявлен метод speed c одним аргументом типа Flyable и с типом возвращаемого значения Double.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Movable {
        Double speed();
    }

    public interface Flyable extends Movable {
        Double speed(Flyable fly);
    }

}