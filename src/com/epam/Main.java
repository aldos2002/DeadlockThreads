package com.epam;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String args[]) {
        Thread t1 = new Thread(new CompetingThread(lock1, lock2, "thread1"));
        Thread t2 = new Thread(new CompetingThread(lock2, lock1, "thread2"));
        t1.start();
        t2.start();

    }
}
