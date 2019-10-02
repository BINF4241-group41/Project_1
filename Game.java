package project;


public class Game {
	
	private static int boardSize;
	private Square[] gameBoard;
	private FirstSquare firstSquare;
	private LastSquare lastSquare;

	public Game(int size, Player... players) {

	    boardSize = size;
	    gameBoard = new Square[size - 2];
		firstSquare = new FirstSquare(1); //first square
		
		for(int i = 2; i < size; ++i)
			gameBoard[i]= new Square(i); //normal square
		
		lastSquare = new LastSquare(size); //last square
		
		for(Player p : players) { //set up all players in the first square
            firstSquare.addPlayer(p);
        }
	}

	public int getBoardSize() {
	    return this.boardSize;
    }
	
	public String stamp() {
		String result="";
		for(int i = 2; i < boardSize; ++i) {
            result.concat(gameBoard[i].stamp());
        }
		return firstSquare.stamp() + result + lastSquare.stamp();
	}
	
	public boolean checkWin() {
		return lastSquare.isOccupied();
	}
}
