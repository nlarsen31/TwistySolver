import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * w and c make up and represent a rubiks cube. Each peice has a primaryColor, secondaryColor (ThirdColor)
 * The colors take presedence based on sides (TOP/Bottom) > (Front/Back) > (Left/Right)
 */
public class Cube extends Piece{
	//
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
	Wedge[] w = new Wedge[12];
	Corner[] c = new Corner[8];
	int[] centers = new int[6];
	
	public Cube() {
		setUpW();
		setUpC();
		setUpCenter();
		
	}
	private void setUpCenter() {
		// TODO Auto-generated method stub
		centers[0] = BLUE;
		centers[1] = GREEN;
		centers[2] = WHITE;
		centers[3] = YELLOW;
		centers[4] = RED;
		centers[5] = ORANGE;
	}
	private void setUpW() {
		w[0] = new Wedge(TOP_FRONT	,BLUE	,WHITE);
		w[1] = new Wedge(TOP_RIGHT	,BLUE	,RED);
		w[2] = new Wedge(TOP_BACK	,BLUE	,YELLOW);
		w[3] = new Wedge(TOP_LEFT	,BLUE	,ORANGE);
		w[4] = new Wedge(BOTTOM_FRONT,GREEN	,WHITE);
		w[5] = new Wedge(BOTTOM_RIGHT,GREEN	,RED);
		w[6] = new Wedge(BOTTOM_BACK	,GREEN	,YELLOW);
		w[7] = new Wedge(BOTTOM_LEFT	,GREEN	,ORANGE);
		w[8] = new Wedge(FRONT_LEFT	,WHITE	,ORANGE);
		w[9] = new Wedge(FRONT_RIGHT	,WHITE	,RED);
		w[10] = new Wedge(BACK_RIGHT	,YELLOW	,RED);
		w[11] = new Wedge(BACK_LEFT	,YELLOW	,ORANGE);
		w[0].position = 0;
		w[1].position = 1;
		w[2].position = 2;
		w[3].position = 3;
		w[4].position = 4;
		w[5].position = 5;
		w[6].position = 6;
		w[7].position = 7;
		w[8].position = 8;
		w[9].position = 9;
		w[10].position = 10;
		w[11].position = 11;
	}
	private void setPos() {
		for (int i = 0; i < c.length; i++) {
			c[i].position = i;
		}
		for (int i = 0; i < w.length; i++) {
			w[i].position = i;
		}
	}
	private void setCorrectPos() {
		for (int i = 0; i < c.length; i++) {
			c[i].correctPosition = i;
		}
		for (int i = 0; i < w.length; i++) {
			w[i].correctPosition = i;
		}
	}
	private void setUpC() {
		c[0] = new Corner(TOP_FRONT_LEFT		,BLUE	,WHITE	,ORANGE);
		c[1] = new Corner(TOP_FRONT_RIGHT	,BLUE	,WHITE	,RED);
		c[2] = new Corner(TOP_BACK_RIGHT		,BLUE	,YELLOW	,RED);
		c[3] = new Corner(TOP_BACK_LEFT		,BLUE	,YELLOW	,ORANGE);
		c[4] = new Corner(BOTTOM_FRONT_LEFT	,GREEN	,WHITE	,ORANGE);
		c[5] = new Corner(BOTTOM_FRONT_RIGHT	,GREEN	,WHITE	,RED);
		c[6] = new Corner(BOTTOM_BACK_RIGHT	,GREEN	,YELLOW	,RED);
		c[7] = new Corner(BOTTOM_BACK_LEFT	,GREEN	,YELLOW	,ORANGE);
		setPos();
	}
	
