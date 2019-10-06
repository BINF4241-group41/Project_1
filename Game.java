package project;


public class Game {

	private Dice dice;

	private int boardSize;
	private Square[] gameBoard; // squares starting at index 1

	private ArrayList<Player> players;
	private nextPlayerIndex;


	public Game(int size, Player... players) {

		// ensure firstSquare != lastSquare
		if (size < 2) {
			size = 2;
		}

		dice = new Dice();

	    boardSize = size;
	    gameBoard = new Square[boardSize + 1];
		nextPlayerIndex = 0;

		gameBoard[1] = new FirstSquare(1);
		gameBoard[boardSize] = new LastSquare(boardSize);

		for(int i = 2; i < boardSize; ++i)
			gameBoard[i]= new Square(i); //normal square
		
		for (Player p : players) { //set up all players in the first square
			this.players.add(p);
            p.setPosition(gameBoard[1]);
        }
	}

	public int getBoardSize() {
	    return this.boardSize;
    }

    public Square getFirstSquare() { return gameBoard[1]; }

	public Square getLastSquare() { return gameBoard[boardSize]; }


    // Rolls the dice and moves the player accordingly (obeying the rules).
	public void nextAction() {

		if (players.size() != 0) {

			int diceResult = dice.rollDice();
			currentPlayer = players.get(nextPlayerIndex);

			// player would go over last square -> move backwards after reaching it
			if (currentPlayer.getPosition().getNumberSquare() + diceResult > boardSize) {
				diceResult = boardSize - currentPlayer.getPosition().getNumberSquare() - diceResult;
			}

			// index (numberSquare) of square where player lands
			int destinationNumber = currentPlayer.getPosition().getNumberSquare() + diceResult;

			// went to before the first square or already occupied -> go to beginning
			if (destinationNumber <= 1 || gameBoard.get(destinationNumber).isOccupied()) {
				currentPlayer.leavePosition();
				currentPlayer.setPosition(gameBoard[1]);
			}
			else {
				currentPlayer.leavePosition();
				currentPlayer.setPosition(gameBoard.get(destinationNumber));
			}

			System.out.println(currentPlayer.getName() + " rolls " + diceResult + " : " this.toString());

			// loop through players
			nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
		}
	}


	public String toString() {
		String result="";
		for(int i = 1; i <= boardSize; ++i) {
            result.concat(gameBoard[i].toString());
        }
		return result;
	}
	
	public boolean isFinished() {
		return gameBoard[boardSize].isOccupied()
	}
}
