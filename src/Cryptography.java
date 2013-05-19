import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 480 Easy
public class Cryptography {
	public long encrypt(int[] numbers) {
		Arrays.sort(numbers);
		numbers[0]++;
		long ans = 1;
		for (int a : numbers) {
			ans *= a;
		}
		return ans;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CryptographyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CryptographyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CryptographyHarness {
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

	static boolean compareOutput(long expected, long result) {
		return expected == result;
	}

	static String formatResult(long res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, long expected, long received) {
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
			int[] numbers = { 1, 2, 3 };
			long expected__ = 12;

			return verifyCase(casenum__, expected__, new Cryptography().encrypt(numbers));
		}
		case 1: {
			int[] numbers = { 1, 3, 2, 1, 1, 3 };
			long expected__ = 36;

			return verifyCase(casenum__, expected__, new Cryptography().encrypt(numbers));
		}
		case 2: {
			int[] numbers = { 1000, 999, 998, 997, 996, 995 };
			long expected__ = 986074810223904000L;

			return verifyCase(casenum__, expected__, new Cryptography().encrypt(numbers));
		}
		case 3: {
			int[] numbers = { 1, 1, 1, 1 };
			long expected__ = 2;

			return verifyCase(casenum__, expected__, new Cryptography().encrypt(numbers));
		}

		// custom cases

		/*
		 * case 4: {
		 * int[] numbers = ;
		 * long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Cryptography().encrypt(numbers));
		 * }
		 */
		/*
		 * case 5: {
		 * int[] numbers = ;
		 * long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Cryptography().encrypt(numbers));
		 * }
		 */
		/*
		 * case 6: {
		 * int[] numbers = ;
		 * long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * Cryptography().encrypt(numbers));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
