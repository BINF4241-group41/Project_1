package project;


public class Game {
	
	private static final int NUMBER_SQUARE=10;
	private static final int FIRST_SQUARE=1;
	private static final int OFFSET_SQUARE=2;
	
	private Square[] gameBoard;
	private FirstSquare firstSquare;
	private LastSquare lastSquare;

	public Game(Player... players) {
		firstSquare=new FirstSquare(FIRST_SQUARE); //first square
		
		for(int i=0;i<NUMBER_SQUARE;i++)
			gameBoard[i]= new Square(i+OFFSET_SQUARE); //normal square
		
		lastSquare=new LastSquare(NUMBER_SQUARE+OFFSET_SQUARE); //last square
		
		for(Player p : players)				//set up all players in the first square
			firstSquare.setPerson(p);
	}
	
	
	public String stamp() {
		String result="";
		for(int i=1;i<NUMBER_SQUARE;i++)
			result.concat(gameBoard[i].stamp());	
		return firstSquare.stamp()+result+lastSquare.stamp();
	}
	
	public boolean checkWin() {
		return lastSquare.isOccupied();
	}
	

}
