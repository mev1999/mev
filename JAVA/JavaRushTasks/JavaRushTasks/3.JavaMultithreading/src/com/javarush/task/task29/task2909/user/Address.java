package com.javarush.task.task29.task2909.user;

/*
14.2.1. Добавь класс Address в пакет user.
14.2.2. Перенеси поля country, city и house в новый класс.
14.2.3. Добавь сеттеры и геттеры для них.
14.2.4. Перепиши класс User, используя поле класса Address address.
*/
public class Address {
    private String country;
    private String city;
// 14.3. Встраивание класса. Класс House почти ничего не делает, избавься от него.
// private House house;
    private String house;
 
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getHouse() {
        return house;
    }
    
    public void setHouse(String house) {
        this.house = house;
    }

}