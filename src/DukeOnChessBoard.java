import java.util.ArrayList;

// Paste me into the FileEdit configuration dialog
// SRM 375 DIV 2 - 550.0

public class DukeOnChessBoard {
	private boolean cRange(int i, int length) {
		if (0 <= i && i < length) {
			return true;
		}
		return false;
	}

	public String dukePath(int n, String initPosition) {
		boolean[][] checked = new boolean[n][n];
		int column = initPosition.charAt(0) - 'a';
		int row = initPosition.charAt(1) - '1';
		checked[column][row] = true;
		// 右、上、下、左
		int[] vx = { 1, 0, 0, -1 };
		int[] vy = { 0, 1, -1, 0 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(column * 10 + row);
		while (true) {
			boolean hit = false;
			for (int i = 0; i < vy.length; i++) {
				// とりあえず右を目指す
				int c = column + vx[i];
				int r = row + vy[i];
				if (cRange(c, checked.length) && cRange(r, checked[0].length)) {
					if (!checked[c][r]) {
						// 既に、行ってなければ
						checked[c][r] = true;
						// 場所の更新
						column = c;
						row = r;
						list.add(column * 10 + row);
						hit = true;
						break;
					}
				}
			}
			// 全て行き尽くした
			if (!hit) {
				break;
			}
		}
		String str = "";
		for (Integer i : list) {
			if (str.length() > 0) {
				str += "-";
			}
			str += getStr(i);
		}
		if (str.length() > 40) {
			return str.substring(0, 20) + "..." +
					str.substring(str.length() - 20, str.length());
		} else {
			return str;
		}
	}

	private String getStr(Integer i) {
		return "" + (char) ((i / 10) + 'a') +
				(char) ((i % 10) + '1');
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DukeOnChessBoardHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DukeOnChessBoardHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DukeOnChessBoardHarness {
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

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
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

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			int n = 3;
			String initPosition = "b2";
			String expected__ = "b2-c2-c3-b3-a3-a2-a1-b1-c1";

			return verifyCase(casenum__, expected__, new DukeOnChessBoard().dukePath(n, initPosition));
		}
		case 1: {
			int n = 4;
			String initPosition = "d4";
			String expected__ = "d4-d3-d2-d1-c1-c2-c3...b3-b2-b1-a1-a2-a3-a4";

			return verifyCase(casenum__, expected__, new DukeOnChessBoard().dukePath(n, initPosition));
		}
		case 2: {
			int n = 3;
			String initPosition = "a2";
			String expected__ = "a2-b2-c2-c3-b3-a3";

			return verifyCase(casenum__, expected__, new DukeOnChessBoard().dukePath(n, initPosition));
		}
		case 3: {
			int n = 4;
			String initPosition = "d3";
			String expected__ = "d3-d4-c4-c3-c2-d2-d1...b2-b3-b4-a4-a3-a2-a1";

			return verifyCase(casenum__, expected__, new DukeOnChessBoard().dukePath(n, initPosition));
		}
		case 4: {
			int n = 8;
			String initPosition = "a8";
			String expected__ = "a8-b8-c8-d8-e8-f8-g8...a1-a2-a3-a4-a5-a6-a7";

			return verifyCase(casenum__, expected__, new DukeOnChessBoard().dukePath(n, initPosition));
		}

		// custom cases

		/*
		 * case 5: {
		 * int n = ;
		 * String initPosition = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DukeOnChessBoard().dukePath(n, initPosition));
		 * }
		 */
		/*
		 * case 6: {
		 * int n = ;
		 * String initPosition = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DukeOnChessBoard().dukePath(n, initPosition));
		 * }
		 */
		/*
		 * case 7: {
		 * int n = ;
		 * String initPosition = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DukeOnChessBoard().dukePath(n, initPosition));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
