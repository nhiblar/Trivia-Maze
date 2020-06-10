import Database.*;
import GUI.*;
import TriviaMaze.*;
import GUI.TriviaController;
import GUI.TriviaModel;
import GUI.TriviaView;

public class TriviaDriver {

	public static void main(String[] args) {
		
		TriviaView theView = new TriviaView();
		TriviaModel theModel = new TriviaModel();
		TriviaController theController = new TriviaController(theView, theModel);
		
		new Database();
		Database.ResetUsedVariable(); 
//      Question newQ = Database.GetMultipleChoiceQuestion();
//		Question newQ = Database.GetTrueFalseQuestion();
//		theView.updateQuestionPanel(newQ);
//		newQ = Database.GetMultipleChoiceQuestion();
//		theView.updateQuestionPanel(newQ);
		
	}
	
}