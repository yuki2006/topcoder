// Paste me into the FileEdit configuration dialog

public class NinjaTurtles {
	public int countOpponents(int P, int K) {
		for (int i = 0;; i++) {
			int j = (i / K) * 3 + (i / 3);
			if (j == P) {
				return i;
			} else if (j > P) {
				return -1;
			}
		}
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			NinjaTurtlesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				NinjaTurtlesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class NinjaTurtlesHarness {
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
			int P = 5;
			int K = 4;
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 1: {
			int P = 1;
			int K = 4;
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 2: {
			int P = 13;
			int K = 6;
			int expected__ = -1;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 3: {
			int P = 13;
			int K = 17;
			int expected__ = 30;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 4: {
			int P = 122;
			int K = 21;
			int expected__ = 258;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}

		// custom cases

		/*
		 * case 5: {
		 * int P = ;
		 * int K = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * NinjaTurtles().countOpponents(P, K));
		 * }
		 */
		/*
		 * case 6: {
		 * int P = ;
		 * int K = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * NinjaTurtles().countOpponents(P, K));
		 * }
		 */
		/*
		 * case 7: {
		 * int P = ;
		 * int K = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * NinjaTurtles().countOpponents(P, K));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
