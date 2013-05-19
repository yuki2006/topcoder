// Paste me into the FileEdit configuration dialog
// SRM 401 DIV 2 - 250.0
public class DreamingAboutCarrots {
	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public int carrotsBetweenCarrots(int x1, int y1, int x2, int y2) {
		return gcd(Math.abs(x2 - x1), Math.abs(y2 - y1)) - 1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DreamingAboutCarrotsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DreamingAboutCarrotsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DreamingAboutCarrotsHarness {
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
			int x1 = 1;
			int y1 = 1;
			int x2 = 5;
			int y2 = 5;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1,
							x2, y2));
		}
		case 1: {
			int x1 = 0;
			int y1 = 0;
			int x2 = 1;
			int y2 = 1;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1,
							x2, y2));
		}
		case 2: {
			int x1 = 50;
			int y1 = 48;
			int x2 = 0;
			int y2 = 0;
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1,
							x2, y2));
		}
		case 3: {
			int x1 = 0;
			int y1 = 0;
			int x2 = 42;
			int y2 = 36;
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1,
							x2, y2));
		}

		// custom cases

		/*
		 * case 4: { int x1 = ; int y1 = ; int x2 = ; int y2 = ; int expected__
		 * = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1, x2, y2)); }
		 */
		/*
		 * case 5: { int x1 = ; int y1 = ; int x2 = ; int y2 = ; int expected__
		 * = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1, x2, y2)); }
		 */
		/*
		 * case 6: { int x1 = ; int y1 = ; int x2 = ; int y2 = ; int expected__
		 * = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DreamingAboutCarrots().carrotsBetweenCarrots(x1, y1, x2, y2)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
