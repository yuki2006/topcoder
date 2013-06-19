import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

// Paste me into the FileEdit configuration dialog
// SRM 571 DIV 2 - 500.0

public class FoxAndMp3Easy {
	public String[] playList(int n) {
		TreeSet<String> set = new TreeSet<String>();
		for (int i = 1; i <= n; i++) {
			set.add(i + ".mp3");
		}
		List<String> asList = Arrays.asList(set.toArray(new String[0]));
		if (set.size() > 50) {
			asList = asList.subList(0, 50);
		}
		return asList.toArray(new String[0]);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndMp3EasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FoxAndMp3EasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndMp3EasyHarness {
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
			int n = 3;
			String[] expected__ = { "1.mp3", "2.mp3", "3.mp3" };

			return verifyCase(casenum__, expected__,
					new FoxAndMp3Easy().playList(n));
		}
		case 1: {
			int n = 10;
			String[] expected__ = { "1.mp3", "10.mp3", "2.mp3", "3.mp3",
					"4.mp3", "5.mp3", "6.mp3", "7.mp3", "8.mp3", "9.mp3" };

			return verifyCase(casenum__, expected__,
					new FoxAndMp3Easy().playList(n));
		}
		case 2: {
			int n = 16;
			String[] expected__ = { "1.mp3", "10.mp3", "11.mp3", "12.mp3",
					"13.mp3", "14.mp3", "15.mp3", "16.mp3", "2.mp3", "3.mp3",
					"4.mp3", "5.mp3", "6.mp3", "7.mp3", "8.mp3", "9.mp3" };

			return verifyCase(casenum__, expected__,
					new FoxAndMp3Easy().playList(n));
		}
		case 3: {
			int n = 32;
			String[] expected__ = { "1.mp3", "10.mp3", "11.mp3", "12.mp3",
					"13.mp3", "14.mp3", "15.mp3", "16.mp3", "17.mp3", "18.mp3",
					"19.mp3", "2.mp3", "20.mp3", "21.mp3", "22.mp3", "23.mp3",
					"24.mp3", "25.mp3", "26.mp3", "27.mp3", "28.mp3", "29.mp3",
					"3.mp3", "30.mp3", "31.mp3", "32.mp3", "4.mp3", "5.mp3",
					"6.mp3", "7.mp3", "8.mp3", "9.mp3" };

			return verifyCase(casenum__, expected__,
					new FoxAndMp3Easy().playList(n));
		}
		case 4: {
			int n = 109;
			String[] expected__ = { "1.mp3", "10.mp3", "100.mp3", "101.mp3",
					"102.mp3", "103.mp3", "104.mp3", "105.mp3", "106.mp3",
					"107.mp3", "108.mp3", "109.mp3", "11.mp3", "12.mp3",
					"13.mp3", "14.mp3", "15.mp3", "16.mp3", "17.mp3", "18.mp3",
					"19.mp3", "2.mp3", "20.mp3", "21.mp3", "22.mp3", "23.mp3",
					"24.mp3", "25.mp3", "26.mp3", "27.mp3", "28.mp3", "29.mp3",
					"3.mp3", "30.mp3", "31.mp3", "32.mp3", "33.mp3", "34.mp3",
					"35.mp3", "36.mp3", "37.mp3", "38.mp3", "39.mp3", "4.mp3",
					"40.mp3", "41.mp3", "42.mp3", "43.mp3", "44.mp3", "45.mp3" };

			return verifyCase(casenum__, expected__,
					new FoxAndMp3Easy().playList(n));
		}

		// custom cases

		/*
		 * case 5: { int n = ; String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndMp3Easy().playList(n)); }
		 */
		/*
		 * case 6: { int n = ; String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndMp3Easy().playList(n)); }
		 */
		/*
		 * case 7: { int n = ; String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndMp3Easy().playList(n)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
