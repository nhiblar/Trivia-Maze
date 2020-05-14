import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class MazeBuider extends JFrame{
	JPanel maze = new JPanel();
	Button buttons[]=new Button[16];
	
	public static void main(String args[]){
		new MazeBuider();
	}
	
	public MazeBuider(){
		super("MazeBuider");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	   maze.setLayout(new GridLayout(4,4));
		for(int i=0;i<16;i++){
			buttons[i]=new Button();
			maze.add(buttons[i]);
		}
		add(maze);
		
		setVisible(true);
	}
}