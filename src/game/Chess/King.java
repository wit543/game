package game.Chess;

import java.awt.image.BufferedImage;

public class King extends ChessPieces {

	//initialize king
	King(int x, int y, int color, String img){
		characteristic[0] = x; //x
		characteristic[1] = y; //y
		characteristic[2] = color; //black or white
		characteristic[3] = 6; //rook
		characteristic[4] = 0; //rook
		icon = img;

	}

	King(){

	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		
		Space s = new Space();

		boolean output = false;
		//test the move of the king
        if((Math.abs(intToX - intFromX)==1)||(Math.abs(intToY - intFromY)==1)||(((Math.abs(intFromX-intFromY)==Math.abs(intToX-intToY))||(Math.abs(intFromX+intFromY)==Math.abs(intToX+intToY))))){
            if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2]==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
    	}else{
    		output =true;
    	}
        }
		
		
		return output;

	}

}