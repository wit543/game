package game.Chess;

public class Board {

	static ChessPieces[][] board = new ChessPieces[8][8];
	//This is the whole 8x8 board for the Chess

	//set each pieces
	static ChessPieces bR1 = new Rook(0,0,1,"â??");
	static ChessPieces bKn1 = new Knight(1,0,1,"â??");
	static ChessPieces bB1 = new Bishop(2,0,1,"â??");
	static ChessPieces bQ = new Queen(3,0,1,"â??");
	static ChessPieces bK = new King(4,0,1,"â??");
	static ChessPieces bB2 = new Bishop(5,0,1,"â??");
	static ChessPieces bKn2 = new Knight(6,0,1,"â??");
	static ChessPieces bR2 = new Rook(7,0,1,"â??");

	static ChessPieces bP1 = new Pawn(0,1,1,"â??");
	static ChessPieces bP2 = new Pawn(1,1,1,"â??");
	static ChessPieces bP3 = new Pawn(2,1,1,"â??");
	static ChessPieces bP4 = new Pawn(3,1,1,"â??");
	static ChessPieces bP5 = new Pawn(4,1,1,"â??");
	static ChessPieces bP6 = new Pawn(5,1,1,"â??");
	static ChessPieces bP7 = new Pawn(6,1,1,"â??");
	static ChessPieces bP8 = new Pawn(7,1,1,"â??");

	static ChessPieces wR1 = new Rook(0,7,0,"â?–");
	static ChessPieces wKn1 = new Knight(1,7,0,"â??");
	static ChessPieces wB1 = new Bishop(2,7,0,"â?—");
	static ChessPieces wQ = new Queen(3,7,0,"â?•");
	static ChessPieces wK = new King(4,7,0,"â?”");
	static ChessPieces wB2 = new Bishop(5,7,0,"â?—");
	static ChessPieces wKn2 = new Knight(6,7,0,"â??");
	static ChessPieces wR2 = new Rook(7,7,0,"â?–");

	static ChessPieces wP1 = new Pawn(0,6,0,"â??");
	static ChessPieces wP2 = new Pawn(1,6,0,"â??");
	static ChessPieces wP3 = new Pawn(2,6,0,"â??");
	static ChessPieces wP4 = new Pawn(3,6,0,"â??");
	static ChessPieces wP5 = new Pawn(4,6,0,"â??");
	static ChessPieces wP6 = new Pawn(5,6,0,"â??");
	static ChessPieces wP7 = new Pawn(6,6,0,"â??");
	static ChessPieces wP8 = new Pawn(7,6,0,"â??");
	
	static ChessPieces black = new ChessPieces();
	static ChessPieces white = new ChessPieces();

	static ChessPieces s = new Space();
	
	public void initBoard(){
		//Set Spaces First
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				board[i][j] = s;
			}
		}
		
		//Put Each Pieces Into the Board
		//While "name".characteristic[0] = X
		//And "name".characteristic[1] = Y
		board[bR1.characteristic[0]][bR1.characteristic[1]] = bR1;
		board[bR2.characteristic[0]][bR2.characteristic[1]] = bR2;
		board[bB1.characteristic[0]][bB1.characteristic[1]] = bB1;
		board[bB2.characteristic[0]][bB2.characteristic[1]] = bB2;
		board[bKn1.characteristic[0]][bKn1.characteristic[1]] = bKn1;
		board[bKn2.characteristic[0]][bKn2.characteristic[1]] = bKn2;
		board[bQ.characteristic[0]][bQ.characteristic[1]] = bQ;
		board[bK.characteristic[0]][bK.characteristic[1]] = bK;
		
		board[bP1.characteristic[0]][bP1.characteristic[1]] = bP1;
		board[bP2.characteristic[0]][bP2.characteristic[1]] = bP2;
		board[bP3.characteristic[0]][bP3.characteristic[1]] = bP3;
		board[bP4.characteristic[0]][bP4.characteristic[1]] = bP4;
		board[bP5.characteristic[0]][bP5.characteristic[1]] = bP5;
		board[bP6.characteristic[0]][bP6.characteristic[1]] = bP6;
		board[bP7.characteristic[0]][bP7.characteristic[1]] = bP7;
		board[bP8.characteristic[0]][bP8.characteristic[1]] = bP8;

		board[wR1.characteristic[0]][wR1.characteristic[1]] = wR1;
		board[wR2.characteristic[0]][wR2.characteristic[1]] = wR2;
		board[wB1.characteristic[0]][wB1.characteristic[1]] = wB1;
		board[wB2.characteristic[0]][wB2.characteristic[1]] = wB2;
		board[wKn1.characteristic[0]][wKn1.characteristic[1]] = wKn1;
		board[wKn2.characteristic[0]][wKn2.characteristic[1]] = wKn2;
		board[wQ.characteristic[0]][wQ.characteristic[1]] = wQ;
		board[wK.characteristic[0]][wK.characteristic[1]] = wK;

		board[wP1.characteristic[0]][wP1.characteristic[1]] = wP1;
		board[wP2.characteristic[0]][wP2.characteristic[1]] = wP2;
		board[wP3.characteristic[0]][wP3.characteristic[1]] = wP3;
		board[wP4.characteristic[0]][wP4.characteristic[1]] = wP4;
		board[wP5.characteristic[0]][wP5.characteristic[1]] = wP5;
		board[wP6.characteristic[0]][wP6.characteristic[1]] = wP6;
		board[wP7.characteristic[0]][wP7.characteristic[1]] = wP7;
		board[wP8.characteristic[0]][wP8.characteristic[1]] = wP8;


	}

}