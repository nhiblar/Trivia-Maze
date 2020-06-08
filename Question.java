
public class Question {

	private String type;
	private String question;
	private String primary;
	private String secondary;
	private String tertiary;
	private String tetrary;
	private String correct;
	
	public Question(String type, String question, String primary, String secondary, String tertiary, String tetrary, String correct) {
		this.type = type;
		this.question = question;
		this.primary = primary;
		this.secondary = secondary;
		this.tertiary = tertiary;
		this.tetrary = tetrary;
		this.correct = correct;
	}
	
	public String GetType() {
		return this.type;
	}
	
	public String GetQuestion() {
		return this.question;
	}
	
	public String Getprimary() {
		return this.primary;
	}
	
	public String Getsecondary() {
		return this.secondary;
	}
		
	public String Gettertiary() {
		return this.tertiary;
	}
	
	public String Gettetrary() {
		return this.tetrary;
	}
	
	public String GetCorrect() {
		return this.correct;
	}
}
