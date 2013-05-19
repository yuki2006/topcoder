// Paste me into the FileEdit configuration dialog
// SRM 463 DIV 2 - 250.0
public class BunnyPuzzle {
	public int theCount(int[] bunnies) {
		int count = 0;
		for (int i = 1; i < bunnies.length - 1; i++) {
			if (2 * bunnies[i] - bunnies[i - 1] < bunnies[i + 1]) {
				count++;
			}
			if (2 * bunnies[i] - bunnies[i+1] > bunnies[i - 1]) {
				count++;
			}
		}
		return count+2;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BunnyPuzzleHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BunnyPuzzleHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BunnyPuzzleHarness {
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
			int[] bunnies = { 5, 8 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new BunnyPuzzle().theCount(bunnies));
		}
		case 1: {
			int[] bunnies = { -1, 0, 1 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new BunnyPuzzle().theCount(bunnies));
		}
		case 2: {
			int[] bunnies = { 0, 1, 3 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new BunnyPuzzle().theCount(bunnies));
		}
		case 3: {
			int[] bunnies = { -677, -45, -2, 3, 8, 29, 384, 867 };
			int expected__ = 7;

			return verifyCase(casenum__, expected__,
					new BunnyPuzzle().theCount(bunnies));
		}
		case 4: {
			int[] bunnies = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new BunnyPuzzle().theCount(bunnies));
		}

		// custom cases

		/*
		 * case 5: { int[] bunnies = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BunnyPuzzle().theCount(bunnies)); }
		 */
		/*
		 * case 6: { int[] bunnies = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BunnyPuzzle().theCount(bunnies)); }
		 */
		/*
		 * case 7: { int[] bunnies = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BunnyPuzzle().theCount(bunnies)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
