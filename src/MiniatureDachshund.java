import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// Single Round Match 599 - Round 1250.0

public class MiniatureDachshund {
	public int maxMikan(int[] mikan, int weight) {
		Arrays.sort(mikan);
		int sum = weight;
		int count = 0;
		for (int i = 0; i < mikan.length; i++) {
			sum += mikan[i];
			if (sum > 5000)
				break;
			count++;
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MiniatureDachshundHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MiniatureDachshundHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MiniatureDachshundHarness {
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
			int[] mikan = { 100, 100, 100, 100, 100 };
			int weight = 4750;
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new MiniatureDachshund().maxMikan(mikan, weight));
		}
		case 1: {
			int[] mikan = { 100, 100, 100, 100, 50 };
			int weight = 4750;
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new MiniatureDachshund().maxMikan(mikan, weight));
		}
		case 2: {
			int[] mikan = { 120, 90, 130, 100, 110, 80 };
			int weight = 3000;
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new MiniatureDachshund().maxMikan(mikan, weight));
		}
		case 3: {
			int[] mikan = { 50 };
			int weight = 5000;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new MiniatureDachshund().maxMikan(mikan, weight));
		}
		case 4: {
			int[] mikan = { 200, 50, 200, 50, 200, 50, 200, 50 };
			int weight = 4800;
			int expected__ = 4;

			return verifyCase(casenum__, expected__, new MiniatureDachshund().maxMikan(mikan, weight));
		}

		// custom cases

		/*
		 * case 5: {
		 * int[] mikan = ;
		 * int weight = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MiniatureDachshund().maxMikan(mikan, weight));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] mikan = ;
		 * int weight = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MiniatureDachshund().maxMikan(mikan, weight));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] mikan = ;
		 * int weight = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MiniatureDachshund().maxMikan(mikan, weight));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
