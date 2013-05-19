// Paste me into the FileEdit configuration dialog

public class PenguinTiles {
	public int minMoves(String[] tiles) {
		for (int i = 0; i < tiles.length; i++) {
			int indexOf = tiles[i].indexOf(".");
			if (indexOf >= 0) {
				int ret = 0;
				if (indexOf < tiles[i].length() - 1) {
					ret++;
				}
				if (i < tiles.length - 1) {
					ret++;
				}
				return ret;
			}
		}
		return 0;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PenguinTilesHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PenguinTilesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PenguinTilesHarness {
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
			String[] tiles = { "PP", "P." };
			int expected__ = 0;

			return verifyCase(casenum, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 1: {
			String[] tiles = { "PPPPPPPP", ".PPPPPPP" };
			int expected__ = 1;

			return verifyCase(casenum, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 2: {
			String[] tiles = { "PPP", "P.P", "PPP" };
			int expected__ = 2;

			return verifyCase(casenum, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 3: {
			String[] tiles = { "P.", "PP", "PP", "PP" };
			int expected__ = 1;

			return verifyCase(casenum, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 4: {
			String[] tiles = { ".PPP", "PPPP", "PPPP", "PPPP" };
			int expected__ = 2;

			return verifyCase(casenum, expected__, new PenguinTiles().minMoves(tiles));
		}

		// custom cases

		/*
		 * case 5: {
		 * String[] tiles = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * PenguinTiles().minMoves(tiles));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] tiles = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * PenguinTiles().minMoves(tiles));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] tiles = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * PenguinTiles().minMoves(tiles));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
