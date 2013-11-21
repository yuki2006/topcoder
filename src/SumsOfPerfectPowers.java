import java.util.ArrayList;

// Paste me into the FileEdit configuration dialog
// SRM 350 DIV 2 - 500.0

public class SumsOfPerfectPowers {
	public int howMany(int lowerBound, int upperBound) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		for (int i = 2; i * i <= upperBound; i++) {
			long z = i * i;
			while (z <= upperBound) {
				list.add((int) z);
				z *= i;
			}
		}
		boolean[] check = new boolean[2 * upperBound + 100];
		for (Integer i : list) {
			for (Integer j : list) {
				check[i + j] = true;
			}
		}
		int count = 0;
		for (int i = lowerBound; i <= upperBound; i++) {
			if (check[i])
				count++;
		}
		return count;
	}

	public int howMany2(int lowerBound, int upperBound) {
		boolean[] check = new boolean[5000001];
		for (int a = 0; a <= 2236; a++) {
			long a1 = a;
			for (int m = 2; m <= 23; m++) {
				a1 *= a;
				if (a1 > upperBound) {
					break;
				}
				for (int b = 0; b <= 2236; b++) {
					long b1 = b;
					for (int k = 2; k <= 23; k++) {
						b1 *= b;
						long num = a1 + b1;
						if (num > upperBound) {
							break;
						}
						if (lowerBound <= num && num <= upperBound) {
							check[(int) num] = true;
						}
					}
				}
			}
		}
		int count = 0;
		for (boolean b : check) {
			count += b ? 1 : 0;
		}
		return count;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SumsOfPerfectPowersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SumsOfPerfectPowersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SumsOfPerfectPowersHarness {
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
			int lowerBound = 0;
			int upperBound = 1;
			int expected__ = 2;

			return verifyCase(casenum__, expected__, new SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		}
		case 1: {
			int lowerBound = 5;
			int upperBound = 6;
			int expected__ = 1;

			return verifyCase(casenum__, expected__, new SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		}
		case 2: {
			int lowerBound = 25;
			int upperBound = 30;
			int expected__ = 5;

			return verifyCase(casenum__, expected__, new SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		}
		case 3: {
			int lowerBound = 103;
			int upperBound = 103;
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		}
		case 4: {
			int lowerBound = 1;
			int upperBound = 100000;
			int expected__ = 33604;

			return verifyCase(casenum__, expected__, new SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		}

		// custom cases

		case 5: {
			int lowerBound = 0;
			int upperBound = 5000000;
			int expected__ = 1272868;

			return verifyCase(casenum__, expected__, new
					SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		}
		/*
		 * case 6: {
		 * int lowerBound = ;
		 * int upperBound = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		 * }
		 */
		/*
		 * case 7: {
		 * int lowerBound = ;
		 * int upperBound = ;
		 * int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SumsOfPerfectPowers().howMany(lowerBound, upperBound));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
