// Paste me into the FileEdit configuration dialog

public class TwoRectangles {
	public String describeIntersection(int[] A, int[] B) {

		boolean bool = false;
		do {
			int C[] = bool ? A : B;
			int D[] = !bool ? A : B;

			if (C[2] < D[0] || C[3] < D[1]) {
				return "none";
			}

			if (C[2] == D[0] && C[1] == D[3] || D[2] == C[0] && D[3] == C[1]) {
				return "point";
			}
			if (D[1] <= C[1] && C[1] <= D[3] && C[0] == D[2] ||
					D[0] <= C[0] && C[0] <= D[2] && C[1] == D[3]) {
				return "segment";
			}

			bool = !bool;
		} while (bool);
		return "rectangle";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TwoRectanglesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TwoRectanglesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TwoRectanglesHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			int[] A = { 0, 0, 3, 2 };
			int[] B = { 1, 1, 5, 3 };
			String expected__ = "rectangle";

			return verifyCase(casenum, expected__, new TwoRectangles().describeIntersection(A, B));
		}
		case 1: {
			int[] A = { 0, 0, 5, 3 };
			int[] B = { 1, 2, 2, 3 };
			String expected__ = "rectangle";

			return verifyCase(casenum, expected__, new TwoRectangles().describeIntersection(A, B));
		}
		case 2: {
			int[] A = { 1, 1, 6, 2 };
			int[] B = { 3, 2, 5, 4 };
			String expected__ = "segment";

			return verifyCase(casenum, expected__, new TwoRectangles().describeIntersection(A, B));
		}
		case 3: {
			int[] A = { 0, 1, 2, 3 };
			int[] B = { 2, 0, 5, 2 };
			String expected__ = "segment";

			return verifyCase(casenum, expected__, new TwoRectangles().describeIntersection(A, B));
		}
		case 4: {
			int[] A = { 0, 0, 1, 1 };
			int[] B = { 1, 1, 5, 2 };
			String expected__ = "point";

			return verifyCase(casenum, expected__, new TwoRectangles().describeIntersection(A, B));
		}
		case 5: {
			int[] A = { 1, 1, 2, 2 };
			int[] B = { 3, 1, 4, 2 };
			String expected__ = "none";

			return verifyCase(casenum, expected__, new TwoRectangles().describeIntersection(A, B));
		}

		// custom cases


		  case 6: {
		  int[] A = {424, 308, 599, 521};
		  int[] B = {599, 279, 846, 308};
		  String expected__ = "point";

		  return verifyCase(casenum, expected__, new
		  TwoRectangles().describeIntersection(A, B));
		  }


		  case 7: {
		  int[] A = {13, 522, 545, 899};
		  int[] B ={545, 827, 589, 921} ;
		  String expected__ ="segment" ;

		  return verifyCase(casenum, expected__, new
		  TwoRectangles().describeIntersection(A, B));
		  }

		/*
		 * case 8: {
		 * int[] A = ;
		 * int[] B = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TwoRectangles().describeIntersection(A, B));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
