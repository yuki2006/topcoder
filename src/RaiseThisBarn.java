// Paste me into the FileEdit configuration dialog
// Single Round Match 593 - Round 1250.0
public class RaiseThisBarn {
	public int calc(String str) {
		int total = 0;
		for (char c : str.toCharArray()) {
			if (c == 'c') {
				total++;
			}
		}
		int result = 0;
		int cCount = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'c') {
				cCount++;
			}
			if (total == cCount * 2) {
				result++;
			}
		}
		return result;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			RaiseThisBarnHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				RaiseThisBarnHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class RaiseThisBarnHarness {
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
			String str = "cc..c.c";
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		case 1: {
			String str = "c....c....c";
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		case 2: {
			String str = "............";
			int expected__ = 11;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		case 3: {
			String str = ".c.c...c..ccc.c..c.c.cc..ccc";
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		case 4: {
			String str = "cccc";
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		case 5: {
			String str = "c..c";
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		case 6: {
			String str = "..cc.";
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new RaiseThisBarn().calc(str));
		}
		// custom cases

		/*
		 * case 4: { String str = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * RaiseThisBarn().calc(str)); }
		 */
		/*
		 * case 5: { String str = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * RaiseThisBarn().calc(str)); }
		 */
		/*
		 * case 6: { String str = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * RaiseThisBarn().calc(str)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
