import java.util.HashMap;

// Paste me into the FileEdit configuration dialog

public class KingdomAndDucks {

	public int minDucks(int[] duckTypes) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i : duckTypes) {
			Integer value = map.get(i);
			if (value == null) {
				value = 0;
			}
			value++;
			map.put(i, value);
			if (max < value) {
				max = value;
			}
		}
		return max * map.size();

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			KingdomAndDucksHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				KingdomAndDucksHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class KingdomAndDucksHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			int[] duckTypes = { 5, 8 };
			int expected__ = 2;

			return verifyCase(casenum, expected__, new KingdomAndDucks().minDucks(duckTypes));
		}
		case 1: {
			int[] duckTypes = { 4, 7, 4, 7, 4 };
			int expected__ = 6;

			return verifyCase(casenum, expected__, new KingdomAndDucks().minDucks(duckTypes));
		}
		case 2: {
			int[] duckTypes = { 17, 17, 19, 23, 23, 19, 19, 17, 17 };
			int expected__ = 12;

			return verifyCase(casenum, expected__, new KingdomAndDucks().minDucks(duckTypes));
		}
		case 3: {
			int[] duckTypes = { 50 };
			int expected__ = 1;

			return verifyCase(casenum, expected__, new KingdomAndDucks().minDucks(duckTypes));
		}
		case 4: {
			int[] duckTypes = { 10, 10, 10, 10, 10 };
			int expected__ = 5;

			return verifyCase(casenum, expected__, new KingdomAndDucks().minDucks(duckTypes));
		}

		// custom cases

		/*
		 * case 5: {
		 * int[] duckTypes = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingdomAndDucks().minDucks(duckTypes));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] duckTypes = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingdomAndDucks().minDucks(duckTypes));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] duckTypes = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingdomAndDucks().minDucks(duckTypes));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
