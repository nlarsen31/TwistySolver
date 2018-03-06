import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;

public class View extends JFrame{

	//private JFrame frame;



	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton up[] = new JButton[9];
	JButton front[] = new JButton[9];
	JButton bottom[] = new JButton[9];
	JButton back[] = new JButton[9];
	JButton right[] = new JButton[9];
	JButton left[] = new JButton[9];
	private void initialize() {
		
		this.setBounds(100, 101, 450, 614);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initButtons(up, Color.BLUE,124,77,30, this);
		initButtons(front, Color.WHITE,124,175,30, this);
		initButtons(bottom, Color.GREEN,124,273,30, this);
		initButtons(back, Color.YELLOW,124,371,30, this);
		initButtons(right, Color.RED,222,175,30, this);
		initButtons(left, Color.ORANGE,26,175,30, this);
	}
	private void initButtons(JButton[] buttons, Color c, int x, int y, int w, JFrame f) {
		int d = w + 2;
		for (int i = 0; i < up.length; i++) {
			buttons[i] = new JButton(i+"");
			buttons[i].setBackground(c);
			buttons[i].setForeground(c);
			buttons[i].setBorderPainted(false);
			buttons[i].setOpaque(true);
			f.getContentPane().add(buttons[i]);
			buttons[i].setBounds(x + d*(i%3)	,y + d*(i/3)	,w, w);
		}
	}
}
