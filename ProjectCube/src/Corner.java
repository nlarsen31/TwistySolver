
public class Corner extends Piece{
	int position;
	int ubColor;
	int fbColor;
	int rlColor;
	protected final int TOP_FRONT_LEFT = 0;
	protected final int TOP_FRONT_RIGHT = 1;
	protected final int TOP_BACK_RIGHT = 2;
	protected final int TOP_BACK_LEFT = 3;
	protected final int BOTTOM_FRONT_LEFT = 4;
	protected final int BOTTOM_FRONT_RIGHT = 5;
	protected final int BOTTOM_BACK_LEFT = 6;
	protected final int BOTTOM_BACk_RIGHT = 7;
	public Corner(int p, int u, int f, int r) {
		position = p;
		ubColor = u;
		fbColor = f;
		rlColor = r;
	}
	public boolean setAtt(int p, int u, int f, int r) {
		if(p<0 || p>11 || u<0 || u>5 || f<0 || f>5 || r<0 || r>5) {
			return false;
		}
		else {
			position = p;
			ubColor = u;
			fbColor = f;
			rlColor = r;
			return true;
		}
	}
	public void swapFbRl() {
		int temp = rlColor;
		rlColor = fbColor;
		fbColor = temp;
	}
}
