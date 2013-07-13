import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 402 DIV 2 - 500.0

public class ConsecutiveNumbers {
	public int[] missingNumber(int[] numbers) {
		Arrays.sort(numbers);
		int middleValue = -1;
		for (int i = 0; i < numbers.length - 1; i++) {
			int diff = numbers[i + 1] - numbers[i];
			if (diff == 1) {
				continue;
			} else if (diff != 2 || middleValue > 0) {
				return new int[] {};
			} else if (diff == 2) {
				middleValue = numbers[i] + 1;
			}
		}
		if (middleValue > 0) {
			return new int[] { middleValue };
		}
		if (numbers[0] == 1) {
			return new int[] { numbers[numbers.length - 1] + 1 };
		}
		return new int[] { numbers[0] - 1, numbers[numbers.length - 1] + 1 };

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ConsecutiveNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ConsecutiveNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ConsecutiveNumbersHarness {
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

	static boolean compareOutput(int[] expected, int[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (expected[i] != result[i])
				return false;
		return true;
	}

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, int[] expected, int[] received) {
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
			int[] numbers = { 10, 7, 12, 8, 11 };
			int[] expected__ = { 9 };

			return verifyCase(casenum__, expected__,
					new ConsecutiveNumbers().missingNumber(numbers));
		}
		case 1: {
			int[] numbers = { 3, 6 };
			int[] expected__ = {};

			return verifyCase(casenum__, expected__,
					new ConsecutiveNumbers().missingNumber(numbers));
		}
		case 2: {
			int[] numbers = { 5, 6, 7, 8 };
			int[] expected__ = { 4, 9 };

			return verifyCase(casenum__, expected__,
					new ConsecutiveNumbers().missingNumber(numbers));
		}
		case 3: {
			int[] numbers = { 1000000000 };
			int[] expected__ = { 999999999, 1000000001 };

			return verifyCase(casenum__, expected__,
					new ConsecutiveNumbers().missingNumber(numbers));
		}
		case 4: {
			int[] numbers = { 1, 6, 9, 3, 8, 12, 7, 4, 11, 5, 10 };
			int[] expected__ = { 2 };

			return verifyCase(casenum__, expected__,
					new ConsecutiveNumbers().missingNumber(numbers));
		}
		case 5: {
			int[] numbers = { 1 };
			int[] expected__ = { 2 };

			return verifyCase(casenum__, expected__,
					new ConsecutiveNumbers().missingNumber(numbers));
		}

		// custom cases

		/*
		 * case 6: { int[] numbers = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ConsecutiveNumbers().missingNumber(numbers)); }
		 */
		/*
		 * case 7: { int[] numbers = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ConsecutiveNumbers().missingNumber(numbers)); }
		 */
		/*
		 * case 8: { int[] numbers = ; int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ConsecutiveNumbers().missingNumber(numbers)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
