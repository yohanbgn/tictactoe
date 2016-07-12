package com.stock.tictactoe.main;

import com.stock.games.tictactoe.TicTacToe;

public class Runner {

	public Runner() {
	}

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.init();
		ticTacToe.printBoard();

		while (!ticTacToe.checkForGameWin()) {
			ticTacToe.play();
			ticTacToe.printBoard();
		}

		System.out.println("Winner is :" + ticTacToe.getWinner().getName());
		ticTacToe.gameOver(true);

	}

}
