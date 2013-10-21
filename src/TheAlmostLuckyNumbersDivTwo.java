// Paste me into the FileEdit configuration dialog
// SRM 510 DIV 2 - 250.0

public class TheAlmostLuckyNumbersDivTwo {
	public int find(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			if (isAlmostLuckyNumber(i)) {
				count++;
			}
		}
		return count;
	}

	boolean isAlmostLuckyNumber(int n) {
		char[] cs = (n + "").toCharArray();
		int count = 0;
		for (char c : cs) {
			if (c == '4' || c == '7') {
				count++;
			}
		}
		return cs.length <= count + 1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheAlmostLuckyNumbersDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheAlmostLuckyNumbersDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheAlmostLuckyNumbersDivTwoHarness {
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
			int a = 4;
			int b = 7;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new TheAlmostLuckyNumbersDivTwo().find(a, b));
		}
		case 1: {
			int a = 8;
			int b = 19;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new TheAlmostLuckyNumbersDivTwo().find(a, b));
		}
		case 2: {
			int a = 28;
			int b = 33;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new TheAlmostLuckyNumbersDivTwo().find(a, b));
		}
		case 3: {
			int a = 1234;
			int b = 4321;
			int expected__ = 36;

			return verifyCase(casenum__, expected__, new TheAlmostLuckyNumbersDivTwo().find(a, b));
		}

		// custom cases

		case 4: {
			int a = 1;
			int b = 1000000;
			int expected__ = 2631;

			return verifyCase(casenum__, expected__, new
					TheAlmostLuckyNumbersDivTwo().find(a, b));
		}
		/*
		 * case 5: {
		 * int a = ;
		 * int b = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheAlmostLuckyNumbersDivTwo().find(a, b));
		 * }
		 */
		/*
		 * case 6: {
		 * int a = ;
		 * int b = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheAlmostLuckyNumbersDivTwo().find(a, b));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
