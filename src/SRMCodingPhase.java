// Paste me into the FileEdit configuration dialog
// SRM 520 DIV 2 - 500.0
public class SRMCodingPhase {
	public int countScore(int[] points, int[] skills, int luck) {
		int max = 0;
		// １問目の問題を解くかどうか
		for (int i = 0; i < 2; i++) {
			// ２問目の問題を解くかどうか
			for (int j = 0; j < 2; j++) {
				// ３問目の問題を解くかどうか
				for (int k = 0; k < 2; k++) {

					int total = 0;
					int time = 0;
					//Luckyの値のコピーのため
					int l = luck;
					//それぞれの値が１なら問題を解く
					if (k == 1) {
						//Luckyをどれだけ使うか。
						//最低はskill -1 まで使えるので
						// 残っているluckとskill -1の小さい分を使う。						
						int x = Math.min(l, skills[2] - 1);
						//skillが減る
						int skill = skills[2] - x;
						//luckを減らします。
						l -= x;
						//時間をたす
						time += skill;
						//スコアをたす
						total += points[2] - 8 * skill;
					}
					if (j == 1) {
						int x = Math.min(l, skills[1] - 1);
						int skill = skills[1] - x;
						l -= x;
						time += skill;
						total += points[1] - 4 * skill;
					}
					if (i == 1) {
						int x = Math.min(l, skills[0] - 1);
						int skill = skills[0] - x;
						l -= x;
						time += skill;
						total += points[0] - 2 * skill;
					}
					if (time <= 75) {
						max = Math.max(total, max);
					}
				}
			}

		}
		return max;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SRMCodingPhaseHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SRMCodingPhaseHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SRMCodingPhaseHarness {
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
			int[] points = { 250, 500, 1000 };
			int[] skills = { 10, 25, 40 };
			int luck = 0;
			int expected__ = 1310;

			return verifyCase(casenum__, expected__,
					new SRMCodingPhase().countScore(points, skills, luck));
		}
		case 1: {
			int[] points = { 300, 600, 900 };
			int[] skills = { 30, 65, 90 };
			int luck = 25;
			int expected__ = 680;

			return verifyCase(casenum__, expected__,
					new SRMCodingPhase().countScore(points, skills, luck));
		}
		case 2: {
			int[] points = { 250, 550, 950 };
			int[] skills = { 10, 25, 40 };
			int luck = 75;
			int expected__ = 1736;

			return verifyCase(casenum__, expected__,
					new SRMCodingPhase().countScore(points, skills, luck));
		}
		case 3: {
			int[] points = { 256, 512, 1024 };
			int[] skills = { 35, 30, 25 };
			int luck = 0;
			int expected__ = 1216;

			return verifyCase(casenum__, expected__,
					new SRMCodingPhase().countScore(points, skills, luck));
		}
		case 4: {
			int[] points = { 300, 600, 1100 };
			int[] skills = { 80, 90, 100 };
			int luck = 4;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new SRMCodingPhase().countScore(points, skills, luck));
		}

		// custom cases

		/*
		 * case 5: { int[] points = ; int[] skills = ; int luck = ; int
		 * expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SRMCodingPhase().countScore(points, skills, luck)); }
		 */
		/*
		 * case 6: { int[] points = ; int[] skills = ; int luck = ; int
		 * expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SRMCodingPhase().countScore(points, skills, luck)); }
		 */
		/*
		 * case 7: { int[] points = ; int[] skills = ; int luck = ; int
		 * expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SRMCodingPhase().countScore(points, skills, luck)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
