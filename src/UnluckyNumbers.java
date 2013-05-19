import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class UnluckyNumbers {
	public int getCount(int[] luckySet, int n) {
		Arrays.sort(luckySet);
		int first = 0;
		int last = 0;

		if (n < luckySet[0]) {
			first = 0;
			last = luckySet[0];
		} else {
			for (int i = 0; i < luckySet.length - 1; i++) {
				if (luckySet[i] < n && n < luckySet[i + 1]) {
					first = luckySet[i];
					last = luckySet[i + 1];
					break;
				}
			}
			if (last==0){
				return 0;
			}
		}

		return (n - first - 1) + (last - n - 1) + (n - first - 1)
				* (last - n - 1);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			UnluckyNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				UnluckyNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class UnluckyNumbersHarness {
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
			int[] luckySet = { 1, 7, 14, 10 };
			int n = 2;
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new UnluckyNumbers().getCount(luckySet, n));
		}
		case 1: {
			int[] luckySet = { 4, 8, 13, 24, 30 };
			int n = 10;
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new UnluckyNumbers().getCount(luckySet, n));
		}
		case 2: {
			int[] luckySet = { 10, 20, 30, 40, 50 };
			int n = 30;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new UnluckyNumbers().getCount(luckySet, n));
		}
		case 3: {
			int[] luckySet = { 3, 7, 12, 18, 25, 100, 33, 1000 };
			int n = 59;
			int expected__ = 1065;

			return verifyCase(casenum__, expected__,
					new UnluckyNumbers().getCount(luckySet, n));
		}

		// custom cases

		/*
		 * case 4: { int[] luckySet = ; int n = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * UnluckyNumbers().getCount(luckySet, n)); }
		 */
		/*
		 * case 5: { int[] luckySet = ; int n = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * UnluckyNumbers().getCount(luckySet, n)); }
		 */
		/*
		 * case 6: { int[] luckySet = ; int n = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * UnluckyNumbers().getCount(luckySet, n)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
