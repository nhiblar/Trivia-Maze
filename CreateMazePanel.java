package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CreateMazePanel {
	
	private JPanel tempMaze; 
	
	public JPanel getMazePanel() {
		return this.tempMaze;
	}
	
	public CreateMazePanel() {
		
		tempMaze = new JPanel();
		tempMaze.setLayout(new GridBagLayout());
		
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
		
		
		JButton but1 = new JButton(" < 1 > ");
		//but1.setVisible(false);
		JButton but2 = new JButton(" < 2 > ");
		JButton but3 = new JButton(" < 3 > ");
		JButton but4 = new JButton(" \\/  4  /\\ ");
		JButton but5 = new JButton(" \\/  5  /\\ ");
		JButton but6 = new JButton(" \\/  6  /\\ ");
		JButton but7 = new JButton(" \\/  7  /\\ ");
		JButton but8 = new JButton(" < 8 > ");
		JButton but9 = new JButton(" < 9 > ");
		JButton but10 = new JButton(" < 10 > ");
		JButton but11 = new JButton(" \\/  11  /\\ ");
		JButton but12 = new JButton(" \\/  12  /\\ ");
		JButton but13 = new JButton(" \\/  13  /\\ ");
		JButton but14 = new JButton(" \\/  14  /\\ ");
		JButton but15 = new JButton(" < 15 > ");
		JButton but16 = new JButton(" < 16 > ");
		JButton but17 = new JButton(" < 17 > ");
		JButton but18 = new JButton(" \\/  18  /\\ ");
		JButton but19 = new JButton(" \\/  19  /\\ ");
		JButton but20 = new JButton(" \\/  20  /\\ ");
		JButton but21 = new JButton(" \\/  21  /\\ ");
		JButton but22 = new JButton(" < 22 > ");
		JButton but23 = new JButton(" < 23 > ");
		JButton but24 = new JButton(" < 24 > ");
		
		JLabel room1 = newLabel("room 1");
		JLabel room2 = newLabel("room 2");
		JLabel room3 = newLabel("room 3");
		JLabel room4 = newLabel("room 4");
		JLabel room5 = newLabel("room 5");
		JLabel room6 = newLabel("room 6");
		JLabel room7 = newLabel("room 7");
		JLabel room8 = newLabel("room 8");
		JLabel room9 = newLabel("room 9");
		JLabel room10 = newLabel("room 10");
		JLabel room11 = newLabel("room 11");
		JLabel room12 = newLabel("room 12");
		JLabel room13 = newLabel("room 13");
		JLabel room14 = newLabel("room 14");
		JLabel room15 = newLabel("room 15");
		JLabel room16 = newLabel("room 16");
		
		
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
		
	}
	
	private JLabel newLabel(String str) {
		
		JLabel labelRoom = new JLabel(str, SwingConstants.CENTER);		
		labelRoom.setPreferredSize(new Dimension(100, 100));
		labelRoom.setOpaque(true);
		labelRoom.setBackground(Color.LIGHT_GRAY);
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);
		labelRoom.setBorder(border);
		
		return labelRoom;
	}
	
}
