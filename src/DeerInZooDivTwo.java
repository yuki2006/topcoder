// Paste me into the FileEdit configuration dialog
// Single Round Match 578 - Round 1250.0

public class DeerInZooDivTwo {
	public int[] getminmax(int N, int K) {
		int min = Math.max(0, N - K);
		int max = Math.max(0, N - ((K+1)/2));
		return new int[]{min,max};
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DeerInZooDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DeerInZooDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DeerInZooDivTwoHarness {
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
			int N = 3;
			int K = 2;
			int[] expected__ = { 1, 2 };

			return verifyCase(casenum__, expected__,
					new DeerInZooDivTwo().getminmax(N, K));
		}
		case 1: {
			int N = 3;
			int K = 3;
			int[] expected__ = { 0, 1 };

			return verifyCase(casenum__, expected__,
					new DeerInZooDivTwo().getminmax(N, K));
		}
		case 2: {
			int N = 10;
			int K = 0;
			int[] expected__ = { 10, 10 };

			return verifyCase(casenum__, expected__,
					new DeerInZooDivTwo().getminmax(N, K));
		}
		case 3: {
			int N = 654;
			int K = 321;
			int[] expected__ = { 333, 493 };

			return verifyCase(casenum__, expected__,
					new DeerInZooDivTwo().getminmax(N, K));
		}
		case 4: {
			int N = 100;
			int K = 193;
			int[] expected__ = { 0, 3 };

			return verifyCase(casenum__, expected__,
					new DeerInZooDivTwo().getminmax(N, K));
		}

		// custom cases

		/*
		 * case 5: { int N = ; int K = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * DeerInZooDivTwo().getminmax(N, K)); }
		 */
		/*
		 * case 6: { int N = ; int K = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * DeerInZooDivTwo().getminmax(N, K)); }
		 */
		/*
		 * case 7: { int N = ; int K = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * DeerInZooDivTwo().getminmax(N, K)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
