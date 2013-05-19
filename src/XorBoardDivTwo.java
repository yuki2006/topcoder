
// Paste me into the FileEdit configuration dialog

public class XorBoardDivTwo {
	public int theMax(String[] board) {
		boolean[][] tablesrc = new boolean[board.length][board[0].length()];
		for (int i = 0; i < tablesrc.length; i++) {
			for (int j = 0; j < tablesrc[i].length; j++) {
				tablesrc[i][j] = board[i].charAt(j) == '1';
			}
		}
		int max = 0;
		for (int i = 0; i < tablesrc.length; i++) {
			for (int j = 0; j < tablesrc[i].length; j++) {
				int a = inverseCount(tablesrc, i, j);
				if (a > max) {
					max = a;
				}
			}
		}
		return max;
	}

	private int inverseCount(boolean[][] table, int row, int column) {
		boolean[][] t = new boolean[table.length][table[0].length];
		for (int i = 0; i < table.length; i++) {
			System.arraycopy(table[i], 0, t[i], 0, table[i].length);
		}
		for (int j = 0; j < table.length; j++) {
			 t[j][column] = ! t[j][column];
		}
		for (int j = 0; j < table[row].length; j++) {
			 t[row][j] = ! t[row][j];
		}

		int count = 0;
		for (int i = 0; i <  t.length; i++) {
			for (int j = 0; j <  t[i].length; j++) {
				if ( t[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			XorBoardDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				XorBoardDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class XorBoardDivTwoHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i = 0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100)
					break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(int expected, int result) {
		return expected == result;
	}

	static String formatResult(int res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, int expected, int received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected));
			System.err.println("    Received: " + formatResult(received));
			return 0;
		}
	}

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String[] board = { "101", "010", "101" };
			int expected__ = 9;

			return verifyCase(casenum, expected__, new XorBoardDivTwo().theMax(board));
		}
		case 1: {
			String[] board = { "111", "111", "111" };
			int expected__ = 5;

			return verifyCase(casenum, expected__, new XorBoardDivTwo().theMax(board));
		}
		case 2: {
			String[] board = { "0101001", "1101011" };
			int expected__ = 9;

			return verifyCase(casenum, expected__, new XorBoardDivTwo().theMax(board));
		}
		case 3: {
			String[] board = { "000", "001", "010", "011", "100", "101", "110", "111" };
			int expected__ = 15;

			return verifyCase(casenum, expected__, new XorBoardDivTwo().theMax(board));
		}
		case 4: {
			String[] board = { "000000000000000000000000", "011111100111111001111110", "010000000100000001000000",
					"010000000100000001000000", "010000000100000001000000", "011111100111111001111110",
					"000000100000001000000010", "000000100000001000000010", "000000100000001000000010",
					"011111100111111001111110", "000000000000000000000000" };
			int expected__ = 105;

			return verifyCase(casenum, expected__, new XorBoardDivTwo().theMax(board));
		}

		// custom cases

		/*
		 * case 5: {
		 * String[] board = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * XorBoardDivTwo().theMax(board));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] board = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * XorBoardDivTwo().theMax(board));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] board = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * XorBoardDivTwo().theMax(board));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
