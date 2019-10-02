package project;

public class LastSquare implements InterfaceSquare {

	
	
	private Player myPlayer=null;
	private int numberSquare=0;

	public LastSquare(int numberSquare) {
		this.numberSquare=numberSquare;
	}
	
	public boolean checkWin() {
		if (myPlayer!=null)return true;
		return false;
	}
	
	@Override
	public boolean setPerson(Player player) {
		if(myPlayer==null) {
			myPlayer=player;
			return true;
		}
		return false;
	}


	@Override
	public String stamp() {
		return "["+numberSquare+"]";
	}

}
