// Paste me into the FileEdit configuration dialog
// Single Round Match 581 - Round 1250.0

public class BlackAndWhiteSolitaire {
	public int minimumTurns(String cardFront) {
		char[] sequenceC = cardFront.toCharArray();
		boolean[] isWhitesequence = new boolean[sequenceC.length];
		for (int i = 0; i < cardFront.length(); i++) {
			isWhitesequence[i] = sequenceC[i] == 'W';
		}
		boolean current = true;
		int isFirstWCount = 0, isFirstBCount = 0;
		for (int i = 0; i < cardFront.length(); i++) {
			if (isWhitesequence[i] != current)
			{
				isFirstWCount++;
			}
			current = !current;
		}
		current = false;
		for (int i = 0; i < cardFront.length(); i++) {
			if (isWhitesequence[i] != current)
			{
				isFirstBCount++;
			}
			current = !current;
		}
		return Math.min(isFirstBCount, isFirstWCount);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BlackAndWhiteSolitaireHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BlackAndWhiteSolitaireHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BlackAndWhiteSolitaireHarness {
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
			String cardFront = "BBBW";
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new BlackAndWhiteSolitaire().minimumTurns(cardFront));
		}
		case 1: {
			String cardFront = "WBWBW";
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new BlackAndWhiteSolitaire().minimumTurns(cardFront));
		}
		case 2: {
			String cardFront = "WWWWWWWWW";
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new BlackAndWhiteSolitaire().minimumTurns(cardFront));
		}
		case 3: {
			String cardFront = "BBWBWWBWBWWBBBWBWBWBBWBBW";
			int expected__ = 10;

			return verifyCase(casenum__, expected__, new BlackAndWhiteSolitaire().minimumTurns(cardFront));
		}

		// custom cases

		/*
		 * case 4: {
		 * String cardFront = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * BlackAndWhiteSolitaire().minimumTurns(cardFront));
		 * }
		 */
		/*
		 * case 5: {
		 * String cardFront = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * BlackAndWhiteSolitaire().minimumTurns(cardFront));
		 * }
		 */
		/*
		 * case 6: {
		 * String cardFront = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * BlackAndWhiteSolitaire().minimumTurns(cardFront));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
