package com.javarush.task.task29.task2909.user;

public class User {
    private String name;
    private String surname;
    private int age;

/*
    private String country;
    private String city;
    private House house;
*/
    private Address address;
    private Work work;

// 14.1. Перемещение поля. Замени поля isManAnya и isManRoma полем man в нужном классе.
// Добавь сеттер и геттер для нового поля (при выборе имен методов учти тип поля).
    private boolean man;

    public void setMan(boolean man)  {
        this.man = man;
    }
    
    public boolean isMan() {
        return man;
    }
    
    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }


/*13.1. Извлечение метода. Добавь метод printInfo(), который будет выводить имя и фамилию
в консоль в формате

Имя: Вася
Фамилия: Пупкин

Замени повторяющийся код метода printUsers() его вызовом.
  */
    public void printInfo() {
        System.out.println("Имя: " + getName());
        System.out.println("Фамилия: " + getSurname());
    }
// 13.3. Перемещение метода. Перемести методы printInfo() и printAdditionalInfo() в класс User.
    public void printAdditionalInfo() {
        if (getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }
/*
14.4. Сокрытие делегирования.
14.4.1. Добавь в класс User метод getBoss().
14.4.2. Перепиши реализацию метода getBossName(User user) класса UserHelper.
*/
    public String getBoss() {
        return work.getBoss();
    }

}
