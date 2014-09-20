package game.Chess;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends ChessPieces {

	//initialize pawn
	Pawn(int x, int y, int color, String img){
		characteristic[0] = x; //x
		characteristic[1] = y; //y
		characteristic[2] = color; //black or white
		characteristic[3] = 1; //pawn
		characteristic[4] = 1; //pawn
		icon = img;

	}

	Pawn(){

	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		
		Space s = new Space();

		boolean output = false;

		//move 1 block
		if(((Math.abs(intToX - intFromX)) == 1)&&(Board.board[intToX][intToY].icon==s.s)&&(Board.board[intFromX][intFromY].characteristic[3]==1)&&(Math.abs(intToY - intFromY) ==0)){
            if(((intToX - intFromX)==1&&Board.board[intFromX][intFromY].characteristic[2]==1)||((intToX - intFromX)==-1&&Board.board[intFromX][intFromY].characteristic[2]==0)){
                if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2]==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
                    }else{
                        output =true;                                
                     }
            }
            else{                      
            }
}
//eat 1 block
        if(((((intToX - intFromX)==1&&Board.board[intFromX][intFromY].characteristic[2]==1)||((intToX - intFromX)==-1&&Board.board[intFromX][intFromY].characteristic[2]==0)))&&(Board.board[intToX][intToY].icon!=s.s)&&(Math.abs(intToY - intFromY) ==1)){
             if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2] ==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
             }else{       
                 output =true;                                
             }
        }
        //finding in between
            int x= intToX-intFromX;	
            int h = 0;
            List<String> black = new ArrayList<String>(Arrays.asList("â??","â??","â??","â??","â??","â??"));
            List<String> white = new ArrayList<String>(Arrays.asList("â?–","â??","â?—","â?•","â?”","â??"));
            String[] inbetween =  {s.s,s.s,s.s,s.s,s.s,s.s,s.s,s.s};
            int count = 0;
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
            for(int i=0;i<8;i++){
                if(white.contains(inbetween[i])||black.contains(inbetween[i])){
                    h++;
                }
            }

        //to 4 or 5
        if(((((intToX == 3) && (intFromX <3) && (Board.board[intFromX][intFromY].icon=="â??"))||((intToX == 4) && (intFromX >4) && (Board.board[intFromX][intFromY].icon=="â??")))&&(Board.board[intToX][intToY].icon==s.s))&&(Math.abs(intToY - intFromY) ==0)&&h==0){
            if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2]==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
                }else{
                        output =true;
                }
        }	
        if(h!=0){
        output =false;
        }
        //En passant (not finish)
        
		return output;

	}
	
	

}
