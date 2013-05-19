// Paste me into the FileEdit configuration dialog

public class SkiResortsEasy {
	public int minCost(int[] altitude) {
		int sum = 0;
		int old = Integer.MAX_VALUE;
		for (int current : altitude) {
			int diff = Math.max(current - old, 0);
			sum += diff;
			old = current - diff;
		}
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SkiResortsEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SkiResortsEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SkiResortsEasyHarness {
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
			int[] altitude = { 30, 20, 20, 10 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new SkiResortsEasy().minCost(altitude));
		}
		case 1: {
			int[] altitude = { 5, 7, 3 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new SkiResortsEasy().minCost(altitude));
		}
		case 2: {
			int[] altitude = { 6, 8, 5, 4, 7, 4, 2, 3, 1 };
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new SkiResortsEasy().minCost(altitude));
		}
		case 3: {
			int[] altitude = { 749, 560, 921, 166, 757, 818, 228, 584, 366, 88 };
			int expected__ = 2284;

			return verifyCase(casenum__, expected__,
					new SkiResortsEasy().minCost(altitude));
		}
		case 4: {
			int[] altitude = { 712, 745, 230, 200, 648, 440, 115, 913, 627,
					621, 186, 222, 741, 954, 581, 193, 266, 320, 798, 745 };
			int expected__ = 6393;

			return verifyCase(casenum__, expected__,
					new SkiResortsEasy().minCost(altitude));
		}

		// custom cases

		/*
		 * case 5: { int[] altitude = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SkiResortsEasy().minCost(altitude)); }
		 */
		/*
		 * case 6: { int[] altitude = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SkiResortsEasy().minCost(altitude)); }
		 */
		/*
		 * case 7: { int[] altitude = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SkiResortsEasy().minCost(altitude)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
