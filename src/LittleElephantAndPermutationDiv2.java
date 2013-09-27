// Paste me into the FileEdit configuration dialog
// Single Round Match 592 - Round 1500.0
public class LittleElephantAndPermutationDiv2 {
	public long getNumber(int N, int K) {
		int[] hit = new int[N];
		int[] list = new int[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = i + 1;
		}
		int p = 1;
		for (int i = 1; i <= N; i++) {
			p *= i;
		}

		return permutaion(hit, list, N, K)*p;
	}

	private long permutaion(int hit[], int list[], int count, int k) {
		if (count == 0) {
			int sum = 0;
			for (int i = 0; i < hit.length; i++) {
				sum += Math.max(list[hit[i] - 1], i + 1);
			}
			if (sum >= k) {
				return 1;
			}
			return 0;
		} else {
			int c = 0;
			int[] tmp = hit.clone();
			for (int i = 0; i < list.length; i++) {
				if (tmp[i] == 0) {
					tmp[i] = count;
					long ret = permutaion(tmp, list, count - 1, k);
					c += ret;
					tmp = hit.clone();
				}
			}
			return c;
		}
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			LittleElephantAndPermutationDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LittleElephantAndPermutationDiv2Harness.run_test(Integer
						.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class LittleElephantAndPermutationDiv2Harness {
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
			int N = 1;
			int K = 1;
			long expected__ = 1;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndPermutationDiv2().getNumber(N, K));
		}
		case 1: {
			int N = 2;
			int K = 1;
			long expected__ = 4;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndPermutationDiv2().getNumber(N, K));
		}
		case 2: {
			int N = 3;
			int K = 8;
			long expected__ = 18;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndPermutationDiv2().getNumber(N, K));
		}
		case 3: {
			int N = 10;
			int K = 47;
			long expected__ = 13168189440000L;

			return verifyCase(casenum__, expected__,
					new LittleElephantAndPermutationDiv2().getNumber(N, K));
		}

		// custom cases

		/*
		 * case 4: { int N = ; int K = ; long expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndPermutationDiv2().getNumber(N, K)); }
		 */
		/*
		 * case 5: { int N = ; int K = ; long expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndPermutationDiv2().getNumber(N, K)); }
		 */
		/*
		 * case 6: { int N = ; int K = ; long expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LittleElephantAndPermutationDiv2().getNumber(N, K)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
