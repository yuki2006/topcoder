
public class ColumnDiagramPerimeter {
	public int getPerimiter(int[] a) {

		int perimiter = a[0] + a[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			perimiter += Math.abs(a[i] - a[i - 1]);
		}
		perimiter += 2 * a.length;
		return perimiter;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ColumnDiagramPerimeterHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ColumnDiagramPerimeterHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ColumnDiagramPerimeterHarness {
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
			int[] a = { 2, 3, 5, 6, 1 };
			int expected__ = 22;

			return verifyCase(casenum__, expected__, new ColumnDiagramPerimeter().getPerimiter(a));
		}
		case 1: {
			int[] a = { 3, 2, 1 };
			int expected__ = 12;

			return verifyCase(casenum__, expected__, new ColumnDiagramPerimeter().getPerimiter(a));
		}
		case 2: {
			int[] a = { 2, 2 };
			int expected__ = 8;

			return verifyCase(casenum__, expected__, new ColumnDiagramPerimeter().getPerimiter(a));
		}
		case 3: {
			int[] a = { 1, 2, 1 };
			int expected__ = 10;

			return verifyCase(casenum__, expected__, new ColumnDiagramPerimeter().getPerimiter(a));
		}
		case 4: {
			int[] a = { 1, 2, 3 };
			int expected__ = 12;

			return verifyCase(casenum__, expected__, new ColumnDiagramPerimeter().getPerimiter(a));
		}

		// custom cases

		/*
		 * case 5: {
		 * int[] a = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ColumnDiagramPerimeter().getPerimiter(a));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] a = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ColumnDiagramPerimeter().getPerimiter(a));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] a = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ColumnDiagramPerimeter().getPerimiter(a));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
