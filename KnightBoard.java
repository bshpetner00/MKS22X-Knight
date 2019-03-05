import java.util.*;
import java.io.*;

private int[][] board;
public class KnightBoard {

	public KnightBoard(int r, int c) throws IllegalArgumentException {
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

	public String toString() {
		String s = "";
		for (int i = 0; i < board.length; < i++) {
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

}