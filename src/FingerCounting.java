// Paste me into the FileEdit configuration dialog
// $METADATA$
public class FingerCounting {
	public int maxNumber(int weakFinger, int maxCount) {
		if (weakFinger == 1) {
			return 8 * maxCount;
		}
		if (weakFinger == 5) {
			return 8 * maxCount + 4;
		}
		if (maxCount % 2 == 0) {
			return 8 * (maxCount / 2) + weakFinger - 1;
		}
		return 8 * (maxCount / 2) + (9 - weakFinger);


//     optimize
//		if (maxCount % 2 == 0) {
//			return 4 * maxCount + weakFinger - 1;
//		}
//		return 4 * maxCount + 5 - weakFinger;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FingerCountingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FingerCountingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FingerCountingHarness {
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
			int weakFinger = 2;
			int maxCount = 3;
			int expected__ = 15;

			return verifyCase(casenum__, expected__, new FingerCounting().maxNumber(weakFinger, maxCount));
		}
		case 1: {
			int weakFinger = 1;
			int maxCount = 0;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new FingerCounting().maxNumber(weakFinger, maxCount));
		}
		case 2: {
			int weakFinger = 5;
			int maxCount = 0;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new FingerCounting().maxNumber(weakFinger, maxCount));
		}
		case 3: {
			int weakFinger = 2;
			int maxCount = 48;
			int expected__ = 193;

			return verifyCase(casenum__, expected__, new FingerCounting().maxNumber(weakFinger, maxCount));
		}
		case 4: {
			int weakFinger = 5;
			int maxCount = 973;
			int expected__ = 7788;

			return verifyCase(casenum__, expected__, new FingerCounting().maxNumber(weakFinger, maxCount));
		}
		case 5: {
			int weakFinger = 3;
			int maxCount = 99999;
			int expected__ = 399998;

			return verifyCase(casenum__, expected__, new FingerCounting().maxNumber(weakFinger, maxCount));
		}

		// custom cases

		/*
		 * case 6: {
		 * int weakFinger = ;
		 * int maxCount = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FingerCounting().maxNumber(weakFinger, maxCount));
		 * }
		 */
		/*
		 * case 7: {
		 * int weakFinger = ;
		 * int maxCount = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FingerCounting().maxNumber(weakFinger, maxCount));
		 * }
		 */
		/*
		 * case 8: {
		 * int weakFinger = ;
		 * int maxCount = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FingerCounting().maxNumber(weakFinger, maxCount));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
