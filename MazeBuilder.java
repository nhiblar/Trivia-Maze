package TrivaMaze;

import java.util.Random;

import TrivaMaze.CellState.CheckRoom;


public class MazeBuilder {
	
	public static QuestionGenerator QG;
	private CellState[][] mazeBuilder;
	private boolean gameOver;
	public static final int mazeSize = 8;
	
	public MazeBuilder() {
		
		refresh();
	}
	
	public void refresh() {
		QG = new QuestionGenerator();
		mazeBuilder = new CellState[mazeSize][mazeSize];
		mazeGenerator();
	}
	
	public CellState getCell(int x, int y) {
		if(!checkBounds(x,y))
			return null;
		return mazeBuilder[x][y];
	}
	
	public boolean checkBounds(int x, int y) {
		return (x >= 0 && x < mazeSize) && (y >= 0 && y < mazeSize);
	}
	
	public CheckRoom checkCell(int x, int y) {
		if(!checkBounds(x,y))
			return getCell(x,y).getState();
		else
			return CheckRoom.BLOCKED;
	}
	
	public boolean GameOver() {
		return gameOver;
	}
	
	public void setGameState(boolean s) {
		gameOver = s;
	}
	
	public void mazeGenerator() {
		Random gen = new Random();
		for(int i = 0; i < mazeSize; i++) {
			for(int j = 0; j < mazeSize; j++) {
				mazeBuilder[i][j] = new CurrentRoom(i, j, QG.getRandomQuestion());
				if(i == 0 || j == 0 || i == mazeSize - 1 || j == mazeSize - 1 || i - j == 0 || i - j == 1)
					mazeBuilder[i][j].setRoom(CheckRoom.BLOCKED);
			}
		}
		mazeBuilder[0][0].setRoom(CheckRoom.UNLOCKED);
	}
}
