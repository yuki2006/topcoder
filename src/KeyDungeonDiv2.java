// Paste me into the FileEdit configuration dialog
// SRM 588 DIV 2 - 250.0
public class KeyDungeonDiv2 {
	public int countDoors(int[] doorR, int[] doorG, int[] keys) {
		int count = 0;
		for (int i = 0; i < doorR.length; i++) {
			// ホワイトキーを使用する数
			int diff = doorR[i] - keys[0];
			if (diff < 0) {
				diff = 0;
			}
			int useWhite = keys[2] - diff;
			if (useWhite < 0) {
				continue;
			}

			if (doorG[i] - keys[1] - useWhite > 0) {
				continue;
			}
			count++;
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			KeyDungeonDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				KeyDungeonDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class KeyDungeonDiv2Harness {
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
			int[] doorR = { 2, 0, 5, 3 };
			int[] doorG = { 1, 4, 0, 2 };
			int[] keys = { 2, 3, 1 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new KeyDungeonDiv2().countDoors(doorR, doorG, keys));
		}
		case 1: {
			int[] doorR = { 0, 1, 2, 0 };
			int[] doorG = { 0, 2, 3, 1 };
			int[] keys = { 0, 0, 0 };
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new KeyDungeonDiv2().countDoors(doorR, doorG, keys));
		}
		case 2: {
			int[] doorR = { 3, 5, 4, 2, 8 };
			int[] doorG = { 4, 2, 3, 8, 1 };
			int[] keys = { 0, 0, 10 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new KeyDungeonDiv2().countDoors(doorR, doorG, keys));
		}
		case 3: {
			int[] doorR = { 4, 5, 4, 6, 8 };
			int[] doorG = { 2, 1, 2, 3, 5 };
			int[] keys = { 1, 2, 1 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new KeyDungeonDiv2().countDoors(doorR, doorG, keys));
		}
		case 4: {
			int[] doorR = { 41, 44, 41, 57, 58, 74, 84, 100, 58, 2, 43, 32, 82,
					97, 44, 13, 35, 98, 96, 81, 43, 77, 18, 51, 27, 27, 39, 39,
					45, 82, 59, 20, 28, 93, 6, 39, 64, 78, 28, 85, 17, 56, 3,
					68, 4, 0, 36, 80, 41, 77 };
			int[] doorG = { 67, 15, 53, 36, 88, 29, 26, 57, 68, 99, 97, 27, 51,
					70, 3, 49, 65, 75, 35, 92, 66, 0, 23, 96, 38, 86, 98, 31,
					26, 75, 30, 2, 92, 78, 100, 99, 38, 26, 85, 74, 77, 15, 16,
					48, 100, 88, 55, 93, 99, 54 };
			int[] keys = { 39, 31, 34 };
			int expected__ = 17;

			return verifyCase(casenum__, expected__,
					new KeyDungeonDiv2().countDoors(doorR, doorG, keys));
		}

		// custom cases

		/*
		 * case 5: { int[] doorR = ; int[] doorG = ; int[] keys = ; int
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KeyDungeonDiv2().countDoors(doorR, doorG, keys)); }
		 */
		/*
		 * case 6: { int[] doorR = ; int[] doorG = ; int[] keys = ; int
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KeyDungeonDiv2().countDoors(doorR, doorG, keys)); }
		 */
		/*
		 * case 7: { int[] doorR = ; int[] doorG = ; int[] keys = ; int
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KeyDungeonDiv2().countDoors(doorR, doorG, keys)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
