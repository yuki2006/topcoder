// Paste me into the FileEdit configuration dialog
// Single Round Match 596 - Round 1250.0

public class FoxAndSightseeing {
	public int getMin(int[] position) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < position.length - 1; i++) {
			int sum = 0;
			int old = position[0];
			for (int j = 1; j < position.length; j++) {
				if (i != j) {
					sum += Math.abs(old - position[j]);
					old = position[j];
				}
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndSightseeingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FoxAndSightseeingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndSightseeingHarness {
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
			int[] position = { 1, 4, -1, 3 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new FoxAndSightseeing().getMin(position));
		}
		case 1: {
			int[] position = { -2, 4, 3 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new FoxAndSightseeing().getMin(position));
		}
		case 2: {
			int[] position = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int expected__ = 9;

			return verifyCase(casenum__, expected__, new FoxAndSightseeing().getMin(position));
		}
		case 3: {
			int[] position = { 100, -100, 99, -99 };
			int expected__ = 199;

			return verifyCase(casenum__, expected__, new FoxAndSightseeing().getMin(position));
		}
		case 4: {
			int[] position = { 74, 84, 92, 23, 5, -70, -47, -59, 24, -86, -39, 99, 85, -42, 54, 100, 47, -3, 42, 38 };
			int expected__ = 836;

			return verifyCase(casenum__, expected__, new FoxAndSightseeing().getMin(position));
		}
		case 5: {
			int[] position = { 2, -3, 5, 7, -11, -13, 17, -19, 23, 29, -31, -37, -41, 43, -47, -53, -59, 61, -67, 71 };
			int expected__ = 535;

			return verifyCase(casenum__, expected__, new FoxAndSightseeing().getMin(position));
		}

		// custom cases

		/*
		 * case 6: {
		 * int[] position = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndSightseeing().getMin(position));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] position = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndSightseeing().getMin(position));
		 * }
		 */
		/*
		 * case 8: {
		 * int[] position = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndSightseeing().getMin(position));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
