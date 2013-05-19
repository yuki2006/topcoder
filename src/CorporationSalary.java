// Paste me into the FileEdit configuration dialog
// SRM 407 DIV 2 - 500.0

public class CorporationSalary {
	long[] salary;

	public long totalSalary(String[] relations) {
		salary = new long[relations.length];
		long sum = 0;
		for (int i = 0; i < relations.length; i++) {
			sum += getSalary(relations, i);
		}
		return sum;
	}

	long getSalary(String[] relations, int i) {
		if (salary[i] > 0) {
			return salary[i];
		}
		long sum = 0;
		for (int j = 0; j < relations[i].length(); j++) {
			if (relations[i].charAt(j) == 'Y') {
				sum += getSalary(relations, j);
			}
		}

		if (sum == 0) {
			salary[i] = 1;
		} else {
			salary[i] = sum;
		}
		return salary[i];
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CorporationSalaryHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CorporationSalaryHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class CorporationSalaryHarness {
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
			String[] relations = { "N" };
			long expected__ = 1;

			return verifyCase(casenum__, expected__, new CorporationSalary().totalSalary(relations));
		}
		case 1: {
			String[] relations = { "NNYN",
					"NNYN",
					"NNNN",
					"NYYN" };
			long expected__ = 5;

			return verifyCase(casenum__, expected__, new CorporationSalary().totalSalary(relations));
		}
		case 2: {
			String[] relations = { "NNNNNN",
					"YNYNNY",
					"YNNNNY",
					"NNNNNN",
					"YNYNNN",
					"YNNYNN" };
			long expected__ = 17;

			return verifyCase(casenum__, expected__, new CorporationSalary().totalSalary(relations));
		}
		case 3: {
			String[] relations = { "NYNNYN",
					"NNNNNN",
					"NNNNNN",
					"NNYNNN",
					"NNNNNN",
					"NNNYYN" };
			long expected__ = 8;

			return verifyCase(casenum__, expected__, new CorporationSalary().totalSalary(relations));
		}
		case 4: {
			String[] relations = { "NNNN",
					"NNNN",
					"NNNN",
					"NNNN" };
			long expected__ = 4;

			return verifyCase(casenum__, expected__, new CorporationSalary().totalSalary(relations));
		}

		// custom cases

		/*
		 * case 5: {
		 * String[] relations = ;
		 * long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CorporationSalary().totalSalary(relations));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] relations = ;
		 * long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CorporationSalary().totalSalary(relations));
		 * }
		 */
		/*
		 * case 7: {
		 * String[] relations = ;
		 * long expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * CorporationSalary().totalSalary(relations));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
