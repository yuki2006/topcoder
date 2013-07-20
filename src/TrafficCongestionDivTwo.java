// Paste me into the FileEdit configuration dialog
// Single Round Match 585 - Round 1500.0

public class TrafficCongestionDivTwo {
	long[] memo = new long[61];

	public long theMinCars(int treeHeight) {
		return ((long) Math.pow(2, treeHeight + 1) + 1) / 3;
	}

	public long theMinCars2(int treeHeight) {
		memo[0] = memo[1] = 1;
		return calc(treeHeight);
	}

	long calc(int height) {
		if (memo[height] > 0) {
			return memo[height];
		}

		for (int i = 0; i <= height - 2; i++) {
			for (int j = 0; j < 2; j++) {
				memo[height] += calc(i);
			}
		}
		memo[height]++;
		return memo[height];
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TrafficCongestionDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TrafficCongestionDivTwoHarness.run_test(Integer
						.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TrafficCongestionDivTwoHarness {
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

	static boolean compareOutput(long expected, long result) {
		return expected == result;
	}

	static String formatResult(long res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, long expected, long received) {
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
			int treeHeight = 1;
			long expected__ = 1;

			return verifyCase(casenum__, expected__,
					new TrafficCongestionDivTwo().theMinCars(treeHeight));
		}
		case 1: {
			int treeHeight = 2;
			long expected__ = 3;

			return verifyCase(casenum__, expected__,
					new TrafficCongestionDivTwo().theMinCars(treeHeight));
		}
		case 2: {
			int treeHeight = 3;
			long expected__ = 5;

			return verifyCase(casenum__, expected__,
					new TrafficCongestionDivTwo().theMinCars(treeHeight));
		}
		case 3: {
			int treeHeight = 10;
			long expected__ = 683;

			return verifyCase(casenum__, expected__,
					new TrafficCongestionDivTwo().theMinCars(treeHeight));
		}
		case 4: {
			int treeHeight = 60;
			long expected__ = 768614336404564651L;

			return verifyCase(casenum__, expected__,
					new TrafficCongestionDivTwo().theMinCars(treeHeight));
		}

		// custom cases

		/*
		 * case 5: { int treeHeight = ; long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TrafficCongestionDivTwo().theMinCars(treeHeight)); }
		 */
		/*
		 * case 6: { int treeHeight = ; long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TrafficCongestionDivTwo().theMinCars(treeHeight)); }
		 */
		/*
		 * case 7: { int treeHeight = ; long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TrafficCongestionDivTwo().theMinCars(treeHeight)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
