
// Paste me into the FileEdit configuration dialog
// SRM 595 DIV 2 - 500.0
public class LittleElephantAndIntervalsDiv2 {
	public int getNumber(int M, int[] L, int[] R) {
		boolean[] d = new boolean[M + 1];
		int count = 0;
		for (int i = L.length - 1; i >= 0; i--) {
			boolean isHit = false;
			for (int j = L[i]; j <= R[i]; j++) {
				if (!d[j]) {
					isHit = true;
					d[j] = true;
				}
			}
			if (!isHit) {
				count++;
			}
		}
		return 1 << (L.length - count);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LittleElephantAndIntervalsDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LittleElephantAndIntervalsDiv2Harness.run_test(Integer
						.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndIntervalsDiv2Harness {
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
			int M = 4;
			int[] L = { 1, 2, 3 };
			int[] R = { 1, 2, 3 };
			int expected__ = 8;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndIntervalsDiv2().getNumber(M, L, R));
		}
		case 1: {
			int M = 3;
			int[] L = { 1, 1, 2 };
			int[] R = { 3, 1, 3 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndIntervalsDiv2().getNumber(M, L, R));
		}
		case 2: {
			int M = 100;
			int[] L = { 47 };
			int[] R = { 74 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndIntervalsDiv2().getNumber(M, L, R));
		}
		case 3: {
			int M = 100;
			int[] L = { 10, 20, 50 };
			int[] R = { 20, 50, 100 };
			int expected__ = 8;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndIntervalsDiv2().getNumber(M, L, R));
		}
		case 4: {
			int M = 42;
			int[] L = { 5, 23, 4, 1, 15, 2, 22, 26, 13, 16 };
			int[] R = { 30, 41, 17, 1, 21, 6, 28, 30, 15, 19 };
			int expected__ = 512;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndIntervalsDiv2().getNumber(M, L, R));
		}

		// custom cases

		/*
		 * case 5: { int M = ; int[] L = ; int[] R = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndIntervalsDiv2().getNumber(M, L, R)); }
		 */
		/*
		 * case 6: { int M = ; int[] L = ; int[] R = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndIntervalsDiv2().getNumber(M, L, R)); }
		 */
		/*
		 * case 7: { int M = ; int[] L = ; int[] R = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndIntervalsDiv2().getNumber(M, L, R)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
