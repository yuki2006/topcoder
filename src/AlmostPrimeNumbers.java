// Paste me into the FileEdit configuration dialog

public class AlmostPrimeNumbers {
	public int getNext(int m) {
		for (m++; isAlmostPrime(m, 11) == false; m++)
			;
		return m;

	}

	/**
 *
 */
	private boolean isAlmostPrime(int m, int start) {
		boolean isPrime = true;
		for (int i = 2; i < m; i++) {
			if (m % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			return false;
		for (int i = 2; i < start; i++) {
			if (m % i == 0)
				return false;
		}
		return true;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			AlmostPrimeNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				AlmostPrimeNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class AlmostPrimeNumbersHarness {
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
			int m = 200;
			int expected__ = 209;

			return verifyCase(casenum__, expected__, new AlmostPrimeNumbers().getNext(m));
		}
		case 1: {
			int m = 666;
			int expected__ = 667;

			return verifyCase(casenum__, expected__, new AlmostPrimeNumbers().getNext(m));
		}
		case 2: {
			int m = 1000;
			int expected__ = 1003;

			return verifyCase(casenum__, expected__, new AlmostPrimeNumbers().getNext(m));
		}
		case 3: {
			int m = 1591;
			int expected__ = 1633;

			return verifyCase(casenum__, expected__, new AlmostPrimeNumbers().getNext(m));
		}
		case 4: {
			int m = 6;
			int expected__ = 121;

			return verifyCase(casenum__, expected__, new AlmostPrimeNumbers().getNext(m));
		}

		// custom cases

		/*
		 * case 5: {
		 * int m = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * AlmostPrimeNumbers().getNext(m));
		 * }
		 */
		/*
		 * case 6: {
		 * int m = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * AlmostPrimeNumbers().getNext(m));
		 * }
		 */
		/*
		 * case 7: {
		 * int m = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * AlmostPrimeNumbers().getNext(m));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
