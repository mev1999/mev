package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Первым делом, для удобства работы с консолью реализуем класс ConsoleHelper. В
дальнейшем, вся работа с консолью должна происходить через этот класс.

Добавь в него:
1. Статическое поле типа BufferedReader, инициализированное с помощью System.in.
2. Статический метод writeMessage(String message), который должен выводить
сообщение message в консоль.
3. Статический метод String readString(), который должен считывать строку с
консоли. Если во время чтения произошло исключение, вывести пользователю
сообщение "Произошла ошибка при попытке ввода текста. Попробуйте еще раз." И
повторить ввод. Метод не должен пробрасывать исключения IOException наружу.
Другие исключения не должны обрабатываться.
4. Статический метод int readInt(). Он должен возвращать введенное число и
использовать метод readString(). Внутри метода обработать исключение
NumberFormatException. Если оно произошло вывести сообщение "Произошла ошибка
при попытке ввода числа. Попробуйте еще раз." И повторить ввод числа.

В этой задаче и далее, если не указано дополнительно другого, то все поля класса должны
быть приватными, а методы публичными.
*/

public class ConsoleHelper {
    
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int nAge = Integer.parseInt(sAge);

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    
    public static String readString() {
        String str = null;
        
        while (str == null) {
            try {
                str = reader.readLine();

            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            } 
        }    
        return str;
    }

    public static int readInt() {
        while(true) 
            try {
                return Integer.parseInt(readString());
            }catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            } 
    }
    
}