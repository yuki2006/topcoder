import java.util.ArrayList;
import java.util.HashMap;

// Paste me into the FileEdit configuration dialog

public class CityMap {
	public String getLegend(String[] cityMap, int[] POIs) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (String str : cityMap) {
			for (char c : str.toCharArray()) {
				if (c=='.'){
					continue;
				}
				Integer integer = map.get(c);
				if (integer == null) {
					integer = 0;
				}
				map.put(c, integer + 1);
			}
		}
		String result = "";
		for (int i = 0; i < POIs.length; i++) {
			int j = POIs[i];
			for (char c : map.keySet()) {
				if (map.get(c) == j) {
					result += c;
					break;
				}
			}
		}
		return result;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CityMapHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CityMapHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CityMapHarness {
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
			String[] cityMap = { "M....M", "...R.M", "R..R.R" };
			int[] POIs = { 3, 4 };
			String expected__ = "MR";

			return verifyCase(casenum__, expected__,
					new CityMap().getLegend(cityMap, POIs));
		}
		case 1: {
			String[] cityMap = { "XXXXXXXZXYYY" };
			int[] POIs = { 1, 8, 3 };
			String expected__ = "ZXY";

			return verifyCase(casenum__, expected__,
					new CityMap().getLegend(cityMap, POIs));
		}
		case 2: {
			String[] cityMap = { "...........", "...........", "...........",
					"..........T" };
			int[] POIs = { 1 };
			String expected__ = "T";

			return verifyCase(casenum__, expected__,
					new CityMap().getLegend(cityMap, POIs));
		}
		case 3: {
			String[] cityMap = { "AIAAARRI.......GOAI.",
					".O..AIIGI.OAAAGI.A.I", ".A.IAAAARI..AI.AAGR.",
					"....IAI..AOIGA.GAIA.", "I.AIIIAG...GAR.IIAGA",
					"IA.AOA....I....I.GAA", "IOIGRAAAO.AI.AA.RAAA",
					"AI.AAA.AIR.AGRIAAG..", "AAAAIAAAI...AAG.RGRA",
					".J.IA...G.A.AA.II.AA" };
			int[] POIs = { 16, 7, 1, 35, 11, 66 };
			String expected__ = "GOJIRA";

			return verifyCase(casenum__, expected__,
					new CityMap().getLegend(cityMap, POIs));
		}

		// custom cases

		/*
		 * case 4: { String[] cityMap = ; int[] POIs = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CityMap().getLegend(cityMap, POIs)); }
		 */
		/*
		 * case 5: { String[] cityMap = ; int[] POIs = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CityMap().getLegend(cityMap, POIs)); }
		 */
		/*
		 * case 6: { String[] cityMap = ; int[] POIs = ; String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CityMap().getLegend(cityMap, POIs)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
