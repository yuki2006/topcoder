import java.util.ArrayList;
import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 348 DIV 2 - 250.0

public class OptimalList {
	public String optimize(String inst) {
		char[] charArray = inst.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			for (int j = 0; j < charArray.length; j++) {
				if (charArray[i] == 'N' && charArray[j] == 'S'
						|| charArray[i] == 'W' && charArray[j] == 'E') {
					charArray[i] = charArray[j] = 0;
				}
			}
		}
		Arrays.sort(charArray);
		String string = "";
		for (char c : charArray) {
			if (c != 0) {
				string += c;
			}
		}
		return string;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			OptimalListHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				OptimalListHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class OptimalListHarness {
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
			String inst = "NENENNWWWWWS";
			String expected__ = "NNNWWW";

			return verifyCase(casenum__, expected__, new OptimalList().optimize(inst));
		}
		case 1: {
			String inst = "NNEESSWW";
			String expected__ = "";

			return verifyCase(casenum__, expected__, new OptimalList().optimize(inst));
		}
		case 2: {
			String inst = "NEWSNWESWESSEWSENSEWSEWESEWWEWEEWESSSWWWWWW";
			String expected__ = "SSSSSSSSWWW";

			return verifyCase(casenum__, expected__, new OptimalList().optimize(inst));
		}
		case 3: {
			String inst = "NENENE";
			String expected__ = "EEENNN";

			return verifyCase(casenum__, expected__, new OptimalList().optimize(inst));
		}

		// custom cases

		/*
		 * case 4: {
		 * String inst = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * OptimalList().optimize(inst));
		 * }
		 */
		/*
		 * case 5: {
		 * String inst = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * OptimalList().optimize(inst));
		 * }
		 */
		/*
		 * case 6: {
		 * String inst = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * OptimalList().optimize(inst));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
