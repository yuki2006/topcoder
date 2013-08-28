import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// Single Round Match 589 - Round 11000.0
public class FlippingBitsDiv2 {

	class Tuple {
		int total;
		int k;

		public Tuple(int total, int k) {
			this.total = total;
			this.k = k;
		}
	}

	public int getmin(String[] Ss, int M) {
		String S = "";
		int turn = 0;
		for (String string : Ss) {
			S += string;
		}
		char[] cs = S.toCharArray();
		int current;
		while (true) {
			current = countBits(cs);
			if (current == cs.length) {
				break;
			}
			// flip any bit
			Tuple countFirst = countFlipFirst(cs, M);
			Tuple countLast = countFlipLast(cs, M);

			if (countFirst.total > countLast.total) {
				if (countFirst.total > 1) {
					flipBitsFirst(cs, countFirst, M);
				} else {
					flipBits(cs);
				}
			} else {
				if (countLast.total > 1) {
					flipBitsLast(cs, countLast, M);
				} else {
					flipBits(cs);
				}
			}
			turn++;
		}
		return turn;
	}

	private void flipBitsFirst(char[] cs, Tuple t, int M) {
		for (int i = 0; i < t.k * M; i++) {
			cs[i] = (cs[i] == '0') ? '1' : '0';
		}
	}

	private void flipBitsLast(char[] cs, Tuple t, int M) {
		for (int i = cs.length - t.k * M; i < cs.length; i++) {
			cs[i] = (cs[i] == '0') ? '1' : '0';
		}
	}

	private void flipBits(char[] cs) {
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '0') {
				cs[i] = '1';
				return;
			}
		}
	}

	private Tuple countFlipLast(char[] cs, int M) {
		int totalMAX = 0;
		int p = 0;
		for (int k = 1; k <= cs.length / M; k++) {
			int total = 0;
			for (int i = cs.length  - k * M; i < cs.length; i++) {
				if (cs[i] == '0') {
					total++;
				} else {
					total--;
				}
			}
			if (total > totalMAX) {
				totalMAX = total;
				p = k;

			}

		}
		return new Tuple(totalMAX, p);
	}

	private Tuple countFlipFirst(char[] cs, int M) {
		int totalMAX = 0;
		int p = 0;
		for (int k = 1; k <= cs.length / M; k++) {
			int total = 0;
			for (int i = 0; i < k * M; i++) {
				if (cs[i] == '0') {
					total++;
				} else {
					total--;
				}
			}
			if (total > totalMAX) {
				totalMAX = total;
				p = k;
			}
		}
		return new Tuple(totalMAX, p);
	}

	private int countBits(char[] cs) {
		int total = 0;
		for (char c : cs) {
			if (c == '1') {
				total++;
			}
		}
		return total;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FlippingBitsDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FlippingBitsDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FlippingBitsDiv2Harness {
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
			String[] S = { "00111000" };
			int M = 1;
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new FlippingBitsDiv2().getmin(S, M));
		}
		case 1: {
			String[] S = { "00111000" };
			int M = 2;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new FlippingBitsDiv2().getmin(S, M));
		}
		case 2: {
			String[] S = { "111111" };
			int M = 3;
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new FlippingBitsDiv2().getmin(S, M));
		}
		case 3: {
			String[] S = { "00100" };
			int M = 5;
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new FlippingBitsDiv2().getmin(S, M));
		}
		case 4: {
			String[] S = { "00010", "11010110", "1010111", "110001010",
					"0110001100", "000110110", "011010101", "00", "111", "100" };
			int M = 13;
			int expected__ = 31;

			return verifyCase(casenum__, expected__,
					new FlippingBitsDiv2().getmin(S, M));
		}

		// custom cases

		/*
		 * case 5: { String[] S = ; int M = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FlippingBitsDiv2().getmin(S, M)); }
		 */
		/*
		 * case 6: { String[] S = ; int M = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FlippingBitsDiv2().getmin(S, M)); }
		 */
		/*
		 * case 7: { String[] S = ; int M = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FlippingBitsDiv2().getmin(S, M)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
