// Paste me into the FileEdit configuration dialog
// SRM 417 DIV 2 - 250.0

public class ReversedSum {
	public static String stringReverseUseSB(String str) {
		String result = new StringBuffer(str).reverse().toString();
		return result;
	}

	public int getReversedSum(int x, int y) {
		String xString = stringReverseUseSB(x + "");
		String yString = stringReverseUseSB(y + "");
		String result = stringReverseUseSB(Integer.valueOf(xString) + Integer.valueOf(yString) + "");
		return Integer.valueOf(result);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ReversedSumHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ReversedSumHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ReversedSumHarness {
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
			int x = 123;
			int y = 100;
			int expected__ = 223;

			return verifyCase(casenum__, expected__, new ReversedSum().getReversedSum(x, y));
		}
		case 1: {
			int x = 111;
			int y = 111;
			int expected__ = 222;

			return verifyCase(casenum__, expected__, new ReversedSum().getReversedSum(x, y));
		}
		case 2: {
			int x = 5;
			int y = 5;
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new ReversedSum().getReversedSum(x, y));
		}
		case 3: {
			int x = 1000;
			int y = 1;
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new ReversedSum().getReversedSum(x, y));
		}
		case 4: {
			int x = 456;
			int y = 789;
			int expected__ = 1461;

			return verifyCase(casenum__, expected__, new ReversedSum().getReversedSum(x, y));
		}

		// custom cases

		/*
		 * case 5: {
		 * int x = ;
		 * int y = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ReversedSum().getReversedSum(x, y));
		 * }
		 */
		/*
		 * case 6: {
		 * int x = ;
		 * int y = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ReversedSum().getReversedSum(x, y));
		 * }
		 */
		/*
		 * case 7: {
		 * int x = ;
		 * int y = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ReversedSum().getReversedSum(x, y));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
