import java.util.Arrays;
import java.util.HashMap;

// Paste me into the FileEdit configuration dialog
// $METADATA$
public class RabbitVoting {
	int getIndex(String[] names, String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public String getWinner(String[] names, String[] votes) {
		int count[] = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			int index = getIndex(names, votes[i]);
			if (index != i) {
				count[index]++;
			}
		}
		int[] copy = count.clone();
		Arrays.sort(copy);
		// find unique max
		if (copy[count.length - 1] == copy[count.length - 2]) {
			// same
			return "";
		}
		for (int i = 0; i < copy.length; i++) {
			if (copy[copy.length - 1] == count[i]) {
				return names[i];
			}
		}
		return "";

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			RabbitVotingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				RabbitVotingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class RabbitVotingHarness {
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
			String[] names = { "Alice", "Bill", "Carol", "Dick" };
			String[] votes = { "Bill", "Dick", "Alice", "Alice" };
			String expected__ = "Alice";

			return verifyCase(casenum__, expected__, new RabbitVoting().getWinner(names, votes));
		}
		case 1: {
			String[] names = { "Alice", "Bill", "Carol", "Dick" };
			String[] votes = { "Carol", "Carol", "Bill", "Bill" };
			String expected__ = "";

			return verifyCase(casenum__, expected__, new RabbitVoting().getWinner(names, votes));
		}
		case 2: {
			String[] names = { "Alice", "Bill", "Carol", "Dick" };
			String[] votes = { "Alice", "Alice", "Bill", "Bill" };
			String expected__ = "Bill";

			return verifyCase(casenum__, expected__, new RabbitVoting().getWinner(names, votes));
		}
		case 3: {
			String[] names = { "Alice", "Bill" };
			String[] votes = { "Alice", "Bill" };
			String expected__ = "";

			return verifyCase(casenum__, expected__, new RabbitVoting().getWinner(names, votes));
		}
		case 4: {
			String[] names = { "WhiteRabbit", "whiterabbit", "whiteRabbit", "Whiterabbit" };
			String[] votes = { "whiteRabbit", "whiteRabbit", "whiteRabbit", "WhiteRabbit" };
			String expected__ = "whiteRabbit";

			return verifyCase(casenum__, expected__, new RabbitVoting().getWinner(names, votes));
		}

		// custom cases

		/*
		 * case 5: {
		 * String[] names = ;
		 * String[] votes = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * RabbitVoting().getWinner(names, votes));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] names = ;
		 * String[] votes = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * RabbitVoting().getWinner(names, votes));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] names = ;
		 * String[] votes = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * RabbitVoting().getWinner(names, votes));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
