package LAB5;

public class Task2 {
	private static final char EMPTY = ' ';
	private char[][] board;

	public Task2(char[][] board) {
		super();
		this.board = board;
	}

	// 'X' = 88 ; 'O' = 79; 'x' = 88 + 32 ; 'o' = 79 + 32
	public boolean checkRows() {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sum += board[i][j];
			}
			if (sum == 88 * board[i].length || sum == 79 * board[i].length || sum == (88 + 32) * board[i].length
					|| sum == (79 + 32) * board[i].length) {
				return true;
			} else {
				sum = 0;
			}
		}
		return false;
	}

	public boolean checkColumns() {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sum += board[j][i];
			}
			if (sum == 88 * board.length || sum == 79 * board.length || sum == (88 + 32) * board.length
					|| sum == (79 + 32) * board.length) {
				return true;
			} else {
				sum = 0;
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		int sum = 0;
		// Đường Chéo Chính
		for (int i = 0; i < board.length; i++) {
			sum += board[i][i];
		}
		if (sum == 88 * board.length || sum == 79 * board.length || sum == (88 + 32) * board.length
				|| sum == (79 + 32) * board.length) {
			return true;
		} else {
			sum = 0;
		}
		// Đường Chéo Phụ
		for (int i = 0; i < board.length; i++) {
			sum += board[i][board[i].length - 1 - i];
		}
		if (sum == 88 * board.length || sum == 79 * board.length || sum == (88 + 32) * board.length
				|| sum == (79 + 32) * board.length) {
			return true;
		} else {
			sum = 0;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board1 = { { 'X', 'X', 'X' }, 
							{ ' ', 'O', ' ' }, 
							{ 'O', 'O', 'X' } };

		char[][] board2 = { { 'O', 'X', 'X' }, 
							{ ' ', 'O', 'X' }, 
							{ 'O', ' ', 'X' } };

		char[][] board3 = { { 'X', 'X', 'O' }, 
							{ 'X', 'O', ' ' }, 
							{ 'O', ' ', ' ' } };

		char[][] board4 = { { 'X', 'X', 'O' }, 
							{ 'O', 'X', ' ' }, 
							{ 'O', ' ', 'X' } };
		Task2 t1 = new Task2(board1);
		Task2 t2 = new Task2(board2);
		Task2 t3 = new Task2(board3);
		Task2 t4 = new Task2(board4);
		// check row
		System.out.println("Check Row : ");
		System.out.println(t1.checkRows());
		System.out.println(t2.checkRows());
		System.out.println("---------------------");
		// check columns
		System.out.println("Check Columns : ");
		System.out.println(t2.checkColumns());
		System.out.println(t3.checkColumns());
		System.out.println("---------------------");
		// check diagonals
		System.out.println("Check Diagonals : ");
		System.out.println(t3.checkDiagonals());
		System.out.println(t4.checkDiagonals());
		System.out.println(t1.checkDiagonals());
		System.out.println(t2.checkDiagonals());
	}
}
