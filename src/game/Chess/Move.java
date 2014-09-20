package game.Chess;


public class Move {
	Move(){
		
	}
	public int moveChess(int[] input){
		int IntfromX = input[0];
		int IntfromY = input[1];
		int InttoX = input[2];
		int InttoY = input[3];
                //1=can pass orther = not pass
		if(input[4]==1){
		ChessPieces s= new Space();
		ChessPieces chessmove = Board.board[IntfromX][IntfromY];		
		Board.board[InttoX][InttoY] = chessmove;
		Board.board[IntfromX][IntfromY] = s;
		}
		else{
			System.out.println("invalid");
		}
            return input[4];
		
		
	}
}