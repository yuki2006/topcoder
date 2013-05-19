// Paste me into the FileEdit configuration dialog
// SRM 428 DIV 2 - 250.0

public class ThePalindrome {
	public int find(String s) {
		char[] charArray = s.toCharArray();
		// マッチする長さ
		for (int i = charArray.length - 1; i >= 0; i--) {
			// 比較する箇所
			boolean isAllHit = true;
			for (int j = 0; j < i; j++) {
				// 元の文字と　　　ひっくりがえした文字との最長一致を計算する。
				if (charArray[charArray.length - j - 1] != charArray[charArray.length - i + j - 1]) {
					isAllHit = false;
					break;
				}
			}
			if (isAllHit) {
				return 2 * s.length() - (i + 1);
			}
		}
		return -1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ThePalindromeHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ThePalindromeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ThePalindromeHarness {
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
			String s = "abab";
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}
		case 1: {
			String s = "abacaba";
			int expected__ = 7;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}
		case 2: {
			String s = "qwerty";
			int expected__ = 11;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}
		case 3: {
			String s = "abdfhdyrbdbsdfghjkllkjhgfds";
			int expected__ = 38;

			return verifyCase(casenum__, expected__, new ThePalindrome().find(s));
		}

		// custom cases

		/*
		 * case 4: {
		 * String s = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ThePalindrome().find(s));
		 * }
		 */
		/*
		 * case 5: {
		 * String s = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ThePalindrome().find(s));
		 * }
		 */
		/*
		 * case 6: {
		 * String s = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * ThePalindrome().find(s));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
