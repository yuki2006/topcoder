// Paste me into the FileEdit configuration dialog

public class SquareDigitNumbers {
	public int getNumber(int n) {
		int square[] = { 0, 1, 4, 9 };
		int result = 0;
		int base = 1;
		while (n > 0) {
			result += square[n % 4] * base;
			n = n / 4;
			base *= 10;
		}
		return result;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SquareDigitNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SquareDigitNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SquareDigitNumbersHarness {
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
			int n = 0;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new SquareDigitNumbers().getNumber(n));
		}
		case 1: {
			int n = 5;
			int expected__ = 11;

			return verifyCase(casenum__, expected__, new SquareDigitNumbers().getNumber(n));
		}
		case 2: {
			int n = 16;
			int expected__ = 100;

			return verifyCase(casenum__, expected__, new SquareDigitNumbers().getNumber(n));
		}
		case 3: {
			int n = 121;
			int expected__ = 1941;

			return verifyCase(casenum__, expected__, new SquareDigitNumbers().getNumber(n));
		}
		case 4: {
			int n = 123;
			int expected__ = 1949;

			return verifyCase(casenum__, expected__, new SquareDigitNumbers().getNumber(n));
		}

		// custom cases

		case 5: {
			int n = 1000;
			int expected__ = 99440;

			return verifyCase(casenum__, expected__, new
					SquareDigitNumbers().getNumber(n));
		}

		/*
		 * case 6: {
		 * int n = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SquareDigitNumbers().getNumber(n));
		 * }
		 */
		/*
		 * case 7: {
		 * int n = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SquareDigitNumbers().getNumber(n));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
