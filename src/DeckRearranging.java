import java.util.ArrayList;

// Paste me into the FileEdit configuration dialog
// SRM 420 DIV 2 - 250.0

public class DeckRearranging {
	public String rearrange(String deck, int[] above) {
		char[] resultChars = new char[deck.length()];
		char[] charArray = deck.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			for (int j = resultChars.length - 1; j >= above[i] + 1; j--) {
				resultChars[j] = resultChars[j - 1];
			}
			resultChars[above[i]] = charArray[i];
		}
		return new String(resultChars);
	}

	public String rearrange2(String deck, int[] above) {
		ArrayList<Character> characters = new ArrayList<Character>();
		char[] charArray = deck.toCharArray();
		for (int i = 0; i < above.length; i++) {
			characters.add(above[i], charArray[i]);
		}
		Character[] array = characters.toArray(new Character[0]);
		char[] chars = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			chars[i] = array[i];
		}
		return new String(chars);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DeckRearrangingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				DeckRearrangingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class DeckRearrangingHarness {
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
			String deck = "BRBRR";
			int[] above = { 0, 0, 1, 0, 3 };
			String expected__ = "RRBRB";

			return verifyCase(casenum__, expected__, new DeckRearranging().rearrange(deck, above));
		}
		case 1: {
			String deck = "RRRRRR";
			int[] above = { 0, 1, 2, 0, 1, 3 };
			String expected__ = "RRRRRR";

			return verifyCase(casenum__, expected__, new DeckRearranging().rearrange(deck, above));
		}
		case 2: {
			String deck = "RBRRBRBB";
			int[] above = { 0, 1, 2, 3, 4, 5, 6, 7 };
			String expected__ = "RBRRBRBB";

			return verifyCase(casenum__, expected__, new DeckRearranging().rearrange(deck, above));
		}
		case 3: {
			String deck = "RBRRBRBB";
			int[] above = { 0, 0, 0, 0, 0, 0, 0, 0 };
			String expected__ = "BBRBRRBR";

			return verifyCase(casenum__, expected__, new DeckRearranging().rearrange(deck, above));
		}
		case 4: {
			String deck = "RBRRBRBB";
			int[] above = { 0, 1, 0, 0, 4, 0, 6, 7 };
			String expected__ = "RRRRBBBB";

			return verifyCase(casenum__, expected__, new DeckRearranging().rearrange(deck, above));
		}

		// custom cases

		/*
		 * case 5: {
		 * String deck = ;
		 * int[] above = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DeckRearranging().rearrange(deck, above));
		 * }
		 */
		/*
		 * case 6: {
		 * String deck = ;
		 * int[] above = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DeckRearranging().rearrange(deck, above));
		 * }
		 */
		/*
		 * case 7: {
		 * String deck = ;
		 * int[] above = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * DeckRearranging().rearrange(deck, above));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
