package Project_1;

import java.util.ArrayList;


public class Game {

	private int boardSize;
	private Square[] gameBoard; // squares starting at index 1

	private ArrayList<Player> players;
	private int nextPlayerIndex = 0;


	public Game(int size, String[] playerNames) {

		// ensure firstSquare != lastSquare
		if (size < 2) {
			size = 2;
			System.out.println("Set board size to 2 (minimum size).");
		}

		players = new ArrayList<Player>();

	    boardSize = size;
	    gameBoard = new Square[boardSize + 1]; // leave first empty -> Square.numberSquare == index

		gameBoard[1] = new FirstSquare(1);
		gameBoard[boardSize] = new LastSquare(boardSize);

		for(int i = 2; i < boardSize; ++i) {
			gameBoard[i] = new NormalSquare(i); //normal square
		}

		// add snaked, ladders
		for(int i = 3; i <= boardSize - 5; i += 3) {
			Square destination;

			// snakes every 6. field starting at 6, moving the player 4 back
			if (i % 6 == 0) {
				destination = gameBoard[i - 4];
			}
			// snakes every 6. field starting at 3, moving the player 5 ahead
			else {
				destination = gameBoard[i + 5];
			}
			gameBoard[i] = new TeleportSquare(i, destination); // replace square
		}

		for (String name : playerNames) { //set up all players in the first square
			Player player = new Player(name);
			players.add(player);
            player.setPosition(gameBoard[1]);
        }
	}

	public int getBoardSize() {
	    return this.boardSize;
    }

    public Player getNextPlayer() { return players.get(nextPlayerIndex); }

    public Square getFirstSquare() { return gameBoard[1]; }

	public Square getLastSquare() { return gameBoard[boardSize]; }


    // Rolls the dice and moves the player accordingly (obeying the rules).
	public void movePlayer(int stepCount) {

		if (players.size() != 0) {

			Player currentPlayer = players.get(nextPlayerIndex);

			int destinationNumber = calculateDestinationIndex(currentPlayer.getPosition().getNumberSquare(), stepCount);

			currentPlayer.leavePosition();
			currentPlayer.setPosition(gameBoard[destinationNumber]);

			// loop through players
			nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
		}
	}


	// Index (numberSquare) of the square to which the player should be moved with diceResult.
	private int calculateDestinationIndex(int originIndex, int stepsForward) {

		// index (numberSquare) of square where player will land
		int destinationNumber = originIndex + stepsForward;

		// player would go over last square -> move backwards after reaching it
		if (destinationNumber > boardSize) {
			destinationNumber = boardSize - (destinationNumber - boardSize);
		}

		// went to before the first square or destination already occupied -> go to beginning
		if (destinationNumber <= 1 || gameBoard[destinationNumber].isOccupied()) {
			return 1;
		}
		return destinationNumber;
	}


	public String toString() {
		String result="";
		for(int i = 1; i <= boardSize; ++i) {
            result += gameBoard[i].toString();
        }
		return result;
	}
	
	public boolean isFinished() {
		return gameBoard[boardSize].isOccupied();
	}
}
