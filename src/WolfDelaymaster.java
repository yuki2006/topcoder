// Paste me into the FileEdit configuration dialog
// Single Round Match 593 - Round 1500.0
public class WolfDelaymaster {
	public String check(String str) {
		char[] charArray = str.toCharArray();
		char old = 'f';
		int currentLng = 0;
		int oldLng = 0;
		if (charArray[0] != 'w') {
			return "INVALID";
		}
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (c == old || c == 'w' && old == 'f' || c == 'o' && old == 'w'
					|| c == 'l' && old == 'o' || c == 'f' && old == 'l') {

				if (c != old) {
					if (old != 'w' && currentLng != oldLng) {
						return "INVALID";
					}
					oldLng = currentLng;
					currentLng = 0;
				}
				currentLng++;
				if (c == 'w') {
					oldLng = 0;
				}
				old = c;
			} else {
				return "INVALID";
			}
		}
		if (currentLng != oldLng) {
			return "INVALID";
		}
		// 最後 fで終わってないといけない
		if (old != 'f') {
			return "INVALID";
		}
		return "VALID";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			WolfDelaymasterHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				WolfDelaymasterHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class WolfDelaymasterHarness {
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
			String str = "wolf";
			String expected__ = "VALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 1: {
			String str = "wwolfolf";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 2: {
			String str = "wolfwwoollffwwwooolllfffwwwwoooollllffff";
			String expected__ = "VALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 3: {
			String str = "flowolf";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 4: {
			String str = "f";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 5: {
			String str = "wo";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 6: {
			String str = "wolff";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 7: {
			String str = "wolfwol";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 8: {
			String str = "wolfwolf";
			String expected__ = "VALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		case 9: {
			String str = "wolffwwolf";
			String expected__ = "INVALID";

			return verifyCase(casenum__, expected__,
					new WolfDelaymaster().check(str));
		}
		// custom cases

		/*
		 * case 4: { String str = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * WolfDelaymaster().check(str)); }
		 */
		/*
		 * case 5: { String str = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * WolfDelaymaster().check(str)); }
		 */
		/*
		 * case 6: { String str = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * WolfDelaymaster().check(str)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
