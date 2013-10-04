// Paste me into the FileEdit configuration dialog
// Single Round Match 591 - Round 1500.0

public class ConvertibleStrings {
	/**
	 * 再帰的に、すべての文字列の順列を導く
	 * 
	 * @return 変換マトリックスの順列での最大値を求める。
	 */
	int combination(String a, String b, char[] cData, int count) {
		if (count == 0) {
			int total = 0;
			// 作成された変換マトリックスから、一致数を計算する。
			for (int i = 0; i < a.length(); i++) {
				if (cData[a.charAt(i) - 'A'] == b.charAt(i)) {
					total++;
				}
			}
			return total;
		} else {
			char[] tmpData = cData.clone();
			int max = 0;
			// 配列と現在の再帰数を利用して、順列の文字を生成する
			for (int i = 0; i < cData.length; i++) {
				if (tmpData[i] == 0) {
					tmpData[i] = (char) ('A' + count - 1);
					int ret = combination(a, b, tmpData, count - 1);
					max = Math.max(max, ret);
					tmpData = cData.clone();
				}
			}
			return max;
		}
	}

	public int leastRemovals(String A, String B) {
		char[] nums = new char[9];
		int max = combination(A, B, nums, nums.length);
		return A.length() - max;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ConvertibleStringsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ConvertibleStringsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ConvertibleStringsHarness {
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
			String A = "DD";
			String B = "FF";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new ConvertibleStrings().leastRemovals(A, B));
		}
		case 1: {
			String A = "AAAA";
			String B = "ABCD";
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new ConvertibleStrings().leastRemovals(A, B));
		}
		case 2: {
			String A = "AAIAIA";
			String B = "BCDBEE";
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new ConvertibleStrings().leastRemovals(A, B));
		}
		case 3: {
			String A = "ABACDCECDCDAAABBFBEHBDFDDHHD";
			String B = "GBGCDCECDCHAAIBBFHEBBDFHHHHE";
			int expected__ = 9;

			return verifyCase(casenum__, expected__, new ConvertibleStrings().leastRemovals(A, B));
		}

		// custom cases

		case 4: {
			String A = "AA";
			String B = "AA";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new
					ConvertibleStrings().leastRemovals(A, B));
		}
		/*
		 * case 5: {
		 * String A = ;
		 * String B = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ConvertibleStrings().leastRemovals(A, B));
		 * }
		 */
		/*
		 * case 6: {
		 * String A = ;
		 * String B = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ConvertibleStrings().leastRemovals(A, B));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
