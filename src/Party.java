// Paste me into the FileEdit configuration dialog

public class Party {
	public double averageNames(int n, int[] personA, int[] personB) {
		boolean[][] table = new boolean[n][n];
		for (int i = 0; i < personA.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (table[personA[i]][j]) {
					table[personB[i]][j] = true;
				}
				if (table[personB[i]][j]) {
					table[personA[i]][j] = true;
				}
			}
			table[personA[i]][personB[i]] = true;
			table[personB[i]][personA[i]] = true;
		}
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (i != j && table[i][j]) {
					count++;
				}
			}
		}
		return (double)count / n;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PartyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PartyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PartyHarness {
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

	static final double MAX_DOUBLE_ERROR = 1E-9;

	static boolean compareOutput(double expected, double result) {
		if (Double.isNaN(expected)) {
			return Double.isNaN(result);
		} else if (Double.isInfinite(expected)) {
			if (expected > 0) {
				return result > 0 && Double.isInfinite(result);
			} else {
				return result < 0 && Double.isInfinite(result);
			}
		} else if (Double.isNaN(result) || Double.isInfinite(result)) {
			return false;
		} else if (Math.abs(result - expected) < MAX_DOUBLE_ERROR) {
			return true;
		} else {
			double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected
					* (1.0 + MAX_DOUBLE_ERROR));
			double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected
					* (1.0 + MAX_DOUBLE_ERROR));
			return result > min && result < max;
		}
	}

	static double relativeError(double expected, double result) {
		if (Double.isNaN(expected) || Double.isInfinite(expected)
				|| Double.isNaN(result) || Double.isInfinite(result)
				|| expected == 0)
			return 0;
		return Math.abs(result - expected) / Math.abs(expected);
	}

	static String formatResult(double res) {
		return String.format("%.10g", res);
	}

	static int verifyCase(int casenum, double expected, double received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0)
				System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			int n = 4;
			int[] personA = { 0, 1, 2 };
			int[] personB = { 1, 2, 3 };
			double expected__ = 2.25;

			return verifyCase(casenum__, expected__,
					new Party().averageNames(n, personA, personB));
		}
		case 1: {
			int n = 5;
			int[] personA = { 0, 0, 0, 0, 0, 0, 0 };
			int[] personB = { 1, 2, 3, 4, 3, 2, 1 };
			double expected__ = 4.0;

			return verifyCase(casenum__, expected__,
					new Party().averageNames(n, personA, personB));
		}
		case 2: {
			int n = 100;
			int[] personA = { 52, 19, 52, 19 };
			int[] personB = { 19, 52, 19, 52 };
			double expected__ = 0.02;

			return verifyCase(casenum__, expected__,
					new Party().averageNames(n, personA, personB));
		}
		case 3: {
			int n = 25;
			int[] personA = { 14, 14, 16, 4, 14, 16, 2, 16, 8, 15, 17, 17, 3,
					3, 19, 17, 20, 4, 24, 8 };
			int[] personB = { 16, 2, 23, 16, 11, 8, 5, 19, 15, 20, 19, 18, 14,
					12, 22, 9, 0, 7, 23, 10 };
			double expected__ = 4.44;

			return verifyCase(casenum__, expected__,
					new Party().averageNames(n, personA, personB));
		}

		// custom cases

		/*
		 * case 4: { int n = ; int[] personA = ; int[] personB = ; double
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new Party().averageNames(n,
		 * personA, personB)); }
		 */
		/*
		 * case 5: { int n = ; int[] personA = ; int[] personB = ; double
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new Party().averageNames(n,
		 * personA, personB)); }
		 */
		/*
		 * case 6: { int n = ; int[] personA = ; int[] personB = ; double
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new Party().averageNames(n,
		 * personA, personB)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
