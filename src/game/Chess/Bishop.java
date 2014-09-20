package game.Chess;

import java.awt.image.BufferedImage;

public class Bishop extends ChessPieces {

	//initialize bishop
	Bishop(int x, int y, int color, String img){
		characteristic[0] = x; //x
		characteristic[1] = y; //y
		characteristic[2] = color; //black or white
		characteristic[3] = 3; //rook
		characteristic[4] = 3; //rook
		icon = img;

	}

	Bishop(){

	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		
		Space s = new Space();

		boolean output = false;
		if(((Math.abs(intFromX-intFromY)==Math.abs(intToX-intToY))||(Math.abs(intFromX+intFromY)==Math.abs(intToX+intToY)//defind the move 
                ))&&(
                    (intToX!=0)&&(intToY!=5)&&(intFromX!=7)&&(intFromY!=2)//SPECIAL CASE it pass the if statement(above)
                )){
	output =false;
	int countX =Math.abs(intToX-intFromX);	
	int count = 0;
	String[] inbetween =  {s.s,s.s,s.s,s.s,s.s,s.s,s.s,s.s};
                //find the piece that in between the move
	if((intToX-intFromX<0)&&(intToY-intFromY<0)){
		while(count < countX){
			
                                if(intFromX-count<0||intFromY-count<0){
                                break;
                                }
                                inbetween[count] = Board.board[intFromX-count][intFromY-count].icon;
                                count ++;
		}	
	}
	if((intToX-intFromX<0)&&(intToY-intFromY>0)){
		while(count < countX){
			
                                if(intFromX-count<0||intFromY+count<0){
                                break;
                                }
                                inbetween[count] = Board.board[intFromX-count][intFromY+count].icon;
                                count ++;
		}	
	}
	if((intToX-intFromX>0)&&(intToY-intFromY<0)){
		while(count < countX){
                                
			
                                if(intFromX+count<0||intFromY-count<0){
                                break;
                                }
                                inbetween[count] = Board.board[intFromX+count][intFromY-count].icon;
                                count ++;
		}	
	}
	if((intToX-intFromX>0)&&(intToY-intFromY>0)){
		while(count < countX){
			
                                if(intFromX+count<0||intFromY-count<0){
                                break;
                                }
                                inbetween[count] = Board.board[intFromX+count][intFromY+count].icon;
                                count ++;
		}	
	}
                // the if there is a piece that is in between
	for(int i=0;i<8;i++){
		if(((Board.board[intFromX][intFromY].characteristic[2]==0)&&(Board.board[intToX][intToY].characteristic[2]==0))||((Board.board[intFromX][intFromY].characteristic[2]==1)&&(Board.board[intToX][intToY].characteristic[2]==1))){
		}else{
		if(inbetween[i]== s.s && inbetween[i]==Board.board[intToX][intToY].icon){			
			output =true;						
		}
		if(inbetween[i]!= s.s){;
			if(inbetween[i] == Board.board[intToX][intToY].icon){
				output =true;
				break;
				}						
			}
		}				
	}	
}
		
		return output;

	}

}