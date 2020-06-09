package TrivaMaze;

import java.util.Random;

public class MultiChoicActions implements QuestionConduct {
	private DataBase info;
	private int address;

	public MultiChoicActions(int id)
	{
		info = DataBase.getInstance();
		address = id;
	}

	@Override
	public String getCorrectAnswer()
	{
		return info.retrieveA(address);
	}

	@Override
	public String[] getIncorrectAnswers()
	{
		// Make random
		String[] incorrect = new String[3];
		int temp;
		for (int i = 0; i < 3; i++)
		{
			temp = DataBase.getInstance().randomAID(false);
			incorrect[i] = info.retrieveA(temp);
		}

		return incorrect;
	}
	
	@Override
	public String getQuestion()
	{
		return "This can be any question";
	}

}
