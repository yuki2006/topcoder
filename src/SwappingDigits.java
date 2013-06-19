// Paste me into the FileEdit configuration dialog
// Single Round Match 583 - Round 1250.0

public class SwappingDigits {
	public String minNumber(String num) {
		long min = Integer.MAX_VALUE;
		int[] nums = new int[num.length()];
		int k = 0;
		for (char i : num.toCharArray()) {
			nums[k] = i-'0';
			k++;
		}
		for (int n1 = 1; n1 <= 10; n1++) {
			int n=n1%10;
			for (int i = nums.length - 1; i >= 1; i--) {
				if (nums[i] == n) {
					for (int j = 0; j < nums.length; j++) {
						if (nums[j] >= n && !(j==0&& n==0)) {
							int tmp = nums[i];
							nums[i] = nums[j];
							nums[j] = tmp;
							StringBuilder builder = new StringBuilder();
							for (int y : nums) {
								builder.append(y);
							}
							return builder.toString();
						}
					}
				}
			}
		}
		return "";

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SwappingDigitsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SwappingDigitsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SwappingDigitsHarness {
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
			String num = "596";
			String expected__ = "569";

			return verifyCase(casenum__, expected__, new SwappingDigits().minNumber(num));
		}
		case 1: {
			String num = "93561";
			String expected__ = "13569";

			return verifyCase(casenum__, expected__, new SwappingDigits().minNumber(num));
		}
		case 2: {
			String num = "5491727514";
			String expected__ = "1491727554";

			return verifyCase(casenum__, expected__, new SwappingDigits().minNumber(num));
		}
		case 3: {
			String num = "10234";
			String expected__ = "10234";

			return verifyCase(casenum__, expected__, new SwappingDigits().minNumber(num));
		}
		case 4: {
			String num = "93218910471211292416";
			String expected__ = "13218910471211292496";

			return verifyCase(casenum__, expected__, new SwappingDigits().minNumber(num));
		}

		// custom cases

		/*
		 * case 5: {
		 * String num = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SwappingDigits().minNumber(num));
		 * }
		 */
		/*
		 * case 6: {
		 * String num = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SwappingDigits().minNumber(num));
		 * }
		 */
		/*
		 * case 7: {
		 * String num = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SwappingDigits().minNumber(num));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
