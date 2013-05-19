
// Paste me into the FileEdit configuration dialog
// SRM 391 DIV 2 - 500.0

public class IsomorphicWords {
	public int countPairs(String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				char[] m = new char[255];
				char[] r = new char[255];
				boolean allHit = true;
				for (int k = 0; k < words[i].length(); k++) {
					if (m[words[i].charAt(k)] == 0 && r[words[j].charAt(k)] ==0) {
						m[words[i].charAt(k)] = words[j].charAt(k);
						r[words[j].charAt(k)] = words[i].charAt(k);
					} else {
						if (m[words[i].charAt(k)] != words[j].charAt(k) || r[words[j].charAt(k)] != words[i].charAt(k)) {
							allHit = false;
							break;
						}
					}
				}
				if (allHit) {
					count++;
				}
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			IsomorphicWordsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				IsomorphicWordsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class IsomorphicWordsHarness {
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
			String[] words = { "abca", "zbxz", "opqr" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new IsomorphicWords().countPairs(words));
		}
		case 1: {
			String[] words = { "aa", "ab", "bb", "cc", "cd" };
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new IsomorphicWords().countPairs(words));
		}
		case 2: {
			String[] words = { "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
					"bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
					"dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca" };
			int expected__ = 13;

			return verifyCase(casenum__, expected__, new IsomorphicWords().countPairs(words));
		}

		// custom cases

		/*
		 * case 3: {
		 * String[] words = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * IsomorphicWords().countPairs(words));
		 * }
		 */
		/*
		 * case 4: {
		 * String[] words = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * IsomorphicWords().countPairs(words));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] words = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * IsomorphicWords().countPairs(words));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
