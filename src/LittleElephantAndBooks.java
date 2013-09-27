import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// Single Round Match 592 - Round 1250.0
public class LittleElephantAndBooks {
	public int getNumber(int[] pages, int number) {
		Arrays.sort(pages);
		int sum = 0;
		for (int i = 0; i < number - 1; i++) {
			sum += pages[i];
		}
		sum += pages[number];
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LittleElephantAndBooksHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LittleElephantAndBooksHarness
						.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndBooksHarness {
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
			int[] pages = { 1, 2 };
			int number = 1;
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBooks().getNumber(pages, number));
		}
		case 1: {
			int[] pages = { 74, 7, 4, 47, 44 };
			int number = 3;
			int expected__ = 58;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBooks().getNumber(pages, number));
		}
		case 2: {
			int[] pages = { 3, 1, 9, 7, 2, 8, 6, 4, 5 };
			int number = 7;
			int expected__ = 29;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBooks().getNumber(pages, number));
		}
		case 3: {
			int[] pages = { 74, 86, 32, 13, 100, 67, 77 };
			int number = 2;
			int expected__ = 80;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndBooks().getNumber(pages, number));
		}

		// custom cases

		
		  case 4: { int[] pages = {1,2,3,4,5,6}; 
		  int number =4 ; int expected__ =11 ;
		  
		  return verifyCase(casenum__, expected__, new
		  LittleElephantAndBooks().getNumber(pages, number)); }
		/*
		 * case 5: { int[] pages = ; int number = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndBooks().getNumber(pages, number)); }
		 */
		/*
		 * case 6: { int[] pages = ; int number = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndBooks().getNumber(pages, number)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
