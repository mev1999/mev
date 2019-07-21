package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

public class Solution {
    private static volatile boolean isFinish;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
//        t.interrupt();
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() throws Error {
        isFinish = true;
//      System.exit(1);
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (!isFinish) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
