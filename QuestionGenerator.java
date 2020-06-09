package TrivaMaze;

import java.util.Random;

public class QuestionGenerator {
	private Random question;
	
	public QuestionGenerator() {
		question = new Random();
	}
	
	public QuestionHandler questionCreation(String obj) {
		QuestionConduct conduct = null;
		QuestionHandler newQues;
		int address = DataBase.getInstance().randomAID(true);
		
		switch(obj.toLowerCase()) {
		case "muiltpleChoice":
			break;
		case "trueFalse":
			break;
		case "short":
			break;
		default:	
		}
		newQues = new QuestionHandler(conduct, address);
		return newQues;
	}
	
	
	public QuestionHandler getQuestion() {
		switch (question.nextInt(3)) {
			case 0:
				return questionCreation("truefalse");
			case 1:
				return questionCreation("shortAnswers");
			case 2:
				return questionCreation("muiltipleChoice");
			default:
				return questionCreation("truefalse");
		}
	}
	
}
