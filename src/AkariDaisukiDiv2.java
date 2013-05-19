
// Paste me into the FileEdit configuration dialog

public class AkariDaisukiDiv2 {

	public int countTuples(String S) {
		int result = 0;
		for (int i =1; i < S.length() - 1; i++) {
			for (int j = 1; i + j < S.length() - 1; j++) {
				for (int k = i + j + 1; k + j < S.length(); k++)
					if (S.substring(i, i + j).equals(S.substring(k, k + j))) {
						result++;
					}
			}

		}
		return result;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			AkariDaisukiDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				AkariDaisukiDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CzUT HERE
class AkariDaisukiDiv2Harness {
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
			String S = "topcoderdivtwo";
			int expected__ = 2;

			return verifyCase(casenum, expected__, new AkariDaisukiDiv2().countTuples(S));
		}
		case 1: {
			String S = "foxciel";
			int expected__ = 0;

			return verifyCase(casenum, expected__, new AkariDaisukiDiv2().countTuples(S));
		}
		case 2: {
			String S = "magicalgirl";
			int expected__ = 4;

			return verifyCase(casenum, expected__, new AkariDaisukiDiv2().countTuples(S));
		}
		case 3: {
			String S = "waaiusushioakariusushiodaisuki";
			int expected__ = 75;

			return verifyCase(casenum, expected__, new AkariDaisukiDiv2().countTuples(S));
		}
		case 4: {
			String S = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			int expected__ = 8924;

			return verifyCase(casenum, expected__, new AkariDaisukiDiv2().countTuples(S));
		}

		// custom cases

		/*
		 * case 5: {
		 * String S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * AkariDaisukiDiv2().countTuples(S));
		 * }
		 */
		/*
		 * case 6: {
		 * String S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * AkariDaisukiDiv2().countTuples(S));
		 * }
		 */
		/*
		 * case 7: {
		 * String S = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * AkariDaisukiDiv2().countTuples(S));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
