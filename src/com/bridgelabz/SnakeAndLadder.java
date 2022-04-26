package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadder {
    static Random random = new Random();
    public static final int START_POSITION = 0;
    public static final int END_POSITION = 100;
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;

    public static int diceRoll(){
        int diceValue = random.nextInt(6) + 1;
        System.out.println("Dice value: " + diceValue);
        return diceValue;
    }
    public static int rollDiceForPlayer(int player, int playerPosition){
        if (playerPosition == END_POSITION)
            return playerPosition;
        else {
            int diceNo = diceRoll();
            int options = random.nextInt(3);
            playerPosition = calculatePlayerMovement(options, diceNo, playerPosition, player);
            System.out.println("Player " + player + " is at position " + playerPosition);
            return playerPosition;
        }
    }
    public static int playerMoveLadder(int diceNo, int position){
        if (position == END_POSITION)
            return position;
        else {
            System.out.println("Yahoo! It's a ladder.");
            if (position + diceNo <= END_POSITION)
                position += diceNo;
            return position;
        }
    }
    public static int playerMoveSnake(int diceNo, int position){
        System.out.println("Oops! It's a snake.");
        if (position >= 0) {
            if (position - diceNo >= 0)
                position -= diceNo;
            else
                position = START_POSITION;
        }
        return position;
    }
    public static int calculatePlayerMovement(int options, int diceNo,int position, int currentPlayer){
        switch (options) {
            case LADDER:
                position = playerMoveLadder(diceNo, position);
                System.out.println("Player"+currentPlayer+" roll again.");
                position = rollDiceForPlayer(currentPlayer, position);
                break;
            case SNAKE:
                position = playerMoveSnake(diceNo, position);
                break;
            case NO_PLAY:
                System.out.println("Sorry, you can't move.");
                break;
        }
        return  position;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Snake & Ladder game! \nRoll a dice.");
        int noOfDiceRolls1 = 0, noOfDiceRolls2=0;
        int positionOfPlayer1 = 0, positionOfPlayer2 = 0;
        /* Use boolean currentPlayer to know which player's turn is ongoing
         * where true is for Player1 and
         * false is for Player2 */
        boolean currentPlayer = true;

        while (positionOfPlayer1 <= END_POSITION && positionOfPlayer2<=END_POSITION) {
            if (positionOfPlayer1 == END_POSITION){
                System.out.println("Congratulations! Player1 won.");
                break;
            } else if (positionOfPlayer2 == END_POSITION) {
                System.out.println("Congratulations! Player2 won.");
                break;
            } else {
                if (currentPlayer){
                    positionOfPlayer1 = rollDiceForPlayer(1, positionOfPlayer1);
                    currentPlayer = false;
                }
                else {
                    positionOfPlayer2 = rollDiceForPlayer(2,positionOfPlayer2);
                    currentPlayer = true;
                }
            }
        }
//        System.out.println("The player rolls the dice "+noOfDiceRolls+" times to win.");
    }
}
