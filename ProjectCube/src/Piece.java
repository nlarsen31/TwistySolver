
public class Piece {

	

	final int BLUE = 0;
	final int GREEN = 1;
	final int WHITE = 2;
	final int YELLOW = 3;
	final int RED = 4;
	final int ORANGE = 5;
	public String getColorString(int color) {
		if(color == BLUE)
			return "BLUE";
		else if(color == GREEN)
			return "GREEN";
		else if(color == YELLOW)
			return "YELLOW";
		else if(color == WHITE)
			return "WHITE";
		else if(color == RED)
			return "RED";
		else if(color == ORANGE)
			return "ORANGE";
		else return "EROR";
	}
}
