package TrivaMaze;

import java.util.Random;


public class TruFalActions implements QuestionConduct {
	
	private DataBase info;
	private int address;
	private boolean notTrue;

	public TruFalActions(int x) {
		info = DataBase.getInstance();
		address = x;
	}
	
	@Override
	public String getCorrectAnswer()
	{
		return !notTrue + "";
	}

	@Override
	public String[] getIncorrectAnswers()
	{
		String[] incorrect = new String[1];
		incorrect[0] = notTrue + "";
		return incorrect;
	}	

	@Override
	public String getQuestion()
	{
		Random r = new Random();
		int incorrect = DataBase.getInstance().randomAID(false);
		notTrue = r.nextBoolean();
		if (notTrue == false)
		{
			return "This can any Question " + info.retrieveA(address) + "?";
		}
		else
		{
			return "This can be any Question " + info.retrieveA(incorrect) + "?";
		}
	}
}