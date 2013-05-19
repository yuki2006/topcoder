// Paste me into the FileEdit configuration dialog
// SRM 441 DIV 2 - 250.0
public class DifferentStrings {
	public int minimize(String A, String B) {
		char[] AcharArray = A.toCharArray();
		char[] BcharArray = B.toCharArray();
		int min=Integer.MAX_VALUE;
		for (int i = 0; i <= BcharArray.length-AcharArray.length; i++) {
			int count=A.length();
			for (int j = 0; j < AcharArray.length; j++) {
				if (AcharArray[j]==BcharArray[i+j]){
					count--;
				}
			}
			min=Math.min(min, count);
		}
		return min;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DifferentStringsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DifferentStringsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DifferentStringsHarness {
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
			String A = "koder";
			String B = "topcoder";
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new DifferentStrings().minimize(A, B));
		}
		case 1: {
			String A = "hello";
			String B = "xello";
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new DifferentStrings().minimize(A, B));
		}
		case 2: {
			String A = "abc";
			String B = "topabcoder";
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new DifferentStrings().minimize(A, B));
		}
		case 3: {
			String A = "adaabc";
			String B = "aababbc";
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new DifferentStrings().minimize(A, B));
		}
		case 4: {
			String A = "giorgi";
			String B = "igroig";
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new DifferentStrings().minimize(A, B));
		}

		// custom cases

		/*
		 * case 5: { String A = ; String B = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DifferentStrings().minimize(A, B)); }
		 */
		/*
		 * case 6: { String A = ; String B = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DifferentStrings().minimize(A, B)); }
		 */
		/*
		 * case 7: { String A = ; String B = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DifferentStrings().minimize(A, B)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
