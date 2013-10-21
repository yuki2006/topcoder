// Paste me into the FileEdit configuration dialog
// SRM 509 DIV 2 - 250.0

public class PalindromizationDiv2 {
	public int getMinimumCost(int X) {
		for (int i = 0;; i++) {
			if (isPalindromic(X + i) || isPalindromic(X - i)) {
				return i;
			}
		}
	}

	private boolean isPalindromic(int n) {
		char[] c = (n + "").toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != c[c.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PalindromizationDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PalindromizationDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PalindromizationDiv2Harness {
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
			int X = 25;
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new PalindromizationDiv2().getMinimumCost(X));
		}
		case 1: {
			int X = 12321;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new PalindromizationDiv2().getMinimumCost(X));
		}
		case 2: {
			int X = 40;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new PalindromizationDiv2().getMinimumCost(X));
		}
		case 3: {
			int X = 2011;
			int expected__ = 9;

			return verifyCase(casenum__, expected__, new PalindromizationDiv2().getMinimumCost(X));
		}
		case 4: {
			int X = 0;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new PalindromizationDiv2().getMinimumCost(X));
		}

		// custom cases

		/*
		 * case 5: {
		 * int X = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PalindromizationDiv2().getMinimumCost(X));
		 * }
		 */
		/*
		 * case 6: {
		 * int X = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PalindromizationDiv2().getMinimumCost(X));
		 * }
		 */
		/*
		 * case 7: {
		 * int X = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PalindromizationDiv2().getMinimumCost(X));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
