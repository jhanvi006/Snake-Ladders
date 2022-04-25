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
        int position = 0, diceNo, options, noOfDiceRolls = 0;

        while (position <= 100) {
            if (position == 100)
                break;
            else {
                diceNo = random.nextInt(6) + 1;
                noOfDiceRolls++;
                System.out.println("Dice value: " + diceNo);

                options = random.nextInt(3);
                switch (options) {
                    case LADDER:
                        if (position+diceNo<=100)
                            position += diceNo;
                        break;
                    case SNAKE:
                        if (position >= 0) {
                            if (position - diceNo >= 0)
                                position -= diceNo;
                            else
                                position = START_POSITION;
                        }
                        break;
                    case NO_PLAY:
                        break;
                }
                System.out.println("Player is at position " + position);
            }
        }
        System.out.println("The player rolls the dice "+noOfDiceRolls+" times to win.");
    }
}
