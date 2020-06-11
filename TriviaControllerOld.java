package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import Database.Database;
import Database.Question;

public class TriviaControllerOld {

	public TriviaView theView;
	public TriviaModel theModel;
	private Database theDatabase;
	private String userGuess = "";
	private String correctAnswer = "";
	private ActionEvent source;
	private Question curQ;
	private String qType;
	private int counter = 0;

	public TriviaController(TriviaView theView, TriviaModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theDatabase = new Database();
		Database.ResetUsedVariable();
		this.theView.addSubmitListener(new SubmitListener());
		this.theView.addMenuListener(new MenuListener());
		this.theView.addDoorListener(new DoorListener());
	}
	

	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == theView.getSubmitButton()) {
				
				for (Enumeration<AbstractButton> buttons = theView.getMultButtons().getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					
					if (button.isSelected() || qType.equals("short")) {
						
						if(qType.equals("short")) {
							userGuess = theView.getShortAnswer();
						}else {
							userGuess = button.getText();
						}
						
						if(button.equals(theView.getCheatButton())) {
							userGuess = correctAnswer;
							System.out.println("Made it to cheat button.");
						}
							
						if(userGuess.equals(correctAnswer)) {
							userGuess = "";
							
							if(source.getSource() == theView.getBut1() && counter == 0){
								System.out.println("Reached button 1");
								theView.setCurrentRoom(theView.getRoom("room 2"));
								System.out.println("Reached 2");
								theView.leaveRoom(theView.getRoom("Enter"));
								System.out.println("Reached 3");
								counter++;
							}else if(source.getSource() == theView.getBut1() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("Enter"));
								theView.leaveRoom(theView.getRoom("room 2"));
								counter--;
							}


							if(source.getSource() == theView.getBut2() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 3"));
								theView.leaveRoom(theView.getRoom("room 2"));
								counter++;
							}else if(source.getSource() == theView.getBut2() && counter == 1){
								theView.setCurrentRoom(theView.getRoom("room 2"));
								theView.leaveRoom(theView.getRoom("room 3"));
								counter--;	
							}

							if(source.getSource() == theView.getBut3() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 4"));
								theView.leaveRoom(theView.getRoom("room 3"));
								counter++;
							}else if(source.getSource() == theView.getBut3() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 3"));
								theView.leaveRoom(theView.getRoom("room 4"));
								counter--;
							}


							if(source.getSource() == theView.getBut4() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 5"));
								theView.leaveRoom(theView.getRoom("Enter"));
								counter++;
							}else if(source.getSource() == theView.getBut4() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("Enter"));
								theView.leaveRoom(theView.getRoom("room 5"));
								counter--;
							}

							if(source.getSource() == theView.getBut5() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 2"));
								counter++;
							}else if(source.getSource() == theView.getBut5() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 2"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter--;
							}

							if(source.getSource() == theView.getBut6() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 3"));
								counter++;
							}else if(source.getSource() == theView.getBut6() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 3"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter--;
							}

							if(source.getSource() == theView.getBut7() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 8"));
								theView.leaveRoom(theView.getRoom("room 4"));
								counter++;
							}else if(source.getSource() == theView.getBut7() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 4"));
								theView.leaveRoom(theView.getRoom("room 8"));
								counter--;
							}

							if(source.getSource() == theView.getBut8() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 5"));
								counter++;
							}else if(source.getSource() == theView.getBut8() && counter == 1){
								theView.setCurrentRoom(theView.getRoom("room 5"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter--;
							}

							if(source.getSource() == theView.getBut9() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter++;
							}else if(source.getSource() == theView.getBut9() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter--;
							}

							if(source.getSource() == theView.getBut10() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 8"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter++;
							}else if(source.getSource() == theView.getBut10() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 8"));
								counter--;
							}

							if(source.getSource() == theView.getBut11() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 9"));
								theView.leaveRoom(theView.getRoom("room 5"));
								counter++;
							}else if(source.getSource() == theView.getBut11() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 5"));
								theView.leaveRoom(theView.getRoom("room 9"));
								counter--;
							}

							if(source.getSource() == theView.getBut12() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 6"));
								counter++;
							}else if(source.getSource() == theView.getBut12() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 6"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter--;
							}

							if(source.getSource() == theView.getBut13() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 7"));
								counter++;
							}else if(source.getSource() == theView.getBut13() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 7"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter--;
							}

							if(source.getSource() == theView.getBut14() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 12"));
								theView.leaveRoom(theView.getRoom("room 8"));
								counter++;
							}else if(source.getSource() == theView.getBut14() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 8"));
								theView.leaveRoom(theView.getRoom("room 12"));
								counter--;
							}

							if(source.getSource() == theView.getBut15() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 9"));
								counter++;
							}else if(source.getSource() == theView.getBut15() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 9"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter--;
							}

							if(source.getSource() == theView.getBut16() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter++;
							}else if(source.getSource() == theView.getBut16() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter--;
							}
							if(source.getSource() == theView.getBut17() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 12"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter++;
							}else if(source.getSource() == theView.getBut17() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 12"));
								counter--;
							}
							if(source.getSource() == theView.getBut18() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 13"));
								theView.leaveRoom(theView.getRoom("room 9"));
								counter++;
							}else if(source.getSource() == theView.getBut18() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 9"));
								theView.leaveRoom(theView.getRoom("room 13"));
								counter--;
							}

							if(source.getSource() == theView.getBut19() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 14"));
								theView.leaveRoom(theView.getRoom("room 10"));
								counter++;
							}else if(source.getSource() == theView.getBut19() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 10"));
								theView.leaveRoom(theView.getRoom("room 14"));
								counter--;
							}
							if(source.getSource() == theView.getBut20() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 15"));
								theView.leaveRoom(theView.getRoom("room 11"));
								counter++;
							}else if(source.getSource() == theView.getBut20() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 11"));
								theView.leaveRoom(theView.getRoom("room 15"));
								counter--;
							}
							if(source.getSource() == theView.getBut21() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("Exit"));
								theView.leaveRoom(theView.getRoom("room 12"));
								counter++;
							}else if(source.getSource() == theView.getBut21() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 12"));
								theView.leaveRoom(theView.getRoom("Exit"));
								counter--;
							}
							if(source.getSource() == theView.getBut22() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 14"));
								theView.leaveRoom(theView.getRoom("room 13"));
								counter++;
							}else if(source.getSource() == theView.getBut22() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 13"));
								theView.leaveRoom(theView.getRoom("room 14"));
								counter--;
							}
							if(source.getSource() == theView.getBut23() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("room 15"));
								theView.leaveRoom(theView.getRoom("room 14"));
								counter++;
							}else if(source.getSource() == theView.getBut23() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 14"));
								theView.leaveRoom(theView.getRoom("room 15"));
								counter--;
							}
							if(source.getSource() == theView.getBut24() && counter == 0){
								theView.setCurrentRoom(theView.getRoom("Exit"));
								theView.leaveRoom(theView.getRoom("room 15"));
								counter++;
							}else if(source.getSource() == theView.getBut24() && counter == 1) {
								theView.setCurrentRoom(theView.getRoom("room 15"));
								theView.leaveRoom(theView.getRoom("Exit"));
								counter--;
							}
							
						}else {
							System.out.println("Wrong Answer in Sumbit Listener.");
							if(source.getSource() == theView.getBut1()) {
								theView.getBut1().setVisible(false);
							}if(source.getSource() == theView.getBut2()) {
								theView.getBut2().setVisible(false);
							}if(source.getSource() == theView.getBut3()) {
								theView.getBut3().setVisible(false);
							}if(source.getSource() == theView.getBut4()) {
								theView.getBut4().setVisible(false);
							}if(source.getSource() == theView.getBut5()) {
								theView.getBut5().setVisible(false);
							}if(source.getSource() == theView.getBut6()) {
								theView.getBut6().setVisible(false);
							}if(source.getSource() == theView.getBut7()) {
								theView.getBut7().setVisible(false);
							}if(source.getSource() == theView.getBut8()) {
								theView.getBut8().setVisible(false);
							}if(source.getSource() == theView.getBut9()) {
								theView.getBut9().setVisible(false);
							}if(source.getSource() == theView.getBut10()) {
								theView.getBut10().setVisible(false);
							}if(source.getSource() == theView.getBut11()) {
								theView.getBut11().setVisible(false);
							}if(source.getSource() == theView.getBut12()) {
								theView.getBut12().setVisible(false);
							}if(source.getSource() == theView.getBut13()) {
								theView.getBut13().setVisible(false);
							}if(source.getSource() == theView.getBut14()) {
								theView.getBut14().setVisible(false);
							}if(source.getSource() == theView.getBut15()) {
								theView.getBut15().setVisible(false);
							}if(source.getSource() == theView.getBut16()) {
								theView.getBut16().setVisible(false);
							}if(source.getSource() == theView.getBut17()) {
								theView.getBut17().setVisible(false);
							}if(source.getSource() == theView.getBut18()) {
								theView.getBut18().setVisible(false);
							}if(source.getSource() == theView.getBut19()) {
								theView.getBut19().setVisible(false);
							}if(source.getSource() == theView.getBut20()) {
								theView.getBut20().setVisible(false);
							}if(source.getSource() == theView.getBut21()) {
								theView.getBut21().setVisible(false);
							}if(source.getSource() == theView.getBut22()) {
								theView.getBut22().setVisible(false);
							}if(source.getSource() == theView.getBut23()) {
								theView.getBut23().setVisible(false);
							}if(source.getSource() == theView.getBut24()) {
								theView.getBut24().setVisible(false);
							}
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
				
//				curQ = Database.GetTrueFalseQuestion();
//				curQ = Database.GetMultipleChoiceQuestion();
//				curQ = Database.GetShortAnswerQuestion();
				curQ = Database.GetQuestion();
				qType = curQ.GetType();
				theView.setQuestionPanel(curQ);
				correctAnswer = curQ.GetCorrect();
			}

		}//end actionPerformed method
	}//end class SubmitListener

	public Question getCurQ() {
		return this.curQ;
	}

}

