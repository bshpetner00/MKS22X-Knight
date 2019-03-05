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

}