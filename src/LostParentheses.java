// Paste me into the FileEdit configuration dialog
// SRM 348 DIV 2 - 500.0
// idea by http://community.topcoder.com/stat?c=problem_solution&rm=264719&rd=10672&pm=7754&cr=22627975
public class LostParentheses {
	public int minResult(String e) {
		String[] s = e.split("[+|-]");
		String ee = e.replaceAll("[^+-]", "");
		boolean flag = false;
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			if (flag) {
				sum -= Integer.valueOf(s[i]);
			} else {
				sum += Integer.valueOf(s[i]);
			}
			if (i < ee.length()  && ee.charAt(i) == '-') {
				flag = true;
			}

		}
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LostParenthesesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LostParenthesesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LostParenthesesHarness {
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
			String e = "55-50+40";
			int expected__ = -35;

			return verifyCase(casenum__, expected__, new LostParentheses().minResult(e));
		}
		case 1: {
			String e = "10+20+30+40";
			int expected__ = 100;

			return verifyCase(casenum__, expected__, new LostParentheses().minResult(e));
		}
		case 2: {
			String e = "00009-00009";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new LostParentheses().minResult(e));
		}

		// custom cases

		/*
		 * case 3: {
		 * String e = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LostParentheses().minResult(e));
		 * }
		 */
		/*
		 * case 4: {
		 * String e = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LostParentheses().minResult(e));
		 * }
		 */
		/*
		 * case 5: {
		 * String e = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LostParentheses().minResult(e));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
