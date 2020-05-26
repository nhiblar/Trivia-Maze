package TrivaMaze;

import java.util.Random;

public class QuestionGenerator {
	private Random question;
	
	public QuestionGenerator() {
		question = new Random();
	}
	
	public QuestionHandler questionCreation(String obj) {
		QuestionHandler ques;
		
		switch(obj.toLowerCase()) {
		case "muiltpleChoice":
			break;
		case "trueFalse":
			break;
		case "short":
			break;
		default:	
		}
		return ques;
	}
	
	
	public Question getQuestion() {
		switch (question.nextInt(3)) {
			case 0:
				return questionCreation("truefalse");
			case 1:
				return questionCreation("short");
			case 2:
				return questionCreation("muiltipleChoice");
			default:
				return questionCreation("truefalse");
		}
	}
	
}
