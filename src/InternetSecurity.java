import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
// Paste me into the FileEdit configuration dialog
// SRM 480 DIV2
public class InternetSecurity {
	public String[] determineWebsite(String[] address, String[] keyword, String[] dangerous, int threshold) {
//		ArrayList<String> dangerousList = new ArrayList<String>();
		HashSet<String> dangerousList = new HashSet<String>();
		boolean[] result = new boolean[address.length];
		Arrays.fill(result, false);
		for (String d : dangerous) {
			dangerousList.add(d);
		}
		while (true) {
			boolean hit = false;
			for (int i = 0; i < keyword.length; i++) {
				if (result[i]){
					continue;
				}
				int count = 0;
				for (String key : keyword[i].split(" ")) {
					for (String string : dangerousList) {
						if (key.equals(string)) {
							count++;
						}
					}
				}
				if (count >= threshold) {
					hit = true;
					result[i] = true;
					for (String string : keyword[i].split(" ")) {
						dangerousList.add(string);
//						if (!dangerousList.contains(string)) {
//							dangerousList.add(string);
//						}
					}
					keyword[i] = "";
					break;
				}
			}
			if (hit == false) {
				break;
			}
		}
		ArrayList<String> tmp = new ArrayList<String>();
		for (int i = 0; i < result.length; i++) {
			if (result[i]) {
				tmp.add(address[i]);
			}

		}

		return tmp.toArray(new String[0]);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			InternetSecurityHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				InternetSecurityHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class InternetSecurityHarness {
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

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			String[] address = { "www.topcoder.com",
					"www.sindicate_of_evil.com",
					"www.happy_citizens.com" };
			String[] keyword = { "hack encryption decryption internet algorithm",
					"signal interference evil snake poison algorithm",
					"flower baloon topcoder blue sky sea" };
			String[] dangerous = { "hack", "encryption", "decryption", "interference", "signal", "internet" };
			int threshold = 3;
			String[] expected__ = { "www.topcoder.com", "www.sindicate_of_evil.com" };

			return verifyCase(casenum__, expected__,
					new InternetSecurity().determineWebsite(address, keyword, dangerous, threshold));
		}
		case 1: {
			String[] address = { "brokenlink", "flowerpower.net", "purchasedomain.com" };
			String[] keyword = { "broken", "rose tulips", "cheap free domain biggest greatest" };
			String[] dangerous = { "biggest", "enemy", "hideout" };
			int threshold = 2;
			String[] expected__ = {};

			return verifyCase(casenum__, expected__,
					new InternetSecurity().determineWebsite(address, keyword, dangerous, threshold));
		}
		case 2: {
			String[] address = { "a..a.ab.", "...aa.b" };
			String[] keyword = { "a bc def", "def ghij klmno" };
			String[] dangerous = { "a", "b", "c", "d", "e" };
			int threshold = 1;
			String[] expected__ = { "a..a.ab.", "...aa.b" };

			return verifyCase(casenum__, expected__,
					new InternetSecurity().determineWebsite(address, keyword, dangerous, threshold));
		}
		case 3: {
			String[] address = { "www.tsa.gov" };
			String[] keyword = { "information assurance signal intelligence research" };
			String[] dangerous = { "signal", "assurance", "penguin" };
			int threshold = 2;
			String[] expected__ = { "www.tsa.gov" };

			return verifyCase(casenum__, expected__,
					new InternetSecurity().determineWebsite(address, keyword, dangerous, threshold));
		}

		// custom cases
		// { 2}

		case 4: {
			String[] address = { "aahntlvynlmdxpkishpmpuvig", "eucbbvkdcwqdtcnnnocn.qeckbualodzzdcevwv_",
					"hsafip_ds_n_" };
			String[] keyword = { "f y ebq tj ng q w g ct p yx k qq yic qd j z o ql h", "cbp niqqeexi jgvz mvi",
					"ogsa s ut gcxk kdstl d okdzc miap mmevatxy y z w g" };
			String[] dangerous = { "ogsa", "cbp", "s", "ut", "gcxk", "kdstl", "d", "okdzc", "niqqeexi", "f", "miap",
					"mmevatxy", "jgvz", "mvi", "ksmidves", "rbkym" };
			int threshold = 2;
			String[] expected__ = { "aahntlvynlmdxpkishpmpuvig", "eucbbvkdcwqdtcnnnocn.qeckbualodzzdcevwv_",
					"hsafip_ds_n_" };

			return verifyCase(casenum__, expected__, new
					InternetSecurity().determineWebsite(address, keyword, dangerous,
							threshold));
		}

		/*
		 * case 5: {
		 * String[] address = ;
		 * String[] keyword = ;
		 * String[] dangerous = ;
		 * int threshold = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * InternetSecurity().determineWebsite(address, keyword, dangerous,
		 * threshold));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] address = ;
		 * String[] keyword = ;
		 * String[] dangerous = ;
		 * int threshold = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * InternetSecurity().determineWebsite(address, keyword, dangerous,
		 * threshold));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
