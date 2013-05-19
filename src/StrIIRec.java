
// Paste me into the FileEdit configuration dialog

public class StrIIRec {

	public String recovstr(int n, int minInv, String minStr) {
		boolean[] charsHit = new boolean[n];
		int[] chars = new int[n];
		int pointer = 0;
		for (int i = 0; i < n; i++) {
			charsHit[i] = false;
		}
		int invCount = 0;
		for (int i = 0; i < minStr.length(); i++) {
			chars[i] = minStr.charAt(i) - 'a';
			charsHit[chars[i]] = true;

		}
		pointer = minStr.length();
		for (int i = 0; i < n; i++) {
			if (charsHit[i] == false) {
				chars[pointer++] = i;
			}
			for (int j = i -1; j >=0; j--) {
				if (chars[j] > chars[i]) {
					invCount++;
				}
			}
		}
		if (invCount >= minInv) {
			return outString(n, chars);
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (chars[i] > chars[j]) {
					int tmp = chars[j];
					chars[j] = chars[i];
					chars[i] = tmp;
					invCount++;
					if (invCount >= minInv) {
						return outString(n, chars);
					}
				}
			}
		}

		return "";
	}

	private String outString(int n, int[] chars) {
		String result = new String();
		for (int i = 0; i < n; i++) {
			result += Character.toString((char) ('a' + chars[i]));
		}
		return result;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			StrIIRecHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				StrIIRecHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class StrIIRecHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			int n = 2;
			int minInv = 1;
			String minStr = "ab";
			String expected__ = "ba";

			return verifyCase(casenum, expected__, new StrIIRec().recovstr(n, minInv, minStr));
		}
		case 1: {
			int n = 9;
			int minInv = 1;
			String minStr = "efcdgab";
			String expected__ = "efcdgabhi";

			return verifyCase(casenum, expected__, new StrIIRec().recovstr(n, minInv, minStr));
		}
		case 2: {
			int n = 11;
			int minInv = 55;
			String minStr = "debgikjfc";
			String expected__ = "kjihgfedcba";

			return verifyCase(casenum, expected__, new StrIIRec().recovstr(n, minInv, minStr));
		}
		case 3: {
			int n = 15;
			int minInv = 0;
			String minStr = "e";
			String expected__ = "eabcdfghijklmno";

			return verifyCase(casenum, expected__, new StrIIRec().recovstr(n, minInv, minStr));
		}
		case 4: {
			int n = 9;
			int minInv = 20;
			String minStr = "fcdebiha";
			String expected__ = "fcdehigba";

			return verifyCase(casenum, expected__, new StrIIRec().recovstr(n, minInv, minStr));
		}

		// custom cases

		/*
		 * case 5: {
		 * int n = ;
		 * int minInv = ;
		 * String minStr = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new StrIIRec().recovstr(n,
		 * minInv, minStr));
		 * }
		 */
		/*
		 * case 6: {
		 * int n = ;
		 * int minInv = ;
		 * String minStr = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new StrIIRec().recovstr(n,
		 * minInv, minStr));
		 * }
		 */
		/*
		 * case 7: {
		 * int n = ;
		 * int minInv = ;
		 * String minStr = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new StrIIRec().recovstr(n,
		 * minInv, minStr));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
