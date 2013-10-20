// Paste me into the FileEdit configuration dialog
// Single Round Match 594 - Round 1250.0

public class FoxAndClassroom {
	public String ableTo(int n, int m) {
		boolean[][] table = new boolean[n][m];
		int x = 0, y = 0;
		int count = 0;
		while (table[x][y] == false) {
			table[x][y] = true;
			x = (x + 1) % table.length;
			y = (y + 1) % table[0].length;
			count++;
		}
		if (count == n * m) {
			return "Possible";
		}
		return "Impossible";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndClassroomHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FoxAndClassroomHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndClassroomHarness {
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

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
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
			int n = 2;
			int m = 3;
			String expected__ = "Possible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		case 1: {
			int n = 2;
			int m = 2;
			String expected__ = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		case 2: {
			int n = 4;
			int m = 6;
			String expected__ = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		case 3: {
			int n = 3;
			int m = 6;
			String expected__ = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		case 4: {
			int n = 5;
			int m = 7;
			String expected__ = "Possible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		case 5: {
			int n = 10;
			int m = 10;
			String expected__ = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		case 6: {
			int n = 9;
			int m = 10;
			String expected__ = "Possible";

			return verifyCase(casenum__, expected__, new FoxAndClassroom().ableTo(n, m));
		}
		// custom cases

		/*
		 * case 6: {
		 * int n = ;
		 * int m = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndClassroom().ableTo(n, m));
		 * }
		 */
		/*
		 * case 7: {
		 * int n = ;
		 * int m = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndClassroom().ableTo(n, m));
		 * }
		 */
		/*
		 * case 8: {
		 * int n = ;
		 * int m = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndClassroom().ableTo(n, m));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
