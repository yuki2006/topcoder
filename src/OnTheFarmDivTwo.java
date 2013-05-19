// Paste me into the FileEdit configuration dialog
// SRM473 DIV2 EASY
public class OnTheFarmDivTwo {
	public int[] animals(int heads, int legs) {
		int chicken = 0;
		int cow = 0;
		for (; heads > 0; heads--) {
			if (legs / 2 > heads) {
				legs -= 4;
				cow++;
			} else {
				legs -= 2;
				chicken++;
			}
		}
		if (legs == 0) {
			return new int[] { chicken, cow };
		}
		return new int[] {};
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			OnTheFarmDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				OnTheFarmDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class OnTheFarmDivTwoHarness {
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

	static boolean compareOutput(int[] expected, int[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (expected[i] != result[i])
				return false;
		return true;
	}

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, int[] expected, int[] received) {
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
			int heads = 3;
			int legs = 8;
			int[] expected__ = { 2, 1 };

			return verifyCase(casenum__, expected__,
					new OnTheFarmDivTwo().animals(heads, legs));
		}
		case 1: {
			int heads = 10;
			int legs = 40;
			int[] expected__ = { 0, 10 };

			return verifyCase(casenum__, expected__,
					new OnTheFarmDivTwo().animals(heads, legs));
		}
		case 2: {
			int heads = 10;
			int legs = 42;
			int[] expected__ = {};

			return verifyCase(casenum__, expected__,
					new OnTheFarmDivTwo().animals(heads, legs));
		}
		case 3: {
			int heads = 1;
			int legs = 3;
			int[] expected__ = {};

			return verifyCase(casenum__, expected__,
					new OnTheFarmDivTwo().animals(heads, legs));
		}
		case 4: {
			int heads = 0;
			int legs = 0;
			int[] expected__ = { 0, 0 };

			return verifyCase(casenum__, expected__,
					new OnTheFarmDivTwo().animals(heads, legs));
		}

		// custom cases

		/*
		 * case 5: { int heads = ; int legs = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * OnTheFarmDivTwo().animals(heads, legs)); }
		 */
		/*
		 * case 6: { int heads = ; int legs = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * OnTheFarmDivTwo().animals(heads, legs)); }
		 */
		/*
		 * case 7: { int heads = ; int legs = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * OnTheFarmDivTwo().animals(heads, legs)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
