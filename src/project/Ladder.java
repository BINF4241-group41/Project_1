package project;

import java.util.Random;

public class Ladder extends Square{
    private Game game;
    private int NUM_PLAYERS= game.getNumberPlayers();
    private int[][] ladders;


    public Ladder (Game game) {
        Random rd = new Random();
        ladders = new int[NUM_PLAYERS][2];
        Square[] gameboard = game.getGameBoard();
        for (int i = 0; i < NUM_PLAYERS; i++) {
            int numberGenerated = rd.nextInt(game.getBoardSize()) + 1;
            // Creating the beginning of the snake
            if (!gameboard[numberGenerated].isOccupied()) {
                ladders[i][0] = numberGenerated;
                // Creating the end of the snake
                numberGenerated = rd.nextInt(game.getBoardSize()) + 1;
                if (!gameboard[numberGenerated].isOccupied()) {
                    ladders[i][1] = numberGenerated;
                }
            }
        }
    }


    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public void removePlayer() {

    }

    @Override
    public String toString() {
        return null;
    }
}