// Paste me into the FileEdit configuration dialog
// Single Round Match 580 - Round 1250.0

public class ShoutterDiv2 {
	public int count(int[] s, int[] t) {
		int pairs = 0;
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i] > s[j]) {
					int t1 = s[i], t2 = t[i];
					s[i] = s[j];
					t[i] = t[j];
					s[j] = t1;
					t[j] = t2;
				}
			}
		}
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (t[i]<=s[j] &&s[j]<=t[i]) {
					pairs++;
				}
			}
		}
		return pairs;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ShoutterDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ShoutterDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ShoutterDiv2Harness {
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
			int[] s = { 1, 2, 4 };
			int[] t = { 3, 4, 6 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s, t));
		}
		case 1: {
			int[] s = { 0 };
			int[] t = { 100 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s, t));
		}
		case 2: {
			int[] s = { 0, 0, 0 };
			int[] t = { 1, 1, 1 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s, t));
		}
		case 3: {
			int[] s = { 9, 26, 8, 35, 3, 58, 91, 24, 10, 26, 22, 18, 15, 12, 15, 27, 15, 60, 76, 19, 12, 16, 37, 35,
					25, 4, 22, 47, 65, 3, 2, 23, 26, 33, 7, 11, 34, 74, 67, 32, 15, 45, 20, 53, 60, 25, 74, 13, 44, 51 };
			int[] t = { 26, 62, 80, 80, 52, 83, 100, 71, 20, 73, 23, 32, 80, 37, 34, 55, 51, 86, 97, 89, 17, 81, 74,
					94, 79, 85, 77, 97, 87, 8, 70, 46, 58, 70, 97, 35, 80, 76, 82, 80, 19, 56, 65, 62, 80, 49, 79, 28,
					75, 78 };
			int expected__ = 830;

			return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s, t));
		}

		// custom cases

		/*
		 * case 4: {
		 * int[] s = ;
		 * int[] t = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s,
		 * t));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] s = ;
		 * int[] t = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s,
		 * t));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] s = ;
		 * int[] t = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new ShoutterDiv2().count(s,
		 * t));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
