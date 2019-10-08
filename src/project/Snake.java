package project;

import java.util.Random;

public class Snake extends Square {
    private Game game;
    private int NUM_PLAYERS= game.getNumberPlayers();

    private int NUM_SNAKES = NUM_PLAYERS; // this can be deleted, is for follow my diagram
    private int[][] snakes;


    public Snake (Game game) {
        Random rd = new Random();
        snakes = new int[NUM_PLAYERS][2];
        Square[] gameboard = game.getGameBoard();
        for (int i = 0; i < NUM_PLAYERS; i++) {
            int numberGenerated = rd.nextInt(game.getBoardSize()) + 1;
            // Creating the beginning of the snake
            if (!gameboard[numberGenerated].isOccupied()) {
                snakes[i][0] = numberGenerated; //This may change the value of gameboard[numberGenerated]
                // Creating the end of the snake
                numberGenerated = rd.nextInt(game.getBoardSize()) + 1;
                if (!gameboard[numberGenerated].isOccupied()) {
                    snakes[i][1] = numberGenerated; //This may change the value of gameboard[numberGenerated]
                } else { i--; }
            } else { i--;}
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












     /*public boolean movePlayer(Player player, int value) {
        //Compute de new position
        int position = player.getPosition();
        position += value; // value is the number of the dice

        if (position >= game.getBoardSize()) {
            //If player is in last square or more, he wins and go to the last square
            player.setPosition(game.getBoardSize());
            return true;
        } else {
            //if new position is not last square..
            // checking new position is not the beginning of a snake
            for (int i=0; i < NUM_SNAKES; i++) {
                if (snakes[i][1] == player.getPosition()) {
                    position = snakes[i][0];
                    player.setPosition(position);
                    return false;
                }
            }

            // checking if new position is the beginning of a ladder
            for (int i=0; i < NUM_PLAYERS; i++) {
                if (ladders[i][0] == position) {
                    position = ladders[i][1];
                    player.setPosition(position);
                    return false;
                }
            }

            player.setPosition(position);
            return false;
        }
    }*/
}