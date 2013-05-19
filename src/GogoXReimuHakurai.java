// Paste me into the FileEdit configuration dialog

public class GogoXReimuHakurai {

	public int solve(String[] choices) {
		return a(choices, 0);
	}

	private int a(String[] choices, int i) {
		int count = 0;
		int max = 0;
		if (choices.length - 1 == i) {
			return 1;
		}
		for (int j = 0; j < choices[i].length(); j++) {

			if (choices[i].charAt(j) == 'Y') {
				count += a(choices, j);
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			GogoXReimuHakuraiHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				GogoXReimuHakuraiHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class GogoXReimuHakuraiHarness {
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
			String[] choices = { "NYY", "NNY", "NNN" };
			int expected__ = 2;

			return verifyCase(casenum, expected__, new GogoXReimuHakurai().solve(choices));
		}
		case 1: {
			String[] choices = { "NYNY", "NNYY", "NNNY", "NNNN" };
			int expected__ = 3;

			return verifyCase(casenum, expected__, new GogoXReimuHakurai().solve(choices));
		}
		case 2: {
			String[] choices = { "NNY", "NNY", "NNN" };
			int expected__ = 1;

			return verifyCase(casenum, expected__, new GogoXReimuHakurai().solve(choices));
		}
		case 3: {
			String[] choices = { "NN", "NN" };
			int expected__ = 0;

			return verifyCase(casenum, expected__, new GogoXReimuHakurai().solve(choices));
		}

		// custom cases

		/*
		 * case 4: {
		 * String[] choices = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * GogoXReimuHakurai().solve(choices));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] choices = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * GogoXReimuHakurai().solve(choices));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] choices = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * GogoXReimuHakurai().solve(choices));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
