package com.stock.games.tictactoe;

public class Player {
	private String name;
	private char[][] moves;
	private char playerMark = 'x';

	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name, char playerMark) {
		this.name = name;
		this.playerMark = playerMark;
	}

	public char[][] getMoves() {
		return moves;
	}

	public void setMoves(char[][] moves) {
		this.moves = moves;
	}

	public char getPlayerMark() {
		return playerMark;
	}

	public void setPlayerMark(char playerMark) {
		this.playerMark = playerMark;
	}

}
