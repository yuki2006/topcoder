// Paste me into the FileEdit configuration dialog
// SRM 387 DIV2
public class GuessingNextElement {
	public int guess(int[] A) {
		int sub = A[A.length - 1] - A[A.length - 2];
		if (sub == A[A.length - 2] - A[A.length - 3]) {
			return A[A.length - 1] + sub;
		}
		return A[A.length - 1] * (A[A.length - 1] / A[A.length - 2]);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			GuessingNextElementHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				GuessingNextElementHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class GuessingNextElementHarness {
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
			int[] A = { 364, 843, 1322, 1801 };
			int expected__ = 2280;

			return verifyCase(casenum__, expected__, new GuessingNextElement().guess(A));
		}
		case 1: {
			int[] A = { 394, 1172, 1950, 2728, 3506, 4284, 5062, 5840 };
			int expected__ = 6618;

			return verifyCase(casenum__, expected__, new GuessingNextElement().guess(A));
		}
		case 2: {
			int[] A = { 13, 117, 1053, 9477, 85293 };
			int expected__ = 767637;

			return verifyCase(casenum__, expected__, new GuessingNextElement().guess(A));
		}
		case 3: {
			int[] A = { 22, 220, 2200, 22000 };
			int expected__ = 220000;

			return verifyCase(casenum__, expected__, new GuessingNextElement().guess(A));
		}
		case 4: {
			int[] A = { 250000, 500000, 1000000 };
			int expected__ = 2000000;

			return verifyCase(casenum__, expected__, new GuessingNextElement().guess(A));
		}

		// custom cases

		/*
		 * case 5: {
		 * int[] A = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * GuessingNextElement().guess(A));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] A = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * GuessingNextElement().guess(A));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] A = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * GuessingNextElement().guess(A));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
