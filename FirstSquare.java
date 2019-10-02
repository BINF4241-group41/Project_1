package project;

import java.util.ArrayList;

public class FirstSquare implements InterfaceSquare {

	private ArrayList<Player> players=null;
	private int numberSquare=0;
	
	public FirstSquare(int numberSquare) {
		this.numberSquare=numberSquare;
	}
	
	
	public void setPlayer(Player p) {
	
	}

	@Override
	public boolean setPerson(Player p) {
		players.add(p);
		return true;
	}

	public void remove(Player player) {
		players.remove(player);
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
