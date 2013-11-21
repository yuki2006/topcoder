// Paste me into the FileEdit configuration dialog
// SRM 350 DIV 2 - 250.0

public class DistanceBetweenStrings {
	public int getDistance(String a, String b, String letterSet) {
		int sum = 0;
		for (int i = 0; i < letterSet.length(); i++) {
			int n1 = 0, n2 = 0;
			char c = letterSet.charAt(i);
			for (int j = 0; j < a.length(); j++) {
				if (Character.toLowerCase(a.charAt(j)) == c) {
					n1++;
				}
			}
			for (int j = 0; j < b.length(); j++) {
				if (Character.toLowerCase(b.charAt(j)) == c) {
					n2++;
				}
			}
			sum += (n1 - n2) * (n1 - n2);
		}
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DistanceBetweenStringsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DistanceBetweenStringsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DistanceBetweenStringsHarness {
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
			String a = "topcoder";
			String b = "contest";
			String letterSet = "tcp";
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new DistanceBetweenStrings().getDistance(a, b, letterSet));
		}
		case 1: {
			String a = "abcdef";
			String b = "fedcba";
			String letterSet = "fed";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new DistanceBetweenStrings().getDistance(a, b, letterSet));
		}
		case 2: {
			String a = "aaaaa";
			String b = "bbbbb";
			String letterSet = "a";
			int expected__ = 25;

			return verifyCase(casenum__, expected__, new DistanceBetweenStrings().getDistance(a, b, letterSet));
		}
		case 3: {
			String a = "aaAaB";
			String b = "BbaAa";
			String letterSet = "ab";
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new DistanceBetweenStrings().getDistance(a, b, letterSet));
		}
		case 4: {
			String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			String b = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
			String letterSet = "ba";
			int expected__ = 5000;

			return verifyCase(casenum__, expected__, new DistanceBetweenStrings().getDistance(a, b, letterSet));
		}
		case 5: {
			String a = "ToPcOdEr";
			String b = "tOpCoDeR";
			String letterSet = "wxyz";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new DistanceBetweenStrings().getDistance(a, b, letterSet));
		}

		// custom cases

		/*
		 * case 6: {
		 * String a = ;
		 * String b = ;
		 * String letterSet = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DistanceBetweenStrings().getDistance(a, b, letterSet));
		 * }
		 */
		/*
		 * case 7: {
		 * String a = ;
		 * String b = ;
		 * String letterSet = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DistanceBetweenStrings().getDistance(a, b, letterSet));
		 * }
		 */
		/*
		 * case 8: {
		 * String a = ;
		 * String b = ;
		 * String letterSet = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DistanceBetweenStrings().getDistance(a, b, letterSet));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
