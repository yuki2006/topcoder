import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class TeamContestEasy {
	public int worstRank(int[] strength) {
		if (strength.length == 3)
			return 1;
		int myScore = strength[0] + strength[1] + strength[2];
		int min = Math.min(Math.min(strength[0], strength[1]), strength[2]);
		myScore -= min;

		int[] s = new int[strength.length - 3];
		for (int i = 3; i < s.length + 3; i++) {
			s[i - 3] = strength[i];
		}
		Arrays.sort(s);

		int[] p = new int[s.length * 2 / 3];
		for (int i = 0; i < p.length; i++) {
			p[i] = s[s.length - i - 1];
		}

		int ret = 1;
		int high = 0;
		int low = p.length - 1;

		while (high < low) {
			if (p[high] + p[low] > myScore) {
				ret++;
				high++;

			}
			low--;
		}
		return ret;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TeamContestEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TeamContestEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TeamContestEasyHarness {
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
			int[] strength = { 5, 7, 3, 5, 7, 3, 5, 7, 3 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}
		case 1: {
			int[] strength = { 5, 7, 3 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}
		case 2: {
			int[] strength = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}
		case 3: {
			int[] strength = { 2, 2, 1, 1, 3, 1, 3, 2, 1, 3, 1, 2, 1, 2, 1 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}
		case 4: {
			int[] strength = { 45, 72, 10, 42, 67, 51, 33, 21, 8, 51, 17, 72 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}
		case 5: {
			int[] strength = { 570466, 958327, 816467, 17, 403, 953808, 734850, 5824, 917784, 921731, 161921, 1734,
					823437, 3218, 81, 932681, 2704, 981643, 1232, 475, 873323, 6558, 45660, 1813, 4714, 224, 32301,
					28081, 6728, 17055, 561, 15146, 842613, 5559, 1860, 783, 989, 2811, 20664, 112531, 1933, 866794,
					805528, 53821, 2465, 137385, 39, 2007 };
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}
		case 6: {
			int[] strength = { 610297, 849870, 523999, 6557, 976530, 731458, 7404, 795100, 147040, 110947, 159692,
					40785, 4949, 2903, 1688, 37278, 620703, 28156, 16823, 1159, 12132, 971379, 5916, 1159, 988589,
					12215, 133, 1490, 911360, 920059, 544070, 40249, 514852, 852, 745070, 1105, 715897, 714696, 589133,
					698317, 5683, 631612, 16453, 101000, 764881, 101, 2053, 754661 };
			int expected__ = 10;

			return verifyCase(casenum__, expected__, new TeamContestEasy().worstRank(strength));
		}

		// custom cases

		/*
		 * case 7: {
		 * int[] strength = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TeamContestEasy().worstRank(strength));
		 * }
		 */
		/*
		 * case 8: {
		 * int[] strength = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TeamContestEasy().worstRank(strength));
		 * }
		 */
		/*
		 * case 9: {
		 * int[] strength = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TeamContestEasy().worstRank(strength));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
