package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import TriviaMaze.CellState;
import TriviaMaze.CurrentRoom;
//import TriviaMaze.QuestionGenerator;
import TriviaMaze.CellState.CheckRoom;

public class TriviaController {

	public TriviaView theView;
	public TriviaModel theModel;
	private String multAnswer;

	public TriviaController(TriviaView theView, TriviaModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theView.addSubmitListener(new SubmitListener());
		this.theView.addMenuListener(new MenuListener());
		this.theView.addDoorListener(new DoorListener());
	}

	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == theView.getSubmitButton()) {

				for (Enumeration<AbstractButton> buttons = theView.getMultButtons().getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						multAnswer = button.getText();
						System.out.println(multAnswer + " from Submit Button");
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
		int counter = 0;
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == theView.getBut1() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 2"));
				theView.leaveRoom(theView.getRoom("Enter"));
				counter++; 
			}else if(e.getSource() == theView.getBut1() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("Enter"));
				theView.leaveRoom(theView.getRoom("room 2"));
				counter--;
			}
			
			
			if(e.getSource() == theView.getBut2() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 3"));
				theView.leaveRoom(theView.getRoom("room 2"));
				counter++;
			}else if(e.getSource() == theView.getBut2() && counter == 1){
				theView.setCurrentRoom(theView.getRoom("room 2"));
				theView.leaveRoom(theView.getRoom("room 3"));
				counter--;	
			}
			
			if(e.getSource() == theView.getBut3() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 4"));
				theView.leaveRoom(theView.getRoom("room 3"));
				counter++;
			}else if(e.getSource() == theView.getBut3() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 3"));
				theView.leaveRoom(theView.getRoom("room 4"));
				counter--;
			}
			
			
			if(e.getSource() == theView.getBut4() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 5"));
				theView.leaveRoom(theView.getRoom("Enter"));
				counter++;
			}else if(e.getSource() == theView.getBut4() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("Enter"));
				theView.leaveRoom(theView.getRoom("room 5"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut5() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 6"));
				theView.leaveRoom(theView.getRoom("room 2"));
				counter++;
			}else if(e.getSource() == theView.getBut5() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 2"));
				theView.leaveRoom(theView.getRoom("room 6"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut6() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 7"));
				theView.leaveRoom(theView.getRoom("room 3"));
				counter++;
			}else if(e.getSource() == theView.getBut6() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 3"));
				theView.leaveRoom(theView.getRoom("room 7"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut7() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 8"));
				theView.leaveRoom(theView.getRoom("room 4"));
				counter++;
			}else if(e.getSource() == theView.getBut7() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 4"));
				theView.leaveRoom(theView.getRoom("room 8"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut8() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 6"));
				theView.leaveRoom(theView.getRoom("room 5"));
				counter++;
			}else if(e.getSource() == theView.getBut8() && counter == 1){
				theView.setCurrentRoom(theView.getRoom("room 5"));
				theView.leaveRoom(theView.getRoom("room 6"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut9() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 7"));
				theView.leaveRoom(theView.getRoom("room 6"));
				counter++;
			}else if(e.getSource() == theView.getBut9() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 6"));
				theView.leaveRoom(theView.getRoom("room 7"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut10() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 8"));
				theView.leaveRoom(theView.getRoom("room 7"));
				counter++;
			}else if(e.getSource() == theView.getBut10() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 7"));
				theView.leaveRoom(theView.getRoom("room 8"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut11() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 9"));
				theView.leaveRoom(theView.getRoom("room 5"));
				counter++;
			}else if(e.getSource() == theView.getBut11() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 5"));
				theView.leaveRoom(theView.getRoom("room 9"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut12() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 10"));
				theView.leaveRoom(theView.getRoom("room 6"));
				counter++;
			}else if(e.getSource() == theView.getBut12() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 6"));
				theView.leaveRoom(theView.getRoom("room 10"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut13() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 11"));
				theView.leaveRoom(theView.getRoom("room 7"));
				counter++;
			}else if(e.getSource() == theView.getBut13() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 7"));
				theView.leaveRoom(theView.getRoom("room 11"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut14() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 12"));
				theView.leaveRoom(theView.getRoom("room 8"));
				counter++;
			}else if(e.getSource() == theView.getBut14() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 8"));
				theView.leaveRoom(theView.getRoom("room 12"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut15() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 10"));
				theView.leaveRoom(theView.getRoom("room 9"));
				counter++;
			}else if(e.getSource() == theView.getBut15() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 9"));
				theView.leaveRoom(theView.getRoom("room 10"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut16() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 11"));
				theView.leaveRoom(theView.getRoom("room 10"));
				counter++;
			}else if(e.getSource() == theView.getBut16() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 10"));
				theView.leaveRoom(theView.getRoom("room 11"));
				counter--;
			}
			if(e.getSource() == theView.getBut17() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 12"));
				theView.leaveRoom(theView.getRoom("room 11"));
				counter++;
			}else if(e.getSource() == theView.getBut17() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 11"));
				theView.leaveRoom(theView.getRoom("room 12"));
				counter--;
			}
			if(e.getSource() == theView.getBut18() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 13"));
				theView.leaveRoom(theView.getRoom("room 9"));
				counter++;
			}else if(e.getSource() == theView.getBut18() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 9"));
				theView.leaveRoom(theView.getRoom("room 13"));
				counter--;
			}
			
			if(e.getSource() == theView.getBut19() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 14"));
				theView.leaveRoom(theView.getRoom("room 10"));
				counter++;
			}else if(e.getSource() == theView.getBut19() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 10"));
				theView.leaveRoom(theView.getRoom("room 14"));
				counter--;
			}
			if(e.getSource() == theView.getBut20() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 15"));
				theView.leaveRoom(theView.getRoom("room 11"));
				counter++;
			}else if(e.getSource() == theView.getBut20() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 11"));
				theView.leaveRoom(theView.getRoom("room 15"));
				counter--;
			}
			if(e.getSource() == theView.getBut21() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("Exit"));
				theView.leaveRoom(theView.getRoom("room 12"));
				counter++;
			}else if(e.getSource() == theView.getBut21() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 12"));
				theView.leaveRoom(theView.getRoom("Exit"));
				counter--;
			}
			if(e.getSource() == theView.getBut22() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 14"));
				theView.leaveRoom(theView.getRoom("room 13"));
				counter++;
			}else if(e.getSource() == theView.getBut22() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 13"));
				theView.leaveRoom(theView.getRoom("room 14"));
				counter--;
			}
			if(e.getSource() == theView.getBut23() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("room 15"));
				theView.leaveRoom(theView.getRoom("room 14"));
				counter++;
			}else if(e.getSource() == theView.getBut23() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 14"));
				theView.leaveRoom(theView.getRoom("room 15"));
				counter--;
			}
			if(e.getSource() == theView.getBut24() && counter == 0){
				theView.setCurrentRoom(theView.getRoom("Exit"));
				theView.leaveRoom(theView.getRoom("room 15"));
				counter++;
			}else if(e.getSource() == theView.getBut24() && counter == 1) {
				theView.setCurrentRoom(theView.getRoom("room 15"));
				theView.leaveRoom(theView.getRoom("Exit"));
				counter--;
			}//end for check multButton source
		}//end actionPerformed method
	}//end class SubmitListener
}