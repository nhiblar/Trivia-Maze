package TrivaMaze;

public class ShActions implements QuestionConduct {
	private DataBase info;
	private int address;

	public ShActions(int x)
	{
		info = DataBase.getInstance();
		address = x;
	}

	@Override
	public String getCorrectAnswer() {
		return info.retrieveA(address);
	}

	@Override
	public String[] getIncorrectAnswers() {
		return null;
	}
	
	
	@Override
	public String getQuestion()
	{
		return "This can be any Question";
	}	

}

