package com.stock.games.tictactoe;

public interface Game {
	public void play();
	public void gameOver(boolean isGameOver);
	public boolean checkForGameWin();
	public Player getWinner();
}
