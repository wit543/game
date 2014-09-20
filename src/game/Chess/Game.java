package game.Chess;

import java.applet.Applet;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends GameLoop{
	
	public void init(){
		setSize(800,700);
		Thread th = new Thread(this);
		th.start();
		
		offscreen = createImage(800,700);
		d = offscreen.getGraphics();
		
		addKeyListener(this);
		
	}
	
	
	
	public void paint(Graphics g){
		d.clearRect(0,0,800,700);
		d.drawImage(background, 0, 0, this);
		d.drawImage(coor, boardPosX-64, boardPosY-64, this);
		d.drawImage(board, boardPosX, boardPosY, this);
		
		d.drawImage(IMG_select, x, y, this);
		
		//Update the board
		chessRender();
		
		g.drawImage(offscreen, 0, 0, this);
	}
	
	public void update(Graphics g){
		
		paint(g);
	}
	
	public void chessRender(){
		for (int x = 0; x < 8; x++){
			for (int y = 0; y < 8; y++){
				
				
				//This one is more certain
				if(Board.board[x][y].characteristic[2] == 0){
					//color = "White";
					if(Board.board[x][y].characteristic[3] == 1){
						//type = "Pawn";
						d.drawImage(IMG_wP, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 2){
						//type = "Rook";
						d.drawImage(IMG_wR, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 3){
						//type = "Bishop";
						d.drawImage(IMG_wB, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 4){
						//type = "Knight";
						d.drawImage(IMG_wKn, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 5){
						//type = "Queen";
						d.drawImage(IMG_wQ, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 6){
						//type = "King";
						d.drawImage(IMG_wK, boardPosX+(64*x), boardPosY+(64*y), this);
					} 
				} else if (Board.board[x][y].characteristic[2] == 1){
					//color = "Black";
					if(Board.board[x][y].characteristic[3] == 1){
						//type = "Pawn";
						d.drawImage(IMG_bP, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 2){
						//type = "Rook";
						d.drawImage(IMG_bR, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 3){
						//type = "Bishop";
						d.drawImage(IMG_bB, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 4){
						//type = "Knight";
						d.drawImage(IMG_bKn, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 5){
						//type = "Queen";
						d.drawImage(IMG_bQ, boardPosX+(64*x), boardPosY+(64*y), this);
					} else if(Board.board[x][y].characteristic[3] == 6){
						//type = "King";
						d.drawImage(IMG_bK, boardPosX+(64*x), boardPosY+(64*y), this);
					} 
				}
			}
		}
		
	}
	
}
