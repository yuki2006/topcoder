// Paste me into the FileEdit configuration dialog
// Test SRM - Test SRM300.0

public class TemperatureScales2 {
	public double convert(int f1, int b1, int f2, int b2, int t) {
		return 1.0 * (t - f1) * (f2 - b2) / (f1 - b1) + f2;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TemperatureScales2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TemperatureScales2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TemperatureScales2Harness {
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
			int f1 = 0;
			int b1 = 100;
			int f2 = 0;
			int b2 = 100;
			int t = 28;
			double expected__ = 28.0;

			return verifyCase(casenum__, expected__, new TemperatureScales2().convert(f1, b1, f2, b2, t));
		}
		case 1: {
			int f1 = 0;
			int b1 = 100;
			int f2 = 1;
			int b2 = 101;
			int t = 28;
			double expected__ = 29.0;

			return verifyCase(casenum__, expected__, new TemperatureScales2().convert(f1, b1, f2, b2, t));
		}
		case 2: {
			int f1 = -1000;
			int b1 = -999;
			int f2 = -1000;
			int b2 = 1000;
			int t = 1000;
			double expected__ = 3999000.0;

			return verifyCase(casenum__, expected__, new TemperatureScales2().convert(f1, b1, f2, b2, t));
		}
		case 3: {
			int f1 = -10;
			int b1 = 0;
			int f2 = 1;
			int b2 = 2;
			int t = 17;
			double expected__ = 3.7;

			return verifyCase(casenum__, expected__, new TemperatureScales2().convert(f1, b1, f2, b2, t));
		}
		case 4: {
			int f1 = 17;
			int b1 = 98;
			int f2 = -123;
			int b2 = 12;
			int t = 22;
			double expected__ = -114.66666666666667;

			return verifyCase(casenum__, expected__, new TemperatureScales2().convert(f1, b1, f2, b2, t));
		}

		// custom cases

		/*
		 * case 5: {
		 * int f1 = ;
		 * int b1 = ;
		 * int f2 = ;
		 * int b2 = ;
		 * int t = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TemperatureScales2().convert(f1, b1, f2, b2, t));
		 * }
		 */
		/*
		 * case 6: {
		 * int f1 = ;
		 * int b1 = ;
		 * int f2 = ;
		 * int b2 = ;
		 * int t = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TemperatureScales2().convert(f1, b1, f2, b2, t));
		 * }
		 */
		/*
		 * case 7: {
		 * int f1 = ;
		 * int b1 = ;
		 * int f2 = ;
		 * int b2 = ;
		 * int t = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TemperatureScales2().convert(f1, b1, f2, b2, t));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
