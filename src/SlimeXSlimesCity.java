import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 506 DIV 2 - 500.0

public class SlimeXSlimesCity {

	public int merge(int[] population) {
		Arrays.sort(population);
		int count = 0;
		for (int i = 0; i < population.length; i++) {
			long plus = 0;
			for (int j = 0; j < i; j++) {
				plus += population[j];
			}
			boolean clear = true;
			for (int j = i + 1; j < population.length; j++) {
				if (population[i] + plus < population[j]) {
					clear = false;
					break;
				} else {
					plus += population[j];
				}
			}
			if (clear) {
				count++;
			}
		}
		return count;
	}

	public int merge2(int[] population) {
		long[] sum_table = new long[population.length + 1];
		Arrays.sort(population);
		int count = 0;
		for (int i = 0; i < population.length; i++) {
			long plus = sum_table[i];
			boolean clear = true;
			for (int j = i + 1; j < population.length; j++) {
				if (population[i] + plus < population[j]) {
					clear = false;
					break;
				} else {
					plus += population[j];
				}
			}
			if (clear) {
				count++;
			}

			sum_table[i + 1] = population[i] + sum_table[i];
		}
		return count;
	}


	public int merge3(int[] population) {
		long[] sum_table = new long[population.length + 1];
		Arrays.sort(population);
		for (int i = 0; i < population.length; i++) {
			sum_table[i + 1] = population[i] + sum_table[i];
		}
		for (int j = population.length - 1; j >= 0; j--) {
			if (sum_table[j] < population[j]) {
				return population.length - j;
			}
		}
		return -1;
	}


	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SlimeXSlimesCityHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SlimeXSlimesCityHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SlimeXSlimesCityHarness {
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
			int[] population = { 2, 3, 4 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new SlimeXSlimesCity().merge(population));
		}
		case 1: {
			int[] population = { 1, 2, 3 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new SlimeXSlimesCity().merge(population));
		}
		case 2: {
			int[] population = { 8, 2, 3, 8 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new SlimeXSlimesCity().merge(population));
		}
		case 3: {
			int[] population = { 1000000000, 999999999, 999999998, 999999997 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new SlimeXSlimesCity().merge(population));
		}
		case 4: {
			int[] population = { 1, 1, 1 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new SlimeXSlimesCity().merge(population));
		}
		case 5: {
			int[] population = { 1, 2, 4, 6, 14, 16, 20 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new SlimeXSlimesCity().merge(population));
		}

		// custom cases

		/*
		 * case 6: {
		 * int[] population = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SlimeXSlimesCity().merge(population));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] population = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SlimeXSlimesCity().merge(population));
		 * }
		 */
		/*
		 * case 8: {
		 * int[] population = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SlimeXSlimesCity().merge(population));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
