package game.Chess;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen extends ChessPieces {

	//initialize queen
	Queen(int x, int y, int color, String img){
		characteristic[0] = x; //x
		characteristic[1] = y; //y
		characteristic[2] = color; //black or white
		characteristic[3] = 5; //rook
		characteristic[4] = 9; //rook
		icon = img;

	}

	Queen(){

	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		
		Space s = new Space();

		boolean output = false;
		//test like rook
				if(((Math.abs(intFromX-intFromY)==Math.abs(intToX-intToY))||(Math.abs(intFromX+intFromY)==Math.abs(intToX+intToY)
		                        ))&&(
		                            (intToX!=0)&&(intToY!=5)&&(intFromX!=7)&&(intFromY!=2)//SPECIAL CASE it pass the if statement
		                        )){
					output =false;
					int countX =Math.abs(intToX-intFromX);	
					int count = 0;
					String[] inbetween =  {s.s,s.s,s.s,s.s,s.s,s.s,s.s,s.s,s.s};
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
		                // test like bishop
				List<String> black = new ArrayList<String>(Arrays.asList("â??","â??","â??","â??","â??","â??"));
				List<String> white = new ArrayList<String>(Arrays.asList("â?–","â??","â?—","â?•","â?”","â??"));
				if(intFromX==intToX || intFromY==intToY){
					int x= intToX-intFromX;
					int y= intToY-intFromY;
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
							int d=0;
							for (d=0;d<8;d++){
								if(white.contains(inbetween[d])||black.contains(inbetween[d])){
									h++;
								}
							}
							if(inbetween[i]== s.s && inbetween[i]==Board.board[intToX][intToY].icon &&h==0){
								for (d=0;d<8;d++){
									if(white.contains(inbetween[d])||black.contains(inbetween[d])){
										h++;
									}
								}
								output =true;
							}
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