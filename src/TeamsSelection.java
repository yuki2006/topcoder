// Paste me into the FileEdit configuration dialog
// Single Round Match 586 - Round 1250.0

public class TeamsSelection {
	public String simulate(int[] preference1, int[] preference2) {
		char[] result = new char[preference1.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = i; j < result.length; j++) {
				if (result[preference1[j] - 1] == 0) {
					result[preference1[j] - 1] = '1';
					break;
				}
			}
			for (int j = i; j < result.length; j++) {
				if (result[preference2[j] - 1] == 0) {
					result[preference2[j] - 1] = '2';
					break;

				}
			}
		}
		return new String(result);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TeamsSelectionHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TeamsSelectionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TeamsSelectionHarness {
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
			int[] preference1 = { 1, 2, 3, 4 };
			int[] preference2 = { 1, 2, 3, 4 };
			String expected__ = "1212";

			return verifyCase(casenum__, expected__, new TeamsSelection().simulate(preference1, preference2));
		}
		case 1: {
			int[] preference1 = { 3, 2, 1 };
			int[] preference2 = { 1, 3, 2 };
			String expected__ = "211";

			return verifyCase(casenum__, expected__, new TeamsSelection().simulate(preference1, preference2));
		}
		case 2: {
			int[] preference1 = { 6, 1, 5, 2, 3, 4 };
			int[] preference2 = { 1, 6, 3, 4, 5, 2 };
			String expected__ = "212211";

			return verifyCase(casenum__, expected__, new TeamsSelection().simulate(preference1, preference2));
		}
		case 3: {
			int[] preference1 = { 8, 7, 1, 2, 4, 5, 6, 3, 9 };
			int[] preference2 = { 7, 2, 4, 8, 1, 5, 9, 6, 3 };
			String expected__ = "121121212";

			return verifyCase(casenum__, expected__, new TeamsSelection().simulate(preference1, preference2));
		}

		// custom cases

		/*
		 * case 4: {
		 * int[] preference1 = ;
		 * int[] preference2 = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TeamsSelection().simulate(preference1, preference2));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] preference1 = ;
		 * int[] preference2 = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TeamsSelection().simulate(preference1, preference2));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] preference1 = ;
		 * int[] preference2 = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TeamsSelection().simulate(preference1, preference2));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
