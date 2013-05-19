// Paste me into the FileEdit configuration dialog

public class JustifyText {
	public String[] format(String[] text) {
		int max = 0;
		for (String string : text) {
			max = Math.max(max, string.length());
		}
		for (int i = 0; i < text.length; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < max - text[i].length(); j++) {
				builder.append(" ");

			}
			text[i] = builder.toString() + text[i];
		}
		return text;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			JustifyTextHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				JustifyTextHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class JustifyTextHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String[] expected, String[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (!expected[i].equals(result[i]))
				return false;
		return true;
	}

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, String[] expected, String[] received) {
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
			String[] text = { "BOB", "TOMMY", "JIM" };
			String[] expected__ = { "  BOB", "TOMMY", "  JIM" };

			return verifyCase(casenum__, expected__,
					new JustifyText().format(text));
		}
		case 1: {
			String[] text = { "JOHN", "JAKE", "ALAN", "BLUE" };
			String[] expected__ = { "JOHN", "JAKE", "ALAN", "BLUE" };

			return verifyCase(casenum__, expected__,
					new JustifyText().format(text));
		}
		case 2: {
			String[] text = { "LONGEST", "A", "LONGER", "SHORT" };
			String[] expected__ = { "LONGEST", "      A", " LONGER", "  SHORT" };

			return verifyCase(casenum__, expected__,
					new JustifyText().format(text));
		}

		// custom cases

		/*
		 * case 3: { String[] text = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * JustifyText().format(text)); }
		 */
		/*
		 * case 4: { String[] text = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * JustifyText().format(text)); }
		 */
		/*
		 * case 5: { String[] text = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * JustifyText().format(text)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
