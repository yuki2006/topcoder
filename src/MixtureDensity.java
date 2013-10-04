import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Paste me into the FileEdit configuration dialog
// SRM 375 DIV 2 - 250.0

public class MixtureDensity {
	public double getDensity(String[] ingredients) {
		int sumVolume = 0;
		int sumMass = 0;
		for (String string : ingredients) {
			Pattern p =
					Pattern.compile("(\\d+)\\D+(\\d+)\\D+");
			Matcher matcher = p.matcher(string);
			if (matcher.find()) {
				// <Volume>
				sumVolume += Integer.valueOf(matcher.group(1));
				// <Mass>
				sumMass += Integer.valueOf(matcher.group(2));
			}
		}
		return 1.0 * sumMass / sumVolume;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {

		if (args.length == 0) {
			MixtureDensityHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MixtureDensityHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MixtureDensityHarness {
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
			String[] ingredients = { "200 ml of oil, weighing 180 g" };
			double expected__ = 0.9;

			return verifyCase(casenum__, expected__, new MixtureDensity().getDensity(ingredients));
		}
		case 1: {
			String[] ingredients = { "100 ml of dichloromethane, weighing 130 g", "100 ml of sea water, weighing 103 g" };
			double expected__ = 1.165;

			return verifyCase(casenum__, expected__, new MixtureDensity().getDensity(ingredients));
		}
		case 2: {
			String[] ingredients = { "1000 ml of water, weighing 1000 g",
					"500 ml of orange juice concentrate, weighing 566 g" };
			double expected__ = 1.044;

			return verifyCase(casenum__, expected__, new MixtureDensity().getDensity(ingredients));
		}
		case 3: {
			String[] ingredients = { "1000 ml of something   l i g h t, weighing 1 g" };
			double expected__ = 0.0010;

			return verifyCase(casenum__, expected__, new MixtureDensity().getDensity(ingredients));
		}

		// custom cases

		/*
		 * case 4: {
		 * String[] ingredients = ;
		 * double expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MixtureDensity().getDensity(ingredients));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] ingredients = ;
		 * double expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MixtureDensity().getDensity(ingredients));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] ingredients = ;
		 * double expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MixtureDensity().getDensity(ingredients));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
