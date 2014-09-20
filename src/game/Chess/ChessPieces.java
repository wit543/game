package game.Chess;

import java.awt.image.BufferedImage;

public class ChessPieces {

	int[] characteristic = new int[5];

	String icon;

	// two option for initialize 1)input in board 2) use if else and get input from  [2]
		//List<String> characteristics = new ArrayList<String>();
		/*
		 * [0] = x position
		 * [1] = y position
		 * [2] = color
		 * 				0 = white
		 * 				1 = black
		 * [3] = type
		 * 				0=space
		 * 				1=pawn
		 * 				2=rook
		 * 				3=bishop
		 * 				4=knight
		 * 				5=queen
		 * 				6=king
		 * [4] = point
		 *              0=space
		 * 				1=pawn
		 * 				5=rook
		 * 				3=bishop
		 * 				3=knight
		 * 				9=queen
		 * 				0=king
		 * 	*/
	
	void setCharacteristic(int x, int y){
		characteristic[0] = x;
		characteristic[1] = y;

	}

	void setCharacteristic(int x, int y, int z){
		characteristic[0] = x;
		characteristic[1] = y;
		characteristic[2] = z;

	}

	void setCharacteristic(int x, int y, int z, int a){
		characteristic[0] = x;
		characteristic[1] = y;
		characteristic[2] = z;
		characteristic[3] = a;

	}

	void setCharacteristic(int x, int y, int z, int a, int b){
		characteristic[0] = x;
		characteristic[1] = y;
		characteristic[2] = z;
		characteristic[3] = a;
		characteristic[4] = b;

	}

	void setCharacteristicImage(String img){
		icon = img;
	}

	boolean logic(int intFromX,int intFromY,int intToX,int intToY){
		return false;		
	}
	
	public int getPieces(){
		if (characteristic[3] == 1){
			//pawn
			return 1;
		} else if (characteristic[3] == 2){
			//rook
			return 2;
		} else if (characteristic[3] == 3){
			//bishop
			return 3;
		} else if (characteristic[3] == 4){
			//knight
			return 4;
		} else if (characteristic[3] == 5){
			//queen
			return 5;
		} else if (characteristic[3] == 6){
			//king
			return 6;
		} else {
			//space
			return 0;
		}
	}

}