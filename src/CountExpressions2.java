// Paste me into the FileEdit configuration dialog
// Test SRM - Test SRM450.0

public class CountExpressions2 {
	/**
	 * 引数として渡した値の各ビットで１の値の総数を返します。 ただし、正の数を対象とします。
	 *
	 * @param num
	 *            ビットを数える値
	 * @return ビットの数を返します。
	 */
	public static int bitcount(int num) {
		int count = 0;
		while (num > 0) {
			count += num % 2;
			num /= 2;
		}
		return count;
	}

	public int calcExpressions(int x, int y, int val) {
		int count = 0;
		for (int i = 0; i < 16; i++) {
			if (bitcount(i) == 2) {
				for (int j = 0; j < 27; j++) {
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						int tmp = testBit(i, k) ? x : y;
						if (k > 0) {
							int tmpJ = j;
							for (int l = 0; l < k; l++) {
								tmpJ /= 3;
							}
							tmpJ = tmpJ % 3;
							if (tmpJ == 0) {
								sum += tmp;
							} else if (tmpJ == 1) {
								sum -= tmp;
							} else {
								sum *= tmp;
							}
						} else {
							sum = tmp;
						}
					}
					if (sum == val) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private boolean testBit(int i, int c) {
		return (i & (1 << c)) > 0;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CountExpressions2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CountExpressions2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CountExpressions2Harness {
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
			int x = 7;
			int y = 8;
			int val = 16;
			int expected__ = 9;

			return verifyCase(casenum__, expected__, new CountExpressions2().calcExpressions(x, y, val));
		}
		case 1: {
			int x = 3;
			int y = 5;
			int val = 7;
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new CountExpressions2().calcExpressions(x, y, val));
		}
		case 2: {
			int x = 99;
			int y = 100;
			int val = 98010000;
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new CountExpressions2().calcExpressions(x, y, val));
		}
		case 3: {
			int x = -99;
			int y = 42;
			int val = -1764;
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new CountExpressions2().calcExpressions(x, y, val));
		}
		case 4: {
			int x = 100;
			int y = -100;
			int val = -100000000;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new CountExpressions2().calcExpressions(x, y, val));
		}
		case 5: {
			int x = 1;
			int y = 2;
			int val = 5;
			int expected__ = 17;

			return verifyCase(casenum__, expected__, new CountExpressions2().calcExpressions(x, y, val));
		}

		// custom cases

		/*
		 * case 6: {
		 * int x = ;
		 * int y = ;
		 * int val = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CountExpressions2().calcExpressions(x, y, val));
		 * }
		 */
		/*
		 * case 7: {
		 * int x = ;
		 * int y = ;
		 * int val = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CountExpressions2().calcExpressions(x, y, val));
		 * }
		 */
		/*
		 * case 8: {
		 * int x = ;
		 * int y = ;
		 * int val = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CountExpressions2().calcExpressions(x, y, val));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
