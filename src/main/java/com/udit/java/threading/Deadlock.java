package com.udit.java.threading;

/**
 * @author Udit Sharma.
 * @since 25 Apr, 2018 6:30 PM
 */
public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        thread.run();
    }

    class ThreadSample extends Thread {

    }
}
