// Paste me into the FileEdit configuration dialog

public class MinskyMysteryDiv2 {
	public long computeAnswer(long N) {
		if (N <= 1)
			return -1;
		long t = (long) (Math.sqrt(N) + 1), i;
		for (i=2;i<=t;i++){
			if (N%i==0) break;
		}
		if (N%i!=0){
			i=N;
		}
		return N/i+i;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MinskyMysteryDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MinskyMysteryDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MinskyMysteryDiv2Harness {
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

	static boolean compareOutput(long expected, long result) {
		return expected == result;
	}

	static String formatResult(long res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, long expected, long received) {
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
			long N = 2L;
			long expected__ = 3L;

			return verifyCase(casenum, expected__, new MinskyMysteryDiv2().computeAnswer(N));
		}
		case 1: {
			long N = 3L;
			long expected__ = 4L;

			return verifyCase(casenum, expected__, new MinskyMysteryDiv2().computeAnswer(N));
		}
		case 2: {
			long N = 4L;
			long expected__ = 4L;

			return verifyCase(casenum, expected__, new MinskyMysteryDiv2().computeAnswer(N));
		}
		case 3: {
			long N = 15L;
			long expected__ = 8L;

			return verifyCase(casenum, expected__, new MinskyMysteryDiv2().computeAnswer(N));
		}
		case 4: {
			long N = 24L;
			long expected__ = 14L;

			return verifyCase(casenum, expected__, new MinskyMysteryDiv2().computeAnswer(N));
		}

		// custom cases

		case 5: {
			long N = 549697684831L;
			long expected__ = 1482832L;

			return verifyCase(casenum, expected__, new
					MinskyMysteryDiv2().computeAnswer(N));
		}

		/*
		 * case 6: {
		 * long N = L;
		 * long expected__ = L;
		 *
		 * return verifyCase(casenum, expected__, new
		 * MinskyMysteryDiv2().computeAnswer(N));
		 * }
		 */
		/*
		 * case 7: {
		 * long N = L;
		 * long expected__ = L;
		 *
		 * return verifyCase(casenum, expected__, new
		 * MinskyMysteryDiv2().computeAnswer(N));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
