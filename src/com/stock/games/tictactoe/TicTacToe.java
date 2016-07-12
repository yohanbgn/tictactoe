package com.stock.games.tictactoe;

import java.util.Scanner;

public class TicTacToe extends BoardGame implements Game {

	private char[][] board;
	private static int boardRows = 3;
	private static int boardColumns = 3;
	private Player currentPlayer;
	private Player player1;
	private Player player2;
	private boolean hasWinner;

	public TicTacToe() {

	}

	public void init() {
		player1 = new Player("player1", 'x');
		player2 = new Player("player2", 'o');
		currentPlayer = player1;
		initializeBoard();
	}

	public void initializeBoard() {

		setBoardSize();

		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = '-';
			}
		}

		System.out.println(board);
		System.out.println("here");
	}

	public void printBoard() {
		System.out.println("-------------");

		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public boolean isBoardFull() {
		boolean isFull = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					isFull = false;
				}
			}
		}

		return isFull;
	}

	public boolean checkForGameWin() {
		boolean isGameWon = false;
		isGameWon = (checkRowsForGameWin() || checkColumnsForGameWin() || checkDiagonalsForGameWin());
		if (isGameWon) {
			setHasWinner(Boolean.TRUE);
		}
		return isGameWon;
	}

	private boolean checkRowsForGameWin() {
		for (int i = 0; i < 3; i++) {
			if (checkRowsAndColumnsEqual(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumnsForGameWin() {
		for (int i = 0; i < 3; i++) {
			if (checkRowsAndColumnsEqual(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonalsForGameWin() {
		for (int i = 0; i < 3; i++) {
			if (checkRowsAndColumnsEqual(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean checkRowsAndColumnsEqual(char character1, char character2, char character3) {
		return ((character1 != '-') && (character1 == character2) && (character1 == character3));
	}

	@Override
	public void play() {
		if (!isBoardFull()) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter a position of x:\t");
			int rowPosition = scanner.nextInt();
			System.out.print("Enter a position of y:\t");
			int columnPosition = scanner.nextInt();
			markCell(rowPosition, columnPosition);
			System.out.println(rowPosition + " , " + columnPosition);
			changePlayer();
		} else {
			System.out.println("Board is full");
			gameOver(true);
		}

	}

	public void changePlayer() {

		boolean hasWinner = isHasWinner();

		if (!hasWinner) {
			if (getCurrentPlayer().getPlayerMark() == player1.getPlayerMark()) {
				currentPlayer = player2;
			} else {
				currentPlayer = player1;
			}
		}

	}

	@Override
	public void gameOver(boolean isGameOver) {
		System.out.println("Game is over........");
		System.exit(0);
	}

	@Override
	public void setBoardSize() {
		board = new char[boardRows][boardColumns];
	}

	public void markCell(int row, int column) {
		if ((row >= 0) && (row < board[0].length)) {
			if ((column >= 0) && (column < board[0].length)) {
				if (board[row][column] == '-') {
					board[row][column] = currentPlayer.getPlayerMark();
				}
			}
		}
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player getWinner() {
		Player winner = null;
		if (getCurrentPlayer().getName().equals("player1")) {
			winner = player2;
		} else {
			return player1;
		}
		return winner;
	}

	public boolean isHasWinner() {
		return hasWinner;
	}

	public void setHasWinner(boolean hasWinner) {
		this.hasWinner = hasWinner;
	}

}
