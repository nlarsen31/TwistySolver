import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;

public class View extends JFrame implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		initButtons(up, Color.BLUE,124,77,30);
		initButtons(front, Color.WHITE,124,175,30);
		initButtons(bottom, Color.GREEN,124,273,30);
		initButtons(back, Color.YELLOW,124,371,30);
		initButtons(right, Color.YELLOW,124,371,30);
		initButtons(left, Color.YELLOW,124,371,30);
	}
	private void initButtons(JButton[] buttons, Color c, int x, int y, int w) {
		int d = w + 2;
		for (int i = 0; i < up.length; i++) {
			buttons[i] = new JButton(i+"");
			buttons[i].setBackground(c);
			buttons[i].setForeground(c);
			buttons[i].setBorderPainted(false);
			buttons[i].setOpaque(true);
			frame.getContentPane().add(buttons[i]);
			buttons[i].setBounds(x + d*(i%3)	,y + d*(i/3)	,w, w);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
