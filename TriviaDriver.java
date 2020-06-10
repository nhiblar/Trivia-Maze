
import javax.swing.JLabel;

import Database.*;
import GUI.*;
import TriviaMaze.*;
import GUI.TriviaController;
import GUI.TriviaModel;
import GUI.TriviaView;

public class TriviaDriver {
	

	
	public static void main(String[] args) {
		
		Boolean gameOver = false;
		TriviaView theView = new TriviaView(null);
		TriviaModel theModel = new TriviaModel();
		TriviaController theController = new TriviaController(theView, theModel);
		theView.setCurrentRoom(theView.getRoom("Enter"));
	}
}