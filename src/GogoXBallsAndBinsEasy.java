
// Paste me into the FileEdit configuration dialog

public class GogoXBallsAndBinsEasy {
	public int solve(int[] T) {
		int a = 0;
		for (int i = 0; i < T.length; i++) {
			a += Math.abs(T[i] - T[T.length - i - 1]);
		}
		return a / 2;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			GogoXBallsAndBinsEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				GogoXBallsAndBinsEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class GogoXBallsAndBinsEasyHarness {
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
			int[] T = { 0, 2, 5 };
			int expected__ = 5;

			return verifyCase(casenum, expected__, new GogoXBallsAndBinsEasy().solve(T));
		}
		case 1: {
			int[] T = { 5, 6, 7, 8 };
			int expected__ = 4;

			return verifyCase(casenum, expected__, new GogoXBallsAndBinsEasy().solve(T));
		}
		case 2: {
			int[] T = { 0, 1, 2, 10 };
			int expected__ = 11;

			return verifyCase(casenum, expected__, new GogoXBallsAndBinsEasy().solve(T));
		}
		case 3: {
			int[] T = { 1, 2, 3, 4, 5, 6, 7, 8 };
			int expected__ = 16;

			return verifyCase(casenum, expected__, new GogoXBallsAndBinsEasy().solve(T));
		}

		// custom cases

		/*
		 * case 4: {
		 * int[] T = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * GogoXBallsAndBinsEasy().solve(T));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] T = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * GogoXBallsAndBinsEasy().solve(T));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] T = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * GogoXBallsAndBinsEasy().solve(T));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
