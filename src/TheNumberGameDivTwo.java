import java.util.Arrays;
// Paste me into the FileEdit configuration dialog
// Single Round Match 575 - Round 1 500.0

public class TheNumberGameDivTwo {

	public String find3(int n) {
		return (check3(n) == 1 ? "John" : "Brus");
	}

	/**
	 * メモ化せず 純粋再起
	 * 指数時間かかるので回答不能？
	 * (512の場合2秒を超える）
	 *
	 * @param n
	 * @return １ならその数字を選んだら必勝のパターンが有る。0ならその数字を選んだら負になる　
	 */

	public int check3(int n) {
		boolean win = false;
		for (int i = n / 2; i >= 2; i--) {
			if (n % i == 0) {
				int tmp = check3(n - i);
				if (tmp == 0) {
					win = true;
					break;
				}
			}
		}
		return win ? 1 : 0;
	}

	// 1 からそのプレイヤーの勝利 0ならそのプレイヤーの負け　が確定してる。-1は未調査。
	int[] tables = new int[1001];

	/**
	 * メモ化再起パターン
	 *
	 * @param n
	 * @return
	 */
	public String find2(int n) {
		Arrays.fill(tables, -1);
		tables[0] = 0;
		tables[1] = 0;
		return (check2(n) == 1 ? "John" : "Brus");
	}

	/**
	 * メモ化再起
	 *
	 * @param n
	 * @return １ならその数字を選んだら必勝のパターンが有る。0ならその数字を選んだら負になる　
	 */

	public int check2(int n) {
		if (tables[n] >= 0) {
			return tables[n];
		}
		boolean win = false;
		for (int i = n / 2; i >= 2; i--) {
			if (n % i == 0) {
				int tmp = check2(n - i);
				if (tmp == 0) {
					win = true;
					break;
				}
			}
		}
		if (win) {
			tables[n] = 1;
		} else {
			tables[n] = 0;
		}
		return tables[n];
	}

	public String find(int n) {
		// true ならそのプレイヤーの勝利 falseならそのプレイヤーの負けが確定してる。
		boolean[] tables = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					if (tables[i - j] == false) {
						tables[i] = true;
						break;
					}
				}
			}
		}
		return (tables[n] ? "John" : "Brus");
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheNumberGameDivTwoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheNumberGameDivTwoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheNumberGameDivTwoHarness {
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
			int n = 6;
			String expected__ = "John";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}
		case 1: {
			int n = 2;
			String expected__ = "Brus";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}
		case 2: {
			int n = 747;
			String expected__ = "Brus";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}
		case 3: {
			int n = 128;
			String expected__ = "Brus";

			return verifyCase(casenum__, expected__, new TheNumberGameDivTwo().find(n));
		}

		// custom cases

		case 4: {
			int n = 52;
			String expected__ = "John";

			return verifyCase(casenum__, expected__, new
					TheNumberGameDivTwo().find(n));
		}
		case 5: {
			int n = 1;
			String expected__ = "Brus";

			return verifyCase(casenum__, expected__, new
					TheNumberGameDivTwo().find(n));
		}

		/*
		 * case 5: {
		 * int n = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheNumberGameDivTwo().find(n));
		 * }
		 */
		/*
		 * case 6: {
		 * int n = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * TheNumberGameDivTwo().find(n));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
