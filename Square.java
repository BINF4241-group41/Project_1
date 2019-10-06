package project;


public abstract class Square {

    private int numberSquare;

    public boolean isOccupied();

    public void addPlayer(Player player); // Game should check if already occupied.
    public void removePlayer();
}
