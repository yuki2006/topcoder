// Paste me into the FileEdit configuration dialog

public class EllysNewNickname {
	public int getLength(String nickname) {
		char[] charArray = nickname.toCharArray();
		boolean oldVowels = false;
		int count = 0;
		for (char c : charArray) {
			boolean current = isVowels(c);
			if (oldVowels && current) {

			} else {
				count++;
			}
			oldVowels = current;
		}
		return count;

	}

	boolean isVowels(char c) {
		if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o'
				|| c == 'y') {
			return true;
		}
		return false;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EllysNewNicknameHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EllysNewNicknameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EllysNewNicknameHarness {
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
			String nickname = "tourist";
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new EllysNewNickname().getLength(nickname));
		}
		case 1: {
			String nickname = "eagaeoppooaaa";
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new EllysNewNickname().getLength(nickname));
		}
		case 2: {
			String nickname = "esprit";
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new EllysNewNickname().getLength(nickname));
		}
		case 3: {
			String nickname = "ayayayayayaya";
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new EllysNewNickname().getLength(nickname));
		}
		case 4: {
			String nickname = "wuuut";
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new EllysNewNickname().getLength(nickname));
		}
		case 5: {
			String nickname = "naaaaaaaanaaaanaananaaaaabaaaaaaaatmaaaaan";
			int expected__ = 16;

			return verifyCase(casenum__, expected__,
					new EllysNewNickname().getLength(nickname));
		}

		// custom cases

		/*
		 * case 6: { String nickname = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EllysNewNickname().getLength(nickname)); }
		 */
		/*
		 * case 7: { String nickname = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EllysNewNickname().getLength(nickname)); }
		 */
		/*
		 * case 8: { String nickname = ; int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EllysNewNickname().getLength(nickname)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