	void upTurn() {
		//rotate edges
		Wedge temp1 = w[0];
		w[0] = w[1];
		w[1] = w[2];
		w[2] = w[3];
		w[3] = temp1;
		//rotate corners
		Corner temp2 = c[0];
		c[0] = c[1];
		c[0].swapFbRl();
		
		c[1] = c[2];
		c[1].swapFbRl();
		
		c[2] = c[3];
		c[2].swapFbRl();
		
		c[3] = temp2;
		c[3].swapFbRl();
		
		setPos();
	}
	void downTurn() {
		Wedge temp1 = w[4];
		w[4] = w[7];
		w[7] = w[6];
		w[6] = w[5];
		w[5] = temp1;
		
		Corner temp2 = c[4];
		c[4] = c[7];
		c[4].swapFbRl();
		c[7] = c[6];
		c[7].swapFbRl();
		c[6] = c[5];
		c[6].swapFbRl();
		c[5] = temp2;
		c[5].swapFbRl();

		setPos();
	}
	void rightTurn() {
		Wedge temp1 = w[1];
		w[1] = w[9];
		w[9] = w[5];
		w[5] = w[10];
		w[10] = temp1;
		
		Corner temp2 = c[1];
		c[1] = new Corner(c[5]);
		c[1].swapUbFb();
		c[5] = new Corner(c[6]);
		c[5].swapUbFb();
		c[6] = new Corner(c[2]);
		c[6].swapUbFb();
		c[2] = new Corner(temp2);
		c[2].swapUbFb();
		
		setPos();
	}
	void leftTurn() {
		Wedge temp1 = w[3];
		w[3] = w[11];
		w[11] = w[7];
		w[7] = w[8];
		w[8] = temp1;
		
		Corner temp2 = c[0];
		c[0] = c[3];
		c[0].swapUbFb();
		c[3] = c[7];
		c[3].swapUbFb();
		c[7] = c[4];
		c[7].swapUbFb();
		c[4] = temp2;
		c[4].swapUbFb();

		setPos();
	}
	void frontTurn() {
		Wedge temp = w[0];
		w[0] = w[8];
		w[0].swapColor();
		w[8] = w[4];
		w[8].swapColor();
		w[4] = w[9];
		w[4].swapColor();
		w[9]  = temp;
		w[9].swapColor();
		
		Corner temp2 = c[0];
		c[0] = c[4];
		c[0].swapUbRl();
		c[4] = c[5];
		c[4].swapUbRl();
		c[5] = c[1];
		c[5].swapUbRl();
		c[1] = temp2;
		c[1].swapUbRl();

		setPos();
	}
	void backTurn() {
		Wedge temp1 = w[2];
		w[2] = w[10];
		w[2].swapColor();
		w[10] = w[6];
		w[10].swapColor();
		w[6] = w[11];
		w[6].swapColor();
		w[11] = temp1;
		w[11].swapColor();
		
		Corner temp2 = c[7];
		c[7] = c[3];
		c[7].swapUbRl();
		c[3] = c[2];
		c[3].swapUbRl();
		c[2] = c[6];
		c[2].swapUbRl();
		c[6] = temp2;
		c[6].swapUbRl();

		setPos();
	}
	
