
// Paste me into the FileEdit configuration dialog

public class KingdomAndTrees {
	public int minLevel(int[] heights) {
		int diff = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			if (i > 0 && diff > heights[i] - heights[i-1]) {
				diff = heights[i] - heights[i-1];
			}
			if (min > heights[i]) {
				min = heights[i];
			}
			if (max < heights[i]) {
				max = heights[i];
			}
		}
		if (max-min<heights.length){
			return heights.length-1;
		}
		return -diff-1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			KingdomAndTreesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				KingdomAndTreesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class KingdomAndTreesHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			int[] heights = { 9, 5, 11 };
			int expected__ = 3;

			return verifyCase(casenum, expected__, new KingdomAndTrees().minLevel(heights));
		}
		case 1: {
			int[] heights = { 5, 8 };
			int expected__ = 0;

			return verifyCase(casenum, expected__, new KingdomAndTrees().minLevel(heights));
		}
		case 2: {
			int[] heights = { 1, 1, 1, 1, 1 };
			int expected__ = 4;

			return verifyCase(casenum, expected__, new KingdomAndTrees().minLevel(heights));
		}
		case 3: {
			int[] heights = { 548, 47, 58, 250, 2012 };
			int expected__ = 251;

			return verifyCase(casenum, expected__, new KingdomAndTrees().minLevel(heights));
		}

		// custom cases

		/*
		 * case 4: {
		 * int[] heights = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingdomAndTrees().minLevel(heights));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] heights = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingdomAndTrees().minLevel(heights));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] heights = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingdomAndTrees().minLevel(heights));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
