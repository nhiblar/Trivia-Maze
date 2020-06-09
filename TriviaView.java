
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class TriviaView extends JFrame{

	private JMenuBar mb;
	private JMenu file, help;
	private JMenuItem save, load, quit, about, addQuestion;
	private JPanel masterPanel, mazePanel, questionPanel, multChoicePanel, comboPanel, tfPanel, tempPanel, shortPanel;
	private JPanel tempButtons; 
	private JRadioButton answer1, answer2, answer3, answer4, trueBtn, falseBtn;
	private ButtonGroup multChoice, tfChoice;
	private JButton submitButton;
	private JButton but1, but2, but3, but4, but5,
					but6, but7, but8, but9, but10,
					but11, but12, but13, but14, but15,
					but16, but17, but18, but19, but20,
					but21, but22, but23, but24;
	private JLabel room1, room2, room3, room4, room5, room6, room7, room8, room9,
			room10, room11, room12, room13, room14, room15, room16;
	private ArrayList<JLabel> rooms = new ArrayList<JLabel>();
	
	AllDoorButtons myBtnGrp = new AllDoorButtons();

	TriviaView(){

		masterPanel = new JPanel(new BorderLayout());
		mazePanel = CreateMazePanel();
		
		questionPanel = CreateQuestionDisplayPanel();
		multChoicePanel = CreateMultChoicePanel();
		//tfPanel = CreateTrueFalsePanel();
		comboPanel = new JPanel();
		comboPanel.setPreferredSize(new Dimension(300, 800));
		comboPanel.add(questionPanel, BorderLayout.NORTH);
		comboPanel.add(multChoicePanel, BorderLayout.SOUTH);
		//comboPanel.add(tfPanel, BorderLayout.SOUTH);
		
		comboPanel.setVisible(true);
		
		masterPanel.add(mazePanel, BorderLayout.WEST);
		masterPanel.add(comboPanel, BorderLayout.EAST);
		
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Maze Trivia");
		
		mb = new JMenuBar();
		file = new JMenu("File");
		help = new JMenu("Help");
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		quit = new JMenuItem("Quit");
		about = new JMenuItem("About");
		addQuestion = new JMenuItem("Add Question");
		
		file.add(save);
		file.add(load);
		file.add(quit);
		help.add(about);
		help.add(addQuestion);
		mb.add(file);
		mb.add(help);
		this.getContentPane().add(masterPanel);
		this.setJMenuBar(mb);
		this.setResizable(false);
		this.setVisible(true);
		
		myBtnGrp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action Command is: " + e.getActionCommand());
			}
		});
	}
	
	public void updateQuestionPanel(String str) {
		
//		String str = o.getName();
		comboPanel = new JPanel();
		questionPanel = CreateQuestionDisplayPanel();
		comboPanel.setPreferredSize(new Dimension(300, 800));
		comboPanel.add(questionPanel, BorderLayout.NORTH);
		
		if(str.equals("trueFalse")) {
			tempPanel = CreateTrueFalsePanel();
			comboPanel.add(tfPanel, BorderLayout.SOUTH);
		}
		if(str.equals("multiple")) {
			tempPanel = CreateMultChoicePanel();
			comboPanel.add(multChoicePanel, BorderLayout.SOUTH);
		}
		if(str.equals("short")) {
			tempPanel = CreateShortAnswerPanel();
			comboPanel.add(shortPanel, BorderLayout.SOUTH);
		}

		comboPanel.setVisible(true);
		masterPanel.add(comboPanel, BorderLayout.EAST);
		
	}
	

	public void aboutPanel() {
		JFrame aboutPanel = new JFrame();
		aboutPanel.setLayout(new FlowLayout());
	    JPanel panel = new JPanel();
	    JTextArea jtext = new JTextArea("Create by: \nNate Hiblar \nQuin Tiller \nWryan Parr" +
	    								"\n\nCurrent Version: 0.7" +
	    								"\n\nCreated on: June 10th, 2020" +
	    								"\n\n\nThe Green Room is your current location." +
	    								"\nClick on a numbered \"door\" to move to another room." +
	    								"\nOnce the exit room is green, you win." +
	    								"\nAnswering a question wrong will close that door." +
	    								"\nIf there are no possible paths to the exit, you lose.");
	    jtext.setEditable(false);
	    jtext.setBackground(null);
	    panel.add(jtext);
	    aboutPanel.add(panel, new GridBagConstraints());
	    aboutPanel.setSize(350, 350);
	    aboutPanel.setLocationRelativeTo(null);
	    aboutPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    aboutPanel.setVisible(true);
	}

	private JPanel CreateQuestionDisplayPanel() {
		
		tempButtons = new JPanel();
		tempButtons.setPreferredSize(new Dimension(300, 300));
		tempButtons.setLayout(new GridLayout(2,1,10,1));
		
		JTextArea jtext = new JTextArea();
		jtext.setSize(280, 400);
		jtext.setEditable(false);
		jtext.setLineWrap(true);
		jtext.setWrapStyleWord(true);
		jtext.setBackground(null);
		jtext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtext.append("Change this text entering every new room with a new questions.");
		
		submitButton = new JButton("Submit Answer");
		String title = "Answer the question:";
		Border border = BorderFactory.createTitledBorder(title);
		tempButtons.setBorder(border);
		
		tempButtons.add(jtext);
		tempButtons.add(submitButton);
		tempButtons.setVisible(true);
		
		return tempButtons;

	}
	
	
	private JPanel CreateMultChoicePanel() {
		
		tempPanel = new JPanel();
		tempPanel.setPreferredSize(new Dimension(300, 400));
		tempPanel.setLayout(new GridLayout(2,1,10,1));
		
		Box multBox = Box.createVerticalBox();
		answer1 = new JRadioButton("Answer 1");
		answer2 = new JRadioButton("Answer 2");
		answer3 = new JRadioButton("Answer 3");
		answer4 = new JRadioButton("Answer 4");
		multChoice = new ButtonGroup();
		multChoice.add(answer1);
		multChoice.add(answer2);
		multChoice.add(answer3);
		multChoice.add(answer4);
		multBox.add(answer1);
		multBox.add(answer2);
		multBox.add(answer3);
		multBox.add(answer4);
		tempPanel.setBorder(BorderFactory.createTitledBorder("Multiple Choice Question:"));
		tempPanel.add(multBox);
		tempPanel.setVisible(true);
		
		return tempPanel;
	}
	
	private JPanel CreateTrueFalsePanel() {
		
		tfPanel = new JPanel();
		tfPanel.setPreferredSize(new Dimension(300, 400));
		tfPanel.setLayout(new GridLayout(2,1,10,1));
		
		Box trueFalseBox = Box.createVerticalBox();
		trueBtn = new JRadioButton("True");
		falseBtn = new JRadioButton("False");
		tfChoice = new ButtonGroup();
		tfChoice.add(trueBtn);
		tfChoice.add(falseBtn);
		trueFalseBox.add(trueBtn);
		trueFalseBox.add(falseBtn);
		
		tempButtons.setBorder(BorderFactory.createTitledBorder("True or False Question:"));
		tempButtons.add(trueFalseBox);
		tempButtons.setVisible(true);
		
		return tempButtons;
		
	}
	
	private JPanel CreateShortAnswerPanel(){
		
		tempPanel = new JPanel();
		tempPanel.setPreferredSize(new Dimension(300, 400));
		tempPanel.setLayout(new GridLayout(2,1,10,1));
		TextArea jText = new TextArea();
		jText.setEditable(true);
		jText.setBackground(null);
		
		return tempPanel;
	}
	
	public JPanel CreateMazePanel() {
		
		JPanel tempMaze = new JPanel();
		tempMaze.setLayout(new GridBagLayout());
		new ButtonGroup();
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 0;
		gridConstraints.weighty = 0;
		gridConstraints.insets = new Insets(5,5,5,5);
		gridConstraints.anchor = GridBagConstraints.CENTER;
		gridConstraints.fill = GridBagConstraints.NONE;
		
		but1 = new JButton(" < 1 > ");
		myBtnGrp.add(but1);
		but2 = new JButton(" < 2 > ");
		myBtnGrp.add(but2);
		but3 = new JButton(" < 3 > ");
		myBtnGrp.add(but3);
		but4 = new JButton(" \\/  4  /\\ ");
		myBtnGrp.add(but4);
		but5 = new JButton(" \\/  5  /\\ ");
		myBtnGrp.add(but5);
		but6 = new JButton(" \\/  6  /\\ ");
		myBtnGrp.add(but6);
		but7 = new JButton(" \\/  7  /\\ ");
		myBtnGrp.add(but7);
		but8 = new JButton(" < 8 > ");
		myBtnGrp.add(but8);
		but9 = new JButton(" < 9 > ");
		myBtnGrp.add(but9);
		but10 = new JButton(" < 10 > ");
		myBtnGrp.add(but10);
		but11 = new JButton(" \\/  11  /\\ ");
		myBtnGrp.add(but11);
		but12 = new JButton(" \\/  12  /\\ ");
		myBtnGrp.add(but12);
		but13 = new JButton(" \\/  13  /\\ ");
		myBtnGrp.add(but13);
		but14 = new JButton(" \\/  14  /\\ ");
		myBtnGrp.add(but14);
		but15 = new JButton(" < 15 > ");
		myBtnGrp.add(but15);
		but16 = new JButton(" < 16 > ");
		myBtnGrp.add(but16);
		but17 = new JButton(" < 17 > ");
		myBtnGrp.add(but17);
		but18 = new JButton(" \\/  18  /\\ ");
		myBtnGrp.add(but18);
		but19 = new JButton(" \\/  19  /\\ ");
		myBtnGrp.add(but19);
		but20 = new JButton(" \\/  20  /\\ ");
		myBtnGrp.add(but20);
		but21 = new JButton(" \\/  21  /\\ ");
		myBtnGrp.add(but21);
		but22 = new JButton(" < 22 > ");
		myBtnGrp.add(but22);
		but23 = new JButton(" < 23 > ");
		myBtnGrp.add(but23);
		but24 = new JButton(" < 24 > ");
		myBtnGrp.add(but24);
		
		room1 = newLabel("Enter");
		rooms.add(room1);
		room2 = newLabel("room 2");
		rooms.add(room2);
		room3 = newLabel("room 3");
		rooms.add(room3);
		room4 = newLabel("room 4");
		rooms.add(room4);
		room5 = newLabel("room 5");
		rooms.add(room5);
		room6 = newLabel("room 6");
		rooms.add(room6);
		room7 = newLabel("room 7");
		rooms.add(room7);
		room8 = newLabel("room 8");
		rooms.add(room8);
		room9 = newLabel("room 9");
		rooms.add(room9);
		room10 = newLabel("room 10");
		rooms.add(room10);
		room11 = newLabel("room 11");
		rooms.add(room11);
		room12 = newLabel("room 12");
		rooms.add(room12);
		room13 = newLabel("room 13");
		rooms.add(room13);
		room14 = newLabel("room 14");
		rooms.add(room14);
		room15 = newLabel("room 15");
		rooms.add(room15);
		room16 = newLabel("Exit");
		rooms.add(room16);
		
		tempMaze.add(room1,gridConstraints);
		gridConstraints.gridx = 2;
		tempMaze.add(but1,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(room2,gridConstraints);
		gridConstraints.gridx = 4;
		tempMaze.add(but2,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(room3,gridConstraints);
		gridConstraints.gridx = 6;
		tempMaze.add(but3,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(room4,gridConstraints);
		
		gridConstraints.gridy = 2;
		gridConstraints.gridx = 1;
		tempMaze.add(but4,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(but5,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(but6,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(but7,gridConstraints);
		gridConstraints.gridx = 1;
		
		gridConstraints.gridy = 3;
		tempMaze.add(room5,gridConstraints);
		gridConstraints.gridx = 2;
		tempMaze.add(but8,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(room6,gridConstraints);
		gridConstraints.gridx = 4;
		tempMaze.add(but9,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(room7,gridConstraints);
		gridConstraints.gridx = 6;
		tempMaze.add(but10,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(room8,gridConstraints);
		
		gridConstraints.gridy = 4;
		gridConstraints.gridx = 1;
		tempMaze.add(but11,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(but12,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(but13,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(but14,gridConstraints);
		gridConstraints.gridx = 1;

		gridConstraints.gridy = 5;
		tempMaze.add(room9,gridConstraints);
		gridConstraints.gridx = 2;
		tempMaze.add(but15,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(room10,gridConstraints);
		gridConstraints.gridx = 4;
		tempMaze.add(but16,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(room11,gridConstraints);
		gridConstraints.gridx = 6;
		tempMaze.add(but17,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(room12,gridConstraints);
		
		gridConstraints.gridy = 6;
		gridConstraints.gridx = 1;
		tempMaze.add(but18,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(but19,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(but20,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(but21,gridConstraints);
		gridConstraints.gridx = 1;
		
		gridConstraints.gridy = 7;
		tempMaze.add(room13,gridConstraints);
		gridConstraints.gridx = 2;
		tempMaze.add(but22,gridConstraints);
		gridConstraints.gridx = 3;
		tempMaze.add(room14,gridConstraints);
		gridConstraints.gridx = 4;
		tempMaze.add(but23,gridConstraints);
		gridConstraints.gridx = 5;
		tempMaze.add(room15,gridConstraints);
		gridConstraints.gridx = 6;
		tempMaze.add(but24,gridConstraints);
		gridConstraints.gridx = 7;
		tempMaze.add(room16,gridConstraints);
		
		tempMaze.setVisible(true);
		
		return tempMaze;
	}

	
	private JLabel newLabel(String str) {
		
		JLabel labelRoom = new JLabel(str, SwingConstants.CENTER);		
		labelRoom.setPreferredSize(new Dimension(100, 100));
		labelRoom.setOpaque(true);
		labelRoom.setBackground(Color.LIGHT_GRAY);
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 4);
		labelRoom.setBorder(border);
		
		return labelRoom;
	}
	
	
	public void setDoorClosed(JButton button) {
		button.setVisible(false);
	}
	
	public void setCurrentRoom(JLabel curRoom) {
		curRoom.setBackground(Color.GREEN);
	}
	
	public void leaveRoom(JLabel oldRoom) {
		oldRoom.setBackground(Color.LIGHT_GRAY);
	}
	
	public JLabel getRoom(String str) {
		
		for(JLabel temp : rooms) {
			//System.out.println(temp.getText());
			if(temp.getText().equals(str))
				return temp; 
		}
		System.out.println("Failed to find room in list");
		return null;
	}

	public JMenuItem getSave() { return save; }
	public JMenuItem getLoad() { return load; }
	public JMenuItem getQuit() { return quit; }
	public JMenuItem getAbout() { return about; }
	public JMenuItem getAddQuestion() { return addQuestion; }
	public JButton getBut1() { return this.but1; }
	public JButton getBut2() { return this.but2; }
	public JButton getBut3() { return this.but3; }
	public JButton getBut4() { return this.but4; }
	public JButton getBut5() { return this.but5; }
	public JButton getBut6() { return this.but6; }
	public JButton getBut7() { return this.but7; }
	public JButton getBut8() { return this.but8; }
	public JButton getBut9() { return this.but9; }
	public JButton getBut10() { return this.but10; }
	public JButton getBut11() { return this.but11; }
	public JButton getBut12() { return this.but12; }
	public JButton getBut13() { return this.but13; }
	public JButton getBut14() { return this.but14; }
	public JButton getBut15() { return this.but15; }
	public JButton getBut16() { return this.but16; }
	public JButton getBut17() { return this.but17; }
	public JButton getBut18() { return this.but18; }
	public JButton getBut19() { return this.but19; }
	public JButton getBut20() { return this.but20; }
	public JButton getBut21() { return this.but21; }
	public JButton getBut22() { return this.but22; }
	public JButton getBut23() { return this.but23; }
	public JButton getBut24() { return this.but24; }
	public JButton getSubmitButton() { return this.submitButton; }
	public ButtonGroup getMultButtons( ) { return this.multChoice; }
	
	public void setAnwer1(String str) {	this.answer1.setText(str); }
	public void setAnwer2(String str) {	this.answer2.setText(str); }
	public void setAnwer3(String str) {	this.answer3.setText(str); }
	public void setAnwer4(String str) {	this.answer4.setText(str); }
	
	
	void addSubmitListener(ActionListener listenerForSubmitButton) {
		submitButton.addActionListener(listenerForSubmitButton);
	}
	
	void addMenuListener(ActionListener listenerForMenuButton) {
		save.addActionListener(listenerForMenuButton);
		load.addActionListener(listenerForMenuButton);
		quit.addActionListener(listenerForMenuButton);
		about.addActionListener(listenerForMenuButton);
		addQuestion.addActionListener(listenerForMenuButton);
	}

	void addDoorListener(ActionListener listenerForDoorButton) {
		but1.addActionListener(listenerForDoorButton);
		but2.addActionListener(listenerForDoorButton);
		but3.addActionListener(listenerForDoorButton);
		but4.addActionListener(listenerForDoorButton);
		but5.addActionListener(listenerForDoorButton);
		but6.addActionListener(listenerForDoorButton);
		but7.addActionListener(listenerForDoorButton);
		but8.addActionListener(listenerForDoorButton);
		but9.addActionListener(listenerForDoorButton);
		but10.addActionListener(listenerForDoorButton);
		but11.addActionListener(listenerForDoorButton);
		but12.addActionListener(listenerForDoorButton);
		but13.addActionListener(listenerForDoorButton);
		but14.addActionListener(listenerForDoorButton);
		but15.addActionListener(listenerForDoorButton);
		but16.addActionListener(listenerForDoorButton);
		but17.addActionListener(listenerForDoorButton);
		but18.addActionListener(listenerForDoorButton);
		but19.addActionListener(listenerForDoorButton);
		but20.addActionListener(listenerForDoorButton);
		but21.addActionListener(listenerForDoorButton);
		but22.addActionListener(listenerForDoorButton);
		but23.addActionListener(listenerForDoorButton);
		but24.addActionListener(listenerForDoorButton);
	}
	
	
}