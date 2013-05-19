
// Paste me into the FileEdit configuration dialog

public class BinaryPolynomialDivTwo {
	public int countRoots(int[] a) {

		int count = 0;
		for (int x = 0; x < 2; x++) {
			int total = a[0];

			for (int i = 1; i < a.length; i++) {
				if (x == 1 && a[i] == 1) {
					total++;
				}

			}
			if (total % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BinaryPolynomialDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BinaryPolynomialDivTwoHarness
						.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BinaryPolynomialDivTwoHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
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
			int[] a = { 1, 0, 1 };
			int expected__ = 1;

			return verifyCase(casenum, expected__,
					new BinaryPolynomialDivTwo().countRoots(a));
		}
		case 1: {
			int[] a = { 0, 1, 0, 1 };
			int expected__ = 2;

			return verifyCase(casenum, expected__,
					new BinaryPolynomialDivTwo().countRoots(a));
		}
		case 2: {
			int[] a = { 1 };
			int expected__ = 0;

			return verifyCase(casenum, expected__,
					new BinaryPolynomialDivTwo().countRoots(a));
		}
		case 3: {
			int[] a = { 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1 };
			int expected__ = 0;

			return verifyCase(casenum, expected__,
					new BinaryPolynomialDivTwo().countRoots(a));
		}
		case 4: {
			int[] a = { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0,
					0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0,
					1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 };
			int expected__ = 1;

			return verifyCase(casenum, expected__,
					new BinaryPolynomialDivTwo().countRoots(a));
		}

		// custom cases

		/*
		 * case 5: { int[] a = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * BinaryPolynomialDivTwo().countRoots(a)); }
		 */
		/*
		 * case 6: { int[] a = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * BinaryPolynomialDivTwo().countRoots(a)); }
		 */
		/*
		 * case 7: { int[] a = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * BinaryPolynomialDivTwo().countRoots(a)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
