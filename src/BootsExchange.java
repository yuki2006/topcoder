// Paste me into the FileEdit configuration dialog
// SRM 307 DIV 2 - 250.0

public class BootsExchange {
	public int leastAmount(int[] left, int[] right) {
		int hit = 0;
		for (int i = 0; i < left.length; i++) {
			for (int j = 0; j < right.length; j++) {
				if (left[i] == right[j]) {
					right[j] = 0;
					hit++;
					break;
				}
			}
		}
		return left.length - hit;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BootsExchangeHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BootsExchangeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BootsExchangeHarness {
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
			int[] left = { 1, 3, 1 };
			int[] right = { 2, 1, 3 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new BootsExchange().leastAmount(left, right));
		}
		case 1: {
			int[] left = { 1, 3 };
			int[] right = { 2, 2 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new BootsExchange().leastAmount(left, right));
		}
		case 2: {
			int[] left = { 1, 2, 3, 4, 5, 6, 7 };
			int[] right = { 2, 4, 6, 1, 3, 7, 5 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new BootsExchange().leastAmount(left, right));
		}

		// custom cases

		case 3: {
			int[] left = { 3, 1, 4, 7, 3, 1, 4, 5, 1 };
			int[] right = { 2, 5, 2, 3, 4, 1, 4, 6, 8 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new
					BootsExchange().leastAmount(left, right));
		}
		/*
		 * case 4: {
		 * int[] left = ;
		 * int[] right = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BootsExchange().leastAmount(left, right));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] left = ;
		 * int[] right = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BootsExchange().leastAmount(left, right));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
