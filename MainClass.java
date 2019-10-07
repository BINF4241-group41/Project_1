package Project_1;

import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {

    // Arguments: [boardSize (int), name1, name2, name3, name4]
    public static void main(String[] args) {

        Game myGame;
        Dice myDice = new Dice();

        // variables for input parameters
        int boardSize;
        ArrayList<String> playerNames = new ArrayList<String>();

        Scanner myScanner = new Scanner(System.in);

        do {
            System.out.println("Enter the number of squares of the board (must be a positive integer)");
            String size = myScanner.nextLine();
            boardSize = Integer.parseInt(size);
        }
        while (boardSize < 1);


        for (int i = 0; i < 4; ++i) {
            System.out.println("Enter the name of the next player (or START to begin the game)");
            String nextName = myScanner.nextLine();

            if (nextName.equals("START")) {
                break;
            }
            playerNames.add(nextName);
        }

        // ensure that there are 2+ players
        for (int i = playerNames.size(); i < 2; ++i) {
            playerNames.add("AIPlayer" + i);
        }

        myGame = new Game(boardSize, playerNames.toArray(new String[playerNames.size()]));
        System.out.println("Initial state: " + myGame.toString());

        do {
            int diceResult = myDice.rollDice();
            System.out.println(myGame.getNextPlayer().getName() + " rolls " + diceResult + ": " + myGame.toString());
            myGame.movePlayer(diceResult); // roll dice, move player
        }
        while (!myGame.isFinished());

        System.out.println("Final state: " + myGame.toString());
        System.out.println(myGame.getLastSquare().getPlayerName() + " wins!");
    }
}