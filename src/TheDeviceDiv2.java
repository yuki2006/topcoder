// Paste me into the FileEdit configuration dialog
// SRM 569 DIV 2 - 500.0

// idea by http://ekaing.hatenablog.com/entry/2013/04/06/232728
public class TheDeviceDiv2 {
	public String identify(String[] plates) {

		for (int i = 0; i < plates[0].length(); i++) {
			int one = 0;
			int zero = 0;

			for (int j = 0; j < plates.length; j++) {
				if (plates[j].charAt(i) == '1') {
					one++;
				} else {
					zero++;
				}
			}
			if (one < 2 || zero < 1) {
				return "NO";
			}
		}
		return "YES";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheDeviceDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheDeviceDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheDeviceDiv2Harness {
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
			String[] plates = { "010", "011", "000" };
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new TheDeviceDiv2().identify(plates));
		}
		case 1: {
			String[] plates = { "1", "0", "1", "0" };
			String expected__ = "YES";

			return verifyCase(casenum__, expected__,
					new TheDeviceDiv2().identify(plates));
		}
		case 2: {
			String[] plates = { "11111" };
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new TheDeviceDiv2().identify(plates));
		}
		case 3: {
			String[] plates = { "0110011", "0101001", "1111010", "1010010" };
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new TheDeviceDiv2().identify(plates));
		}
		case 4: {
			String[] plates = { "101001011", "011011010", "010110010",
					"111010100", "111111111" };
			String expected__ = "YES";

			return verifyCase(casenum__, expected__,
					new TheDeviceDiv2().identify(plates));
		}

		// custom cases

		/*
		 * case 5: { String[] plates = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheDeviceDiv2().identify(plates)); }
		 */
		/*
		 * case 6: { String[] plates = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheDeviceDiv2().identify(plates)); }
		 */
		/*
		 * case 7: { String[] plates = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheDeviceDiv2().identify(plates)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
