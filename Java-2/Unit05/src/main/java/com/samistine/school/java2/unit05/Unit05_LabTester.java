package com.samistine.school.java2.unit05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit05
 * Date: Created Oct 30, 2016 1:41:12 PM
 * 
 * By turning in this code, I Pledge:
 *  1. That I have completed the programming assignment independently.
 *  2. I have not copied the code from a student or any source.
 *  3. I have not given my code to any student.
 * 
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public final class Unit05_LabTester {

    public static final int THREAD_COUNT = 4;
    public static final Random random = new Random();

    public static void main(String[] args) {

        final Queue<Thread> threads = new LinkedList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            /* Create new looprunner that prints out a numeral character between 1 & 10 times */
            LoopRunner runner = new LoopRunner(Character.forDigit(i + 1, 11), random.nextInt(10) + 1);
            /* Wrap the looprunner in a thread */
            Thread thread = new Thread(runner);
            /* Add the thread to our queue */
            threads.add(thread);
        }

        /* Start each thread */
        threads.forEach(Thread::start);
        System.out.println("Main method here");

        /* Wait for threads to finish */
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        System.out.println("Execution finished");
    }

}
