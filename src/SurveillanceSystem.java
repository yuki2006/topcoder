import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

// Paste me into the FileEdit configuration dialog
// Single Round Match 581 - Round 1500.0
/**
 * @bug
 * @author yuki
 *
 */
public class SurveillanceSystem {
	public String getContainerInfo(String containers, int[] reports, int L) {
		int[] watchCount = new int[containers.length()];

		for (int i = 0; i < containers.length(); i++) {
			for (int j = 0; j < L && i + j < containers.length(); j++) {
				watchCount[i] += containers.charAt(i + j) == 'X' ? 1 : 0;
			}
		}
		for (int i = containers.length() - L + 1; i < containers.length(); i++) {
			watchCount[i] = -1;
		}
		char[] zones = new char[containers.length()];
		Arrays.fill(zones, '-');
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int report : reports) {
			Integer integer = map.get(report);
			if (integer == null) {
				integer = 0;
			}
			map.put(report, integer + 1);
		}
		for (Entry<Integer, Integer> report : map.entrySet()) {
			int[] count = new int[watchCount.length];
			for (int i = 0; i < watchCount.length; i++) {
				if (watchCount[i] == report.getKey()) {
					for (int j = 0; j < L && i + j < containers.length(); j++) {
						count[i + j]++;
					}
				}
			}
			int max = 0;
			int subTotal = 0;
			for (int i = 0; i < count.length; i++) {
				subTotal += count[i];
				if (count[i] > max) {
					max = count[i];
				} else if (count[i] == 0) {
					if (subTotal / L == max) {
						for (int j = i - 1; j >= 0; j--) {
							count[j] = Integer.MAX_VALUE;
						}
					}
				}
			}

			for (int i = 0; i < count.length; i++) {
				if (count[i] ==  Integer.MAX_VALUE) {
					zones[i] = '+';
				} else if (count[i] > 0 && zones[i] != '+') {
					zones[i] = '?';
				}
			}
		}
		return String.valueOf(zones);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SurveillanceSystemHarness.run_test(4);
		} else {
			for (int i = 0; i < args.length; ++i)
				SurveillanceSystemHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SurveillanceSystemHarness {
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
			String containers = "-X--XX";
			int[] reports = { 1, 2 };
			int L = 3;
			String expected__ = "??++++";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 1: {
			String containers = "-XXXXX-";
			int[] reports = { 2 };
			int L = 3;
			String expected__ = "???-???";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 2: {
			String containers = "------X-XX-";
			int[] reports = { 3, 0, 2, 0 };
			int L = 5;
			String expected__ = "++++++++++?";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 3: {
			String containers = "-XXXXX---X--";
			int[] reports = { 2, 1, 0, 1 };
			int L = 3;
			String expected__ = "???-??++++??";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 4: {
			String containers = "-XX--X-XX-X-X--X---XX-X---XXXX-----X";
			int[] reports = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			int L = 7;
			String expected__ = "???++++?++++++++++++++++++++??????--";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}

		// custom cases

		/*
		 * case 5: {
		 * String containers = ;
		 * int[] reports = ;
		 * int L = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SurveillanceSystem().getContainerInfo(containers, reports, L));
		 * }
		 */
		/*
		 * case 6: {
		 * String containers = ;
		 * int[] reports = ;
		 * int L = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SurveillanceSystem().getContainerInfo(containers, reports, L));
		 * }
		 */
		/*
		 * case 7: {
		 * String containers = ;
		 * int[] reports = ;
		 * int L = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SurveillanceSystem().getContainerInfo(containers, reports, L));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
