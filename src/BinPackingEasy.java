import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Paste me into the FileEdit configuration dialog
// Single Round Match 598 - Round 1500.0

public class BinPackingEasy {
	/**
	 * 
	 */
	private static final int MAX = 1000;

	public int minBins(int[] item) {
		Arrays.sort(item);
		int ans = 0;
		int minIndex = 0;
		for (int i = item.length - 1; i >= minIndex; i--) {
			if (item[i] + item[minIndex] <= 300) {
				minIndex++;
			}
			ans++;
		}
		return ans;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BinPackingEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BinPackingEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BinPackingEasyHarness {
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
			int[] item = { 150, 150, 150, 150, 150 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		case 1: {
			int[] item = { 130, 140, 150, 160 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		case 2: {
			int[] item = { 101, 101, 101, 101, 101, 101, 101, 101, 101 };
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		case 3: {
			int[] item = { 101, 200, 101, 101, 101, 101, 200, 101, 200 };
			int expected__ = 6;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		case 4: {
			int[] item = { 123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198 };
			int expected__ = 8;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		case 5: {
			int[] item = { 300, 300, 300 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		case 6: {
			int[] item = { 101, 101, 300 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new BinPackingEasy().minBins(item));
		}
		// custom cases

		/*
		 * case 5: {
		 * int[] item = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BinPackingEasy().minBins(item));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] item = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BinPackingEasy().minBins(item));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] item = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BinPackingEasy().minBins(item));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
