// Paste me into the FileEdit configuration dialog
// Single Round Match 575 - Round 1 250.0

public class TheSwapsDivTwo {
	public int find(int[] sequence) {
		int count = 0;
		boolean distinct = false;
		for (int i = 0; i < sequence.length - 1; i++) {
			for (int j = i + 1; j < sequence.length; j++) {
				if (sequence[i] != sequence[j]) {
					count++;
				} else {
					distinct = true;
				}
			}
		}
		return count + (distinct ? 1 : 0);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheSwapsDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheSwapsDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheSwapsDivTwoHarness {
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
			int[] sequence = { 4, 7, 4 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new TheSwapsDivTwo().find(sequence));
		}
		case 1: {
			int[] sequence = { 1, 47 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new TheSwapsDivTwo().find(sequence));
		}
		case 2: {
			int[] sequence = { 9, 9, 9, 9 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new TheSwapsDivTwo().find(sequence));
		}
		case 3: {
			int[] sequence = { 22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39,
					24, 47, 37 };
			int expected__ = 319;

			return verifyCase(casenum__, expected__, new TheSwapsDivTwo().find(sequence));
		}

		// custom cases


		 case 4: {
		 int[] sequence = {5,5,7,7,};
		  int expected__ = 5;

		  return verifyCase(casenum__, expected__, new
		  TheSwapsDivTwo().find(sequence));
		  }
		/*
		 * case 5: {
		 * int[] sequence = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheSwapsDivTwo().find(sequence));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] sequence = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheSwapsDivTwo().find(sequence));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
