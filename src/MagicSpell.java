import java.util.LinkedList;

// Paste me into the FileEdit configuration dialog
// $META_DATA$
public class MagicSpell {
	public String fixTheSpell(String spell) {
		char[] charArray = spell.toCharArray();
		LinkedList<Character> characters = new LinkedList<Character>();
		for (int i = 0; i < charArray.length; i++) {
			if (spell.charAt(i) == 'A' || spell.charAt(i) == 'Z') {
				characters.add(charArray[i]);
			}
		}
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'A' || charArray[i] == 'Z') {
				charArray[i] = characters.removeLast();
			}
		}

		return new String(charArray);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MagicSpellHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MagicSpellHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MagicSpellHarness {
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
			String spell = "AZ";
			String expected__ = "ZA";

			return verifyCase(casenum__, expected__, new MagicSpell().fixTheSpell(spell));
		}
		case 1: {
			String spell = "ABACADA";
			String expected__ = "ABACADA";

			return verifyCase(casenum__, expected__, new MagicSpell().fixTheSpell(spell));
		}
		case 2: {
			String spell = "AABZCADZA";
			String expected__ = "AZBACZDAA";

			return verifyCase(casenum__, expected__, new MagicSpell().fixTheSpell(spell));
		}
		case 3: {
			String spell = "AZBASGHNAZAHBNVZZGGGAGGZAZ";
			String expected__ = "ZABZSGHNAZZHBNVAZGGGAGGAZA";

			return verifyCase(casenum__, expected__, new MagicSpell().fixTheSpell(spell));
		}

		// custom cases

		/*
		 * case 4: {
		 * String spell = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * MagicSpell().fixTheSpell(spell));
		 * }
		 */
		/*
		 * case 5: {
		 * String spell = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * MagicSpell().fixTheSpell(spell));
		 * }
		 */
		/*
		 * case 6: {
		 * String spell = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * MagicSpell().fixTheSpell(spell));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
