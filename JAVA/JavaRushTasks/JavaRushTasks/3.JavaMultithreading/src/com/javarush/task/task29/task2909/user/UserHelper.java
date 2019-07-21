package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

//    private boolean isManAnya = false;
//    private boolean isManRoma = true;
//    userAnya.setMan(false);
//    userRoma.setMan(true);

    public void printUsers() {
/*        System.out.println("Имя: " + userAnya.getName());
        System.out.println("Фамилия: " + userAnya.getSurname());
*/      
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

//        System.out.println("Имя: " + userRoma.getName());
//        System.out.println("Фамилия: " + userRoma.getSurname());
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }
/*
//13.2. Встраивание метода. Избавься от метода ageLessThan16().
    public void printAdditionalInfo(User user) {
        if (user.getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }
*/
/*
    private boolean ageLessThan16(User user) {
        if (user.getAge() < 16) {
            return true;
        }
        return false;
    }
*/

//13.4. Расщепление переменной. Переменная age в методе calculateAverageAge() используется для разных промежуточных значений. Перепиши метод без использования этой переменной.
    public int calculateAverageAge() {
//        int age = 28;
        User userUra = new User("Юра", "Карп", 28);
//        age = (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

//13.5. Удаление присваиваний параметрам. Перепиши метод calculateRate(), чтобы он не пытался менять входные параметры, а просто возвращал рассчитанное значение.
    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        AtomicInteger result = new AtomicInteger(base.get());
        result.set(result.get() + age / 100);
        result.set((int) (result.get() * (hasWork ? 1.1 : 0.9)));
        result.set((int) (result.get() * (hasHouse ? 1.1 : 0.9)));
        
        return result.get();
    }

    public String getBossName(User user) {
//        Work work = user.getWork();
        return user.getBoss();
    }
}