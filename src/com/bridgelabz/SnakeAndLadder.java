package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadder {
    static Random random = new Random();
    public static final int START_POSITION = 0;
    public static final int END_POSITION = 100;
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;

    public static int DiceRoll(){
        int diceValue = random.nextInt(6) + 1;
        System.out.println("Dice value: " + diceValue);
        return diceValue;
    }
    public static int PlayerMoveLadder(int diceNo, int position){
        System.out.println("Yahoo! It's a ladder.");
        if (position+diceNo<=END_POSITION)
            position += diceNo;
        return position;
    }
    public static int PlayerMoveSnake(int diceNo, int position){
        System.out.println("Oops! It's a snake.");
        if (position >= 0) {
            if (position - diceNo >= 0)
                position -= diceNo;
            else
                position = START_POSITION;
        }
        return position;
    }
    public static int CalculatePlayerMovement(int options, int diceNo,int position){
        switch (options) {
            case LADDER:
                position = PlayerMoveLadder(diceNo, position);
                break;
            case SNAKE:
                position = PlayerMoveSnake(diceNo, position);
                break;
            case NO_PLAY:
                System.out.println("Sorry, you can't move.");
                break;
        }
        return  position;
    }
    public static void main(String[] args) {

        System.out.println("Welcome to Snake & Ladder game! \nRoll a dice.");
        int position = 0, diceNo, options, noOfDiceRolls = 0;
//        int positionOfPlayer1 = 0, positionOfPlayer2 = 0;

        while (position <= END_POSITION) {
            if (position == END_POSITION){
                System.out.println("Congratulations! You won.");
                break;
            }
            else {
                diceNo = DiceRoll();
                noOfDiceRolls++;

                options = random.nextInt(3);
                position = CalculatePlayerMovement(options, diceNo, position);
                System.out.println("Player is at position " + position);
            }
        }
        System.out.println("The player rolls the dice "+noOfDiceRolls+" times to win.");
    }
}
