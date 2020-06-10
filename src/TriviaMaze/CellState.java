package TriviaMaze;

public class CellState {
	public enum CheckRoom {
		BLOCKED, LOCKED, UNLOCKED
	};
	
	private CheckRoom roomState;
	protected int x, y;
	
	public CellState() {
		setRoom(CheckRoom.BLOCKED);
	}
	public CellState(int x, int y) {
		this();
		this.setX(x);
		this.setY(y);
	}
	public void setX(int xUpdate) {
		this.x = xUpdate;
	}
	public void setY(int yUpdate) {
		this.y = yUpdate;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public CheckRoom getState() {
		return roomState;
	}
	public void setRoom(CheckRoom newRoom) {
		this.roomState = newRoom;
	}
	
}
