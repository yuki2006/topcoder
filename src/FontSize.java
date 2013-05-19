// Paste me into the FileEdit configuration dialog

public class FontSize {
	public int getPixelWidth(String sentence, int[] uppercase, int[] lowercase) {
		char[] charArray = sentence.toCharArray();
		int sum = 0;
		for (char c : charArray) {
			if (sum > 0) {
				sum++;
			}
			if ('A' <= c && c <= 'Z') {
				sum += uppercase[c - 'A'];
			}
			if ('a' <= c && c <= 'z') {
				sum += lowercase[c - 'a'];
			}
			if (c==' '){
				sum+=3;
			}
		}
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FontSizeHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FontSizeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FontSizeHarness {
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
			String sentence = "Dead Beef";
			int[] uppercase = { 6, 6, 6, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
			int[] lowercase = { 5, 5, 5, 4, 4, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
			int expected__ = 49;

			return verifyCase(casenum__, expected__, new FontSize().getPixelWidth(sentence, uppercase, lowercase));
		}
		case 1: {
			String sentence = "Hello World";
			int[] uppercase = { 7, 8, 8, 8, 7, 8, 8, 8, 7, 8, 8, 8, 8, 8, 7, 8, 8, 8, 8, 8, 7, 8, 8, 8, 8, 8 };
			int[] lowercase = { 5, 6, 6, 6, 5, 6, 6, 6, 5, 6, 6, 6, 6, 6, 5, 6, 6, 6, 6, 6, 5, 6, 6, 6, 6, 6 };
			int expected__ = 74;

			return verifyCase(casenum__, expected__, new FontSize().getPixelWidth(sentence, uppercase, lowercase));
		}
		case 2: {
			String sentence = "Hello World";
			int[] uppercase = { 7, 7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 7, 7, 7 };
			int[] lowercase = { 5, 5, 5, 6, 6, 5, 5, 5, 5, 5, 5, 1, 5, 5, 6, 5, 5, 6, 5, 5, 5, 5, 5, 5, 5, 5 };
			int expected__ = 63;

			return verifyCase(casenum__, expected__, new FontSize().getPixelWidth(sentence, uppercase, lowercase));
		}
		case 3: {
			String sentence = "ThE qUiCk BrOwN fOx JuMpEd OvEr ThE lAzY dOg";
			int[] uppercase = { 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15,
					14, 13, 12, 11 };
			int[] lowercase = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
					25, 26 };
			int expected__ = 778;

			return verifyCase(casenum__, expected__, new FontSize().getPixelWidth(sentence, uppercase, lowercase));
		}
		case 4: {
			String sentence = "two  spaces";
			int[] uppercase = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
			int[] lowercase = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			int expected__ = 43;

			return verifyCase(casenum__, expected__, new FontSize().getPixelWidth(sentence, uppercase, lowercase));
		}

		// custom cases

		/*
		 * case 5: {
		 * String sentence = ;
		 * int[] uppercase = ;
		 * int[] lowercase = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FontSize().getPixelWidth(sentence, uppercase, lowercase));
		 * }
		 */
		/*
		 * case 6: {
		 * String sentence = ;
		 * int[] uppercase = ;
		 * int[] lowercase = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FontSize().getPixelWidth(sentence, uppercase, lowercase));
		 * }
		 */
		/*
		 * case 7: {
		 * String sentence = ;
		 * int[] uppercase = ;
		 * int[] lowercase = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FontSize().getPixelWidth(sentence, uppercase, lowercase));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
