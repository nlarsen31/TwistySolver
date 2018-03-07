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
	
	public Cube() {
		setUpW();
		setUpC();
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
	}

	public void upTurn() {
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
		
	}
}
