// Paste me into the FileEdit configuration dialog

public class PackingParts {
	public int pack(int[] partSizes, int[] boxSizes) {
		int boxPointer = 0;
		int hit = 0;
		for (int pointer = 0; pointer < partSizes.length;) {
			if (partSizes[pointer] <= boxSizes[boxPointer]) {
				boxSizes[boxPointer] -= partSizes[pointer];
				hit++;
				pointer++;
			}
			boxPointer++;
			if (boxPointer == boxSizes.length) {
				break;
			}

		}
		return hit;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PackingPartsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PackingPartsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PackingPartsHarness {
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
			int[] partSizes = { 2, 2, 2 };
			int[] boxSizes = { 1, 2, 2, 3 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new PackingParts().pack(partSizes, boxSizes));
		}
		case 1: {
			int[] partSizes = { 1, 5 };
			int[] boxSizes = { 2, 5 };
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new PackingParts().pack(partSizes, boxSizes));
		}
		case 2: {
			int[] partSizes = { 10, 10, 10, 10 };
			int[] boxSizes = { 9, 9, 9, 10, 10, 10 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new PackingParts().pack(partSizes, boxSizes));
		}
		case 3: {
			int[] partSizes = { 1, 1, 1, 1 };
			int[] boxSizes = { 1, 2, 2, 3, 6, 7 };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new PackingParts().pack(partSizes, boxSizes));
		}
		case 4: {
			int[] partSizes = { 1, 1, 1, 1 };
			int[] boxSizes = { 2, 3, 6 };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new PackingParts().pack(partSizes, boxSizes));
		}
		case 5: {
			int[] partSizes = { 10, 32, 46, 55, 55, 84, 100 };
			int[] boxSizes = { 15, 31, 34, 46, 59, 68, 83, 99 };
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new PackingParts().pack(partSizes, boxSizes));
		}

		// custom cases

		/*
		 * case 6: { int[] partSizes = ; int[] boxSizes = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PackingParts().pack(partSizes, boxSizes)); }
		 */
		/*
		 * case 7: { int[] partSizes = ; int[] boxSizes = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PackingParts().pack(partSizes, boxSizes)); }
		 */
		/*
		 * case 8: { int[] partSizes = ; int[] boxSizes = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * PackingParts().pack(partSizes, boxSizes)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
