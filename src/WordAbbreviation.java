// Paste me into the FileEdit configuration dialog
// SRM 402 DIV 2 - 250.0

public class WordAbbreviation {
	public String[] getAbbreviations(String[] words) {
		String[] result = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				String substring = words[i].substring(0, j+1);
				boolean hit = false;
				for (int k = 0; k < words.length; k++) {
					if (k == i)
						continue;
					if (words[k].startsWith(substring)) {
						hit = true;
					}
				}
				if (!hit) {
					result[i] = substring;
					break;
				}
			}
		}
		return result;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			WordAbbreviationHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				WordAbbreviationHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class WordAbbreviationHarness {
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

	static boolean compareOutput(String[] expected, String[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (!expected[i].equals(result[i]))
				return false;
		return true;
	}

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, String[] expected, String[] received) {
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
			String[] words = { "abc", "def", "ghi" };
			String[] expected__ = { "a", "d", "g" };

			return verifyCase(casenum__, expected__,
					new WordAbbreviation().getAbbreviations(words));
		}
		case 1: {
			String[] words = { "aaab", "aaac", "aaad" };
			String[] expected__ = { "aaab", "aaac", "aaad" };

			return verifyCase(casenum__, expected__,
					new WordAbbreviation().getAbbreviations(words));
		}
		case 2: {
			String[] words = { "top", "coder", "contest" };
			String[] expected__ = { "t", "cod", "con" };

			return verifyCase(casenum__, expected__,
					new WordAbbreviation().getAbbreviations(words));
		}
		case 3: {
			String[] words = { "bababaaaaa", "baaabaababa",
					"bbabaaabbaaabbabaabaabbbbbaabb",
					"aaababababbbbababbbaabaaaaaaaabbabbbaaab",
					"baaaaabaababbbaabbbabbababbbabbbbbbbbab" };
			String[] expected__ = { "bab", "baaab", "bb", "a", "baaaa" };

			return verifyCase(casenum__, expected__,
					new WordAbbreviation().getAbbreviations(words));
		}
		case 4: {
			String[] words = { "oneword" };
			String[] expected__ = { "o" };

			return verifyCase(casenum__, expected__,
					new WordAbbreviation().getAbbreviations(words));
		}

		// custom cases

		/*
		 * case 5: { String[] words = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * WordAbbreviation().getAbbreviations(words)); }
		 */
		/*
		 * case 6: { String[] words = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * WordAbbreviation().getAbbreviations(words)); }
		 */
		/*
		 * case 7: { String[] words = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * WordAbbreviation().getAbbreviations(words)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
