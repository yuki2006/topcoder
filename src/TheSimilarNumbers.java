// Paste me into the FileEdit configuration dialog

public class TheSimilarNumbers {
	public int find(int lower, int upper) {
		int count = 0;
		for (int i = lower; i <= upper; i++) {
			for (int j = upper; j >i; j--) {
				if (i <= 10 * j && j <= 10 * i) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheSimilarNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheSimilarNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheSimilarNumbersHarness {
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
			int lower = 1;
			int upper = 10;
			int expected__ = 1;

			return verifyCase(casenum, expected__, new TheSimilarNumbers().find(lower, upper));
		}
		case 1: {
			int lower = 5;
			int upper = 511;
			int expected__ = 3;

			return verifyCase(casenum, expected__, new TheSimilarNumbers().find(lower, upper));
		}
		case 2: {
			int lower = 5;
			int upper = 4747;
			int expected__ = 3;

			return verifyCase(casenum, expected__, new TheSimilarNumbers().find(lower, upper));
		}
		case 3: {
			int lower = 1;
			int upper = 1000000;
			int expected__ = 6;

			return verifyCase(casenum, expected__, new TheSimilarNumbers().find(lower, upper));
		}
		case 4: {
			int lower = 10;
			int upper = 10110;
			int expected__ = 3;

			return verifyCase(casenum, expected__, new TheSimilarNumbers().find(lower, upper));
		}

		// custom cases

		/*
		 * case 5: {
		 * int lower = ;
		 * int upper = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TheSimilarNumbers().find(lower, upper));
		 * }
		 */
		/*
		 * case 6: {
		 * int lower = ;
		 * int upper = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TheSimilarNumbers().find(lower, upper));
		 * }
		 */
		/*
		 * case 7: {
		 * int lower = ;
		 * int upper = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TheSimilarNumbers().find(lower, upper));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
