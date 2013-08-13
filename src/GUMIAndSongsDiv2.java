import java.util.ArrayList;
import java.util.Collections;

// Paste me into the FileEdit configuration dialog
// SRM 588 DIV 2 - 500.0

// 参考 http://82rensa.blogspot.jp/2013/08/srm588-div2-medium.html

public class GUMIAndSongsDiv2 {
	public int maxSongs(int[] duration, int[] tone, int T) {
		int max = 0;
		//ビットを使った全パターン検索を使用する。(2^15なので、計算量的には間に合う）
		for (int bit = 1 << duration.length; bit > 0; bit--) {
			int tmpSum = 0;
			ArrayList<Integer> dataList = new ArrayList<Integer>();

			for (int i = 0; i < duration.length; i++) {
				if ((1 << i & bit) > 0) {
					//durationはそのまま足す
					tmpSum += duration[i];
					dataList.add(tone[i]);
				}
				Collections.sort(dataList);
			}
			//Toneはソートして、下から順番に差分をとると最小になる。
			for (int i = 0; i < dataList.size() - 1; i++) {
				tmpSum += dataList.get(i + 1) - dataList.get(i);
			}
			//合計がT以下なら歌うことができる。
			if (tmpSum <= T) {
				//歌えた数を更新する
				max = Math.max(max, dataList.size());
			}
		}
		return max;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			GUMIAndSongsDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				GUMIAndSongsDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class GUMIAndSongsDiv2Harness {
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
			int[] duration = { 3, 5, 4, 11 };
			int[] tone = { 2, 1, 3, 1 };
			int T = 17;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new GUMIAndSongsDiv2().maxSongs(duration, tone, T));
		}
		case 1: {
			int[] duration = { 100, 200, 300 };
			int[] tone = { 1, 2, 3 };
			int T = 10;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new GUMIAndSongsDiv2().maxSongs(duration, tone, T));
		}
		case 2: {
			int[] duration = { 1, 2, 3, 4 };
			int[] tone = { 1, 1, 1, 1 };
			int T = 100;
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new GUMIAndSongsDiv2().maxSongs(duration, tone, T));
		}
		case 3: {
			int[] duration = { 10, 10, 10 };
			int[] tone = { 58, 58, 58 };
			int T = 30;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new GUMIAndSongsDiv2().maxSongs(duration, tone, T));
		}
		case 4: {
			int[] duration = { 8, 11, 7, 15, 9, 16, 7, 9 };
			int[] tone = { 3, 8, 5, 4, 2, 7, 4, 1 };
			int T = 14;
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new GUMIAndSongsDiv2().maxSongs(duration, tone, T));
		}
		case 5: {
			int[] duration = { 5611, 39996, 20200, 56574, 81643, 90131, 33486,
					99568, 48112, 97168, 5600, 49145, 73590, 3979, 94614 };
			int[] tone = { 2916, 53353, 64924, 86481, 44803, 61254, 99393,
					5993, 40781, 2174, 67458, 74263, 69710, 40044, 80853 };
			int T = 302606;
			int expected__ = 8;

			return verifyCase(casenum__, expected__,
					new GUMIAndSongsDiv2().maxSongs(duration, tone, T));
		}

		// custom cases

		/*
		 * case 6: { int[] duration = ; int[] tone = ; int T = ; int expected__
		 * = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * GUMIAndSongsDiv2().maxSongs(duration, tone, T)); }
		 */
		/*
		 * case 7: { int[] duration = ; int[] tone = ; int T = ; int expected__
		 * = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * GUMIAndSongsDiv2().maxSongs(duration, tone, T)); }
		 */
		/*
		 * case 8: { int[] duration = ; int[] tone = ; int T = ; int expected__
		 * = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * GUMIAndSongsDiv2().maxSongs(duration, tone, T)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
