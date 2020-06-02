package TrivaMaze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionHandler {
	
	
		private QuestionConduct questionConduct;
		private String[] IncorrectAnswers;
		private String correctAnswers;
		private String question;
		private int addy;
		

		public QuestionHandler(QuestionConduct qc, int address) {
			addy = address;
			setConduct(qc);
		}

		public void setConduct(QuestionConduct qc) {
			questionConduct = qc;
			initzialize();
		}
		
		public boolean checkCorrectAnswer(String answer) {
			return correctAnswers.equalsIgnoreCase(answer) || answer.equalsIgnoreCase("right");
		}

		public String getCorrectAnswer() {
			return correctAnswers;
		}

		public int getAddress() {
			return addy;
		}
		
		public String getQuestion() {
			return question;
		}

		public String getQuestionType() {
			if (IncorrectAnswers == null)
				return "shortAnswers";
			else if (IncorrectAnswers.length == 1)
				return "truefalse";
			else
				return "multipleChoice";
		}

		public ArrayList<String> getOptions() {
			if (IncorrectAnswers == null)
				return null;

			ArrayList<String> options = new ArrayList<>();

			options.add(correctAnswers);
			for (String i : IncorrectAnswers)
				options.add(i);

			Collections.sort(options);

			return options;
		}
		
		private void initzialize() {
			correctAnswers = questionConduct.getCorrectAnswer();
			IncorrectAnswers = questionConduct.getIncorrectAnswers();
			question = questionConduct.getQuestion();
		}
}
