package project;

import java.util.Random;


public class Dice {

    Random rand = new Random();

    public int rollDice() {
        int num = rand.nextInt(6)+1;
        return num;
    }
}