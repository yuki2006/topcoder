// Paste me into the FileEdit configuration dialog
// SRM 379 DIV 2 - 250.0

public class DownloadingFiles {
	public double actualTime(String[] tasks) {
		int totalSpeed = 0;
		int remainSize = 0;
		for (String task : tasks) {
			String[] split = task.split(" ");
			int speed = Integer.valueOf(split[0]);
			int remainTime = Integer.valueOf(split[1]);
			totalSpeed += speed;
			remainSize += speed * remainTime;
		}
		return (double)remainSize/totalSpeed;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DownloadingFilesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DownloadingFilesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DownloadingFilesHarness {
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
			String[] tasks = { "3 57", "2 22" };
			double expected__ = 43.0;

			return verifyCase(casenum__, expected__, new DownloadingFiles().actualTime(tasks));
		}
		case 1: {
			String[] tasks = { "3 1057", "2 1022" };
			double expected__ = 1043.0;

			return verifyCase(casenum__, expected__, new DownloadingFiles().actualTime(tasks));
		}
		case 2: {
			String[] tasks = { "25 1000", "5 5000", "10 5000" };
			double expected__ = 2500.0;

			return verifyCase(casenum__, expected__, new DownloadingFiles().actualTime(tasks));
		}
		case 3: {
			String[] tasks = { "1 10", "1 20", "2 40" };
			double expected__ = 27.5;

			return verifyCase(casenum__, expected__, new DownloadingFiles().actualTime(tasks));
		}
		case 4: {
			String[] tasks = { "6 88", "39 7057", "63 2502", "45 2285", "28 8749", "62 3636", "1 5546", "49 5741" };
			double expected__ = 4414.542662116041;

			return verifyCase(casenum__, expected__, new DownloadingFiles().actualTime(tasks));
		}

		// custom cases

		/*
		 * case 5: {
		 * String[] tasks = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * DownloadingFiles().actualTime(tasks));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] tasks = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * DownloadingFiles().actualTime(tasks));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] tasks = ;
		 * double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * DownloadingFiles().actualTime(tasks));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
