
// Paste me into the FileEdit configuration dialog
// Single Round Match 585 - Round 1250.0

public class LISNumberDivTwo {
	public int calculate(int[] seq) {

		int old = Integer.MAX_VALUE;
		int result = 0;
		for (int i : seq) {
			if (old >= i) {
				result++;
			}
			old = i;
		}
		return result;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LISNumberDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LISNumberDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LISNumberDivTwoHarness {
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
			int[] seq = { 1, 4, 4, 2, 6, 3 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new LISNumberDivTwo().calculate(seq));
		}
		case 1: {
			int[] seq = { 5, 8, 9, 12, 16, 32, 50 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new LISNumberDivTwo().calculate(seq));
		}
		case 2: {
			int[] seq = { 1, 1, 9, 9, 2, 2, 3, 3 };
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new LISNumberDivTwo().calculate(seq));
		}
		case 3: {
			int[] seq = { 50, 40, 30, 20, 10 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new LISNumberDivTwo().calculate(seq));
		}
		case 4: {
			int[] seq = { 42 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new LISNumberDivTwo().calculate(seq));
		}

		// custom cases

		/*
		 * case 5: { int[] seq = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * LISNumberDivTwo().calculate(seq)); }
		 */
		/*
		 * case 6: { int[] seq = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * LISNumberDivTwo().calculate(seq)); }
		 */
		/*
		 * case 7: { int[] seq = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * LISNumberDivTwo().calculate(seq)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
