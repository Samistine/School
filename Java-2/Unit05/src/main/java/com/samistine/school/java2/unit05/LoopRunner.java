package com.samistine.school.java2.unit05;

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
public final class LoopRunner implements Runnable {

    private final char character;
    private final int times;

    public LoopRunner(char character, int times) {
        this.character = character;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(character);
        }
    }

}
