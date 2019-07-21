package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch(type) {
            case TRUCK: return new Truck(numberOfPassengers);
            case SEDAN: return new Sedan(numberOfPassengers);
            case CABRIOLET: return new Cabriolet(numberOfPassengers);    
        }
        return null;
    }


//11.1. Замена кода ошибки исключением. Перепиши метод заправиться fill(double numberOfLiters), чтобы он в случае ошибки кидал исключение Exception.
    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
//            return -1;
        fuel += numberOfLiters;
//        return 0;
    }

// 11.2.1. Добавь и реализуй метод в классе Car, определяющий относится ли переданная дата к лету: boolean isSummer(Date date , Date summerStart, Date summerEnd).    
    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
/*        date.setYear(2000);
        summerStart.setYear(2000);
        summerEnd.setYear(2000);*/
        return !(date.after(summerEnd) || date.before(summerStart) );
    }   

// 11.2.2. Добавь и реализуй метод, рассчитывающий расход топлива зимой: 
    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }
    
//11.2.3. Добавь и реализуй метод, рассчитывающий расход топлива летом: 
    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

//11.2.4. Перепиши метод getTripConsumption(), используя новые методы.
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        return (isSummer(date, SummerStart, SummerEnd) ? getSummerConsumption(length) : getWinterConsumption(length)) ;
    }

// 12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры в класс Car. 
// Метод должен возвращать true, если водитель доступен isDriverAvailable и есть топливо fuel.
    private boolean canPassengersBeTransferred() {
        return (isDriverAvailable() && fuel >0);
    }

//12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы (используй метод canPassengersBeTransferred()).

    public int getNumberOfPassengersCanBeTransferred() {
        /*if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;
        return numberOfPassengers;*/
        if (canPassengersBeTransferred()) return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

//12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод startMoving(), чтобы в нем не было повторяющихся вызовов функций.
    public void startMoving() {
        if (numberOfPassengers > 0) fastenPassengersBelts();
        fastenDriverBelt();
/*        } else {
            fastenDriverBelt();
        }*/
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

//12.3. Замена магического числа символьной константой. Замени магические числа в методе
// getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED, MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
    public abstract int getMaxSpeed();
/*    {
        if (type == TRUCK)
            return MAX_TRUCK_SPEED;
        if (type == SEDAN)
            return MAX_SEDAN_SPEED;
        return MAX_CABRIOLET_SPEED;
    }
*/
}