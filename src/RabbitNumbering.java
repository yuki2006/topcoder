import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 463 DIV 2 - 500.0
public class RabbitNumbering {
	public int theCount(int[] maxNumber) {
		Arrays.sort(maxNumber);
		long current = 1;
		for (int i = 0; i < maxNumber.length; i++) {
			int x = maxNumber[i] - i;
			current *= x;
			current %= 1000000007;
		}
		return (int) (current);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			RabbitNumberingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				RabbitNumberingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class RabbitNumberingHarness {
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
			int[] maxNumber = { 5 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new RabbitNumbering().theCount(maxNumber));
		}
		case 1: {
			int[] maxNumber = { 4, 4, 4, 4 };
			int expected__ = 24;

			return verifyCase(casenum__, expected__,
					new RabbitNumbering().theCount(maxNumber));
		}
		case 2: {
			int[] maxNumber = { 5, 8 };
			int expected__ = 35;

			return verifyCase(casenum__, expected__,
					new RabbitNumbering().theCount(maxNumber));
		}
		case 3: {
			int[] maxNumber = { 2, 1, 2 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new RabbitNumbering().theCount(maxNumber));
		}
		case 4: {
			int[] maxNumber = { 25, 489, 76, 98, 704, 98, 768, 39, 697, 8, 56,
					74, 36, 95, 87, 2, 968, 4, 920, 54, 873, 90 };
			int expected__ = 676780400;

			return verifyCase(casenum__, expected__,
					new RabbitNumbering().theCount(maxNumber));
		}

		// custom cases

		/*
		 * case 5: { int[] maxNumber = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * RabbitNumbering().theCount(maxNumber)); }
		 */
		/*
		 * case 6: { int[] maxNumber = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * RabbitNumbering().theCount(maxNumber)); }
		 */
		/*
		 * case 7: { int[] maxNumber = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * RabbitNumbering().theCount(maxNumber)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
