package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

//    protected int course;

// 9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size,
//    protected int[] size;

    public class Size {
        public int height;
        public int weight;
    }
    
    Size size = new Size();


//    protected boolean isSoldier;
/*
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
*/
//    private int bloodGroup;

    
    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    public void addChild(Human child) {
        children.add(child);
    }    
        
    public void removeChild(Human child) {
        children.remove(child);
    }

/*    public void setChildren(List<Human> children) {
        this.children = children;
    }
*/

    public void setBloodGroup(BloodGroup bloodGroup) {
/*        switch(bloodGroup.getCode()) {
            case 1:
                bloodGroup = BloodGroup.first();
            break;    
            case 2:
                bloodGroup = BloodGroup.second();
            break;    
            case 3:
                bloodGroup = BloodGroup.third();
            break;    
            case 4:
                bloodGroup = BloodGroup.fourth();
            break;    
        }
    */
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

/*    public Human(boolean isSoldier) {
        this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
    }
*/

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {
    }    


    public int getId() {
        return id;
    }
/*
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент создания объекта.
    public void setId(int id) {
        this.id = id;
    }
*/
    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
    
    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() +": " + name);
    }
    
}