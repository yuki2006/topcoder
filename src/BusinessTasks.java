import java.util.ArrayList;

// Paste me into the FileEdit configuration dialog
// SRM 236 DIV 2 - 500.0

public class BusinessTasks {
	public String getTask(String[] list, int n) {
		ArrayList<String> strings = new ArrayList<String>();
		for (String s : list) {
			strings.add(s);
		}
		int current = 0;
		while (strings.size() > 1) {
			current += n - 1;
			current %= strings.size();
			strings.remove(current);
		}
		return strings.get(0);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BusinessTasksHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BusinessTasksHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BusinessTasksHarness {
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
			String[] list = { "a", "b", "c", "d" };
			int n = 2;
			String expected__ = "a";

			return verifyCase(casenum__, expected__, new BusinessTasks().getTask(list, n));
		}
		case 1: {
			String[] list = { "a", "b", "c", "d", "e" };
			int n = 3;
			String expected__ = "d";

			return verifyCase(casenum__, expected__, new BusinessTasks().getTask(list, n));
		}
		case 2: {
			String[] list = { "alpha", "beta", "gamma", "delta", "epsilon" };
			int n = 1;
			String expected__ = "epsilon";

			return verifyCase(casenum__, expected__, new BusinessTasks().getTask(list, n));
		}
		case 3: {
			String[] list = { "a", "b" };
			int n = 1000;
			String expected__ = "a";

			return verifyCase(casenum__, expected__, new BusinessTasks().getTask(list, n));
		}
		case 4: {
			String[] list = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
					"s", "t",
					"u", "v", "w", "x", "y", "z" };
			int n = 17;
			String expected__ = "n";

			return verifyCase(casenum__, expected__, new BusinessTasks().getTask(list, n));
		}
		case 5: {
			String[] list = { "zlqamum", "yjsrpybmq", "tjllfea", "fxjqzznvg", "nvhekxr", "am", "skmazcey", "piklp",
					"olcqvhg", "dnpo", "bhcfc", "y", "h", "fj", "bjeoaxglt", "oafduixsz", "kmtbaxu",
					"qgcxjbfx", "my", "mlhy", "bt", "bo", "q" };
			int n = 9000000;
			String expected__ = "fxjqzznvg";

			return verifyCase(casenum__, expected__, new BusinessTasks().getTask(list, n));
		}

		// custom cases

		/*
		 * case 6: {
		 * String[] list = ;
		 * int n = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BusinessTasks().getTask(list, n));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] list = ;
		 * int n = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BusinessTasks().getTask(list, n));
		 * }
		 */
		/*
		 * case 8: {
		 * String[] list = ;
		 * int n = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BusinessTasks().getTask(list, n));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
