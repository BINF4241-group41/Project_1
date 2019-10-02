package project;


import java.util.ArrayList;

public class FirstSquare implements ISquare {

	private ArrayList<Player> players = new ArrayList<Player>();
	private int numberSquare=0;
	
	public FirstSquare(int numberSquare) {
		this.numberSquare=numberSquare;
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public boolean isOccupied() {
		return (players.size() != 0);
	}

	@Override
	public String stamp() {
		return "["+numberSquare+getListAsName()+"]";
	}


	private String getListAsName() {
		String s="";
		for(Player p:players) {
			s.concat(p.getName());
		}
		return s;
	}

}
