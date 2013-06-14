import java.util.Arrays;
import java.util.HashMap;

// Paste me into the FileEdit configuration dialog
// Single Round Match 581 - Round 1 500.0
/**
 * @author yuki
 *
 */
public class SurveillanceSystem {
	public String getContainerInfo(String containers, int[] reports, int L) {
		int length = containers.length();
		// Containerをフォーカスしてる数を連想配列でまとめる
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int report : reports) {
			Integer value = 0;
			if (map.containsKey(report)) {
				value = map.get(report);
			}
			map.put(report, value + 1);
		}
		// カメラをおいた時のフォーカスの数を求める配列。
		int[] focusContainers = new int[length];
		for (int i = 0; i <= length - L; i++) {
			int container = 0;
			for (int j = 0; j < L; j++) {
				if (i + j < length && containers.charAt(i + j) == 'X') {
					container++;
				}
			}
			focusContainers[i] = container;
		}
		char[] c = new char[length];
		// 結果のchar配列をすべて – で初期化しておく。
		Arrays.fill(c, '-');
		for (Integer focus : map.keySet()) {
			int[] focuses = new int[length];
			int m = map.get(focus);
			// カメラのポジションの候補探す（候補がn 箇所）
			int n = 0;
			for (int i = 0; i <= length - L; i++) {
				if (focusContainers[i] == focus) {
					n++;
					for (int j = 0; j < L; j++) {
						focuses[i + j]++;
					}
				}
			}
			for (int i = 0; i < focuses.length; i++) {
				if (focuses[i] >= n - m + 1) {
					// (n-m)+1個以上フォーカスされている時 その配列の場所は＋に書き換える。
					c[i] = '+';
				} else if (focuses[i] >= 1 && c[i] == '-') {
					// 1個以上フォーカスされている時
					// 配列のその場所が–のときは？に書き換える。
					c[i] = '?';
				}
			}
		}
		return new String(c);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SurveillanceSystemHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SurveillanceSystemHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SurveillanceSystemHarness {
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

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			String containers = "-X--XX";
			int[] reports = { 1, 2 };
			int L = 3;
			String expected__ = "??++++";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 1: {
			String containers = "-XXXXX-";
			int[] reports = { 2 };
			int L = 3;
			String expected__ = "???-???";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 2: {
			String containers = "------X-XX-";
			int[] reports = { 3, 0, 2, 0 };
			int L = 5;
			String expected__ = "++++++++++?";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 3: {
			String containers = "-XXXXX---X--";
			int[] reports = { 2, 1, 0, 1 };
			int L = 3;
			String expected__ = "???-??++++??";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 4: {
			String containers = "-XX--X-XX-X-X--X---XX-X---XXXX-----X";
			int[] reports = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			int L = 7;
			String expected__ = "???++++?++++++++++++++++++++??????--";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}

		// custom cases

		/*
		 * case 5: {
		 * String containers = ;
		 * int[] reports = ;
		 * int L = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SurveillanceSystem().getContainerInfo(containers, reports, L));
		 * }
		 */
		/*
		 * case 6: {
		 * String containers = ;
		 * int[] reports = ;
		 * int L = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SurveillanceSystem().getContainerInfo(containers, reports, L));
		 * }
		 */
		/*
		 * case 7: {
		 * String containers = ;
		 * int[] reports = ;
		 * int L = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SurveillanceSystem().getContainerInfo(containers, reports, L));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
