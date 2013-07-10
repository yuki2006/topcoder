import java.util.Arrays;
import java.util.HashMap;

// Paste me into the FileEdit configuration dialog
// Single Round Match 582 - Round 1500.0

public class SpaceWarDiv2 {
	public static void reverse(Integer[] keys) {
		for (int i = 0; i < keys.length / 2; i++) {
			int tmp = keys[keys.length - i - 1];
			keys[keys.length - i - 1] = keys[i];
			keys[i] = tmp;
		}
	}

	public int minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength,
			int[] enemyCount) {

		// log(n)
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		Arrays.sort(magicalGirlStrength);

		int total = 0;
		for (int i = 0; i < enemyStrength.length; i++) {
			Integer value = hashMap.get(enemyStrength[i]);
			if (value == null) {
				value = 0;
			}
			value += enemyCount[i];
			hashMap.put(enemyStrength[i], value);
			total += enemyCount[i];
		}
		Integer[] keys = hashMap.keySet().toArray(new Integer[0]);
		Arrays.sort(keys);
		reverse(keys);
		// O(50*50*100)=O(250000)
		for (int t = 1;; t++) {
			boolean hit = false;
			// O(50)
			for (int i = 0; i < magicalGirlStrength.length; i++) {

				// O(50*100)

				for (Integer key : keys) {
					if (hashMap.get(key) > 0
							&& key <= magicalGirlStrength[i]) {
						hashMap.put(key, hashMap.get(key) - 1);
						total--;
						if (total == 0) {
							return t;
						}
						hit = true;
						break;
					}
				}
			}
			if (!hit) {
				return -1;
			}
		}

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SpaceWarDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SpaceWarDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SpaceWarDiv2Harness {
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

	static boolean compareOutput(int expected, int result) {
		return expected == result;
	}

	static String formatResult(int res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, int expected, int received) {
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
			int[] magicalGirlStrength = { 2, 3, 5 };
			int[] enemyStrength = { 1, 3, 4 };
			int[] enemyCount = { 2, 9, 4 };
			int expected__ = 7;

			return verifyCase(casenum__, expected__,
					new SpaceWarDiv2().minimalFatigue(magicalGirlStrength,
							enemyStrength, enemyCount));
		}
		case 1: {
			int[] magicalGirlStrength = { 2, 3, 5 };
			int[] enemyStrength = { 1, 1, 2 };
			int[] enemyCount = { 2, 9, 4 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new SpaceWarDiv2().minimalFatigue(magicalGirlStrength,
							enemyStrength, enemyCount));
		}
		case 2: {
			int[] magicalGirlStrength = { 14, 6, 22 };
			int[] enemyStrength = { 8, 33 };
			int[] enemyCount = { 9, 1 };
			int expected__ = -1;

			return verifyCase(casenum__, expected__,
					new SpaceWarDiv2().minimalFatigue(magicalGirlStrength,
							enemyStrength, enemyCount));
		}
		case 3: {
			int[] magicalGirlStrength = { 17, 10, 29, 48, 92, 60, 80, 100, 15,
					69, 36, 43, 70, 14, 88, 12, 14, 29, 9, 40 };
			int[] enemyStrength = { 93, 59, 27, 68, 48, 82, 15, 95, 61, 49, 68,
					15, 16, 26, 64, 82, 7, 8, 92, 15 };
			int[] enemyCount = { 56, 26, 12, 52, 5, 19, 93, 36, 69, 61, 68, 66,
					55, 28, 49, 55, 63, 57, 33, 45 };
			int expected__ = 92;

			return verifyCase(casenum__, expected__,
					new SpaceWarDiv2().minimalFatigue(magicalGirlStrength,
							enemyStrength, enemyCount));
		}

		// custom cases

		/*
		 * case 4: { int[] magicalGirlStrength = ; int[] enemyStrength = ; int[]
		 * enemyCount = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength,
		 * enemyCount)); }
		 */
		/*
		 * case 5: { int[] magicalGirlStrength = ; int[] enemyStrength = ; int[]
		 * enemyCount = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength,
		 * enemyCount)); }
		 */
		/*
		 * case 6: { int[] magicalGirlStrength = ; int[] enemyStrength = ; int[]
		 * enemyCount = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength,
		 * enemyCount)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
