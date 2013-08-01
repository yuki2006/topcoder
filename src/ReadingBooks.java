// Paste me into the FileEdit configuration dialog
// SRM 404 DIV 2 - 250.0

public class ReadingBooks {
	public int countBooks(String[] readParts) {
		int count = 0;
		for (int i = 0; i < readParts.length - 2; i++) {
			if (!readParts[i].equals(readParts[i + 1]) &&
					!readParts[i + 1].equals(readParts[i + 2]) &&
					!readParts[i].equals(readParts[i + 2])) {
				count++;
				i += 2;
			}
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ReadingBooksHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ReadingBooksHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ReadingBooksHarness {
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
			String[] readParts = { "introduction", "story", "introduction", "edification" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new ReadingBooks().countBooks(readParts));
		}
		case 1: {
			String[] readParts = { "introduction", "story", "edification", "introduction", "story", "edification" };
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new ReadingBooks().countBooks(readParts));
		}
		case 2: {
			String[] readParts = { "introduction", "story", "introduction", "edification", "story", "introduction" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new ReadingBooks().countBooks(readParts));
		}
		case 3: {
			String[] readParts = { "introduction", "story", "introduction", "edification", "story",
					"story", "edification", "edification", "edification", "introduction",
					"introduction", "edification", "story", "introduction", "story",
					"edification", "edification", "story", "introduction", "edification",
					"story", "story", "edification", "introduction", "story" };
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new ReadingBooks().countBooks(readParts));
		}

		// custom cases

		/*
		 * case 4: {
		 * String[] readParts = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ReadingBooks().countBooks(readParts));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] readParts = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ReadingBooks().countBooks(readParts));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] readParts = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ReadingBooks().countBooks(readParts));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
