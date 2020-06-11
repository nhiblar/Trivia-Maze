package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;

import Database.Database;
import Database.Question;
//import GUI.AllDoorButtons.BtnGrpListener;
//import TrivaMaze.MazeBuilder;
//import TrivaMaze.CellState.CheckRoom;

public class TriviaController {

	public TriviaView theView;
	public TriviaModel theModel;
	private String multAnswer;
	private Database theDatabase;
	private String userGuess = "";
	private String correctAnswer = "";
	private String curRoom = "";
	private ActionEvent source;

	public TriviaController(TriviaView theView, TriviaModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theDatabase = new Database();
		Database.ResetUsedVariable();
		this.theView.addSubmitListener(new SubmitListener());
		this.theView.addMenuListener(new MenuListener());
		this.theView.addDoorListener(new DoorListener());
	}
	int [][] maze = 
		{ {0, 0, 0, 0, 0, 0, 0},
		  {0,-1, 0,-1, 0,-1, 0},
		  {0, 0, 0, 0, 0, 0, 0},
		  {0,-1, 0,-1, 0,-1, 0},
		  {0, 0, 0, 0, 0, 0, 0},
		  {0,-1, 0,-1, 0,-1, 0},
		  {0, 0, 0, 0, 0, 0, 0}

		};
	public void Tracker(int row, int colum) {
		
		maze[row][colum] = -1;		
		
	}
	public void win(int row, int colum) {
		maze[row][colum] = 2;
	}
	public void visited(int row, int colum) {
		
		maze[row][colum] = 1;
	}
	
	public static boolean isPath(int arr[][]) 
    { 
        // set arr[0][0] = 1 
        arr[0][0] = 1; 
  
        // Mark reachable (from top left) nodes 
        // in first row and first column. 
        for (int i = 1; i < 7; i++) 
            if (arr[0][i] != -1) 
                arr[0][i] = arr[0][i - 1]; 
        for (int j = 1; j < 7; j++) 
            if (arr[j][0] != -1) 
                arr[j][0] = arr[j - 1][0]; 
  
        // Mark reachable nodes in 
        //  remaining matrix. 
        for (int i = 1; i < 7; i++) 
            for (int j = 1; j < 7; j++) 
                if (arr[i][j] != -1) 
                    arr[i][j] = Math.max(arr[i][j - 1], 
                                        arr[i - 1][j]); 
        
        // return yes if right  
        // bottom index is 1 
        return (arr[7 - 1][7 - 1] == 1); 
    }
	
	private void youWin()
	{
		int dialog = JOptionPane.showConfirmDialog(null,
				"Congratulations, you win!!\n"
						+ "Would you like to play again?", "Game Over",
				JOptionPane.YES_NO_OPTION);
		if (dialog == JOptionPane.NO_OPTION)
			System.exit(0);
		
	}

	private void youLose()
	{
		int dialog = JOptionPane.showConfirmDialog(null, "ALMOST!\n"
				+ "Would you like to play again?", "Game Over",
				JOptionPane.YES_NO_OPTION);
		if (dialog == JOptionPane.NO_OPTION)
			System.exit(0);
		
			
	}
	public void checkGameOver() {
		youLose();
	}
	
