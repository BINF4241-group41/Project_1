package project;


public abstract class Square {

    protected int numberSquare;


    public int getNumberSquare() {
        return numberSquare;
    }

    public boolean isOccupied();

    public void addPlayer(Player player); // Game should check if already occupied.
    public void removePlayer();

    public String getPlayerName();

    public String toString();
}
