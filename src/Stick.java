// Paste me into the FileEdit configuration dialog
// SRM 409 DIV 2 - 250.0

public class Stick {
	public int pieces(int x) {
		int count=0;
		while (x > 0) {
			if (x%2==1){
				count++;
			}
			x/=2;
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			StickHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				StickHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class StickHarness {
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

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			int x = 32;
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new Stick().pieces(x));
		}
		case 1: {
			int x = 48;
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new Stick().pieces(x));
		}
		case 2: {
			int x = 23;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new Stick().pieces(x));
		}

		// custom cases

		/*
		 * case 3: {
		 * int x = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new Stick().pieces(x));
		 * }
		 */
		/*
		 * case 4: {
		 * int x = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new Stick().pieces(x));
		 * }
		 */
		/*
		 * case 5: {
		 * int x = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new Stick().pieces(x));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
