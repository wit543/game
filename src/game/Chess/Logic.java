package game.Chess;

public class Logic {

	public int[] test(int[] input){

		int intFromX = input[0];
		int intFromY = input[1];
		int intToX = input[2];
		int intToY = input[3];

		ChessPieces p = new Pawn();
		ChessPieces r = new Rook();
		ChessPieces b = new Bishop();
		ChessPieces kn = new Knight();
		ChessPieces q = new Queen();
		ChessPieces k = new King();

		boolean output = false;
		
		//Logic of Each Pieces Below, As "name".characteristic[3] = type
		if (Board.board[intFromX][intFromY].characteristic[3] == 1){
			//Pawn's Logic
			output = p.logic(intFromX, intFromY, intToX, intToY);
		} else if (Board.board[intFromX][intFromY].characteristic[3] == 2){
			//Rook's Logic
			output = p.logic(intFromX, intFromY, intToX, intToY);
		} else if (Board.board[intFromX][intFromY].characteristic[3] == 3){
			//Bishop's Logic
			output = p.logic(intFromX, intFromY, intToX, intToY);
		} else if (Board.board[intFromX][intFromY].characteristic[3] == 4){
			//Knight's Logic
			output = p.logic(intFromX, intFromY, intToX, intToY);
		} else if (Board.board[intFromX][intFromY].characteristic[3] == 5){
			//Queen's Logic
			output = p.logic(intFromX, intFromY, intToX, intToY);
		} else if (Board.board[intFromX][intFromY].characteristic[3] == 6){
			//King's Logic
			output = p.logic(intFromX, intFromY, intToX, intToY);
		}
		
		//now test the result
		int[] outputArray = new int[5];
		if (output == true){
			outputArray[0] = intFromX;
			outputArray[1] = intFromY;
			outputArray[2] = intToX;
			outputArray[3] = intToY;
			outputArray[4] = 1;
		} else {
			outputArray[0] = intFromX;
			outputArray[1] = intFromY;
			outputArray[2] = intToX;
			outputArray[3] = intToY;
			outputArray[4] = 0;
		}

		return outputArray;
	}
	
    //test with color for each side turn
	public int[] test(int[] input, int color){
		int IntfromX = input[0];
		int IntfromY = input[1];
		int InttoX = input[2];
		int InttoY = input[3];
		
		ChessPieces p = new Pawn();
		ChessPieces r = new Rook();
		ChessPieces b = new Bishop();
		ChessPieces kn = new Knight();
		ChessPieces q = new Queen();
		ChessPieces k = new King();
		boolean output=false;
                
                //for each piece to their logic
		if(Board.board[IntfromX][IntfromY].characteristic[3]==1){
			output = p.logic(IntfromX, IntfromY, InttoX, InttoY);
		}
		else if(Board.board[IntfromX][IntfromY].characteristic[3]==2){
			output = r.logic(IntfromX, IntfromY, InttoX, InttoY);
		}
		else if(Board.board[IntfromX][IntfromY].characteristic[3]==3){
			output = b.logic(IntfromX, IntfromY, InttoX, InttoY);
		}
		else if(Board.board[IntfromX][IntfromY].characteristic[3]==4){
			output = kn.logic(IntfromX, IntfromY, InttoX, InttoY);
		}
		else if(Board.board[IntfromX][IntfromY].characteristic[3]==5){
			output = q.logic(IntfromX, IntfromY, InttoX, InttoY);
		}
		else if(Board.board[IntfromX][IntfromY].characteristic[3]==6){
			output = k.logic(IntfromX, IntfromY, InttoX, InttoY);
		}
                
                colorCheck c = new colorCheck();
                //c.colorCheck(color, board.board[IntfromX][IntfromY].characteristic[2]);
                
                
                //put the test result in to the output array
		int[] outputArray= new int[5]; 
		if(output==true&&  c.colorCheck(color, Board.board[IntfromX][IntfromY].characteristic[2])==1){
			outputArray[0]=IntfromX;
			outputArray[1]=IntfromY;
			outputArray[2]=InttoX;
			outputArray[3]=InttoY;
			outputArray[4]=1;			
		}
		else{
			outputArray[0]=IntfromX;
			outputArray[1]=IntfromY;
			outputArray[2]=InttoX;
			outputArray[3]=InttoY;
			outputArray[4]=0;		
		}
		return outputArray;
		
	}	
        //cheack the color of turn
    private class colorCheck {
        
        int colorCheck(int color, int colorMove) {
            int output = 0;
            if(color==colorMove){
                output =1;
            }
            
            else{
                output=0;
            }
            return output;
        }
        
    	}
       
	}
	

