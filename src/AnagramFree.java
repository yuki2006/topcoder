import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Paste me into the FileEdit configuration dialog
// SRM 496 DIV 2 - 250.0

public class AnagramFree {
	public int getMaximumSubset(String[] S) {
		Set<String> set = new HashSet<String>();
		for (String string : S) {
			char[] charArray = string.toCharArray();
			Arrays.sort(charArray);
			set.add(new String(charArray));
		}
		return set.size();
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			AnagramFreeHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				AnagramFreeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class AnagramFreeHarness {
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
			String[] S = { "abcd", "abdc", "dabc", "bacd" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new AnagramFree().getMaximumSubset(S));
		}
		case 1: {
			String[] S = { "abcd", "abac", "aabc", "bacd" };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new AnagramFree().getMaximumSubset(S));
		}
		case 2: {
			String[] S = { "aa", "aaaaa", "aaa", "a", "bbaaaa", "aaababaa" };
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new AnagramFree().getMaximumSubset(S));
		}
		case 3: {
			String[] S = { "creation", "sentence", "reaction", "sneak", "star", "rats", "snake" };
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new AnagramFree().getMaximumSubset(S));
		}

		// custom cases

		/*
		 * case 4: {
		 * String[] S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * AnagramFree().getMaximumSubset(S));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * AnagramFree().getMaximumSubset(S));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * AnagramFree().getMaximumSubset(S));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
