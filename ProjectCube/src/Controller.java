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
	private boolean cc = false;
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
		runTurns.addActionListener(this);
		solve.addActionListener(this);
		flip.addActionListener(this);
		scramble.addActionListener(this);
		addListeners();
		for (int i = 0; i < back.length; i++) {
			back[i].addActionListener(this);
			up[i].addActionListener(this);
			front[i].addActionListener(this);
			down[i].addActionListener(this);
			left[i].addActionListener(this);
			right[i].addActionListener(this);
		}
		updateView(cube);
		this.validate();
	}
	private void addListeners() {
		// TODO Auto-generated method stub
		leftTurn.addActionListener(this);
		rightTurn.addActionListener(this);
		backTurn.addActionListener(this);
		frontTurn.addActionListener(this);
		downTurn.addActionListener(this);
		upTurn.addActionListener(this);
		mTurn.addActionListener(this);
		eTurn.addActionListener(this);
		sTurn.addActionListener(this);
		xTurn.addActionListener(this);
		yTurn.addActionListener(this);
		zTurn.addActionListener(this);
	}
	public void flipDir() {
		if(upTurn.getText().equals("U")) {
			upTurn.setText("U\'");
			downTurn.setText("D\'");
			leftTurn.setText("L\'");
			rightTurn.setText("R\'");
			backTurn.setText("B\'");
			frontTurn.setText("F\'");
			mTurn.setText("M\'");
			eTurn.setText("E\'");
			sTurn.setText("S\'");
			xTurn.setText("X\'");
			yTurn.setText("Y\'");
			zTurn.setText("Z\'");
			cc = true;
		} else {
			upTurn.setText("U");
			downTurn.setText("D");
			leftTurn.setText("L");
			rightTurn.setText("R");
			backTurn.setText("B");
			frontTurn.setText("F");
			mTurn.setText("M");
			eTurn.setText("E");
			sTurn.setText("S");
			xTurn.setText("X");
			yTurn.setText("Y");
			zTurn.setText("Z");
			cc = false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		removeListeners();
		JButton clicked = (JButton)e.getSource();
		//other buttons
		if(e.getActionCommand().equals("Run Turns")) {
			cube.runTurns(super.turnList.getText());
		}
		else if(e.getActionCommand().equals("Flip Dir")) {
			flipDir();
		}
		else if(e.getActionCommand().equals("Solve")) {
			cube.solve();
		}
		else if(e.getActionCommand().equals("Scramble")) {
			turnList.setText(cube.scramble());
		}
		//code for button tiles
		if(Arrays.asList(up).contains(clicked)) {
			System.out.printf("UP %d\n",Arrays.asList(up).indexOf(clicked));
		}
		else if(Arrays.asList(down).contains(clicked)) {
			System.out.printf("DOWN %d\n",Arrays.asList(down).indexOf(clicked));			
		}
		else if(Arrays.asList(left).contains(clicked)) {
			System.out.printf("LEFT %d\n",Arrays.asList(left).indexOf(clicked));
		}
		else if(Arrays.asList(right).contains(clicked)) {
			System.out.printf("RIGHT %d\n",Arrays.asList(right).indexOf(clicked));
		}
		else if(Arrays.asList(back).contains(clicked)) {
			System.out.printf("BACK %d\n",Arrays.asList(back).indexOf(clicked));
		}
		else if(Arrays.asList(front).contains(clicked)) {
			System.out.printf("FRONT %d\n",Arrays.asList(front).indexOf(clicked));
		}
		
		
		//code for turn buttons
		if(clicked.equals(upTurn)) {
			System.out.println("turn the cube top");
			cube.upTurn();
			if(cc) {
				cube.upTurn();
				cube.upTurn();
			}
		} else if(clicked.equals(downTurn)) {
			System.out.println("turn the cube bottom");
			cube.downTurn();
			if(cc) {
				cube.downTurn();
				cube.downTurn();
			}
		} else if(clicked.equals(rightTurn)) {
			System.out.println("turn the right of the cube");
			cube.rightTurn();
			if(cc) {
				cube.rightTurn();
				cube.rightTurn();
			}
		} else if(clicked.equals(leftTurn)) {
			System.out.println("turn the left of the cube");
			cube.leftTurn();
			if(cc) {
				cube.leftTurn();
				cube.leftTurn();
			}
		} else if(clicked.equals(frontTurn)) {
			 System.out.println("turn the front of the cube");
			 cube.frontTurn();
			 if(cc) {
				 cube.frontTurn();
				 cube.frontTurn();
			 }
		} else if(clicked.equals(backTurn)) {
			System.out.println("turn the back of the cube");
			cube.backTurn();
			if(cc) {
				cube.backTurn();
				cube.backTurn();
			}
		} else if(clicked.equals(mTurn)) {
			cube.mTurn();
			if(cc) {
				cube.mTurn();
				cube.mTurn();
			}
		} else if(clicked.equals(sTurn)) {
			cube.sTurn();
			if(cc) {
				cube.sTurn();
				cube.sTurn();
			}
		} else if(clicked.equals(eTurn)) {
			cube.eTurn();
			if(cc) {
				cube.eTurn();
				cube.eTurn();
			}
		} else if(clicked.equals(xTurn)) {
			cube.xTurn();
			if(cc) {
				cube.xTurn();
				cube.xTurn();
			}
		} else if(clicked.equals(yTurn)) {
			cube.yTurn();
			if(cc) {
				cube.yTurn();
				cube.yTurn();
			}
		} else if(clicked.equals(zTurn)) {
			cube.zTurn();
			if(cc) {
				cube.zTurn();
				cube.zTurn();
			}
		}
		addListeners();
		updateView(cube);
		update(this.getGraphics());
		validate();
	}
	private void removeListeners() {
		// TODO Auto-generated method stub
		leftTurn.removeActionListener(this);
		rightTurn.removeActionListener(this);
		backTurn.removeActionListener(this);
		frontTurn.removeActionListener(this);
		downTurn.removeActionListener(this);
		upTurn.removeActionListener(this);
		mTurn.removeActionListener(this);
		eTurn.removeActionListener(this);
		sTurn.removeActionListener(this);
		xTurn.removeActionListener(this);
		yTurn.removeActionListener(this);
		zTurn.removeActionListener(this);
	}

}
