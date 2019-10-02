package project;


public class LastSquare implements ISquare {

	private Player myPlayer=null;
	private int numberSquare=0;

	public LastSquare(int numberSquare) {
		this.numberSquare=numberSquare;
	}

	public int getNumberSquare() {
		return numberSquare;
	}

	public boolean isOccupied() {
		return (myPlayer != null);
	}
	
	@Override
	public void addPlayer(Player player) {
		myPlayer=player;
	}

	public void removePlayer() {
		myPlayer = null;
	}

	@Override
	public String stamp() {
		return "["+numberSquare+"]";
	}

}
