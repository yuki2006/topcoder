import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class ANDEquation {
	public int restoreY(int[] A) {
		Arrays.sort(A);
		int tmp = A[A.length - 1];
		for (int i = A.length - 1; i >= 1; i--) {
			tmp &= A[i];
		}
		if (tmp == A[0]) {
			return A[0];
		}
		return -1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ANDEquationHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ANDEquationHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ANDEquationHarness {
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
			int[] A = { 1, 3, 5 };
			int expected__ = 1;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}
		case 1: {
			int[] A = { 31, 7 };
			int expected__ = -1;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}
		case 2: {
			int[] A = { 31, 7, 7 };
			int expected__ = 7;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}
		case 3: {
			int[] A = { 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0,
					0, 1 };
			int expected__ = 0;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}
		case 4: {
			int[] A = { 191411, 256951, 191411, 191411, 191411, 256951, 195507, 191411, 192435, 191411, 191411, 195511,
					191419, 191411, 256947, 191415, 191475, 195579, 191415, 191411, 191483, 191411, 191419, 191475,
					256947, 191411, 191411, 191411, 191419, 256947, 191411, 191411, 191411 };
			int expected__ = 191411;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}
		case 5: {
			int[] A = { 1362, 1066, 1659, 2010, 1912, 1720, 1851, 1593, 1799, 1805, 1139, 1493, 1141, 1163, 1211 };
			int expected__ = -1;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}
		case 6: {
			int[] A = { 2, 3, 7, 19 };
			int expected__ = -1;

			return verifyCase(casenum, expected__, new ANDEquation().restoreY(A));
		}

		// custom cases

		/*
		 * case 7: {
		 * int[] A = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * ANDEquation().restoreY(A));
		 * }
		 */
		/*
		 * case 8: {
		 * int[] A = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * ANDEquation().restoreY(A));
		 * }
		 */
		/*
		 * case 9: {
		 * int[] A = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * ANDEquation().restoreY(A));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
