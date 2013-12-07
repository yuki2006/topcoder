import java.util.HashMap;

// Paste me into the FileEdit configuration dialog
// Single Round Match 599 - Round 1500.0

public class BigFatInteger2 {
	public String isDivisible(int A, int B, int C, int D) {
		HashMap<Integer, Integer> mapA = getMap(A);
		HashMap<Integer, Integer> mapC = getMap(C);
		boolean isOK = true;
		for (Integer key : mapC.keySet()) {
			if (mapA.containsKey(key)) {
				long left = (long) mapA.get(key) * B;
				long right = (long) mapC.get(key) * D;
				if (left < right) {
					isOK = false;
					break;
				}
			} else {
				isOK = false;
				break;
			}
		}
		if (isOK) {
			return "divisible";
		}
		return "not divisible";
	}

	private HashMap<Integer, Integer> getMap(int A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int tmp = A;
		for (int i = 2; i * i <= A; i++) {
			int count = 0;
			while (tmp > 1) {
				if (tmp % i == 0) {
					tmp /= i;
					count++;
				} else {
					break;
				}
			}
			if (count > 0)
				map.put(i, count);
		}
		if (tmp > 1) {
			map.put(tmp, 1);
		}
		return map;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BigFatInteger2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BigFatInteger2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BigFatInteger2Harness {
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

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
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
			int A = 6;
			int B = 1;
			int C = 2;
			int D = 1;
			String expected__ = "divisible";

			return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
		}
		case 1: {
			int A = 2;
			int B = 1;
			int C = 6;
			int D = 1;
			String expected__ = "not divisible";

			return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
		}
		case 2: {
			int A = 1000000000;
			int B = 1000000000;
			int C = 1000000000;
			int D = 200000000;
			String expected__ = "divisible";

			return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
		}
		case 3: {
			int A = 8;
			int B = 100;
			int C = 4;
			int D = 200;
			String expected__ = "not divisible";

			return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
		}
		case 4: {
			int A = 999999937;
			int B = 1000000000;
			int C = 999999929;
			int D = 1;
			String expected__ = "not divisible";

			return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
		}
		case 5: {
			int A = 2;
			int B = 2;
			int C = 4;
			int D = 1;
			String expected__ = "divisible";

			return verifyCase(casenum__, expected__, new BigFatInteger2().isDivisible(A, B, C, D));
		}

		// custom cases

		/*
		 * case 6: {
		 * int A = ;
		 * int B = ;
		 * int C = ;
		 * int D = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BigFatInteger2().isDivisible(A, B, C, D));
		 * }
		 */
		/*
		 * case 7: {
		 * int A = ;
		 * int B = ;
		 * int C = ;
		 * int D = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BigFatInteger2().isDivisible(A, B, C, D));
		 * }
		 */
		/*
		 * case 8: {
		 * int A = ;
		 * int B = ;
		 * int C = ;
		 * int D = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BigFatInteger2().isDivisible(A, B, C, D));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
