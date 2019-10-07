package project;


// Square without functionality (no snakes/ladders).
public class NormalSquare extends Square{
	

	private Player myPlayer=null;


	public NormalSquare(int numberSquare) {
		this.numberSquare=numberSquare;
	}

	public int getNumberSquare() {
		return numberSquare;
	}

	// move a player to the square
	@Override
	public void addPlayer(Player player) {
		myPlayer=player;
	}

	// remove a player from the square
	public void removePlayer() {
		myPlayer=null;
	}

	public boolean isOccupied() {
		return (myPlayer != null);
	}

	public String toString() {
		return "[" + numberSquare + "<" + getPlayerName() + ">" + "]";
	}

	public String getPlayerName() {
		return (myPlayer != null ? myPlayer.getName() : "");
	}
}
