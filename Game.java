package project;


public class Game {

	private Dice dice;

	private int boardSize;
	private Square[] gameBoard;
	private FirstSquare firstSquare;
	private LastSquare lastSquare;

	private ArrayList<Player> players;
	private nextPlayerIndex;


	public Game(int size, Player... players) {

		dice = new Dice();

	    boardSize = size;
	    gameBoard = new Square[size-2];
		firstSquare = new FirstSquare(1); //first square

		nextPlayerIndex = 0;

		for(int i = 2; i < size; ++i)
			gameBoard[i]= new Square(i); //normal square
		
		lastSquare = new LastSquare(size); //last square
		
		for (Player p : players) { //set up all players in the first square
			this.players.add(p);
            p.setPosition(firstSquare);
        }
	}

	public int getBoardSize() {
	    return this.boardSize;
    }


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
				currentPlayer.setPosition(firstSquare);
			}
			else {
				currentPlayer.leavePosition();
				currentPlayer.setPosition(gameBoard.get(destinationNumber));
			}

			// loop through players
			nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
		}
	}


	public String toString() {
		String result="";
		for(int i = 0; i < boardSize-2; ++i) {
            result.concat(gameBoard[i].toString());
        }
		return firstSquare.toString() + result + lastSquare.toString();
	}
	
	public boolean isFinished() {
		return lastSquare.isOccupied()
	}
}
