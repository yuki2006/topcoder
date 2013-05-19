// Paste me into the FileEdit configuration dialog
// Single Round Match 578 - Round 1500.0

public class GooseInZooDivTwo {
	private String[] field;

	public int count(String[] field, int dist) {
		this.field = field;
		boolean[][] checked = new boolean[field.length][field[0].length()];
		int count = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length(); j++) {
				if (field[i].charAt(j) == 'v') {
					if (!checked[i][j]) {
						check(checked, i, j, dist);
						count++;
					}
				}
			}
		}
		if (count == 0) {
			return 0;
		}
		int mod = 1000000007;
		int result = 1;
		for (int i = 0; i < count; i++) {
			result = (result * 2) % mod;
		}
		// もしresultが0だったとき-1になるので（数学的にありえるかどうかは不明）
		// なくてもシステムテストには通った！！
		result = (result - 1 + mod) % mod;
		return result;
	}

	private void check(boolean[][] checked, int i, int j, int dist) {
		if (checked[i][j]) {
			return;
		}
		checked[i][j] = true;
		for (int dx = -dist; dx <= dist; dx++) {
			for (int dy = -dist; dy <= dist; dy++) {
				if (Math.abs(dx) + Math.abs(dy) <= dist) {
					int i2 = i + dx, j2 = j + dy;
					if (i2 >= 0 && i2 < checked.length && j2 >= 0
							&& j2 < checked[0].length) {
						if (field[i2].charAt(j2) == 'v') {
							check(checked, i2, j2, dist);
						}
					}
				}
			}
		}
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			GooseInZooDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				GooseInZooDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class GooseInZooDivTwoHarness {
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
			String[] field = { "vvv" };
			int dist = 0;
			int expected__ = 7;

			return verifyCase(casenum__, expected__,
					new GooseInZooDivTwo().count(field, dist));
		}
		case 1: {
			String[] field = { "." };
			int dist = 100;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new GooseInZooDivTwo().count(field, dist));
		}
		case 2: {
			String[] field = { "vvv" };
			int dist = 1;
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new GooseInZooDivTwo().count(field, dist));
		}
		case 3: {
			String[] field = {
					"v.v..................v............................",
					".v......v..................v.....................v",
					"..v.....v....v.........v...............v......v...",
					".........vvv...vv.v.........v.v..................v",
					".....v..........v......v..v...v.......v...........",
					"...................vv...............v.v..v.v..v...",
					".v.vv.................v..............v............",
					"..vv.......v...vv.v............vv.....v.....v.....",
					"....v..........v....v........v.......v.v.v........",
					".v.......v.............v.v..........vv......v.....",
					"....v.v.......v........v.....v.................v..",
					"....v..v..v.v..............v.v.v....v..........v..",
					"..........v...v...................v..............v",
					"..v........v..........................v....v..v...",
					"....................v..v.........vv........v......",
					"..v......v...............................v.v......",
					"..v.v..............v........v...............vv.vv.",
					"...vv......v...............v.v..............v.....",
					"............................v..v.................v",
					".v.............v.......v..........................",
					"......v...v........................v..............",
					".........v.....v..............vv..................",
					"................v..v..v.........v....v.......v....",
					"........v.....v.............v......v.v............",
					"...........v....................v.v....v.v.v...v..",
					"...........v......................v...v...........",
					"..........vv...........v.v.....................v..",
					".....................v......v............v...v....",
					".....vv..........................vv.v.....v.v.....",
					".vv.......v...............v.......v..v.....v......",
					"............v................v..........v....v....",
					"................vv...v............................",
					"................v...........v........v...v....v...",
					"..v...v...v.............v...v........v....v..v....",
					"......v..v.......v........v..v....vv..............",
					"...........v..........v........v.v................",
					"v.v......v................v....................v..",
					".v........v................................v......",
					"............................v...v.......v.........",
					"........................vv.v..............v...vv..",
					".......................vv........v.............v..",
					"...v.............v.........................v......",
					"....v......vv...........................v.........",
					"....vv....v................v...vv..............v..",
					"..................................................",
					"vv........v...v..v.....v..v..................v....",
					".........v..............v.vv.v.............v......",
					".......v.....v......v...............v.............",
					"..v..................v................v....v......",
					".....v.....v.....................v.v......v......." };
			int dist = 3;
			int expected__ = 797922654;

			return verifyCase(casenum__, expected__,
					new GooseInZooDivTwo().count(field, dist));
		}

		// custom cases

		/*
		 * case 4: { String[] field = ; int dist = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * GooseInZooDivTwo().count(field, dist)); }
		 */
		/*
		 * case 5: { String[] field = ; int dist = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * GooseInZooDivTwo().count(field, dist)); }
		 */
		/*
		 * case 6: { String[] field = ; int dist = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * GooseInZooDivTwo().count(field, dist)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
