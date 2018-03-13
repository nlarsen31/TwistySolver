public class Wedge  extends Piece {
	//Defined constants to make code cleaner
	int position;
	int primaryColor;
	int secondaryColor;
	
	public Wedge(int p, int pc, int sc) {
		position = p;
		primaryColor = pc;
		secondaryColor = sc;
	}
	public boolean setAtt(int p, int pc, int sc) {
		if(p<0 || p>11 || pc<0 || pc>5 || sc<0 || sc>5) {
			return false;
		}
		else {
			this.position = p;
			this.primaryColor = pc;
			this.secondaryColor = sc;
			return true;
		}
	}
	public void swapColor() {
		// TODO Auto-generated method stub
		int temp = primaryColor;
		primaryColor = secondaryColor;
		secondaryColor = temp;
	}
}