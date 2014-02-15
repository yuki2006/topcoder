import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class Chopsticks {
	public int getmax(int[] length) {
		int count = 0;
		Arrays.sort(length);

		for (int pointer = 0; pointer < length.length-1; pointer++) {
			if (length[pointer] == length[pointer + 1]) {
				count++;
				pointer++;
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ChopsticksHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ChopsticksHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ChopsticksHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			int[] length = { 5, 5 };
			int expected__ = 1;

			return verifyCase(casenum, expected__,
					new Chopsticks().getmax(length));
		}
		case 1: {
			int[] length = { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
			int expected__ = 4;

			return verifyCase(casenum, expected__,
					new Chopsticks().getmax(length));
		}
		case 2: {
			int[] length = { 1 };
			int expected__ = 0;

			return verifyCase(casenum, expected__,
					new Chopsticks().getmax(length));
		}
		case 3: {
			int[] length = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int expected__ = 0;

			return verifyCase(casenum, expected__,
					new Chopsticks().getmax(length));
		}
		case 4: {
			int[] length = { 35, 35, 35, 50, 16, 30, 10, 10, 35, 50, 16, 16,
					16, 30, 50, 30, 16, 35, 50, 30, 10, 50, 50, 16, 16, 10, 35,
					50, 50, 50, 16, 35, 35, 30, 35, 10, 50, 10, 50, 50, 16, 30,
					35, 10, 10, 30, 10, 10, 16, 35 };
			int expected__ = 24;

			return verifyCase(casenum, expected__,
					new Chopsticks().getmax(length));
		}

		// custom cases

		/*
		 * case 5: { int[] length = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * Chopsticks().getmax(length)); }
		 */
		/*
		 * case 6: { int[] length = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * Chopsticks().getmax(length)); }
		 */
		/*
		 * case 7: { int[] length = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * Chopsticks().getmax(length)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
