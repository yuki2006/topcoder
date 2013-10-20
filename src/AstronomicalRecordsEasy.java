import java.util.HashSet;

// Paste me into the FileEdit configuration dialog
// Single Round Match 594 - Round 1500.0

public class AstronomicalRecordsEasy {
	public int minimalPlanets(int[] A, int[] B) {
		int min = 50 * 50;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int m = lcs(A[i], B[j]);
				int size = getSize(A, m / A[i], B, m / B[j]);
				min = Math.min(size, min);
			}
		}
		return min;
	}

	int getSize(int[] A, int i1, int[] B, int i2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int j = 0; j < A.length; j++) {
			set.add(A[j] * i1);
		}
		for (int j = 0; j < B.length; j++) {
			set.add(B[j] * i2);
		}
		return set.size();
	}

	int lcs(int a, int b) {
		return a * b / gcd(a, b);
	}

	int gcd(int a, int b) {
		int c = 0;
		while ((c = a % b) > 0) {
			a = b;
			b = c;
			c = a / b;
		}
		return b;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			AstronomicalRecordsEasyHarness.run_test(7);
		} else {
			for (int i = 0; i < args.length; ++i)
				AstronomicalRecordsEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class AstronomicalRecordsEasyHarness {
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
			int[] A = { 1, 2, 3, 4 };
			int[] B = { 2, 3, 4, 5 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		case 1: {
			int[] A = { 1, 2, 3, 4 };
			int[] B = { 2, 4, 6, 8 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		case 2: {
			int[] A = { 1, 2, 3, 5, 6, 8, 9 };
			int[] B = { 2, 4, 5, 6, 7, 8, 9 };
			int expected__ = 9;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		case 3: {
			int[] A = { 1, 2, 3, 4 };
			int[] B = { 6, 7, 8, 9 };
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		case 4: {
			int[] A = { 200, 500 };
			int[] B = { 100, 200, 300, 400, 600, 700, 800, 900 };
			int expected__ = 9;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		case 5: {
			int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
			int[] B = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
			int expected__ = 19;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		case 6: {
			int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
			int[] B = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
			int expected__ = 15;

			return verifyCase(casenum__, expected__, new AstronomicalRecordsEasy().minimalPlanets(A, B));
		}
		// custom cases

		case 7: {
			int[] A = { 285, 475, 570, 585, 780, 855 };
			int[] B = { 156, 312, 416 };
			int expected__ = 7;

			return verifyCase(casenum__, expected__, new
					AstronomicalRecordsEasy().minimalPlanets(A, B));
		}

		/*
		 * case 7: {
		 * int[] A = ;
		 * int[] B = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AstronomicalRecordsEasy().minimalPlanets(A, B));
		 * }
		 */
		/*
		 * case 8: {
		 * int[] A = ;
		 * int[] B = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AstronomicalRecordsEasy().minimalPlanets(A, B));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
