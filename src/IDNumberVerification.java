import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

// Paste me into the FileEdit configuration dialog
// Single Round Match 583 - Round 1550.0

public class IDNumberVerification {
	public String verify(String id, String[] regionCodes) {
		for (String region : regionCodes) {
			if (id.startsWith(region)) {
				int digit = 0;
				for (char c : id.toCharArray()) {
					digit *= 2;
					if (c == 'X') {
						digit += 10;
					} else {
						digit += (c - '0');
					}
				}
				if ((digit %= 11) != 1) {
					continue;
				}
				if (!checkBirth(id.substring(6, 6 + 8))) {
					continue;
				}

				int sexual = Integer.valueOf(id.substring(6 + 8, 6 + 8 + 3));
				if (sexual == 0) {
					continue;
				}
				if (sexual % 2 == 0) {
					return "Female";
				} else {
					return "Male";
				}
			}
		}
		return "Invalid";
	}

	/**
	 * @param birth
	 * @return
	 */
	private static boolean checkBirth(String birth) {
		int year = Integer.parseInt(birth.substring(0, 4));
		int month = Integer.parseInt(birth.substring(4, 6));
		int day = Integer.parseInt(birth.substring(6, 8));

		if (!(1900 <= year && year <= 2011)) {
			return false;
		}
		if (!(1 <= month && month <= 12)) {
			return false;
		}

		if (Arrays.binarySearch(new int[] { 1, 3, 5, 7, 8, 10, 12 }, month) >= 0) {
			if (1 <= day && day <= 31) {
				return true;
			}
		} else if (month != 2) {
			if (1 <= day && day <= 30) {
				return true;
			}
		} else if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			if (1 <= day && day <= 29) {
				return true;
			}
		} else {
			if (1 <= day && day <= 28) {
				return true;
			}
		}
		return false;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			IDNumberVerificationHarness.run_test(6);
		} else {
			for (int i = 0; i < args.length; ++i)
				IDNumberVerificationHarness.run_test(Integer.valueOf(args[i]));
		}
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("20040229", true);
		map.put("20010229", false);
		map.put("20000229", true);
		map.put("19000229", false);
		map.put("20000228", true);
		map.put("20000132", false);
		map.put("20000631", false);
		map.put("20000630", true);
		map.put("20001131", false);
		map.put("20001231", true);
		map.put("20041231", true);
		map.put("20040100", false);
		map.put("20040227", true);
		map.put("20040228", true);
		map.put("20040229", true);
		for (Entry<String, Boolean> entry : map.entrySet()) {
			if (checkBirth(entry.getKey()) != entry.getValue()) {
				System.err.println("error");
			}
		}

	}
	// END CUT HERE
}

// BEGIN CUT HERE
class IDNumberVerificationHarness {
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
			String id = "441323200312060636";
			String[] regionCodes = { "441323" };
			String expected__ = "Male";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 1: {
			String id = "62012319240507058X";
			String[] regionCodes = { "620123" };
			String expected__ = "Female";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 2: {
			String id = "321669197204300886";
			String[] regionCodes = { "610111", "659004" };
			String expected__ = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 3: {
			String id = "230231198306900162";
			String[] regionCodes = { "230231" };
			String expected__ = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 4: {
			String id = "341400198407260005";
			String[] regionCodes = { "341400" };
			String expected__ = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 5: {
			String id = "520381193206090891";
			String[] regionCodes = { "532922", "520381" };
			String expected__ = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}

		// custom cases


		  case 6: {
		  String id = "000001200002290015";
		  String[] regionCodes = {"000001"};
		  String expected__ ="Invalid" ;

		  return verifyCase(casenum__, expected__, new
		  IDNumberVerification().verify(id, regionCodes));
		  }

		/*
		 * case 7: {
		 * String id = ;
		 * String[] regionCodes = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * IDNumberVerification().verify(id, regionCodes));
		 * }
		 */
		/*
		 * case 8: {
		 * String id = ;
		 * String[] regionCodes = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * IDNumberVerification().verify(id, regionCodes));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
