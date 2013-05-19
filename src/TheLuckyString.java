// Paste me into the FileEdit configuration dialog
// SRM 428 DIV 2 - 500.0

public class TheLuckyString {
	int[] map = new int[27];
	int L = 0;
	int cnt = 0;

	public int count(String s) {
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			map[c - 'a']++;
		}
		L = s.length();
		solve(0, ' ');
		return cnt;
	}

	private void solve(int pos, char prev) {
		if (pos == L) {
			cnt++;
		}
		for (char c = 0; c <= 26; c++) {
			if (prev != c && map[c] > 0) {
				map[c]--;
				solve(pos + 1, c);
				map[c]++;
			}
		}
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheLuckyStringHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheLuckyStringHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheLuckyStringHarness {
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
			String s = "ab";
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new TheLuckyString().count(s));
		}
		case 1: {
			String s = "aaab";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new TheLuckyString().count(s));
		}
		case 2: {
			String s = "aabbbaa";
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new TheLuckyString().count(s));
		}
		case 3: {
			String s = "abcdefghij";
			int expected__ = 3628800;

			return verifyCase(casenum__, expected__, new TheLuckyString().count(s));
		}

		// custom cases

		/*
		 * case 4: {
		 * String s = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheLuckyString().count(s));
		 * }
		 */
		/*
		 * case 5: {
		 * String s = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheLuckyString().count(s));
		 * }
		 */
		/*
		 * case 6: {
		 * String s = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheLuckyString().count(s));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
