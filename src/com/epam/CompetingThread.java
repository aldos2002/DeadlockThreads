package com.epam;

/**
 * Created by Almas_Doskozhin
 * on 2/23/2016.
 */
public class CompetingThread implements Runnable {
    private Object lock1;
    private Object lock2;
    private String name;

    public CompetingThread(Object lock1, Object lock2, String name) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.name = name;
    }

    public void run() {
        System.out.println("lock1 requested by "+ this.name);
        synchronized (lock1) {
            System.out.println("lock1 aquired by "+ this.name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("lock2 requested by "+ this.name);
            synchronized (lock2) {
                System.out.println("lock2 aquired by "+ this.name);
            }
        }
    }
}
