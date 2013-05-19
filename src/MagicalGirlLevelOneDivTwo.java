// Paste me into the FileEdit configuration dialog
// SRM514 DIV2 EASY
import static java.lang.Math.*;

public class MagicalGirlLevelOneDivTwo {
	public double theMinDistance(int d, int x, int y) {
		int[] point = { max(abs(x), d) - d, max(abs(y), d) - d };
		return sqrt(point[0] * point[0] + point[1] * point[1]);

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MagicalGirlLevelOneDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MagicalGirlLevelOneDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MagicalGirlLevelOneDivTwoHarness {
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
			int d = 5;
			int x = 10;
			int y = 10;
			double expected__ = 7.0710678118654755;

			return verifyCase(casenum__, expected__, new MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		}
		case 1: {
			int d = 5;
			int x = 10;
			int y = 3;
			double expected__ = 5.0;

			return verifyCase(casenum__, expected__, new MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		}
		case 2: {
			int d = 5;
			int x = -8;
			int y = -6;
			double expected__ = 3.1622776601683795;

			return verifyCase(casenum__, expected__, new MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		}
		case 3: {
			int d = 5;
			int x = 3;
			int y = 2;
			double expected__ = 0.0;

			return verifyCase(casenum__, expected__, new MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		}
		case 4: {
			int d = 24;
			int x = 24;
			int y = -24;
			double expected__ = 0.0;

			return verifyCase(casenum__, expected__, new MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		}
		case 5: {
			int d = 345;
			int x = -471;
			int y = 333;
			double expected__ = 126.0;

			return verifyCase(casenum__, expected__, new MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		}

		// custom cases

		/*
		 * case 6: {
		 * int d = ;
		 * int x = ;
		 * int y = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		 * }
		 */
		/*
		 * case 7: {
		 * int d = ;
		 * int x = ;
		 * int y = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		 * }
		 */
		/*
		 * case 8: {
		 * int d = ;
		 * int x = ;
		 * int y = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * MagicalGirlLevelOneDivTwo().theMinDistance(d, x, y));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
