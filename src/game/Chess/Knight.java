package game.Chess;

import java.awt.image.BufferedImage;

public class Knight extends ChessPieces {

	//initialize knight
	Knight(int x, int y, int color, String img){
		characteristic[0] = x; //x
		characteristic[1] = y; //y
		characteristic[2] = color; //black or white
		characteristic[3] = 4; //rook
		characteristic[4] = 3; //rook
		icon = img;

	}

	Knight(){

	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		
		Space s = new Space();

		boolean output = false;
		//test for the match of the move
				if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2]==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
				}
				else{
					if((((intToX == intFromX+2 && intToY== intFromY+1)||(intToX == intFromX+2 && intToY== intFromY-1))||
						((intToX == intFromX-2 && intToY== intFromY+1)||(intToX == intFromX-2 && intToY== intFromY-1)))||
						(((intToX == intFromX+1 && intToY== intFromY+2)||(intToX == intFromX+1 && intToY== intFromY-2))||
						((intToX == intFromX-1 && intToY== intFromY+2)||(intToX == intFromX-1 && intToY== intFromY-2)))){
						output =true;
					}
					else{
						output =false;
					}
				}
		
		
		return output;

	}

}