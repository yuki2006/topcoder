// Paste me into the FileEdit configuration dialog
// Single Round Match 598 - Round 1250.0

public class ErasingCharacters {
	public String simulate(String s) {
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length - 1; i++) {
			if (charArray[i] == 0)
				continue;
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[j] == 0)
					continue;
				if (charArray[i] == charArray[j]) {
					charArray[i] = charArray[j] = 0;
					i = -1;
				}
				break;
			}
		}
		String ret = "";
		for (char c : charArray) {
			if (c > 0)
				ret += String.valueOf(c);
		}
		return ret;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ErasingCharactersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ErasingCharactersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ErasingCharactersHarness {
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
			String s = "cieeilll";
			String expected__ = "cl";

			return verifyCase(casenum__, expected__, new ErasingCharacters().simulate(s));
		}
		case 1: {
			String s = "topcoder";
			String expected__ = "topcoder";

			return verifyCase(casenum__, expected__, new ErasingCharacters().simulate(s));
		}
		case 2: {
			String s = "abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba";
			String expected__ = "";

			return verifyCase(casenum__, expected__, new ErasingCharacters().simulate(s));
		}
		case 3: {
			String s = "bacaabaccbaaccabbcabbacabcbba";
			String expected__ = "bacbaca";

			return verifyCase(casenum__, expected__, new ErasingCharacters().simulate(s));
		}
		case 4: {
			String s = "eel";
			String expected__ = "l";

			return verifyCase(casenum__, expected__, new ErasingCharacters().simulate(s));
		}

		// custom cases

		/*
		 * case 5: {
		 * String s = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ErasingCharacters().simulate(s));
		 * }
		 */
		/*
		 * case 6: {
		 * String s = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ErasingCharacters().simulate(s));
		 * }
		 */
		/*
		 * case 7: {
		 * String s = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ErasingCharacters().simulate(s));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
