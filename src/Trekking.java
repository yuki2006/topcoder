// Paste me into the FileEdit configuration dialog
// SRM 345 DIV 2 - 250.0

public class Trekking {
	public int findCamps(String trail, String[] plans) {
		char[] trailChars = trail.toCharArray();
		int min = Integer.MAX_VALUE;
		for (String str : plans) {
			char[] plan = str.toCharArray();
			int count = 0;
			for (int i = 0; i < plan.length; i++) {
				if (plan[i] == 'C') {
					if (trailChars[i] == '.') {
						count++;
					} else {
						count = Integer.MAX_VALUE;
						break;
					}
				}
			}

			min = Math.min(min, count);
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TrekkingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TrekkingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TrekkingHarness {
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
			String trail = "^^....^^^...";
			String[] plans = { "CwwCwwCwwCww",
					"wwwCwCwwwCww",
					"wwwwCwwwwCww" };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new Trekking().findCamps(trail, plans));
		}
		case 1: {
			String trail = "^^^^";
			String[] plans = { "wwww",
					"wwwC"
			};
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new Trekking().findCamps(trail, plans));
		}
		case 2: {
			String trail = "^^.^^^^";
			String[] plans = { "wwCwwwC",
					"wwwCwww",
					"wCwwwCw" };
			int expected__ = -1;

			return verifyCase(casenum__, expected__, new Trekking().findCamps(trail, plans));
		}
		case 3: {
			String trail = "^^^^....^.^.^.";
			String[] plans = { "wwwwCwwwwCwCwC",
					"wwwwCwwCwCwwwC",
					"wwwCwwwCwwwCww",
					"wwwwwCwwwCwwwC" };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new Trekking().findCamps(trail, plans));
		}
		case 4: {
			String trail = "..............";
			String[] plans = { "CwCwCwCwCwCwCw",
					"CwwCwwCwwCwwCw" };
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new Trekking().findCamps(trail, plans));
		}

		// custom cases

		/*
		 * case 5: {
		 * String trail = ;
		 * String[] plans = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Trekking().findCamps(trail, plans));
		 * }
		 */
		/*
		 * case 6: {
		 * String trail = ;
		 * String[] plans = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Trekking().findCamps(trail, plans));
		 * }
		 */
		/*
		 * case 7: {
		 * String trail = ;
		 * String[] plans = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Trekking().findCamps(trail, plans));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
