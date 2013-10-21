// Paste me into the FileEdit configuration dialog
// SRM 510 DIV 2 - 500.0

public class TheLuckyGameDivTwo {
	public int find(int a, int b, int jLen, int bLen) {
		int[] sum = new int[b + 1];
		for (int i = 0; i < b; i++) {
			sum[i + 1] = sum[i] + (isLuckyNumber(i + 1) ? 1 : 0);
		}
		int johnMax = 0;
		for (int john = a; john + (jLen - 1) <= b; john++) {
			int brusMin = Integer.MAX_VALUE;
			for (int brus = john; brus + bLen <= john + jLen; brus++) {
				brusMin = Math.min(brusMin, sum[brus + bLen - 1] - sum[brus - 1]);
			}
			johnMax = Math.max(johnMax, brusMin);
		}
		return johnMax;
	}

	boolean isLuckyNumber(int n) {
		char[] cs = String.valueOf(n).toCharArray();
		for (char c : cs) {
			if (!(c == '4' || c == '7')) {
				return false;
			}
		}
		return true;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheLuckyGameDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheLuckyGameDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheLuckyGameDivTwoHarness {
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
			int a = 1;
			int b = 10;
			int jLen = 2;
			int bLen = 1;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		}
		case 1: {
			int a = 1;
			int b = 100;
			int jLen = 100;
			int bLen = 100;
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		}
		case 2: {
			int a = 4;
			int b = 8;
			int jLen = 3;
			int bLen = 2;
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		}
		case 3: {
			int a = 1;
			int b = 100;
			int jLen = 75;
			int bLen = 50;
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		}

		// custom cases

		case 4: {
			int a = 2027;
			int b = 3742;
			int jLen = 1379;
			int bLen = 638;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new
					TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		}

		case 5: {
			int a = 1;
			int b = 4747;
			int jLen = 4747;
			int bLen = 4747;
			int expected__ = 20;

			return verifyCase(casenum__, expected__, new
					TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		}

		/*
		 * case 6: {
		 * int a = ;
		 * int b = ;
		 * int jLen = ;
		 * int bLen = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheLuckyGameDivTwo().find(a, b, jLen, bLen));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
