
// Paste me into the FileEdit configuration dialog

public class CasketOfStarEasy {
	public int func(int[] a) { // Return the answer to the input a[].
		int N = a.length, i, j, ans = 0;
		int pointer = 0;
		for (i = 1; i < N - 1; i++) { // We try all possible i, from 1 to N-1,
										// inclusive.
			int b[] = new int[N - 1]; // if we discard the i-th element, this
										// array will become b[].
			for (j = 0; j < N - 1; j++)
				b[j] = a[j + ((j >= i) ? 1 : 0)]; // This is a tricky for
													// calculating b[].
			int tmp = func(b) + a[i - 1] * a[i + 1]; // a[i-1]*a[i+1] is for the
														// current operation,
														// and func(b) for the
														// next operations.

			ans = Math.max(ans, tmp);
			if (ans == Math.max(ans, tmp)) {
				pointer = i;

			}
		}

		return ans;
	}

	public int maxEnergy(int[] weight) {
		return func(weight);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CasketOfStarEasyHarness.run_test(0);
		} else {
			for (int i = 0; i < args.length; ++i)
				CasketOfStarEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CasketOfStarEasyHarness {
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
			int[] weight = { 1, 1, 1, 2, 3, 2, 1, 1, 1 };
			int expected__ = 12;

			return verifyCase(casenum, expected__, new CasketOfStarEasy().maxEnergy(weight));
		}
		case 1: {
			int[] weight = { 100, 2, 1, 3, 100 };
			int expected__ = 10400;

			return verifyCase(casenum, expected__, new CasketOfStarEasy().maxEnergy(weight));
		}
		case 2: {
			int[] weight = { 2, 2, 7, 6, 90, 5, 9 };
			int expected__ = 1818;

			return verifyCase(casenum, expected__, new CasketOfStarEasy().maxEnergy(weight));
		}
		case 3: {
			int[] weight = { 477, 744, 474, 777, 447, 747, 777, 474 };
			int expected__ = 2937051;

			return verifyCase(casenum, expected__, new CasketOfStarEasy().maxEnergy(weight));
		}
		case 4: {
			int[] weight = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int expected__ = 8;

			return verifyCase(casenum, expected__, new CasketOfStarEasy().maxEnergy(weight));
		}

		// custom cases

		case 5: {
			int[] weight = { 784, 783, 785, 785, 784, 783, 785, 785, 783 };
			int expected__ = 4308867;

			return verifyCase(casenum, expected__, new
					CasketOfStarEasy().maxEnergy(weight));
		}

		/*
		 * case 6: {
		 * int[] weight = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * CasketOfStarEasy().maxEnergy(weight));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] weight = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * CasketOfStarEasy().maxEnergy(weight));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
