package com.udit.java.threading;

/**
 * @author Udit Sharma.
 * @since 25 Apr, 2018 6:46 PM
 */
public class HelloWorld {
    static volatile boolean printedHello;

    static class thread extends Thread {
        private boolean printHello;

        public thread(boolean printHello) {
            this.printHello = printHello;
        }

        @Override
        public void run() {
            while (true) {
                if (printHello) {
                    if (!printedHello) {
                        System.out.print("Hello");
                        printedHello = true;
                    }
                } else {
                    if (!printedHello) {
                        System.out.print("World !!");
                        System.out.println();
                        printedHello = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        thread hello = new thread(true);
        thread world = new thread(false);
        hello.start();
        world.start();
    }
}
