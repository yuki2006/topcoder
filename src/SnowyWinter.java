// Paste me into the FileEdit configuration dialog
// SRM 391 DIV 2 - 250.0

public class SnowyWinter {
	public int snowyHighwayLength(int[] startPoints, int[] endPoints) {
		boolean[] hit = new boolean[10000];
		for (int i = 0; i < startPoints.length; i++) {
			for (int j = startPoints[i]; j < endPoints[i]; j++) {
				hit[j]=true;
			}
		}
		int count=0;
		for (boolean b : hit) {
			count+=b?1:0;
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SnowyWinterHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SnowyWinterHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SnowyWinterHarness {
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
			int[] startPoints = { 17, 85, 57 };
			int[] endPoints = { 33, 86, 84 };
			int expected__ = 44;

			return verifyCase(casenum__, expected__, new SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		}
		case 1: {
			int[] startPoints = { 45, 100, 125, 10, 15, 35, 30, 9 };
			int[] endPoints = { 46, 200, 175, 20, 25, 45, 40, 10 };
			int expected__ = 132;

			return verifyCase(casenum__, expected__, new SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		}
		case 2: {
			int[] startPoints = { 4387, 711, 2510, 1001, 4687, 3400, 5254, 584, 284, 1423, 3755, 929, 2154, 5719, 1326,
					2368, 554 };
			int[] endPoints = { 7890, 5075, 2600, 6867, 7860, 9789, 6422, 5002, 4180, 7086, 8615, 9832, 4169, 7188,
					9975, 8690, 1423 };
			int expected__ = 9691;

			return verifyCase(casenum__, expected__, new SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		}
		case 3: {
			int[] startPoints = { 4906, 5601, 5087, 1020, 4362, 2657, 6257, 5509, 5107, 5315, 277, 6801, 2136, 2921,
					5233, 5082, 497, 8250, 3956, 5720 };
			int[] endPoints = { 4930, 9130, 9366, 2322, 4687, 4848, 8856, 6302, 5496, 5438, 829, 9053, 4233, 4119,
					9781, 8034, 3956, 9939, 4908, 5928 };
			int expected__ = 9510;

			return verifyCase(casenum__, expected__, new SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		}
		case 4: {
			int[] startPoints = { 51, 807, 943, 4313, 8319, 3644, 481, 220, 2161, 448, 465, 1657, 6290, 22, 6152, 647,
					3185, 4474, 2168 };
			int[] endPoints = { 1182, 912, 1832, 7754, 9557, 7980, 4144, 3194, 7129, 5535, 1172, 2043, 6437, 7252,
					9508, 4745, 8313, 8020, 4017 };
			int expected__ = 9535;

			return verifyCase(casenum__, expected__, new SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		}
		case 5: {
			int[] startPoints = { 8786, 7391, 201, 4414, 5822, 5872, 157, 1832, 7487, 7518, 2267, 1763, 3984, 3102,
					7627, 4099, 524, 1543, 1022, 3060 };
			int[] endPoints = { 9905, 7957, 3625, 6475, 9314, 9332, 4370, 8068, 8295, 8177, 7772, 2668, 7191, 8480,
					9211, 4802, 2625, 1924, 9970, 4180 };
			int expected__ = 9813;

			return verifyCase(casenum__, expected__, new SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		}

		// custom cases

		/*
		 * case 6: {
		 * int[] startPoints = ;
		 * int[] endPoints = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] startPoints = ;
		 * int[] endPoints = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		 * }
		 */
		/*
		 * case 8: {
		 * int[] startPoints = ;
		 * int[] endPoints = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SnowyWinter().snowyHighwayLength(startPoints, endPoints));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
