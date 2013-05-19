// Paste me into the FileEdit configuration dialog

public class EllysTSP {
	public int getMax(String places) {
		int C = 0;
		int V = 0;
		for (int i = 0; i < places.length(); i++) {
			if (places.charAt(i) == 'C') {
				C++;
			} else {
				V++;
			}
		}
		if (C == V) {
			return C * 2;
		}
		return Math.min(V, C) * 2 + 1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EllysTSPHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EllysTSPHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EllysTSPHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String places = "CVVCVC";
			int expected__ = 6;

			return verifyCase(casenum, expected__,
					new EllysTSP().getMax(places));
		}
		case 1: {
			String places = "VVV";
			int expected__ = 1;

			return verifyCase(casenum, expected__,
					new EllysTSP().getMax(places));
		}
		case 2: {
			String places = "VVVVCVV";
			int expected__ = 3;

			return verifyCase(casenum, expected__,
					new EllysTSP().getMax(places));
		}
		case 3: {
			String places = "CVCVCVC";
			int expected__ = 7;

			return verifyCase(casenum, expected__,
					new EllysTSP().getMax(places));
		}
		case 4: {
			String places = "V";
			int expected__ = 1;

			return verifyCase(casenum, expected__,
					new EllysTSP().getMax(places));
		}

		// custom cases

		/*
		 * case 5: { String places = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysTSP().getMax(places)); }
		 */
		/*
		 * case 6: { String places = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysTSP().getMax(places)); }
		 */
		/*
		 * case 7: { String places = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * EllysTSP().getMax(places)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
