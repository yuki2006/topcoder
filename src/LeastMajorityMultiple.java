// Paste me into the FileEdit configuration dialog
// SRM 434 DIV 2 - 250.0

public class LeastMajorityMultiple {
	public int leastMajorityMultiple(int a, int b, int c, int d, int e) {
		int x = 1;
		while (true) {
			int count = 0;
			count += (x % a == 0 ? 1 : 0);
			count += (x % b == 0 ? 1 : 0);
			count += (x % c == 0 ? 1 : 0);
			count += (x % d == 0 ? 1 : 0);
			count += (x % e == 0 ? 1 : 0);
			if (count >= 3) {
				return x;
			}
			x++;
		}

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LeastMajorityMultipleHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LeastMajorityMultipleHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LeastMajorityMultipleHarness {
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
			int a = 1;
			int b = 2;
			int c = 3;
			int d = 4;
			int e = 5;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		}
		case 1: {
			int a = 30;
			int b = 42;
			int c = 70;
			int d = 35;
			int e = 90;
			int expected__ = 210;

			return verifyCase(casenum__, expected__, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		}
		case 2: {
			int a = 30;
			int b = 45;
			int c = 23;
			int d = 26;
			int e = 56;
			int expected__ = 1170;

			return verifyCase(casenum__, expected__, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		}
		case 3: {
			int a = 3;
			int b = 14;
			int c = 15;
			int d = 92;
			int e = 65;
			int expected__ = 195;

			return verifyCase(casenum__, expected__, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		}

		// custom cases

		/*
		 * case 4: {
		 * int a = ;
		 * int b = ;
		 * int c = ;
		 * int d = ;
		 * int e = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		 * }
		 */
		/*
		 * case 5: {
		 * int a = ;
		 * int b = ;
		 * int c = ;
		 * int d = ;
		 * int e = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		 * }
		 */
		/*
		 * case 6: {
		 * int a = ;
		 * int b = ;
		 * int c = ;
		 * int d = ;
		 * int e = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
