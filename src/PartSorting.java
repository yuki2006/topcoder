// Paste me into the FileEdit configuration dialog
// SRM 307 DIV 2 - 500.0

public class PartSorting {
	public int[] process(int[] data, int nSwaps) {
		for (int i = 0; i < data.length; i++) {
			int maxIndex = i;
			for (int j = i+1; j < data.length  && j <=i+nSwaps; j++) {
				if (data[maxIndex]<data[j]){
					maxIndex=j;
				}
			}
			for (int j=maxIndex-1; j >=i ; j--) {
				if (data[j] < data[j + 1]) {
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
					nSwaps--;
				}
			}

		}
		return data;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			PartSortingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				PartSortingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class PartSortingHarness {
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

	static boolean compareOutput(int[] expected, int[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (expected[i] != result[i])
				return false;
		return true;
	}

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, int[] expected, int[] received) {
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
			int[] data = { 10, 20, 30, 40, 50, 60, 70 };
			int nSwaps = 1;
			int[] expected__ = { 20, 10, 30, 40, 50, 60, 70 };

			return verifyCase(casenum__, expected__, new PartSorting().process(data, nSwaps));
		}
		case 1: {
			int[] data = { 3, 5, 1, 2, 4 };
			int nSwaps = 2;
			int[] expected__ = { 5, 3, 2, 1, 4 };

			return verifyCase(casenum__, expected__, new PartSorting().process(data, nSwaps));
		}
		case 2: {
			int[] data = { 19, 20, 17, 18, 15, 16, 13, 14, 11, 12 };
			int nSwaps = 5;
			int[] expected__ = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };

			return verifyCase(casenum__, expected__, new PartSorting().process(data, nSwaps));
		}

		// custom cases
		
		  case 3: {
		  int[] data ={89, 103, 107, 90, 97, 85, 12, 29, 71, 10, 94, 18, 15, 36, 55, 13, 77, 86, 5, 4, 48, 47, 3, 43, 25, 41, 74, 119, 8, 113, 42, 98, 14, 80, 37, 110, 11, 115, 87, 21, 127, 28, 124, 61, 102, 39, 70, 38, 81, 73} ;
		  int nSwaps = 10;
		  int[] expected__ ={107, 103, 97, 90, 89, 85, 94, 12, 29, 71, 10, 18, 15, 36, 55, 13, 77, 86, 5, 4, 48, 47, 3, 43, 25, 41, 74, 119, 8, 113, 42, 98, 14, 80, 37, 110, 11, 115, 87, 21, 127, 28, 124, 61, 102, 39, 70, 38, 81, 73} ;
		 
		  return verifyCase(casenum__, expected__, new
		  PartSorting().process(data, nSwaps));
		  }
		 
		/*
		 * case 4: {
		 * int[] data = ;
		 * int nSwaps = ;
		 * int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * PartSorting().process(data, nSwaps));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] data = ;
		 * int nSwaps = ;
		 * int[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * PartSorting().process(data, nSwaps));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
