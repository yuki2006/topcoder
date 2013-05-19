
// Paste me into the FileEdit configuration dialog

public class ColorfulBricks {
	public int countLayouts(String bricks) {
		int k[] = new int[26];
		int colors = 0;
		for (int i = 0; i < bricks.length(); i++) {
			int j = bricks.charAt(i) - 'A';
			k[j]++;
			if (k[j] == 1) {
				colors++;
			}
		}
		if (colors == 2)
			return 2;
		if (colors == 1)
			return 1;
		return 0;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ColorfulBricksHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ColorfulBricksHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ColorfulBricksHarness {
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
			String bricks = "ABAB";
			int expected__ = 2;

			return verifyCase(casenum, expected__, new ColorfulBricks().countLayouts(bricks));
		}
		case 1: {
			String bricks = "AAA";
			int expected__ = 1;

			return verifyCase(casenum, expected__, new ColorfulBricks().countLayouts(bricks));
		}
		case 2: {
			String bricks = "WXYZ";
			int expected__ = 0;

			return verifyCase(casenum, expected__, new ColorfulBricks().countLayouts(bricks));
		}

		// custom cases

		/*
		 * case 3: {
		 * String bricks = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * ColorfulBricks().countLayouts(bricks));
		 * }
		 */
		/*
		 * case 4: {
		 * String bricks = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * ColorfulBricks().countLayouts(bricks));
		 * }
		 */
		/*
		 * case 5: {
		 * String bricks = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * ColorfulBricks().countLayouts(bricks));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
