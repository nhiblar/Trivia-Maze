package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CreateButtonPanel implements ActionListener{

	private JPanel tempButtons; 
	private JRadioButton answer1, answer2, answer3, answer4;
	private JButton submitButton;
	private ButtonGroup multChoice;
	
	public JPanel getButtonPanel() {
		
		return this.tempButtons;
	}
	
	CreateButtonPanel() {
		
		tempButtons = new JPanel();
		tempButtons.setPreferredSize(new Dimension(200, 600));
		tempButtons.setLayout(new GridLayout(4,4,5,5));
		Box multBox = Box.createVerticalBox();
		submitButton = new JButton("Submit Anwer");
		answer1 = new JRadioButton("Answer 1");
		answer2 = new JRadioButton("Answer 2");
		answer3 = new JRadioButton("Answer 3");
		answer4 = new JRadioButton("Answer 4");
		multChoice = new ButtonGroup();
		multChoice.add(submitButton);
		multChoice.add(answer1);
		multChoice.add(answer2);
		multChoice.add(answer3);
		multChoice.add(answer4);
		multBox.add(submitButton);
		multBox.add(answer1);
		multBox.add(answer2);
		multBox.add(answer3);
		multBox.add(answer4);
		multBox.setBorder(BorderFactory.createTitledBorder("Multiple Choice Question:"));
		tempButtons.add(multBox);
		tempButtons.setVisible(true);

	}
	
	void addSubmitListener(ActionListener listenerForSubmitButton) {
		submitButton.addActionListener(listenerForSubmitButton);
	}
	
	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == submitButton) {

				System.out.println("Clicked submit button.");
				
				if(getAnswer1().isSelected()) {
					System.out.println("Answer 1 selected");
				}
				if(getAnswer2().isSelected()) {
					System.out.println("Answer 2 selected");
				}
				if(getAnswer3().isSelected()) {
					System.out.println("Answer 3 selected.");
				}
				if(getAnswer4().isSelected()) {
					System.out.println("Answer 4 selected.");
				}
			}//end if e.getSource
		}	
	}//end class SubmitListener
	
	public JButton getSubmitButton() { return this.submitButton; }
	public JRadioButton getAnswer1() { return this.answer1; }
	public JRadioButton getAnswer2() { return this.answer2;	}
	public JRadioButton getAnswer3() { return this.answer3; }
	public JRadioButton getAnswer4() { return this.answer4;	}
	public ButtonGroup getMultButtons( ) { return this.multChoice; }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submitButton) {

			System.out.println("Clicked submit button.");
						
			if(getAnswer1().isSelected()) {
				System.out.println("Answer 1 selected");
			}
			if(getAnswer2().isSelected()) {
				System.out.println("Answer 2 selected");
			}
			if(getAnswer3().isSelected()) {
				System.out.println("Answer 3 selected.");
			}
			if(getAnswer4().isSelected()) {
				System.out.println("Answer 4 selected.");
			}
			
		}//end if e.getSource

		
	}

}
