package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private static AtomicInteger currentPriority = new AtomicInteger(MIN_PRIORITY);

    private synchronized void setNewPriority() {
        setPriority(currentPriority.getAndIncrement());
        if(currentPriority.get() > MAX_PRIORITY) currentPriority.set(MIN_PRIORITY);
    }

    private synchronized void setNewPriority(ThreadGroup group) {
        if(currentPriority.get() <= group.getMaxPriority())
            setPriority(currentPriority.getAndIncrement());
        else {
            setPriority(group.getMaxPriority());
            currentPriority.getAndIncrement();
        }
        if(currentPriority.get() > MAX_PRIORITY) currentPriority.set(MIN_PRIORITY);
    }

    public MyThread() {
        super();
        setNewPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setNewPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setNewPriority(group);
    }

    public MyThread(String name) {
        super(name);
        setNewPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setNewPriority(group);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setNewPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setNewPriority(group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setNewPriority(group);
    }
}
