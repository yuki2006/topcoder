// Paste me into the FileEdit configuration dialog
// Single Round Match 586 - Round 1500.0

public class PiecewiseLinearFunctionDiv2 {
	public int[] countSolutions(int[] Y, int[] query) {
		int[] result = new int[query.length];
		for (int qi = 0; qi < query.length; qi++) {
			int q = query[qi];
			for (int i = 0; i < Y.length; i++) {
				if (i > 0) {
					if (Y[i] == q) {
						if (Y[i - 1] == Y[i]) {
							result[qi] = -1;
							break;
						} else {
							result[qi]++;
						}
					} else if ((Y[i - 1] < q && q < Y[i]) || (Y[i - 1] > q && q > Y[i])) {
						result[qi]++;
					}
				} else {
					if (Y[i] == q) {
						result[qi]++;
					}
				}
			}
		}
		return result;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PiecewiseLinearFunctionDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PiecewiseLinearFunctionDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PiecewiseLinearFunctionDiv2Harness {
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
			int[] Y = { 1, 4, -1, 2 };
			int[] query = { -2, -1, 0, 1 };
			int[] expected__ = { 0, 1, 2, 3 };

			return verifyCase(casenum__, expected__, new PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		}
		case 1: {
			int[] Y = { 0, 0 };
			int[] query = { -1, 0, 1 };
			int[] expected__ = { 0, -1, 0 };

			return verifyCase(casenum__, expected__, new PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		}
		case 2: {
			int[] Y = { 2, 4, 8, 0, 3, -6, 10 };
			int[] query = { 0, 1, 2, 3, 4, 0, 65536 };
			int[] expected__ = { 3, 4, 5, 4, 3, 3, 0 };

			return verifyCase(casenum__, expected__, new PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		}
		case 3: {
			int[] Y = { -178080289, -771314989, -237251715, -949949900, -437883156, -835236871, -316363230, -929746634,
					-671700962 };
			int[] query = { -673197622, -437883156, -251072978, 221380900, -771314989, -949949900, -910604034,
					-671700962, -929746634, -316363230 };
			int[] expected__ = { 8, 6, 3, 0, 7, 1, 4, 8, 3, 4 };

			return verifyCase(casenum__, expected__, new PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		}

		// custom cases

		/*
		 * case 4: {
		 * int[] Y = ;
		 * int[] query = ;
		 * int[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] Y = ;
		 * int[] query = ;
		 * int[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] Y = ;
		 * int[] query = ;
		 * int[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PiecewiseLinearFunctionDiv2().countSolutions(Y, query));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
