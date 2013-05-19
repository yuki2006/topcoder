// Paste me into the FileEdit configuration dialog

public class CuttingBitString {
	String[] powList = new String[8];
	{
		int tmp = 1;
		powList[0] = "1";
		for (int i = 1; i < powList.length; i++) {
			tmp *= 5;
			powList[i] = Integer.toBinaryString(tmp);
		}
	}

	public int getmin(String S) {

		return recursive(S);
	}

	private int recursive(String S) {
		if (S.length() == 0) {
			return 0;
		}
		System.err.println(S);
		int min = Integer.MAX_VALUE;
		int pointer = 0;
		for (int i = powList.length - 1; i >= 0; i--) {
			if (S.startsWith(powList[i])) {
				String tmp = S.substring(powList[i].length());
				if (tmp.length() > 0) {
					int a = recursive(tmp);
					if (a != -1 && a < min) {
						min = a +1;
						pointer = i;
					}
				} else {
					min = 1;
					pointer = i;
				}
			}
		}
		if (min==Integer.MAX_VALUE ){
			return -1;
		}

		return min;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CuttingBitStringHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CuttingBitStringHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CuttingBitStringHarness {
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
			String S = "101101101";
			int expected__ = 3;

			return verifyCase(casenum, expected__, new CuttingBitString().getmin(S));
		}
		case 1: {
			String S = "1111101";
			int expected__ = 1;

			return verifyCase(casenum, expected__, new CuttingBitString().getmin(S));
		}
		case 2: {
			String S = "00000";
			int expected__ = -1;

			return verifyCase(casenum, expected__, new CuttingBitString().getmin(S));
		}
		case 3: {
			String S = "110011011";
			int expected__ = 3;

			return verifyCase(casenum, expected__, new CuttingBitString().getmin(S));
		}
		case 4: {
			String S = "1000101011";
			int expected__ = -1;

			return verifyCase(casenum, expected__, new CuttingBitString().getmin(S));
		}
		case 5: {
			String S = "111011100110101100101110111";
			int expected__ = 5;

			return verifyCase(casenum, expected__, new CuttingBitString().getmin(S));
		}

		// custom cases

		/*
		 * case 6: {
		 * String S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * CuttingBitString().getmin(S));
		 * }
		 */
		/*
		 * case 7: {
		 * String S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * CuttingBitString().getmin(S));
		 * }
		 */
		/*
		 * case 8: {
		 * String S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * CuttingBitString().getmin(S));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
