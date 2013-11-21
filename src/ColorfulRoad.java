import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// Single Round Match 596 - Round 1500.0

public class ColorfulRoad {
	/**
	 * 
	 */
	private static final int MAX = 100000;

	public int getMin(String road) {

		int[] roads = new int[road.length()];
		int[] dp = new int[roads.length];
		Arrays.fill(dp, MAX);
		for (int i = 0; i < roads.length; i++) {
			roads[i] = road.charAt(i) == 'R' ? 0 : road.charAt(i) == 'G' ? 1 : 2;
		}
		dp[0] = 0;

		for (int i = 0; i < roads.length - 1; i++) {
			for (int j = i + 1; j < roads.length; j++) {
				if (roads[j] == (roads[i] + 1) % 3) {
					dp[j] = Math.min(dp[i] + (j - i) * (j - i), dp[j]);
				}
			}
		}
		return (dp[dp.length - 1] == MAX ? -1 : dp[dp.length - 1]);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ColorfulRoadHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ColorfulRoadHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ColorfulRoadHarness {
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
			String road = "RGGGB";
			int expected__ = 8;

			return verifyCase(casenum__, expected__, new ColorfulRoad().getMin(road));
		}
		case 1: {
			String road = "RGBRGBRGB";
			int expected__ = 8;

			return verifyCase(casenum__, expected__, new ColorfulRoad().getMin(road));
		}
		case 2: {
			String road = "RBBGGGRR";
			int expected__ = -1;

			return verifyCase(casenum__, expected__, new ColorfulRoad().getMin(road));
		}
		case 3: {
			String road = "RBRRBGGGBBBBR";
			int expected__ = 50;

			return verifyCase(casenum__, expected__, new ColorfulRoad().getMin(road));
		}
		case 4: {
			String road = "RG";
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new ColorfulRoad().getMin(road));
		}
		case 5: {
			String road = "RBRGBGBGGBGRGGG";
			int expected__ = 52;

			return verifyCase(casenum__, expected__, new ColorfulRoad().getMin(road));
		}

		// custom cases

		case 6: {
			String road = "RRR";
			int expected__ = -1;

			return verifyCase(casenum__, expected__, new
					ColorfulRoad().getMin(road));
		}
		case 7: {
			String road = "RBG";
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new
					ColorfulRoad().getMin(road));
		}
		case 8: {
			String road = "RGB";
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new
					ColorfulRoad().getMin(road));
		}
		case 9: {
			String road = "RGRGB";
			int expected__ = 10;

			return verifyCase(casenum__, expected__, new
					ColorfulRoad().getMin(road));
		}
		case 10: {
			String road = "RGGGBBB";
			int expected__ = 18;

			return verifyCase(casenum__, expected__, new
					ColorfulRoad().getMin(road));
		}
		/*
		 * case 7: {
		 * String road = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ColorfulRoad().getMin(road));
		 * }
		 */
		/*
		 * case 8: {
		 * String road = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ColorfulRoad().getMin(road));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
