package project;


public interface ISquare {

    public boolean isOccupied();
    public void addPlayer(); // Game should check if already occupied.
    public void removePlayer();
}
