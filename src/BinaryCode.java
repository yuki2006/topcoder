
// Paste me into the FileEdit configuration dialog

public class BinaryCode {
	public String[] decode(String message) {
		int[][] p = new int[2][message.length()];
		p[0][0] = 0;
		p[1][0] = 1;
		for (int i = 0; i < message.length() - 1; i++) {

			for (int j = 0; j < p.length; j++) {
				if (i == 0) {
					p[j][i + 1] = (message.charAt(i) - '0') - p[j][i];
				} else {
					p[j][i + 1] = (message.charAt(i) - '0') - p[j][i] - p[j][i - 1];
				}
			}
		}
		String[] output = { "", "" };
		for (int i = 0; i < p.length; i++) {
			if (p[i][0] == 1) {
				output[i] = "NONE";
			} else {
				for (int j = 0; j < p[i].length; j++) {
					output[i] += p[i][j];
				}
			}
		}
		return output;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BinaryCodeHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BinaryCodeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BinaryCodeHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String message = "123210122";
			String[] expected__ = { "011100011", "NONE" };

			return verifyCase(casenum, expected__, new BinaryCode().decode(message));
		}
		case 1: {
			String message = "11";
			String[] expected__ = { "01", "10" };

			return verifyCase(casenum, expected__, new BinaryCode().decode(message));
		}
		case 2: {
			String message = "22111";
			String[] expected__ = { "NONE", "11001" };

			return verifyCase(casenum, expected__, new BinaryCode().decode(message));
		}
		case 3: {
			String message = "123210120";
			String[] expected__ = { "NONE", "NONE" };

			return verifyCase(casenum, expected__, new BinaryCode().decode(message));
		}
		case 4: {
			String message = "3";
			String[] expected__ = { "NONE", "NONE" };

			return verifyCase(casenum, expected__, new BinaryCode().decode(message));
		}
		case 5: {
			String message = "12221112222221112221111111112221111";
			String[] expected__ = { "01101001101101001101001001001101001", "10110010110110010110010010010110010" };

			return verifyCase(casenum, expected__, new BinaryCode().decode(message));
		}

		// custom cases

		/*
		 * case 6: {
		 * String message = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * BinaryCode().decode(message));
		 * }
		 */
		/*
		 * case 7: {
		 * String message = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * BinaryCode().decode(message));
		 * }
		 */
		/*
		 * case 8: {
		 * String message = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * BinaryCode().decode(message));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
