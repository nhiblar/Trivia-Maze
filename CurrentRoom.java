package TrivaMaze;

public class CurrentRoom extends CellState {
	private Question question;
	
	public CurrentRoom() {
		this.setX(x);
		this.setY(y);
	}
	public CurrentRoom(int x, int y, Question question) {
		this(x, y);
		this.question = question;
	}
	public Question getQuestion() {
		return this.question;
	}
}
