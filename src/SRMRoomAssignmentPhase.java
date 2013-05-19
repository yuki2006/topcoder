import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 520 DIV 2 - 250.0
public class SRMRoomAssignmentPhase {
	public int countCompetitors(int[] ratings, int K) {
		int myScore = ratings[0];
		//まずソートする。
		Arrays.sort(ratings);
		// グループごとのスコアを計算　
		for (int i = 0; i < ratings.length; i++) {
			// 配列の最後からi番目をみることでスコアが高い順にみてる
			int lastIndex = ratings.length - i - 1;
			// 自分の場所をみつけたらグループ内で何番目かを返す。
			if (ratings[lastIndex] == myScore) {
				return i / K;
			}
		}
		return -1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SRMRoomAssignmentPhaseHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SRMRoomAssignmentPhaseHarness
						.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SRMRoomAssignmentPhaseHarness {
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
			int[] ratings = { 491, 981, 1199, 763, 994, 879, 888 };
			int K = 3;
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new SRMRoomAssignmentPhase().countCompetitors(ratings, K));
		}
		case 1: {
			int[] ratings = { 1024, 1000, 600 };
			int K = 1;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new SRMRoomAssignmentPhase().countCompetitors(ratings, K));
		}
		case 2: {
			int[] ratings = { 505, 679, 900, 1022 };
			int K = 2;
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new SRMRoomAssignmentPhase().countCompetitors(ratings, K));
		}
		case 3: {
			int[] ratings = { 716, 58, 1000, 1004, 912, 822, 453, 1100, 558 };
			int K = 3;
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new SRMRoomAssignmentPhase().countCompetitors(ratings, K));
		}
		case 4: {
			int[] ratings = { 422, 623, 1023, 941, 882, 776, 852, 495, 803,
					622, 618, 532, 751, 500 };
			int K = 4;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new SRMRoomAssignmentPhase().countCompetitors(ratings, K));
		}
		case 5: {
			int[] ratings = { 1197, 1198, 1196, 1195, 1199 };
			int K = 1;
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new SRMRoomAssignmentPhase().countCompetitors(ratings, K));
		}

		// custom cases

		/*
		 * case 6: { int[] ratings = ; int K = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SRMRoomAssignmentPhase().countCompetitors(ratings, K)); }
		 */
		/*
		 * case 7: { int[] ratings = ; int K = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SRMRoomAssignmentPhase().countCompetitors(ratings, K)); }
		 */
		/*
		 * case 8: { int[] ratings = ; int K = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SRMRoomAssignmentPhase().countCompetitors(ratings, K)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
