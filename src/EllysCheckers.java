// Paste me into the FileEdit configuration dialog

public class EllysCheckers {
	public String getWinner(String board) {
		int numMoves = 0;
		for (int curPos = 0; curPos < board.length(); curPos++) {
			if (board.charAt(curPos) == 'o') {
				numMoves += board.length() - curPos - 1;
			}
		}
		return numMoves % 2 == 1 ? "YES" : "NO";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EllysCheckersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EllysCheckersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EllysCheckersHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String board = ".o...";
			String expected__ = "YES";

			return verifyCase(casenum, expected__,
					new EllysCheckers().getWinner(board));
		}
		case 1: {
			String board = "..o..o";
			String expected__ = "YES";

			return verifyCase(casenum, expected__,
					new EllysCheckers().getWinner(board));
		}
		case 2: {
			String board = ".o...ooo..oo..";
			String expected__ = "NO";

			return verifyCase(casenum, expected__,
					new EllysCheckers().getWinner(board));
		}
		case 3: {
			String board = "......o.ooo.o......";
			String expected__ = "YES";

			return verifyCase(casenum, expected__,
					new EllysCheckers().getWinner(board));
		}
		case 4: {
			String board = ".o..o...o....o.....o";
			String expected__ = "NO";

			return verifyCase(casenum, expected__,
					new EllysCheckers().getWinner(board));
		}

		// custom cases

		/*
		 * case 5: { String board = ; String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysCheckers().getWinner(board)); }
		 */
		/*
		 * case 6: { String board = ; String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysCheckers().getWinner(board)); }
		 */
		/*
		 * case 7: { String board = ; String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysCheckers().getWinner(board)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
