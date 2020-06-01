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

		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == theView.getBut1()){
				System.out.println("Door 1 clicked");
			}if(e.getSource() == theView.getBut2()){
				System.out.println("Door 2 clicked");
			}if(e.getSource() == theView.getBut3()){
				System.out.println("Door 3 clicked");
			}if(e.getSource() == theView.getBut4()){
				System.out.println("Door 4 clicked");
			}if(e.getSource() == theView.getBut5()){
				System.out.println("Door 5 clicked");
			}if(e.getSource() == theView.getBut6()){
				System.out.println("Door 6 clicked");
			}if(e.getSource() == theView.getBut7()){
				System.out.println("Door 7 clicked");
			}if(e.getSource() == theView.getBut8()){
				System.out.println("Door 8 clicked");
			}if(e.getSource() == theView.getBut9()){
				System.out.println("Door 9 clicked");
			}if(e.getSource() == theView.getBut10()){
				System.out.println("Door 10 clicked");
			}if(e.getSource() == theView.getBut11()){
				System.out.println("Door 11 clicked");
			}if(e.getSource() == theView.getBut12()){
				System.out.println("Door 12 clicked");
			}if(e.getSource() == theView.getBut13()){
				System.out.println("Door 13 clicked");
			}if(e.getSource() == theView.getBut14()){
				System.out.println("Door 14 clicked");
			}if(e.getSource() == theView.getBut15()){
				System.out.println("Door 15 clicked");
			}if(e.getSource() == theView.getBut16()){
				System.out.println("Door 16 clicked");
			}if(e.getSource() == theView.getBut17()){
				System.out.println("Door 17 clicked");
			}if(e.getSource() == theView.getBut18()){
				System.out.println("Door 18 clicked");
			}if(e.getSource() == theView.getBut19()){
				System.out.println("Door 19 clicked");
			}if(e.getSource() == theView.getBut20()){
				System.out.println("Door 20 clicked");
			}if(e.getSource() == theView.getBut21()){
				System.out.println("Door 21 clicked");
			}if(e.getSource() == theView.getBut22()){
				System.out.println("Door 22 clicked");
			}if(e.getSource() == theView.getBut23()){
				System.out.println("Door 23 clicked");
			}if(e.getSource() == theView.getBut24()){
				System.out.println("Door 24 clicked");
				
			}//end for check multButton source
		}//end actionPerformed method
	}//end class SubmitListener



}