	int counter = 0;
	class SubmitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource() == theView.getSubmitButton()) {

				for (Enumeration<AbstractButton> buttons = theView.getMultButtons().getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						userGuess = button.getText();
						if(userGuess.contentEquals(correctAnswer)) {
							
							System.out.println("Correct Answer in Sumbit Listener.");
							userGuess = "";
							
							if(source.getSource() == theView.getBut1() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 2"));
								theView.leaveRoom(theView.getRoom("Enter"));
								counter++;
								visited(0,0);
								visited(0,2);
							}else if(source.getSource() == theView.getBut1() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("Enter"));
								theView.leaveRoom(theView.getRoom("room 2"));
								counter--;
							}


							if(source.getSource() == theView.getBut2() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 3"));
								theView.leaveRoom(theView.getRoom("room 2"));
								counter++;
								visited(0,4);
							}else if(source.getSource() == theView.getBut2() && counter == 1){
								theView.setCurrentRoom(theView.getRoom("room 2"));
								theView.leaveRoom(theView.getRoom("room 3"));
								counter--;	
							}

							if(source.getSource() == theView.getBut3() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 4"));
								theView.leaveRoom(theView.getRoom("room 3"));
								counter++;
								visited(0,6);
							}else if(source.getSource() == theView.getBut3() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 3"));
								theView.leaveRoom(theView.getRoom("room 4"));
								counter--;
							}


							if(source.getSource() == theView.getBut4() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 5"));
								theView.leaveRoom(theView.getRoom("Enter"));
								counter++;
								visited(2,0);
							}else if(source.getSource() == theView.getBut4() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("Enter"));
								theView.leaveRoom(theView.getRoom("room 5"));
								counter--;
							}

							if(source.getSource() == theView.getBut5() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 2"));
								counter++;
								visited(2,2);
							}else if(source.getSource() == theView.getBut5() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 2"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter--;
							}

							if(source.getSource() == theView.getBut6() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 3"));
								counter++;
								visited(2,4);
							}else if(source.getSource() == theView.getBut6() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 3"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter--;
							}

							if(source.getSource() == theView.getBut7() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 8"));
								theView.leaveRoom(theView.getRoom("room 4"));
								counter++;
								visited(2,6);
							}else if(source.getSource() == theView.getBut7() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 4"));
								theView.leaveRoom(theView.getRoom("room 8"));
								counter--;
							}

							if(source.getSource() == theView.getBut8() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 5"));
								counter++;
								visited(2,2);
							}else if(source.getSource() == theView.getBut8() && counter == 1){
								theView.setCurrentRoom(theView.getRoom("room 5"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter--;
							}

							if(source.getSource() == theView.getBut9() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter++;
								visited(2,4);
							}else if(source.getSource() == theView.getBut9() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter--;
							}

							if(source.getSource() == theView.getBut10() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 8"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter++;
								visited(2,6);
							}else if(source.getSource() == theView.getBut10() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 8"));
								counter--;
							}

							if(source.getSource() == theView.getBut11() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 9"));
								theView.leaveRoom(theView.getRoom("room 5"));
								counter++;
								visited(4,0);
							}else if(source.getSource() == theView.getBut11() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 5"));
								theView.leaveRoom(theView.getRoom("room 9"));
								counter--;
							}

							if(source.getSource() == theView.getBut12() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter++;
								visited(4,2);
							}else if(source.getSource() == theView.getBut12() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter--;
							}

							if(source.getSource() == theView.getBut13() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter++;
								visited(4,4);
							}else if(source.getSource() == theView.getBut13() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter--;
							}

							if(source.getSource() == theView.getBut14() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 12"));
								theView.leaveRoom(theView.getRoom("room 8"));
								counter++;
								visited(4,6);
							}else if(source.getSource() == theView.getBut14() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 8"));
								theView.leaveRoom(theView.getRoom("room 12"));
								counter--;
							}

							if(source.getSource() == theView.getBut15() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 9"));
								counter++;
								visited(4,2);
							}else if(source.getSource() == theView.getBut15() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 9"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter--;
							}

							if(source.getSource() == theView.getBut16() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter++;
								visited(4,4);
							}else if(source.getSource() == theView.getBut16() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter--;
							}
							if(source.getSource() == theView.getBut17() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 12"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter++;
								visited(4,6);
							}else if(source.getSource() == theView.getBut17() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 12"));
								counter--;
							}
							if(source.getSource() == theView.getBut18() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 13"));
								theView.leaveRoom(theView.getRoom("room 9"));
								counter++;
								visited(6,0);
							}else if(source.getSource() == theView.getBut18() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 9"));
								theView.leaveRoom(theView.getRoom("room 13"));
								counter--;
							}

							if(source.getSource() == theView.getBut19() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 14"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter++;
								visited(6,2);
							}else if(source.getSource() == theView.getBut19() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 14"));
								counter--;
							}
							if(source.getSource() == theView.getBut20() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 15"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter++;
								visited(6,5);
							}else if(source.getSource() == theView.getBut20() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 15"));
								counter--;
							}
							if(source.getSource() == theView.getBut21() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("Exit"));
								theView.leaveRoom(theView.getRoom("room 12"));
								counter++;
								win(6,6);
							}else if(source.getSource() == theView.getBut21() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 12"));
								theView.leaveRoom(theView.getRoom("Exit"));
								counter--;
							}
							if(source.getSource() == theView.getBut22() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 14"));
								theView.leaveRoom(theView.getRoom("room 13"));
								counter++;
								visited(6,2);
							}else if(source.getSource() == theView.getBut22() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 13"));
								theView.leaveRoom(theView.getRoom("room 14"));
								counter--;
							}
							if(source.getSource() == theView.getBut23() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 15"));
								theView.leaveRoom(theView.getRoom("room 14"));
								counter++;
								visited(6,4);
							}else if(source.getSource() == theView.getBut23() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 14"));
								theView.leaveRoom(theView.getRoom("room 15"));
								counter--;
							}
							if(source.getSource() == theView.getBut24() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("Exit"));
								theView.leaveRoom(theView.getRoom("room 15"));
								counter++;
								win(6,6);
							}else if(source.getSource() == theView.getBut24() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 15"));
								theView.leaveRoom(theView.getRoom("Exit"));
								counter--;
							}
							
						}else {
							System.out.println("Wrong Answer in Sumbit Listener.");
							if(source.getSource() == theView.getBut1()) {
								theView.getBut1().setVisible(false);
								Tracker(0,1);
							}if(source.getSource() == theView.getBut2()) {
								theView.getBut2().setVisible(false);
								Tracker(0,3);
							}if(source.getSource() == theView.getBut3()) {
								theView.getBut3().setVisible(false);
								Tracker(0,5);
							}if(source.getSource() == theView.getBut4()) {
								theView.getBut4().setVisible(false);
								Tracker(1,0);
							}if(source.getSource() == theView.getBut5()) {
								theView.getBut5().setVisible(false);
								Tracker(1,2);
							}if(source.getSource() == theView.getBut6()) {
								theView.getBut6().setVisible(false);
								Tracker(1,4);
							}if(source.getSource() == theView.getBut7()) {
								theView.getBut7().setVisible(false);
								Tracker(1,6);
							}if(source.getSource() == theView.getBut8()) {
								theView.getBut8().setVisible(false);
								Tracker(2,1);
							}if(source.getSource() == theView.getBut9()) {
								theView.getBut9().setVisible(false);
								Tracker(2,3);
							}if(source.getSource() == theView.getBut10()) {
								theView.getBut10().setVisible(false);
								Tracker(2,5);
							}if(source.getSource() == theView.getBut11()) {
								theView.getBut11().setVisible(false);
								Tracker(3,0);
							}if(source.getSource() == theView.getBut12()) {
								theView.getBut12().setVisible(false);
								Tracker(3,2);
							}if(source.getSource() == theView.getBut13()) {
								theView.getBut13().setVisible(false);
								Tracker(3,4);
							}if(source.getSource() == theView.getBut14()) {
								theView.getBut14().setVisible(false);
								Tracker(3,6);
							}if(source.getSource() == theView.getBut15()) {
								theView.getBut15().setVisible(false);
								Tracker(4,1);
							}if(source.getSource() == theView.getBut16()) {
								theView.getBut16().setVisible(false);
								Tracker(4,3);
							}if(source.getSource() == theView.getBut17()) {
								theView.getBut17().setVisible(false);
								Tracker(4,5);
							}if(source.getSource() == theView.getBut18()) {
								theView.getBut18().setVisible(false);
								Tracker(5,0);
							}if(source.getSource() == theView.getBut19()) {
								theView.getBut19().setVisible(false);
								Tracker(5,2);
							}if(source.getSource() == theView.getBut20()) {
								theView.getBut20().setVisible(false);
								Tracker(5,4);
							}if(source.getSource() == theView.getBut21()) {
								theView.getBut21().setVisible(false);
								Tracker(5,6);
							}if(source.getSource() == theView.getBut22()) {
								theView.getBut22().setVisible(false);
								Tracker(6,1);
							}if(source.getSource() == theView.getBut23()) {
								theView.getBut23().setVisible(false);
								Tracker(6,3);
							}if(source.getSource() == theView.getBut24()) {
								theView.getBut24().setVisible(false);
								Tracker(6,5);
							}
						}
						if(maze[6][6] == 2) {
							youWin();
						}
						if(isPath(maze) == true) {
							
						}else {
							youLose();
						}
					}
				}//end for check multButton source
			}//end if e.getSource
		}//end actionPerformed method
	}//end class SubmitListener
	
	class MenuListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getSave()){
				System.out.println("Saved in Menu, File clicked");

			}if(e.getSource() == theView.getLoad()){
				System.out.println("Load in Menu, File clicked");

			}if(e.getSource() == theView.getQuit()){
				System.out.println("Quit in Menu, File clicked");

			}if(e.getSource() == theView.getAbout()){
				theView.aboutPanel();
			}
		}
	}

	class DoorListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {

			source = e;
			
			if(e.getSource() == theView.getBut1() || e.getSource() == theView.getBut2() || e.getSource() == theView.getBut3() ||
					e.getSource() == theView.getBut4() || e.getSource() == theView.getBut5() || e.getSource() == theView.getBut6() ||
					e.getSource() == theView.getBut7() || e.getSource() == theView.getBut8() || e.getSource() == theView.getBut9() || 
					e.getSource() == theView.getBut10() || e.getSource() == theView.getBut11() || e.getSource() == theView.getBut12() || 
					e.getSource() == theView.getBut13() || e.getSource() == theView.getBut14() || e.getSource() == theView.getBut15() || 
					e.getSource() == theView.getBut16() || e.getSource() == theView.getBut17() || e.getSource() == theView.getBut18() ||
					e.getSource() == theView.getBut19() || e.getSource() == theView.getBut20() || e.getSource() == theView.getBut21() ||
					e.getSource() == theView.getBut22() || e.getSource() == theView.getBut23() || e.getSource() == theView.getBut24());	{
				Database.ResetUsedVariable();
				Question curQ = Database.GetMultipleChoiceQuestion();
				theView.setQuestionPanel(curQ);
				correctAnswer = curQ.GetCorrect();
			}

			if(!userGuess.isEmpty() && ! correctAnswer.isEmpty()) {

				
			}//end for check multButton source
		}//end actionPerformed method
	}//end class SubmitListener



}

