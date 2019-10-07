package project;

import java.util.Random;


public class Dice {

    private Random rand = new Random();

    private int eyeNumber = rollDice(); // result of last roll


    public int getEyeNumber() {
        return eyeNumber;
    }

    public int rollDice() {
        int num = rand.nextInt(6) + 1;
        return num;
    }
}