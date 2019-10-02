package project;


import java.util.ArrayList;

public class FirstSquare implements ISquare {

	private ArrayList<Player> players;
	private int numberSquare=0;
	
	public FirstSquare(int numberSquare) {
		this.numberSquare=numberSquare;
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

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
