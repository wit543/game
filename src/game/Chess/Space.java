package game.Chess;

public class Space extends ChessPieces{

	public String s = " ";

	Space(){
		icon = " ";
		characteristic[2] = -1; //no color
		characteristic[3] = 0; //space
	}
	
	Space(int x, int y){
		characteristic[0] = x;
		characteristic[1] = y;
		characteristic[2] = -1; //no color
		characteristic[3] = 0; //space
		icon = " ";
	}
}