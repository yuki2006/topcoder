// Paste me into the FileEdit configuration dialog
// SRM 508 DIV 2 - 250.0
public class CandyShop {
	private static final int CENTER = 200;

	public int countProbablePlaces(int[] X, int[] Y, int[] R) {
		int[][] map = new int[CENTER * 2 + 1][CENTER * 2 + 1];
		for (int i = 0; i < X.length; i++) {
			check(map, X[i], Y[i], R[i]);
		}

		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == R.length) {
					count++;
				}
			}
		}
		return count;
	}

	private int abs(int k) {
		return Math.abs(k);
	}

	private void check(int[][] map, int x, int y, int r) {
		for (int i = -r; i <= r; i++) {
			for (int j = -r; j <= r; j++) {
				if (abs(i + x) <= CENTER && abs(j + y) <= CENTER) {
					if (abs(i) + abs(j) <= r) {
						map[i + x + CENTER][j + y + CENTER]++;
					}
				}
			}
		}
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CandyShopHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CandyShopHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CandyShopHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
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
			int[] X = { 0 };
			int[] Y = { 0 };
			int[] R = { 1 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new CandyShop().countProbablePlaces(X, Y, R));
		}
		case 1: {
			int[] X = { 0 };
			int[] Y = { 0 };
			int[] R = { 2 };
			int expected__ = 13;

			return verifyCase(casenum__, expected__,
					new CandyShop().countProbablePlaces(X, Y, R));
		}
		case 2: {
			int[] X = { 2, 3 };
			int[] Y = { 1, -1 };
			int[] R = { 2, 2 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new CandyShop().countProbablePlaces(X, Y, R));
		}
		case 3: {
			int[] X = { 2, 3, 5 };
			int[] Y = { 1, -1, 0 };
			int[] R = { 2, 2, 3 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new CandyShop().countProbablePlaces(X, Y, R));
		}
		case 4: {
			int[] X = { -100, -100, -100, 0, 0, 0, 100, 100, 100 };
			int[] Y = { -100, 0, 100, -100, 0, 100, -100, 0, 100 };
			int[] R = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new CandyShop().countProbablePlaces(X, Y, R));
		}
		case 5: {
			int[] X = { -3, 3, 5, 5 };
			int[] Y = { 4, 5, -2, 0 };
			int[] R = { 10, 11, 8, 6 };
			int expected__ = 33;

			return verifyCase(casenum__, expected__,
					new CandyShop().countProbablePlaces(X, Y, R));
		}

		// custom cases

		/*
		 * case 6: { int[] X = ; int[] Y = ; int[] R = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CandyShop().countProbablePlaces(X, Y, R)); }
		 */
		/*
		 * case 7: { int[] X = ; int[] Y = ; int[] R = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CandyShop().countProbablePlaces(X, Y, R)); }
		 */
		/*
		 * case 8: { int[] X = ; int[] Y = ; int[] R = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CandyShop().countProbablePlaces(X, Y, R)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
