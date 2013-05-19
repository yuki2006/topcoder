// Paste me into the FileEdit configuration dialog

public class KingXNewBaby {
	public String isValid(String name) {
		char[] vowels = new char[] { 'a', 'i', 'u', 'e', 'o' };
		if (name.length() == 8) {
			int count = 0;
			for (char string : vowels) {
				int tmp = 0;

				for (int i = 0; i < name.length(); i++) {
					char c = name.charAt(i);
					if (c == string) {
						tmp++;
					}
				}
				if (tmp != 2 && tmp>0) {
					break;
				}
				count += tmp;
			}
			if (count == 2) {
				return "YES";
			}
		}
		return "NO";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			KingXNewBabyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				KingXNewBabyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class KingXNewBabyHarness {
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
			String name = "dengklek";
			String expected__ = "YES";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}
		case 1: {
			String name = "gofushar";
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}
		case 2: {
			String name = "dolphinigle";
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}
		case 3: {
			String name = "mystictc";
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}
		case 4: {
			String name = "rngringo";
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}
		case 5: {
			String name = "misof";
			String expected__ = "NO";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}
		case 6: {
			String name = "metelsky";
			String expected__ = "YES";

			return verifyCase(casenum__, expected__,
					new KingXNewBaby().isValid(name));
		}

		// custom cases

		/*
		 * case 7: { String name = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KingXNewBaby().isValid(name)); }
		 */
		/*
		 * case 8: { String name = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KingXNewBaby().isValid(name)); }
		 */
		/*
		 * case 9: { String name = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KingXNewBaby().isValid(name)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