	public String runTurns(String s) {
		//System.out.println("Running turns " + s);
		StringTokenizer toks = new StringTokenizer(s, "UDLRFB2\'", true);
		String last = "";
		while(toks.hasMoreTokens()) {
			String turn = toks.nextToken();
			char t = turn.charAt(0);
			if(t == '2') {
				turn(last);
			} else if(t == '\'') {
				turn(last);
				turn(last);
			} else {
				turn(turn);
				last = turn;
			}
		}
		return s;
	}
	/// rotate layers between L and R
	void mTurn() {
		//centers
		int temp1 = centers[0];
		centers[0] = centers[3];
		centers[3] = centers[1];
		centers[1] = centers[2];
		centers[2] = temp1;
		//wedges
		Wedge temp2 = w[0];
		w[0] = w[2];
		w[0].swapColor();
		w[2] = w[6];
		w[2].swapColor();
		w[6] = w[4];
		w[6].swapColor();
		w[4] = temp2;
		w[4].swapColor();
	}
	///rotate layers between F and B
	void sTurn() {
		//centers
		int temp1 = centers[0];
		centers[0] = centers[5];
		centers[5] = centers[1];
		centers[1] = centers[4];
		centers[4] = temp1;
		
		Wedge temp2 = w[1];
		w[1] = w[3];
		w[1].swapColor();
		w[3] = w[7];
		w[3].swapColor();
		w[7] = w[5];
		w[7].swapColor();
		w[5] = temp2;
		w[5].swapColor();
		
	}
	///rotate layers between U and D
	void eTurn() {
		//centers
		int temp1 = centers[2];
		centers[2] = centers[5];
		centers[5] = centers[3];
		centers[3] = centers[4];
		centers[4] = temp1;
		//wedges
		Wedge temp2 = w[8];
		w[8] = w[11];
		w[8].swapColor();
		w[11] = w[10];
		w[11].swapColor();
		w[10] = w[9];
		w[10].swapColor();
		w[9] = temp2;
		w[9].swapColor();
	}
	/// rotate cube like F
	void zTurn() {
		frontTurn();
		backTurn();
		backTurn();
		backTurn();
		sTurn();
	}
	/// rotate cube like U
	void yTurn() {
		upTurn();
		downTurn();
		downTurn();
		downTurn();
		eTurn();
		eTurn();
		eTurn();
	}
	/// rotate cube like R
	void xTurn() {
		rightTurn();
		leftTurn();
		leftTurn();
		leftTurn();
		mTurn();
		mTurn();
		mTurn();
	}
	public boolean turn(String s) {
		//System.out.println("turn" + s);
		switch(s) {
		case "U"	: upTurn(); return true;
		case "D"	: downTurn(); return true;
		case "L"	: leftTurn(); return true;
		case "R"	: rightTurn(); return true;
		case "F"	: frontTurn(); return true;
		case "B"	: backTurn(); return true;
		case "M" 	: mTurn(); return true;
		case "E"	: eTurn(); return true;
		case "S" 	: sTurn(); return true;
		case "X"	: xTurn(); return true;
		case "Y" 	: yTurn(); return true;
		case "Z"	: zTurn(); return true;
		default: return false;
		}
	}
	// MARK - The Following methods are for solving the cube
	public void solve() {
		// TODO Auto-generated method stub
		System.out.println("Solving the Cube");
		String turns = "";
		// MARK - solve the cross
		ArrayList<Integer> positionsSolved = new ArrayList<Integer>();
		Wedge wed = null;
		// First find a wedge on top if possible to tuen to the bottom.
		wed = getNextCross(super.BLUE);
		if(wed != null) {
			turns += placeCross(wed, super.BLUE);
		}
		positionsSolved.add(wed.position);
		wed = getNextCross(super.BLUE);
		if(wed != null) {
			turns += placeCross(wed, super.BLUE);
		}
		System.out.println(turns);
		
	}
	private Wedge getNextCross(int crossColor) {
		//find and place next piece
		Wedge wed = null;
		for(int i = 0; i < 3 && wed == null; i ++) {
			if((w[i].primaryColor == crossColor || w[i].secondaryColor == crossColor) && w[i].position != w[i].correctPosition)
				wed = w[i];
		}
		//check the bottom
		for(int i = 4; i < 12 && wed == null; i ++) {
			if((w[i].primaryColor == crossColor || w[i].secondaryColor == crossColor))
				wed = w[i];
		}
		return wed;
	}
	private String placeCross(Wedge wed, int corssColor) {
		String turns = "";
		// TODO Auto-generated method stub
		if(wed.position == 0)
			turns += runTurns("F2");
		if(wed.position == 1)
			turns += runTurns("R2");
		if(wed.position == 2)
			turns += runTurns("B2");
		if(wed.position == 3)
			turns += runTurns("L2");
		//These need to be tested
		if(wed.position == 8)
			turns += runTurns("F'DF");
		if(wed.position == 9)
			turns += runTurns("FDF'");
		if(wed.position == 10)
			turns += runTurns("B'DB");
		if(wed.position == 11)
			turns += runTurns("BDB'");
		//From here if the above works we would have the wed on the bottom
		if(wed.primaryColor == super.BLUE) 
			while(wed.secondaryColor != centers[getCenter(wed)])
				turns += runTurns("D");
		else 
			while(wed.primaryColor != centers[getCenter(wed)]) 
				turns += runTurns("D");
		if(wed.position == 4) {
			turns += runTurns("F2");
		} else if(wed.position == 5) {
			turns += runTurns("R2");
		} else if(wed.position == 6) {
			turns += runTurns("B2");
		} else if(wed.position == 7) {
			turns += runTurns("L2");
		}
		return turns;
	}
	public int getCenter(Wedge wed) {
		if(wed.position == 4) return 2;
		if(wed.position == 7) return 4;
		if(wed.position == 5) return 5;
		if(wed.position == 6) return 3;
		return -1;
	}
	public String scramble() {
		String solveTurns = "";
		Random randy = new Random();
		for (int i = 0; i < 25; i++) {
			int r = randy.nextInt() % 18;
			switch(r) {
			case 0: upTurn(); 
				solveTurns = "U'" + solveTurns; break;
			case 1: downTurn(); 
				solveTurns = "D'" + solveTurns; break;
			case 2: frontTurn(); 
				solveTurns = "F'" + solveTurns; break;
			case 3: backTurn(); 
				solveTurns = "B'" + solveTurns; break;
			case 4: leftTurn(); 
				solveTurns = "L'" + solveTurns; break;
			case 5: rightTurn(); 
				solveTurns = "R'" + solveTurns; break;
			case 6: upTurn(); upTurn(); 
				solveTurns = "U2" + solveTurns; break;
			case 7: downTurn(); downTurn(); 
				solveTurns = "D2" + solveTurns; break;
			case 8: frontTurn();frontTurn();
				solveTurns = "F2" + solveTurns; break;
			case 9: backTurn(); backTurn();
				solveTurns = "B2" + solveTurns; break;
			case 10: leftTurn();leftTurn();
				solveTurns = "L2" + solveTurns; break;
			case 11: rightTurn();rightTurn();
				solveTurns = "R2" + solveTurns; break;
			case 12: upTurn(); upTurn(); upTurn(); 
				solveTurns = "U" + solveTurns; break;
			case 13: downTurn(); downTurn(); 
				solveTurns = "D" + solveTurns; break;
			case 14: frontTurn(); frontTurn(); frontTurn(); 
				solveTurns = "F" + solveTurns; break;
			case 15: backTurn(); backTurn(); backTurn(); 
				solveTurns = "B" + solveTurns; break;
			case 16: leftTurn(); leftTurn(); leftTurn(); 
				solveTurns = "L" + solveTurns; break;
			case 17: rightTurn(); rightTurn(); rightTurn(); 
				solveTurns = "R" + solveTurns; break;
			}
		}
		return solveTurns;
	}

}
