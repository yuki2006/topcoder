//SRM150 DIV2 250
public class WidgetRepairs {
	public int days(int[] arrivals, int numPerDay) {
		int how = 0;
		for (int i = 0; i < arrivals.length - 1; i++) {
			if (arrivals[i] / numPerDay == 0 && arrivals[i] % numPerDay > 0) {
				how++;
			} else {
				how += arrivals[i] / numPerDay;
				arrivals[i + 1] += arrivals[i] % numPerDay;
			}
		}
		if (arrivals[arrivals.length - 1] % numPerDay > 0) {
			how += arrivals[arrivals.length - 1] / numPerDay + 1;
		} else {
			how += arrivals[arrivals.length - 1] / numPerDay;
		}
		return how;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			WidgetRepairsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				WidgetRepairsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class WidgetRepairsHarness {
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

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			int[] arrivals = { 10, 0, 0, 4, 20 };
			int numPerDay = 8;
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new WidgetRepairs().days(arrivals, numPerDay));
		}
		case 1: {
			int[] arrivals = { 0, 0, 0 };
			int numPerDay = 10;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new WidgetRepairs().days(arrivals, numPerDay));
		}
		case 2: {
			int[] arrivals = { 100, 100 };
			int numPerDay = 10;
			int expected__ = 20;

			return verifyCase(casenum__, expected__,
					new WidgetRepairs().days(arrivals, numPerDay));
		}
		case 3: {
			int[] arrivals = { 27, 0, 0, 0, 0, 9 };
			int numPerDay = 9;
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new WidgetRepairs().days(arrivals, numPerDay));
		}
		case 4: {
			int[] arrivals = { 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 };
			int numPerDay = 3;
			int expected__ = 15;

			return verifyCase(casenum__, expected__,
					new WidgetRepairs().days(arrivals, numPerDay));
		}

		// custom cases

		case 5: {
			int[] arrivals = new int[] { 11, 0, 1, 2 };
			int numPerDay = 4;
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new WidgetRepairs().days(arrivals, numPerDay));
		}
		/*
		 * case 6: { int[] arrivals = ; int numPerDay = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * WidgetRepairs().days(arrivals, numPerDay)); }
		 */
		/*
		 * case 7: { int[] arrivals = ; int numPerDay = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * WidgetRepairs().days(arrivals, numPerDay)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
