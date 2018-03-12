import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JButton;

public class View extends JFrame{

	//private JFrame frame;

	protected final int TOP_FRONT = 0;
	protected final int TOP_RIGHT = 1;
	protected final int TOP_BACK = 2;
	protected final int TOP_LEFT = 3;
	protected final int BOTTOM_FRONT = 4;
	protected final int BOTTOM_RIGHT = 5;
	protected final int BOTTOM_BACK = 6;
	protected final int BOTTOM_LEFT = 7;
	protected final int FRONT_RIGHT = 8;
	protected final int FRONT_LEFT = 9;
	protected final int BACK_RIGHT = 10;
	protected final int BACK_LEFT = 11;
	
	protected final int TOP_FRONT_LEFT = 0;
	protected final int TOP_FRONT_RIGHT = 1;
	protected final int TOP_BACK_RIGHT = 2;
	protected final int TOP_BACK_LEFT = 3;
	protected final int BOTTOM_FRONT_LEFT = 4;
	protected final int BOTTOM_FRONT_RIGHT = 5;
	protected final int BOTTOM_BACK_LEFT = 6;
	protected final int BOTTOM_BACK_RIGHT = 7;


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
	JButton down[] = new JButton[9];
	JButton back[] = new JButton[9];
	JButton right[] = new JButton[9];
	JButton left[] = new JButton[9];
	JButton leftTurn = new JButton("left"),
			rightTurn = new JButton("right"),
			backTurn = new JButton("back"),
			frontTurn = new JButton("front"),
			upTurn = new JButton("up"),
			downTurn = new JButton("bottom"),
			flip = new JButton("Flip Dir");
	JTextField turnList = new JTextField(25);
	JButton runTurns = new JButton("Run Turns");
	private void initialize() {
		
		
		this.getContentPane().setLayout(null);
		JPanel turns = new JPanel(new GridLayout(2,4));
		turns.add(upTurn);
		turns.add(frontTurn);
		turns.add(leftTurn);
		turns.add(flip);
		turns.add(downTurn);
		turns.add(backTurn);
		turns.add(rightTurn);
		turns.setBounds(22,475,294,100);
		this.getContentPane().add(turns);
		
		JPanel turnListPan = new JPanel(new FlowLayout());
		turnListPan.setBounds(22,575,325,100);
		turnListPan.add(turnList);
		turnListPan.add(runTurns);
		turnList.setVisible(true);
		this.getContentPane().add(turnListPan);
		
		this.setBounds(100, 101, 450, 670);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initButtons(up, Color.BLUE,124,77,30, this);
		initButtons(front, Color.WHITE,124,175,30, this);
		initButtons(down, Color.GREEN,124,273,30, this);
		initButtons(back, Color.YELLOW,124,371,30, this);
		initButtons(right, Color.RED,222,175,30, this);
		initButtons(left, Color.ORANGE,26,175,30, this);
		
		
	}
	
	private void initButtons(JButton[] buttons, Color c, int x, int y, int w, JFrame f) {
		int d = w + 2;
		for (int i = 0; i < up.length; i++) {
			buttons[i] = new JButton("");
			buttons[i].setBackground(c);
			buttons[i].setForeground(c);
			buttons[i].setBorderPainted(false);
			buttons[i].setOpaque(true);
			f.getContentPane().add(buttons[i]);
			buttons[i].setBounds(x + d*(i%3)	,y + d*(i/3)	,w, w);
		}
	}
	public void updateView(Cube cube) {
		//sets top layer wedges 
		up[7].setBackground(getColor(cube.w[0].primaryColor));
		front[1].setBackground(getColor(cube.w[0].secondaryColor));
		up[5].setBackground(getColor(cube.w[1].primaryColor));
		right[1].setBackground(getColor(cube.w[1].secondaryColor));
		up[1].setBackground(getColor(cube.w[2].primaryColor));
		back[7].setBackground(getColor(cube.w[2].secondaryColor));
		up[3].setBackground(getColor(cube.w[3].primaryColor));
		left[1].setBackground(getColor(cube.w[3].secondaryColor));
		//middle layer wedges
		left[5].setBackground(getColor(cube.w[8].secondaryColor));
		front[3].setBackground(getColor(cube.w[8].primaryColor));
		front[5].setBackground(getColor(cube.w[9].primaryColor));
		right[3].setBackground(getColor(cube.w[9].secondaryColor));
		right[5].setBackground(getColor(cube.w[10].secondaryColor));
		back[5].setBackground(getColor(cube.w[10].primaryColor));
		back[3].setBackground(getColor(cube.w[11].primaryColor));
		left[3].setBackground(getColor(cube.w[11].secondaryColor));
		//BottomLayer wedges
		down[1].setBackground(getColor(cube.w[4].primaryColor));
		front[7].setBackground(getColor(cube.w[4].secondaryColor));
		down[5].setBackground(getColor(cube.w[5].primaryColor));
		right[7].setBackground(getColor(cube.w[5].secondaryColor));
		down[7].setBackground(getColor(cube.w[6].primaryColor));
		back[1].setBackground(getColor(cube.w[6].secondaryColor));
		down[3].setBackground(getColor(cube.w[7].primaryColor));
		left[7].setBackground(getColor(cube.w[7].secondaryColor));
		//Top Layer Corners
		up[6].setBackground(getColor(cube.c[0].ubColor));
		front[0].setBackground(getColor(cube.c[0].fbColor));
		left[2].setBackground(getColor(cube.c[0].rlColor)); 
		
		up[8].setBackground(getColor(cube.c[1].ubColor));
		front[2].setBackground(getColor(cube.c[1].fbColor));
		right[0].setBackground(getColor(cube.c[1].rlColor));
		
		up[2].setBackground(getColor(cube.c[2].ubColor));
		back[8].setBackground(getColor(cube.c[2].fbColor));
		right[2].setBackground(getColor(cube.c[2].rlColor));
		
		up[0].setBackground(getColor(cube.c[3].ubColor));
		back[6].setBackground(getColor(cube.c[3].fbColor));
		left[0].setBackground(getColor(cube.c[3].rlColor));
		//Bottom Layer Corners
		down[0].setBackground(getColor(cube.c[4].ubColor));
		front[6].setBackground(getColor(cube.c[4].fbColor));
		left[8].setBackground(getColor(cube.c[4].rlColor)); 
		
		down[2].setBackground(getColor(cube.c[5].ubColor));
		front[8].setBackground(getColor(cube.c[5].fbColor));
		right[6].setBackground(getColor(cube.c[5].rlColor));
		
		down[8].setBackground(getColor(cube.c[6].ubColor));
		back[2].setBackground(getColor(cube.c[6].fbColor));
		right[8].setBackground(getColor(cube.c[6].rlColor));
		
		down[6].setBackground(getColor(cube.c[7].ubColor));
		back[0].setBackground(getColor(cube.c[7].fbColor));
		left[6].setBackground(getColor(cube.c[7].rlColor));
		
	}


	public Color getColor(int c) {
		switch(c) {
		case 0: return Color.BLUE;
		case 1: return Color.GREEN;
		case 2: return Color.WHITE;
		case 3: return Color.YELLOW;
		case 4: return Color.RED;
		default: return Color.ORANGE;
		}
	}
}
