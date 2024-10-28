package org.example.utils;

public class DiceUtility {
    public static int roll(int numberOfDices) {
        int min = 1;
        int max = 6 * numberOfDices;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}

/*
min = 1
max = 12

x * 12 + 1

x = 0.4 => 5.8 => 5
x = 0.1 => 2.2 => 2
x = 0.9 => 11.8 => 11
x = 0.99 => 12.88 => 12
 */
