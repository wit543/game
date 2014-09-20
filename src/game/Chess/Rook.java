package game.Chess;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends ChessPieces {

	//initialize rook
	Rook(int x, int y, int color, String img){
		characteristic[0] = x; //x
		characteristic[1] = y; //y
		characteristic[2] = color; //black or white
		characteristic[3] = 2; //rook
		characteristic[4] = 5; //rook
		icon = img;

	}

	Rook(){

	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		
		Space s = new Space();

		boolean output = false;
		if(intFromX==intToX || intFromY==intToY){
            //making a array of the piece that is in betweem the origin and final point
	int x= intToX-intFromX;
	int y= intToY-intFromY;
	List<String> black = new ArrayList<String>(Arrays.asList("â??","â??","â??","â??","â??","â??"));
	List<String> white = new ArrayList<String>(Arrays.asList("â?–","â??","â?—","â?•","â?”","â??"));
	String[] inbetween =  {s.s,s.s,s.s,s.s,s.s,s.s,s.s,s.s};
	int count = 0;
                //seperate the case for each type example up down left right
	if(x>0){
		while(count <Math.abs(x)){
			count ++;
			inbetween[count] = Board.board[intFromX+count][intFromY].icon;
		}	
	}
	if(x<0){
		while(count <Math.abs(x)){
			count ++;
			inbetween[count] = Board.board[intFromX-count][intFromY].icon;
		}	
	}
	if(y>0){
		while(count <Math.abs(y)){
			count ++;
			inbetween[count] = Board.board[intFromX][intFromY+count].icon;
		}	
	}
	if(y<0){
			while(count <Math.abs(y)){
			count ++;
			inbetween[count] = Board.board[intFromX][intFromY-count].icon;
		}	
	}
	for(int i=1;i<8;i++){
		if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2]==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
		}else{				
			int h=0;
			int d=0;//use for loop
                                //checking for a piece that is in between
			for (d=0;d<8;d++){
				if(white.contains(inbetween[d])||black.contains(inbetween[d])){
					h++;
				}
			}
                               //checking for space in the between&the final point is space
			if(inbetween[i]== s.s && inbetween[i]==Board.board[intToX][intToY].icon &&h==0){
				for (d=0;d<8;d++){
					if(white.contains(inbetween[d])||black.contains(inbetween[d])){
						h++;
					}
				}
				output =true;
			}
                                //checking for space in the between&the final point is not space
			if(inbetween[i]!= s.s){
				for (d=0;d<8;d++){
					if(white.contains(inbetween[d])||black.contains(inbetween[d])){
						h++;
					}
				}
				if((inbetween[i] == Board.board[intToX][intToY].icon)){				
					if((h==Math.abs(y)+1||h==Math.abs(x)+1)&&(Board.board[intToX][intToY].icon!= s.s)){
								output =true;
							}
					}
				}
				break;
			}				
		}
	}

		return output;
	}

}
