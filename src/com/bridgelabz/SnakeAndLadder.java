package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadder {
    public static final int START_POSITION = 0;
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    public static void main(String[] args) {
        System.out.println("Welcome to Snake & Ladder game! \nRoll a dice.");
        Random random = new Random();
        int position = 0;
        int diceNo = random.nextInt(6) + 1;
        System.out.println("Dice value: "+diceNo);

        int options = random.nextInt(3);
        switch (options){
            case LADDER :
                position += diceNo;
                break;
            case SNAKE:
                if (position != 0)
                    position -= diceNo;
                break;
            case NO_PLAY:
                break;
        }
        System.out.println("Player is at position "+position);
    }
}
