package tic;

import javafx.scene.paint.Color;

public class Board {
	// [row][col]
	public Piece[][] board;
	public int turn = 0;

	public Board() {
		board = new Piece[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = new TransPiece();
			}
		}
	}

	public boolean checkWin() {
		if (checkDiagonal()) {
			return true;
		}
		if (checkHorizontal()) {
			return true;
		}
		if (checkVerticle()) {
			return true;
		}
		return false;
	}

	private boolean checkHorizontal() {
		int match = 1;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if ((board[i][j].color != Color.TRANSPARENT) && (board[i][j].color == board[i][j + 1].color)) {
					match += 1;
					System.err.println(match);
				}
			}
			if (match == 5) {
				return true;
			} 
			match = 1;
		}
		return false;
	}
	private boolean checkDiagonal() {
		int match = 1;

	// diagnoal starting topleft
		for (int i = 0; i < 4; i++) {
			if ((board[i][i].color != Color.TRANSPARENT) && (board[i][i].color == board[i + 1][i+ 1].color)) {
				match += 1;
			}
		}
		if (match == 5) {
			return true;
		}
		match = 1;
		return false;
	}
	private boolean checkVerticle() {
		int match = 1;

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				if ((board[i][j].color != Color.TRANSPARENT) && (board[i][j].color == board[i + 1][j].color)) {
					match += 1;
					System.err.println(match);
				}
			}
			if (match == 5) {
				return true;
			} 
			match = 1;
		}

		return false;
	}
}
