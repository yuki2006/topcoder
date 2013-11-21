// Paste me into the FileEdit configuration dialog
// SRM 271 DIV 2 - 250.0

public class CheckFunction {
	public int newFunction(String code) {
		int[] dashes = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
		int sum = 0;
		for (char c : code.toCharArray()) {
			sum += dashes[c - '0'];
		}
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CheckFunctionHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CheckFunctionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CheckFunctionHarness {
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
			String code = "13579";
			int expected__ = 21;

			return verifyCase(casenum__, expected__, new CheckFunction().newFunction(code));
		}
		case 1: {
			String code = "02468";
			int expected__ = 28;

			return verifyCase(casenum__, expected__, new CheckFunction().newFunction(code));
		}
		case 2: {
			String code = "73254370932875002027963295052175";
			int expected__ = 157;

			return verifyCase(casenum__, expected__, new CheckFunction().newFunction(code));
		}

		// custom cases

		/*
		 * case 3: {
		 * String code = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CheckFunction().newFunction(code));
		 * }
		 */
		/*
		 * case 4: {
		 * String code = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CheckFunction().newFunction(code));
		 * }
		 */
		/*
		 * case 5: {
		 * String code = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CheckFunction().newFunction(code));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
