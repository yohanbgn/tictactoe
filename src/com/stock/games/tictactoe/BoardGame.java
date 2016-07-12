package com.stock.games.tictactoe;

abstract public class BoardGame implements Game {

	public BoardGame() {
	}

	public abstract void initializeBoard();

	public abstract void printBoard();

	public abstract boolean isBoardFull();

	public abstract void setBoardSize();

	public abstract void gameOver(boolean isGameOver);

	public abstract Player getWinner();

}
