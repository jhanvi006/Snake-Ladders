package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadder {
    public static final int START_POSITION = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to Snake & Ladder game! \nRoll a dice.");
        Random random = new Random();
        int position = 0;
        int diceNo = random.nextInt(6) + 1;
        System.out.println("Dice value: "+diceNo);
    }
}
