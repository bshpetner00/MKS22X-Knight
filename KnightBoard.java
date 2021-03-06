import java.util.*;
import java.io.*;

public class KnightBoard {
	private int[][] board;
	private int[][] moves;
	public KnightBoard(int r, int c) throws IllegalArgumentException {
		moves = new int[][]{{2,1}, {1,2}, {2,-1}, {-2,1}, {-2,-1}, {-1,2}, {1,-2}, {-1,-2}};
		if (r <= 0 || c <= 0) {
			throw new IllegalArgumentException("BREEBLER ALERT");
		}
		board = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				board[i][j] = 0;
			}
		}
	}

	private void clear() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				board[r][c] = 0;
			}
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] % 10 == board[i][j]) {
					if (board[i][j] == 0) {
						s = s + "   _"; 
					}
					else {
						s = s + "   " + board[i][j];
					}
				}
				else if (board[i][j] % 100 == board[i][j]) {
					if (board[i][j] == 0) {
						s = s + "  _"; 
					}
					else {
						s = s + "  " + board[i][j];
					}
				}
				else {
					if (board[i][j] == 0) {
						s = s + " _"; 
					}
					else {
						s = s + " " + board[i][j];
					}
				}
			}
			s += "\n";
		}
		return s;
	}

	public boolean solve(int firstRow, int firstCol) throws IllegalStateException,IllegalArgumentException {
		if (firstRow < 0 || firstCol < 0) {
			throw new IllegalArgumentException("Invalid board index");
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException("Invalid board state. Clear it or suffer.");
				}
			}
		}
		if (solveHelp(firstRow, firstCol, 1)) {
			return true;
		}
		else {
			clear();
			return false;
		}
	}

	public boolean solveHelp(int r, int c, int knights) {
		int arr = 0;
		int see = 0;
		if (r >= board.length || c >= board[0].length || r < 0 || c < 0) {
			return false;
		}
		else if (board[r][c] != 0){
			return false;
		}
		else if (knights == board.length * board[r].length) {
			board[r][c] = knights;
			return true;
		}
		else {
			for (int[]move: moves) {
				board[r][c] = knights;
				arr = r + move[0];
				see = c + move[1];
				if (solveHelp(arr,see,knights+1)) {
					return true;
				}
				board[r][c] = 0;
			}
		}
		return false;
	}

	public int countSolutions(int firstRow, int firstCol) throws IllegalStateException,IllegalArgumentException {
		if (firstRow < 0 || firstCol < 0) {
			throw new IllegalArgumentException("Invalid board index");
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException("Invalid board state. Clear it or suffer.");
				}
			}
		}
		return countHelp(firstRow, firstCol, 1);
	}

	public int countHelp(int r, int c, int knights) {
		int count = 0;
		if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || board[r][c] != 0){
			return 0;
		}
		if (knights == board.length * board[0].length){
			return 1;
		}
		for (int[]move: moves) {
			board[r][c] = knights;
			int arr = r + move[0];
			int see = c + move[1];
			count += countHelp(arr,see,knights+1);
			board[r][c] = 0;
		}
		return count;
	}

	public static void main(String[] args) {
		KnightBoard b = new KnightBoard(6,6);
		b.solve(0,0);
		System.out.println(b);
	}

}