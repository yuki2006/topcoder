// Paste me into the FileEdit configuration dialog

public class EasyHomework {
	public String determineSign(int[] A) {
		boolean flag = true;
		for (int i : A) {
			if (i == 0) {
				return "ZERO";
			} else if (i < 0) {
				flag = !flag;
			}
		}
		return flag ? "POSITIVE" : "NEGATIVE";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EasyHomeworkHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EasyHomeworkHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EasyHomeworkHarness {
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

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
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
			int[] A = { 5, 7, 2 };
			String expected__ = "POSITIVE";

			return verifyCase(casenum__, expected__,
					new EasyHomework().determineSign(A));
		}
		case 1: {
			int[] A = { -5, 7, 2 };
			String expected__ = "NEGATIVE";

			return verifyCase(casenum__, expected__,
					new EasyHomework().determineSign(A));
		}
		case 2: {
			int[] A = { 5, 7, 2, 0 };
			String expected__ = "ZERO";

			return verifyCase(casenum__, expected__,
					new EasyHomework().determineSign(A));
		}
		case 3: {
			int[] A = { 3, -14, 159, -26 };
			String expected__ = "POSITIVE";

			return verifyCase(casenum__, expected__,
					new EasyHomework().determineSign(A));
		}
		case 4: {
			int[] A = { -1000000000 };
			String expected__ = "NEGATIVE";

			return verifyCase(casenum__, expected__,
					new EasyHomework().determineSign(A));
		}
		case 5: {
			int[] A = { 123, -456, 789, -101112, 131415, 161718, 192021,
					222324, 252627, 282930, 313233, 343536, 373839, 404142,
					434445, 464748, 495051, 525354, 555657 };
			String expected__ = "POSITIVE";

			return verifyCase(casenum__, expected__,
					new EasyHomework().determineSign(A));
		}

		// custom cases

		/*
		 * case 6: { int[] A = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EasyHomework().determineSign(A)); }
		 */
		/*
		 * case 7: { int[] A = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EasyHomework().determineSign(A)); }
		 */
		/*
		 * case 8: { int[] A = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EasyHomework().determineSign(A)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
