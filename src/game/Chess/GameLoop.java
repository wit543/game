package game.Chess;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class GameLoop extends Applet implements Runnable, KeyListener {

	public int x, y;

	protected Scanner scanner = new Scanner(System.in);

	public static int boardPosX = 200, boardPosY = 125;

	public Image offscreen;
	public static Graphics d;

	public String type = "", fromPos = "", color = "";;

	public boolean left, up, right, down;

	public static String input = "";
	public static String select = "";
	public static boolean selected = false;

	public static BufferedImage background, board, coor, IMG_bK, IMG_wK,
			IMG_bQ, IMG_wQ, IMG_bP, IMG_wP, IMG_bKn, IMG_wKn, IMG_bR, IMG_wR,
			IMG_bB, IMG_wB, IMG_select, IMG_move, IMG_danger;

	// Local Variables of the board game
	public Board b = new Board();
	public Input i = new Input();
	public Logic l = new Logic();
	public Move m = new Move();
	public Translater t = new Translater();
	public Check c = new Check();
	public CheckMate ch = new CheckMate();
	public AI ai = new AI();
	public KeyInput k = new KeyInput();

	int g = 0;
	int colorCode = 0; // 1 = black 0 = white
	int player = 2;// default = 2 for 2 player
	int playerColor = -1, aiColor = -1;

	public void run() {
		b.initBoard();

		String[][] boardPos = new String[8][8];
		for (int i = 0; i < 8; i++) {
			// row 1-8
			for (int j = 0; j < 8; j++) {
				// column a-h
				boardPos[i][j] = ((j + 1) + "") + "/"
						+ (((char) (97 + i)) + "");
			}
		}

		for (int i = 0; i < 8; i++) {
			// row 1-8
			for (int j = 0; j < 8; j++) {
				// column A-H
				System.out.print(boardPos[i][j] + " ");
			}
			System.out.println();
		}

		// Test the Graphic Changes with the 1st Black Knight
		Board.bKn1.characteristic[0] = 4;
		Board.bKn1.characteristic[1] = 4;

		// This one has a bug
		// System.out.print(Board.board[0][0].getPieces());

		select = "1/a";

		x = boardPosX + (64 * 0);
		y = boardPosY + (64 * 0);

		try {
			background = ImageIO.read(this.getClass().getResource(
					"BG_Blue_test.jpg"));
			board = ImageIO.read(this.getClass().getResource(
					"checker_board.png"));
			coor = ImageIO
					.read(this.getClass().getResource("checker_coor.png"));
			IMG_bK = ImageIO
					.read(this.getClass().getResource("black_king.png"));
			IMG_wK = ImageIO
					.read(this.getClass().getResource("white_king.png"));
			IMG_bQ = ImageIO.read(this.getClass()
					.getResource("black_queen.png"));
			IMG_wQ = ImageIO.read(this.getClass()
					.getResource("white_queen.png"));
			IMG_bP = ImageIO
					.read(this.getClass().getResource("black_pawn.png"));
			IMG_wP = ImageIO
					.read(this.getClass().getResource("white_pawn.png"));
			IMG_bKn = ImageIO.read(this.getClass().getResource(
					"black_knight.png"));
			IMG_wKn = ImageIO.read(this.getClass().getResource(
					"white_knight.png"));
			IMG_bR = ImageIO
					.read(this.getClass().getResource("black_rook.png"));
			IMG_wR = ImageIO
					.read(this.getClass().getResource("white_rook.png"));
			IMG_bB = ImageIO.read(this.getClass().getResource(
					"black_bishop.png"));
			IMG_wB = ImageIO.read(this.getClass().getResource(
					"white_bishop.png"));

			IMG_select = ImageIO.read(this.getClass().getResource(
					"selector.png"));
			IMG_move = ImageIO.read(this.getClass().getResource("movable.png"));
			IMG_danger = ImageIO
					.read(this.getClass().getResource("danger.png"));

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (true) {
			System.out.print("Select How many Player: ");
			try {
				input = k.keyboardInString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("invalid");
			}

			if (Integer.parseInt(input) == 1) {
				player = 1;
				input = "";
				break;
			} else if (Integer.parseInt(input) == 2) {
				player = 2;
				input = "";
				break;
			} else {
				System.out.println("invalid");
			}
		}

		while (true) {
			System.out.print("Select Color : ");
			try {
				input = k.keyboardInString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("invalid");
			}

			if (Integer.parseInt(input) == 0) {
				playerColor = 0;
				colorCode = 0;
				input = "";
				break;
			} else if (Integer.parseInt(input) == 1) {
				playerColor = 0;
				colorCode = 1;
				input = "";
				break;
			} else {
				System.out.println("invalid");
			}
		}

		// Game Runner
		while (true) {

			if (left == true && boardPosX < x) {
				x -= 64;
			}
			if (up == true && boardPosY < y) {
				y -= 64;
			}
			if (right == true && x < boardPosX + (64 * 7)) {
				x += 64;
			}
			if (down == true && y < boardPosY + (64 * 7)) {
				y += 64;
			}

			if (left == true && boardPosX <= x) {
				checkTypeInBoard();
			}
			if (up == true && boardPosY <= y) {
				checkTypeInBoard();
			}
			if (right == true && x <= boardPosX + (64 * 7)) {
				checkTypeInBoard();
			}
			if (down == true && y <= boardPosY + (64 * 7)) {
				checkTypeInBoard();
			}

			// update screen method
			repaint();
			try {
				// Game's Speed
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			left = true;
		}
		if (e.getKeyCode() == 38) {
			up = true;
		}
		if (e.getKeyCode() == 39) {
			right = true;
		}
		if (e.getKeyCode() == 40) {
			down = true;
		}

		// Test the Graphic Changes as press up
				if (e.getKeyCode() == 37) {
					if (Board.bKn1.characteristic[0] == 4) {
						Board.bKn1.characteristic[0] = 5;
					} else {
						Board.bKn1.characteristic[0] = 4;
					}
					if (Board.bKn1.characteristic[1] == 4) {
						Board.bKn1.characteristic[1] = 5;
					} else {
						Board.bKn1.characteristic[1] = 4;
					}
					Board.board[Board.bKn1.characteristic[0]][Board.bKn1.characteristic[1]] = Board.s;
					Board.board[1][0] = Board.s;
					repaint();
				}
		
		// Test the Graphic Changes as press down
		if (e.getKeyCode() == 40) {
			if (Board.bKn1.characteristic[0] == 4) {
				Board.bKn1.characteristic[0] = 5;
			} else {
				Board.bKn1.characteristic[0] = 4;
			}
			if (Board.bKn1.characteristic[1] == 4) {
				Board.bKn1.characteristic[1] = 5;
			} else {
				Board.bKn1.characteristic[1] = 4;
			}
			Board.board[Board.bKn1.characteristic[0]][Board.bKn1.characteristic[1]] = Board.bKn1;
			repaint();
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER && !selected) {
			selected = true;
			input += select;
			System.out.println(input);
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER && selected
				&& select != input) {
			selected = false;
			input += " " + select;
			System.out.println(input);

			switch (player) {
			case 1:
				while (g < 1) {
					if (colorCode == 0 && playerColor == 0) {

						if (m.moveChess(l.test(t.StringToCode(input), colorCode)) == 1) {
							colorCode = 1;
							// System.out.println("1");
						}
					} else if (colorCode == 1 && playerColor == 1) {
						if (m.moveChess(l.test(t.StringToCode(input), colorCode)) == 1) {
							colorCode = 0;
							// System.out.println("2");
						}
					} else if (colorCode == 0 && aiColor == 0) {
						if (m.moveChess(ai.ai(aiColor)) == 1) {
							colorCode = 1;
							// System.out.println("3");
						}
					} else if (colorCode == 1 && aiColor == 1) {
						if (m.moveChess(ai.ai(aiColor)) == 1) {
							colorCode = 0;
							// System.out.println("4");
						}
					}
					if (c.checkKing() == 1 || ch.checkmate() == 1) {
						break;
					}
				}
				// two player
			case 2:
				while (g < 1) {
					if (colorCode == 0) {

						if (m.moveChess(l.test(t.StringToCode(input), colorCode)) == 1) {
							colorCode = 1;
						}
					} else if (colorCode == 1) {
						if (m.moveChess(l.test(t.StringToCode(input), colorCode)) == 1) {
							colorCode = 0;
						}
					}
					if (c.checkKing() == 1 || ch.checkmate() == 1) {
						break;
					}
				}
			}

			input = "";
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE && selected) {
			selected = false;
			input = "";
			System.out.println(input);
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			left = false;
		}
		if (e.getKeyCode() == 38) {
			up = false;
		}
		if (e.getKeyCode() == 39) {
			right = false;
		}
		if (e.getKeyCode() == 40) {
			down = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}

	public void checkTypeInBoard() {
		String[][] boardPos = new String[8][8];
		for (int i = 0; i < 8; i++) {
			// row 1-8
			for (int j = 0; j < 8; j++) {
				// column a-h
				boardPos[i][j] = ((j + 1) + "") + "/"
						+ (((char) (97 + i)) + "");
			}
		}

		String displaySpace = "";

		// Check Selector Position
		for (int xi = 0; xi < 8; xi++) {
			if (x == boardPosX + (64 * xi)) {
				for (int yi = 0; yi < 8; yi++) {
					if (y == boardPosY + (64 * yi)) {
						fromPos = boardPos[xi][yi];

						/*
						 * This one Works the same as the one above, just
						 * different casting
						 */
						if (Board.board[xi][yi].characteristic[2] == 0) {
							color = "White";
							displaySpace = " ";
							if (Board.board[xi][yi].characteristic[3] == 1) {
								type = "Pawn";
							} else if (Board.board[xi][yi].characteristic[3] == 2) {
								type = "Rook";
							} else if (Board.board[xi][yi].characteristic[3] == 3) {
								type = "Bishop";
							} else if (Board.board[xi][yi].characteristic[3] == 4) {
								type = "Knight";
							} else if (Board.board[xi][yi].characteristic[3] == 5) {
								type = "Queen";
							} else if (Board.board[xi][yi].characteristic[3] == 6) {
								type = "King";
							}
						} else if (Board.board[xi][yi].characteristic[2] == 1) {
							color = "Black";
							displaySpace = " ";
							if (Board.board[xi][yi].characteristic[3] == 1) {
								type = "Pawn";
							} else if (Board.board[xi][yi].characteristic[3] == 2) {
								type = "Rook";
							} else if (Board.board[xi][yi].characteristic[3] == 3) {
								type = "Bishop";
							} else if (Board.board[xi][yi].characteristic[3] == 4) {
								type = "Knight";
							} else if (Board.board[xi][yi].characteristic[3] == 5) {
								type = "Queen";
							} else if (Board.board[xi][yi].characteristic[3] == 6) {
								type = "King";
							}
						} else {
							color = "";
							type = "Space";
							displaySpace = "";
						}

						select = boardPos[xi][yi];

						System.out.println(color + displaySpace + type);

					}
				}
			}

		}
	}

}
