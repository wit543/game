package game.Chess;

public class CheckMate {
	// test if the king can move or not
	int checkmate() {
		// find black/white king
		int[] black = new int[2];
		int[] white = new int[2];
		String color = "";// 1=black 0= white
		int end = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Board.board[i][j].characteristic[3] == 6
						&& Board.board[i][j].characteristic[2] == 1) {
					black[0] = Board.board[i][j].characteristic[0];
					black[1] = Board.board[i][j].characteristic[1];
				}
				if (Board.board[i][j].characteristic[3] == 6
						&& Board.board[i][j].characteristic[2] == 0) {
					white[0] = Board.board[i][j].characteristic[0];
					white[1] = Board.board[i][j].characteristic[1];
				}
			}
		}
		if (move(white) == 1) {
			color = "black";
			end = 1;
			toPlayer(color);
		}
		if (move(black) == 1) {
			color = "white";
			end = 1;
			toPlayer(color);
		}

		return end;

	}

	// find all the possible move of king
	int move(int[] from) {
		// test the king move
		Logic l = new Logic();
		int[] test = new int[4];
		int[] output = new int[5];

		test[0] = from[0];
		test[1] = from[1];
		for (int i = 0; i < 8; i++) {
			test[2] = test[0];
			test[3] = test[1];
			switch (i) {
			case 0:
				if (test[0] < 6 && test[1] < 6) {
					test[2] = from[0] + 1;
					test[3] = from[1] + 1;
				}
				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 1:
				if (test[0] > 1 & test[1] > 1) {
					test[2] = from[0] - 1;
					test[3] = from[1] - 1;
				}

				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 2:
				if (test[0] < 6 && test[1] > 1) {
					test[2] = from[0] + 1;
					test[3] = from[1] - 1;
				}
				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 3:
				if (test[0] > 1 && test[1] < 6) {
					test[2] = from[0] - 1;
					test[3] = from[1] + 1;
				}
				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 4:
				if (test[1] < 6) {
					test[2] = from[0];
					test[3] = from[1] + 1;
				}
				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 5:
				if (test[0] < 6) {
					test[2] = from[0] + 1;
					test[3] = from[1];
				}
				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 6:
				if (test[0] > 6) {
					test[2] = from[0] - 1;
					test[3] = from[1];
				}
				output = l.test(test);
				if (output[4] == 1) {
					break;
				}
			case 7:
				if (test[1] > 1) {
					test[2] = from[0];
					test[3] = from[1] - 1;
					output = l.test(test);
					if (output[4] == 1) {
						break;
					}
				}
			}
		}
		return output[4];

	}

	// out put to player who win
	void toPlayer(String color) {
		System.out.print(color + " checkmate");
	}
}
