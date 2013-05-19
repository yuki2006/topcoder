// Paste me into the FileEdit configuration dialog
// SRM 282 DIV2 EASY
public class FixTheAverage {
	public double add(double[] list, double target) {
		target *= list.length + 1;
		for (double d : list) {
			target-=d;
		}
		return target;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FixTheAverageHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FixTheAverageHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FixTheAverageHarness {
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
			double[] list = { 3.0, 7.0, 2.5 };
			double target = 4.5;
			double expected__ = 5.5;

			return verifyCase(casenum__, expected__, new FixTheAverage().add(list, target));
		}
		case 1: {
			double[] list = { 72, 72, 72, 72 };
			double target = 72;
			double expected__ = 72.0;

			return verifyCase(casenum__, expected__, new FixTheAverage().add(list, target));
		}
		case 2: {
			double[] list = { 0, 0 };
			double target = 100;
			double expected__ = 300.0;

			return verifyCase(casenum__, expected__, new FixTheAverage().add(list, target));
		}
		case 3: {
			double[] list = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
			double target = 0;
			double expected__ = -1000.0;

			return verifyCase(casenum__, expected__, new FixTheAverage().add(list, target));
		}
		case 4: {
			double[] list = { 0.01 };
			double target = 0.02;
			double expected__ = 0.03;

			return verifyCase(casenum__, expected__, new FixTheAverage().add(list, target));
		}

		// custom cases

		/*
		 * case 5: {
		 * double[] list = ;
		 * double target = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FixTheAverage().add(list, target));
		 * }
		 */
		/*
		 * case 6: {
		 * double[] list = ;
		 * double target = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FixTheAverage().add(list, target));
		 * }
		 */
		/*
		 * case 7: {
		 * double[] list = ;
		 * double target = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FixTheAverage().add(list, target));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
