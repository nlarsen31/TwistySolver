import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;

public class Controller extends View implements ActionListener{
	
	private Cube cube = new Cube();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller window = new Controller();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Controller() {
		super();
		super.leftTurn.addActionListener(this);
		this.rightTurn.addActionListener(this);
		this.backTurn.addActionListener(this);
		this.frontTurn.addActionListener(this);
		this.bottomTurn.addActionListener(this);
		this.upTurn.addActionListener(this);
		for (int i = 0; i < back.length; i++) {
			back[i].addActionListener(this);
			up[i].addActionListener(this);
			front[i].addActionListener(this);
			bottom[i].addActionListener(this);
			left[i].addActionListener(this);
			right[i].addActionListener(this);
		}
		updateView(cube);
		this.validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if(Arrays.asList(up).contains(clicked)) {
			System.out.printf("UP %d\n",Arrays.asList(up).indexOf(clicked));
		}
		else if(Arrays.asList(bottom).contains(clicked)) {
			System.out.printf("Bottom %d\n",Arrays.asList(bottom).indexOf(clicked));			
		}
		else if(Arrays.asList(left).contains(clicked)) {
			System.out.printf("Left %d\n",Arrays.asList(left).indexOf(clicked));
		}
		else if(Arrays.asList(right).contains(clicked)) {
			System.out.printf("RIGHT %d\n",Arrays.asList(right).indexOf(clicked));
		}
		else if(Arrays.asList(back).contains(clicked)) {
			System.out.printf("BACK %d\n",Arrays.asList(back).indexOf(clicked));
		}
		if(Arrays.asList(front).contains(clicked)) {
			System.out.printf("FRONT %d\n",Arrays.asList(front).indexOf(clicked));
		}
		
		if(clicked.equals(upTurn)) {
			System.out.println("turn the cube top");
			cube.upTurn();
		} else if(clicked.equals(bottomTurn)) {
			System.out.println("turn the cube bottom");
			cube.bottomTurn();
		} else if(clicked.equals(rightTurn)) {
			System.out.println("turn the right of the cube");
			cube.rightTurn();
		} else if(clicked.equals(leftTurn)) {
			System.out.println("turn the left of the cube");
			cube.leftTurn();
		} else if(clicked.equals(frontTurn)) {
			 System.out.println("turn the front of the cube");
			 cube.frontTurn();
		} else if(clicked.equals(backTurn)) {
			System.out.println("turn the back of the cube");
			cube.backTurn();
		}
		updateView(cube);
		validate();
	}

}
