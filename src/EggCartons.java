// Paste me into the FileEdit configuration dialog
// SRM 452 DIV 2 - 250.0
public class EggCartons {
	public int minCartons(int n) {
		int min=Integer.MAX_VALUE;
		for (int x = 0; x <= 20; x++) {
			for (int y = 0; y <= 20; y++) {
				if (6*x+8*y!=n){
					continue;
				}
				min=Math.min(min, x+y);
			}			
		}
		if (min==Integer.MAX_VALUE){
			return -1;
		}
		return min;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EggCartonsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EggCartonsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EggCartonsHarness {
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
			int n = 20;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new EggCartons().minCartons(n));
		}
		case 1: {
			int n = 24;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new EggCartons().minCartons(n));
		}
		case 2: {
			int n = 15;
			int expected__ = -1;

			return verifyCase(casenum__, expected__,
					new EggCartons().minCartons(n));
		}
		case 3: {
			int n = 4;
			int expected__ = -1;

			return verifyCase(casenum__, expected__,
					new EggCartons().minCartons(n));
		}

		// custom cases

		/*
		 * case 4: { int n = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * EggCartons().minCartons(n)); }
		 */
		/*
		 * case 5: { int n = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * EggCartons().minCartons(n)); }
		 */
		/*
		 * case 6: { int n = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * EggCartons().minCartons(n)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
