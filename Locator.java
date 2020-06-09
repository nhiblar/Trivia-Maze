package TrivaMaze;

import java.awt.Point;

import javax.swing.JOptionPane;

import TrivaMaze.CellState.CheckRoom;


public class Locator {
	protected MazeBuilder maze;
	protected Point cur;

	public Locator(MazeBuilder mazeUpdate, int x, int y)
	{
		maze = mazeUpdate;
		cur = new Point(x, y);
	}

	public int getX()
	{
		return cur.x;
	}

	public int getY()
	{
		return cur.y;
	}

	public void moveWest()
	{
		move(getX() - 1, getY());
	}

	public void moveEast()
	{
		move(getX() + 1, getY());
	}

	public void moveNorth()
	{
		move(getX(), getY() - 1);
	}

	public void moveSouth()
	{
		move(getX(), getY() + 1);
	}

	public void move(int x, int y)
	{
		if (maze.checkCell(x, y) == CheckRoom.UNLOCKED)
		{
			cur.setLocation(x, y);
		}
		if (maze.checkCell(x, y) == CheckRoom.LOCKED)
		{
			CurrentRoom room = (CurrentRoom) maze.getCell(x, y);
			QuestionPanel.getInstance().setRoom(room);
		}

		MiniMapPanel.getInstance().repaint();
		RoomPanel.getInstance().repaint();
	}

	public void checkGameOver()
	{
		if (maze.checkCell(MazeBuilder.mazeSize - 1, MazeBuilder.mazeSize - 1) == CheckRoom.SEALED
				|| !checkPaths())
			youLose();

		if (cur.x == MazeBuilder.mazeSize - 1
				&& cur.y == MazeBuilder.mazeSize - 1)
		{
			youWin();
		}
	}

	private void youWin()
	{
		int dialog = JOptionPane.showConfirmDialog(null,
				"Congratulations, you win!!\n"
						+ "Would you like to play again?", "Game Over",
				JOptionPane.YES_NO_OPTION);
		if (dialog == JOptionPane.NO_OPTION)
			System.exit(0);
		else
			reset();
	}

	private void youLose()
	{
		int dialog = JOptionPane.showConfirmDialog(null, "ALMOST!"\n"
				+ "Would you like to play again?", "Game Over",
				JOptionPane.YES_NO_OPTION);
		if (dialog == JOptionPane.NO_OPTION)
			System.exit(0);
		else
			reset();
	}

	public void reset()
	{
		maze.refresh();
		cur = new Point(0, 0);
		MiniMapPanel.getInstance().repaint();
		RoomPanel.getInstance().repaint();
		QuestionPanel.getInstance().reset();
	}

	private boolean checkPaths()
	{
		int[][] mazeUpdate = getIntMazeBuilder();
		return checkPath(mazeUpdate, cur.x, cur.y);
	}

	private boolean checkPath(int[][] mazeUpdate, int x, int y)
	{
		if (!maze.checkBounds(x, y) || mazeUpdate[y][x] == 0)
			return false;

		if (x == MazeBuilder.mazeSize - 1 && y == MazeBuilder.mazeSize - 1)
			return true;

		mazeUpdate[y][x] = 0;

		return checkPath(mazeUpdate, x + 1, y) || checkPath(mazeUpdate, x - 1, y)
				|| checkPath(mazeUpdate, x, y + 1) || checkPath(mazeUpdate, x, y - 1);
	}

	private int[][] getIntMazeBuilder()
	{
		int[][] mazeUpdate = new int[MazeBuilder.mazeSize][MazeBuilder.mazeSize];

		for (int y = 0; y < MazeBuilder.mazeSize; y++)
			for (int x = 0; x < MazeBuilder.mazeSize; x++)
				switch (maze.checkCell(x, y))
				{
				case UNLOCKED:
					mazeUpdate[y][x] = 1;
					break;
				case LOCKED:
					mazeUpdate[y][x] = 1;
					break;
				case BLOCKED:
					mazeUpdate[y][x] = 0;
				}

		return mazeUpdate;
	}

	public void save()
	{
		String saveName = JOptionPane.showInputDialog(null,
				"Choose a save name:", "Save name",
				JOptionPane.OK_CANCEL_OPTION);

		if (saveName == null)
			return;

		String code = "";

		for (int y = 0; y < MazeBuilder.mazeSize; y++)
			for (int x = 0; x < MazeBuilder.mazeSize; x++)
				switch (maze.checkCell(x, y))
				{
				case UNLOCKED:
					code += 0;
					break;
				case LOCKED:
					code += 1;
					break;
				case BLOCKED:
					code += 2;
				}

		code += getX();
		code += getY();

		DataBase.getInstance().save(saveName, code);
	}

	public void load(int id)
	{
		String code = DataBase.getInstance().retrieveSave(id);
		reset();
		cur.setLocation(
				code.charAt(MazeBuilder.mazeSize * MazeBuilder.mazeSize) - '0',
				code.charAt(MazeBuilder.mazeSize * MazeBuilder.mazeSize + 1) - '0');
		for (int r = 0; r < MazeBuilder.mazeSize; r++)
			for (int c = 0; c < MazeBuilder.mazeSize; c++)
			{
				int num = code.charAt(r * MazeBuilder.mazeSize + c) - '0';
				switch (num)
				{
				case 0:
					maze.getCell(c, r).setRoom(CheckRoom.UNLOCKED);
					break;
				case 1:
					maze.getCell(c, r).setRoom(CheckRoom.LOCKED);
					break;
				case 2:
					maze.getCell(c, r).setRoom(CheckRoom.BLOCKED);
					break;
				default:
					maze.getCell(c, r).setRoom(CheckRoom.LOCKED);
					break;
				}
			}
	}
}

