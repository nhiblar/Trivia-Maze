package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class TriviaController {

	public TriviaView theView;
	public TriviaModel theModel;
	private String multAnswer;

	TriviaController(TriviaView theView, TriviaModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theView.addSubmitListener(new SubmitListener());
	}

	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == theView.getSubmitButton()) {

				System.out.println("Clicked submit button.");
				int firstNumber = 0;

				try {
					firstNumber = theView.getaNumber();
					theModel.setSubmitValue(firstNumber);
					theView.setSubmitValue(theModel.getSubmitValue());

				}
				catch(NumberFormatException ex) {

					theView.displayErrorMessage("You need to enter an Integer");
				}
				
				if(theView.getAnswer1().isSelected()) {
					System.out.println("Answer 1 selected");
				}
				if(theView.getAnswer2().isSelected()) {
					System.out.println("Answer 2 selected");
				}
				if(theView.getAnswer3().isSelected()) {
					System.out.println("Answer 3 selected.");
				}
				if(theView.getAnswer4().isSelected()) {
					System.out.println("Answer 4 selected.");
				}
				
			}//end if e.getSource

		}	
	}//end class SubmitListener


	class RadioListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			for (Enumeration<AbstractButton> buttons = theView.getMultButtons().getElements(); buttons.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();

				if (button.isSelected()) {
					multAnswer = button.getText();
					System.out.println(multAnswer);
				}

			}//end for check multButton source
		}
	}//end class RadioListener
}


