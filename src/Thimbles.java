// Paste me into the FileEdit configuration dialog
// SRM 354 DIV 2 - 250.0

public class Thimbles {
	public int thimbleWithBall(String[] swaps) {
		int current = 1;
		for (String swap : swaps) {
			String[] split = swap.split("-");
			for (int i = 0; i < split.length; i++) {
				if (Integer.valueOf(split[i]) == current) {
					current = Integer.valueOf(split[(i + 1) % 2]);
					break;
				}
			}

		}
		return current;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ThimblesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ThimblesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ThimblesHarness {
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

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			String[] swaps = { "1-2", "3-1" };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new Thimbles().thimbleWithBall(swaps));
		}
		case 1: {
			String[] swaps = { "3-1", "2-3", "3-1", "3-2" };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new Thimbles().thimbleWithBall(swaps));
		}
		case 2: {
			String[] swaps = { "2-3", "1-3", "2-3", "2-1", "3-1" };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new Thimbles().thimbleWithBall(swaps));
		}
		case 3: {
			String[] swaps = { "1-2", "3-2", "1-2", "2-1", "2-1", "3-2", "1-3", "3-1", "1-2" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new Thimbles().thimbleWithBall(swaps));
		}

		// custom cases

		/*
		 * case 4: {
		 * String[] swaps = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Thimbles().thimbleWithBall(swaps));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] swaps = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Thimbles().thimbleWithBall(swaps));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] swaps = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Thimbles().thimbleWithBall(swaps));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
