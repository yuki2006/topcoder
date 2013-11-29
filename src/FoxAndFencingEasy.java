// Paste me into the FileEdit configuration dialog
// Single Round Match 598 - Round 11000.0

public class FoxAndFencingEasy {
	public String WhoCanWin(int mov1, int mov2, int d) {
		if (mov1>=d) return "Ciel";
		if (mov1>2*mov2) return "Ciel";
		if (mov2>2*mov1) return "Liss";
		return "Draw";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndFencingEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FoxAndFencingEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndFencingEasyHarness {
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

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
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
			int mov1 = 1;
			int mov2 = 58;
			int d = 1;
			String expected__ = "Ciel";

			return verifyCase(casenum__, expected__, new FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		}
		case 1: {
			int mov1 = 100;
			int mov2 = 100;
			int d = 100000000;
			String expected__ = "Draw";

			return verifyCase(casenum__, expected__, new FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		}
		case 2: {
			int mov1 = 100;
			int mov2 = 150;
			int d = 100000000;
			String expected__ = "Draw";

			return verifyCase(casenum__, expected__, new FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		}
		case 3: {
			int mov1 = 100;
			int mov2 = 250;
			int d = 100000000;
			String expected__ = "Liss";

			return verifyCase(casenum__, expected__, new FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		}

		// custom cases

		/*
		 * case 4: {
		 * int mov1 = ;
		 * int mov2 = ;
		 * int d = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		 * }
		 */
		/*
		 * case 5: {
		 * int mov1 = ;
		 * int mov2 = ;
		 * int d = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		 * }
		 */
		/*
		 * case 6: {
		 * int mov1 = ;
		 * int mov2 = ;
		 * int d = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndFencingEasy().WhoCanWin(mov1, mov2, d));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
