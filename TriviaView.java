package GUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TriviaView extends JFrame{

	private JTextField aNumber;
	private JButton submitButton;
	private JTextField showSubmitSolution;
	private ButtonGroup multChoice;
	private JRadioButton answer1, answer2, answer3, answer4;
	
	
	
	TriviaView(){

		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mave Trivia");
		JPanel mainPanel = new JPanel();

		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - // 
		
		submitButton = new JButton("Submit Anwer");
		JPanel submitPanel = new JPanel();
		Border submitPanelBorder = BorderFactory.createTitledBorder("Submit Answer");
		submitPanel.setBorder(submitPanelBorder);
		submitPanel.add(submitButton);
		mainPanel.add(submitPanel);
		
		aNumber = new JTextField(10);
		showSubmitSolution = new JTextField(10);
		JPanel aPanel = new JPanel();
		Border aPanelBorder = BorderFactory.createTitledBorder("Number Question:");
		aPanel.setBorder(aPanelBorder);
		aPanel.add(aNumber);
		aPanel.add(showSubmitSolution);
		mainPanel.add(aPanel);
		
		answer1 = new JRadioButton("Answer 1");
		answer2 = new JRadioButton("Answer 2");
		answer3 = new JRadioButton("Answer 3");
		answer4 = new JRadioButton("Answer 4");
		multChoice = new ButtonGroup();
		multChoice.add(answer1);
		multChoice.add(answer2);
		multChoice.add(answer3);
		multChoice.add(answer4);
		JPanel multChoicePanel = new JPanel();
		Border multCoiceBorder = BorderFactory.createTitledBorder("Multipe Choice Question:");
		multChoicePanel.setBorder(multCoiceBorder);
		multChoicePanel.add(answer1);
		multChoicePanel.add(answer2);
		multChoicePanel.add(answer3);
		multChoicePanel.add(answer4);
		mainPanel.add(multChoicePanel);
		
		this.add(mainPanel);
		this.setVisible(true);
		
		//this.setNewLayout(mainPanel);
		
	}
	/*
	private void setNewLayout(JPanel aPanel) {
		
		GroupLayout layout = new GroupLayout(aPanel);
		aPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				   layout.createSequentialGroup()
				      .addComponent(c1)
				      .addComponent(c2)
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent((Component) multChoice)
				);
				layout.setVerticalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(c1)
				           .addComponent(c2)
				           .addComponent(multChoice))
				);
	}

*/
	void addSubmitListener(ActionListener listenerForSubmitButton) {
		submitButton.addActionListener(listenerForSubmitButton);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	public void setSubmitValue(int submitValue) {
		showSubmitSolution.setText(Integer.toString(submitValue));
	}
	
	public int getaNumber() { return Integer.parseInt(aNumber.getText()); }
	public JButton getSubmitButton() { return this.submitButton; }
	public JRadioButton getAnswer1() { return this.answer1; }
	public JRadioButton getAnswer2() { return this.answer2;	}
	public JRadioButton getAnswer3() { return this.answer3; }
	public JRadioButton getAnswer4() { return this.answer4;	}
	public ButtonGroup getMultButtons( ) { return this.multChoice; }
	
	
}
