// Paste me into the FileEdit configuration dialog
// SRM 565 DIV 2 - 500.0
public class MonstersValley2 {
	public int minimumPrice(int[] dread, int[] price) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < 1 << dread.length; i++) {
			long dtotal = 0;
			int p = 0;
			boolean hit = true;
			for (int j = 0; j < dread.length; j++) {
				if (((1 << j) & i) > 0) {
					dtotal += dread[j];
					p += price[j];
				}
				if (dtotal < dread[j]) {
					hit = false;
					break;
				}
			}
			if (hit) {
				min=Math.min(min, p);
			}
		}
		return min;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MonstersValley2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MonstersValley2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MonstersValley2Harness {
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
			int[] dread = { 8, 5, 10 };
			int[] price = { 1, 1, 2 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new MonstersValley2().minimumPrice(dread, price));
		}
		case 1: {
			int[] dread = { 1, 2, 4, 1000000000 };
			int[] price = { 1, 1, 1, 2 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new MonstersValley2().minimumPrice(dread, price));
		}
		case 2: {
			int[] dread = { 200, 107, 105, 206, 307, 400 };
			int[] price = { 1, 2, 1, 1, 1, 2 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new MonstersValley2().minimumPrice(dread, price));
		}
		case 3: {
			int[] dread = { 5216, 12512, 613, 1256, 66, 17202, 30000, 23512,
					2125, 33333 };
			int[] price = { 2, 2, 1, 1, 1, 1, 2, 1, 2, 1 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new MonstersValley2().minimumPrice(dread, price));
		}

		// custom cases

		/*
		 * case 4: { int[] dread = ; int[] price = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MonstersValley2().minimumPrice(dread, price)); }
		 */
		/*
		 * case 5: { int[] dread = ; int[] price = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MonstersValley2().minimumPrice(dread, price)); }
		 */
		/*
		 * case 6: { int[] dread = ; int[] price = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MonstersValley2().minimumPrice(dread, price)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
