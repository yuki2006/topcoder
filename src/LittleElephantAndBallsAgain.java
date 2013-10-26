// Paste me into the FileEdit configuration dialog
// SRM 595 DIV 2 - 250.0
public class LittleElephantAndBallsAgain {
	public int getNumber(String S) {
		char[] cs = S.toCharArray();
		int max = 0;
		int current = 1;
		for (int i = 1; i < cs.length; i++) {
			if (cs[i - 1] != cs[i]) {
				max = Math.max(max, current);
				current = 1;
			} else {
				current++;
			}
		}
		max = Math.max(max, current);

		return S.length() - max;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LittleElephantAndBallsAgainHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LittleElephantAndBallsAgainHarness.run_test(Integer
						.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndBallsAgainHarness {
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
			String S = "RRGGBB";
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBallsAgain().getNumber(S));
		}
		case 1: {
			String S = "R";
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBallsAgain().getNumber(S));
		}
		case 2: {
			String S = "RGBRGB";
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBallsAgain().getNumber(S));
		}
		case 3: {
			String S = "RGGGBB";
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBallsAgain().getNumber(S));
		}
		case 4: {
			String S = "RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR";
			int expected__ = 46;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBallsAgain().getNumber(S));
		}

		// custom cases

		/*
		 * case 5: { String S = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndBallsAgain().getNumber(S)); }
		 */
		/*
		 * case 6: { String S = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndBallsAgain().getNumber(S)); }
		 */
		/*
		 * case 7: { String S = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndBallsAgain().getNumber(S)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
