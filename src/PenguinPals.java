// Paste me into the FileEdit configuration dialog

public class PenguinPals {
	public int findMaximumMatching(String colors) {
		int length = colors.length();
		int lineMax = 0;
		for (int i = 0; i < length; i++) {
			String mColors = colors.substring(i) + colors.substring(0, i);
			int first = 1, last = length - 1, current = 0;
			int line = 0;
			for (; first + 1 < last; current++) {
				first = current + 1;
				char c = mColors.charAt(current);
				if (c == mColors.charAt(first)) {
					line++;
					current++;
				} else if (c == mColors.charAt(last)) {
					line++;
					last--;
				}
			}
			lineMax = Math.max(line, lineMax);
		}

		return lineMax;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PenguinPalsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PenguinPalsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PenguinPalsHarness {
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
			String colors = "RRBRBRBB";
			int expected__ = 3;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 1: {
			String colors = "RRRR";
			int expected__ = 2;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 2: {
			String colors = "BBBBB";
			int expected__ = 2;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 3: {
			String colors = "RBRBRBRBR";
			int expected__ = 4;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 4: {
			String colors = "RRRBRBRBRBRB";
			int expected__ = 5;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 5: {
			String colors = "R";
			int expected__ = 0;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 6: {
			String colors = "RBRRBBRB";
			int expected__ = 3;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 7: {
			String colors = "RBRBBRBRB";
			int expected__ = 4;

			return verifyCase(casenum, expected__, new PenguinPals().findMaximumMatching(colors));
		}

		// custom cases

		/*
		 * case 8: {
		 * String colors = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * PenguinPals().findMaximumMatching(colors));
		 * }
		 */
		/*
		 * case 9: {
		 * String colors = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * PenguinPals().findMaximumMatching(colors));
		 * }
		 */
		/*
		 * case 10: {
		 * String colors = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * PenguinPals().findMaximumMatching(colors));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
