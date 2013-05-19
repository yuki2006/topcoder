// Paste me into the FileEdit configuration dialog
import java.util.HashMap;

public class InterestingParty {
	public int bestInvitation2(String[] first, String[] second) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int max = 1;

		String[][] strings = new String[][] { first, second };
		for (String[] topics : strings) {
			for (String key : topics) {
				if (map.containsKey(key)) {
					int value = map.get(key) + 1;
					map.put(key, value);
					max = Math.max(value, max);
				} else {
					map.put(key, 1);
				}
			}
		}
		return max;
	}

	public int bestInvitation(String[] first, String[] second) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < first.length; i++) {
			map.put(first[i], 0);
			map.put(second[i], 0);
		}

		for (int i = 0; i < first.length; i++) {
			map.put(first[i], map.get(first[i]) + 1);
			map.put(second[i], map.get(second[i]) + 1);
		}
		int max = 0;
		for (String entry : map.keySet()) {
			max = Math.max(map.get(entry), max);
		}
		return max;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			InterestingPartyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				InterestingPartyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class InterestingPartyHarness {
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
			String[] first = { "fishing", "gardening", "swimming", "fishing" };
			String[] second = { "hunting", "fishing", "fishing", "biting" };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new InterestingParty().bestInvitation(first, second));
		}
		case 1: {
			String[] first = { "variety", "diversity", "loquacity", "courtesy" };
			String[] second = { "talking", "speaking", "discussion", "meeting" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new InterestingParty().bestInvitation(first, second));
		}
		case 2: {
			String[] first = { "snakes", "programming", "cobra", "monty" };
			String[] second = { "python", "python", "anaconda", "python" };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new InterestingParty().bestInvitation(first, second));
		}
		case 3: {
			String[] first = { "t", "o", "p", "c", "o", "d", "e", "r", "s",
					"i", "n", "g", "l", "e", "r", "o", "u", "n", "d", "m", "a",
					"t", "c", "h", "f", "o", "u", "r", "n", "i" };
			String[] second = { "n", "e", "f", "o", "u", "r", "j", "a", "n",
					"u", "a", "r", "y", "t", "w", "e", "n", "t", "y", "t", "w",
					"o", "s", "a", "t", "u", "r", "d", "a", "y" };
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new InterestingParty().bestInvitation(first, second));
		}

		// custom cases

		/*
		 * case 4: { String[] first = ; String[] second = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * InterestingParty().bestInvitation(first, second)); }
		 */
		/*
		 * case 5: { String[] first = ; String[] second = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * InterestingParty().bestInvitation(first, second)); }
		 */
		/*
		 * case 6: { String[] first = ; String[] second = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * InterestingParty().bestInvitation(first, second)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
