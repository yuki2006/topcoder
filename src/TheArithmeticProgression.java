// Paste me into the FileEdit configuration dialog
// Single Round Match 591 - Round 1250.0

public class TheArithmeticProgression {
	public double minimumChange(int a, int b, int c) {
		return Math.abs(b - (double) (c + a) / 2);

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheArithmeticProgressionHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheArithmeticProgressionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheArithmeticProgressionHarness {
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
			double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
			double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
			return result > min && result < max;
		}
	}

	static double relativeError(double expected, double result) {
		if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result)
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
			int a = 0;
			int b = 1;
			int c = 2;
			double expected__ = 0.0;

			return verifyCase(casenum__, expected__, new TheArithmeticProgression().minimumChange(a, b, c));
		}
		case 1: {
			int a = 0;
			int b = 2;
			int c = 1;
			double expected__ = 1.5;

			return verifyCase(casenum__, expected__, new TheArithmeticProgression().minimumChange(a, b, c));
		}
		case 2: {
			int a = 3;
			int b = 2;
			int c = 1;
			double expected__ = 0.0;

			return verifyCase(casenum__, expected__, new TheArithmeticProgression().minimumChange(a, b, c));
		}
		case 3: {
			int a = 4;
			int b = 4;
			int c = 8;
			double expected__ = 2.0;

			return verifyCase(casenum__, expected__, new TheArithmeticProgression().minimumChange(a, b, c));
		}

		// custom cases

		/*
		 * case 4: {
		 * int a = ;
		 * int b = ;
		 * int c = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheArithmeticProgression().minimumChange(a, b, c));
		 * }
		 */
		/*
		 * case 5: {
		 * int a = ;
		 * int b = ;
		 * int c = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheArithmeticProgression().minimumChange(a, b, c));
		 * }
		 */
		/*
		 * case 6: {
		 * int a = ;
		 * int b = ;
		 * int c = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheArithmeticProgression().minimumChange(a, b, c));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
