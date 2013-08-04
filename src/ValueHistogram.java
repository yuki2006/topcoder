// Paste me into the FileEdit configuration dialog
// SRM 565 DIV 2 - 250.0

public class ValueHistogram {
	public String[] build(int[] values) {
		int[] hist = new int[10];
		for (int v : values) {
			hist[v]++;
		}
		int max = 0;
		for (int i : hist) {
			max = Math.max(i, max);
		}
		char[][] result = new char[max + 1][10];
		for (int i = max; i >= 0; i--) {
			for (int j = 0; j < hist.length; j++) {
				result[i][j] = hist[j] >= i + 1 ? 'X' : '.';
			}
		}
		String[] r = new String[result.length];
		for (int i = 0; i < r.length; i++) {
			r[i] = new String(result[r.length - 1 - i]);
		}
		return r;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ValueHistogramHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ValueHistogramHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ValueHistogramHarness {
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
			int[] values = { 2, 3, 5, 5, 5, 2, 0, 8 };
			String[] expected__ = { "..........", ".....X....", "..X..X....", "X.XX.X..X." };

			return verifyCase(casenum__, expected__, new ValueHistogram().build(values));
		}
		case 1: {
			int[] values = { 9, 9, 9, 9 };
			String[] expected__ = { "..........", ".........X", ".........X", ".........X", ".........X" };

			return verifyCase(casenum__, expected__, new ValueHistogram().build(values));
		}
		case 2: {
			int[] values = { 6, 4, 0, 0, 3, 9, 8, 8 };
			String[] expected__ = { "..........", "X.......X.", "X..XX.X.XX" };

			return verifyCase(casenum__, expected__, new ValueHistogram().build(values));
		}
		case 3: {
			int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			String[] expected__ = { "..........", "XXXXXXXXXX" };

			return verifyCase(casenum__, expected__, new ValueHistogram().build(values));
		}
		case 4: {
			int[] values = { 6, 2, 3, 3, 3, 7, 8, 1, 0, 9, 2, 2, 4, 3 };
			String[] expected__ = { "..........", "...X......", "..XX......", "..XX......", "XXXXX.XXXX" };

			return verifyCase(casenum__, expected__, new ValueHistogram().build(values));
		}

		// custom cases

		/*
		 * case 5: {
		 * int[] values = ;
		 * String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ValueHistogram().build(values));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] values = ;
		 * String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ValueHistogram().build(values));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] values = ;
		 * String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ValueHistogram().build(values));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
