// Paste me into the FileEdit configuration dialog

public class TheExperimentDiv2 {
	public int[] determineHumidity(int[] intensity, int L, int[] leftEnd) {
		int[] result = new int[leftEnd.length];
		for (int i = 0; i < leftEnd.length; i++) {
			for (int j = 0; j < L; j++) {
				result[i] += intensity[j + leftEnd[i]];
				intensity[j+leftEnd[i]] = 0;
			}
		}
		return result;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheExperimentDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheExperimentDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheExperimentDiv2Harness {
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
			int[] intensity = { 3, 4, 1, 1, 5, 6 };
			int L = 3;
			int[] leftEnd = { 3, 1, 0 };
			int[] expected__ = { 12, 5, 3 };

			return verifyCase(casenum__, expected__,
					new TheExperimentDiv2().determineHumidity(intensity, L,
							leftEnd));
		}
		case 1: {
			int[] intensity = { 5, 5 };
			int L = 2;
			int[] leftEnd = { 0, 0 };
			int[] expected__ = { 10, 0 };

			return verifyCase(casenum__, expected__,
					new TheExperimentDiv2().determineHumidity(intensity, L,
							leftEnd));
		}
		case 2: {
			int[] intensity = { 92, 11, 1000, 14, 3 };
			int L = 2;
			int[] leftEnd = { 0, 3 };
			int[] expected__ = { 103, 17 };

			return verifyCase(casenum__, expected__,
					new TheExperimentDiv2().determineHumidity(intensity, L,
							leftEnd));
		}
		case 3: {
			int[] intensity = { 2, 6, 15, 10, 8, 11, 99, 2, 4, 4, 4, 13 };
			int L = 4;
			int[] leftEnd = { 1, 7, 4, 5, 8, 0 };
			int[] expected__ = { 39, 14, 110, 0, 13, 2 };

			return verifyCase(casenum__, expected__,
					new TheExperimentDiv2().determineHumidity(intensity, L,
							leftEnd));
		}

		// custom cases

		/*
		 * case 4: { int[] intensity = ; int L = ; int[] leftEnd = ; int[]
		 * expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheExperimentDiv2().determineHumidity(intensity, L, leftEnd)); }
		 */
		/*
		 * case 5: { int[] intensity = ; int L = ; int[] leftEnd = ; int[]
		 * expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheExperimentDiv2().determineHumidity(intensity, L, leftEnd)); }
		 */
		/*
		 * case 6: { int[] intensity = ; int L = ; int[] leftEnd = ; int[]
		 * expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheExperimentDiv2().determineHumidity(intensity, L, leftEnd)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
