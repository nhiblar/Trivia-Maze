package TriviaMaze;

public class CurrentRoom extends CellState {
	
	private QuestionHandler question;
	
	public CurrentRoom(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	public CurrentRoom(int x, int y, QuestionHandler questionNew) {
		this(x,y);
		this.question = questionNew;
	}
	public QuestionHandler getQuestion() {
		return this.question;
	}
}
