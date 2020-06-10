package Database;

public class Question {

	private String type;
	private String question;
	private String first;
	private String second;
	private String third;
	private String fourth;
	private String correct;
	
	public Question(String type, String question, String first, String second, String third, String fourth, String correct) {
		this.type = type;
		this.question = question;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.correct = correct;
	}
	
	public String GetType() {
		return this.type;
	}
	
	public String GetQuestion() {
		return this.question;
	}
	
	public String GetFirst() {
		return this.first;
	}
	
	public String GetSecond() {
		return this.second;
	}
		
	public String GetThird() {
		return this.third;
	}
	
	public String GetFourth() {
		return this.fourth;
	}
	
	public String GetCorrect() {
		return this.correct;
	}
}
