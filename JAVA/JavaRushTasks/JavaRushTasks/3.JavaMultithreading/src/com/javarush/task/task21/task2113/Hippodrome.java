package com.javarush.task.task21.task2113;

import java.util.*;
import java.io.*;


public class Hippodrome extends Thread {
    
    private List<Horse> horses;
    
    public List<Horse> getHorses() {
        return horses;
    }
    
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    
    public Horse getWinner() {
        double maxDistance = 0d;
        Horse winner = null;
        for(Horse horse : horses) 
            winner = (horse.getDistance() > maxDistance ? horse : winner);
        return winner;    
    }
    
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }    
    
    
    public static Hippodrome game;
    
/* В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды - добавь в него еще Thread.sleep(200);    
*/
    public void run() {
        for(int i = 0;  i < 10; i++) {
            try {
                move();
                print();
                Thread.sleep(200);
            } catch(Exception e) {
                e.printStackTrace();
            }    
        }
    }
    
    public void move() {
        for(Horse horse : horses) horse.move();
    }
    
    public void print() {
        for(Horse horse : horses) horse.print();
        for(int i = 0; i < 10; i++) System.out.println();
    }
    
    public static void main(String[] args) {
        
        List<Horse> horses = new ArrayList<Horse>();
        horses.add(new Horse("Strela", 3.0d, 0.0d));
        horses.add(new Horse("Molniya", 3.0d, 0.0d));
        horses.add(new Horse("Grom", 3.0d, 0.0d));
        
        Hippodrome.game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}