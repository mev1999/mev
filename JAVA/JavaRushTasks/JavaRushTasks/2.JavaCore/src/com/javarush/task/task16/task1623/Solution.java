package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(this.getName());
            sb.append(" created");
            return sb.toString();
        }

        @Override
        public void run() {
            if(countCreatedThreads < count) {
                Thread t = new GenerateThread();
                System.out.println(t);
            }
        }

        public GenerateThread() {
            super(++countCreatedThreads + "");
            start();
        }
    }
}
