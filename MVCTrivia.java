import Database.*;

public class MVCTrivia {

	public static void main(String[] args) {
		
		TriviaView theView = new TriviaView();
		TriviaModel theModel = new TriviaModel();
		TriviaController theController = new TriviaController(theView, theModel);
		theView.setVisible(true);
		theView.setCurrentRoom(theView.getRoom("Enter"));
		
		Database db = new Database();
				
		
		
		
		//theView.updateQuestionPanel("multiple");
		
	}
	
}