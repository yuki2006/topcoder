// Paste me into the FileEdit configuration dialog
// SRM 236 DIV 2 - 250.0

public class MassiveNumbers {
	public String getLargest(String numberA, String numberB) {
		String[] split;
		split = numberA.split("\\^");
		double numA = Integer.valueOf(split[1]) * Math.log10(Integer.valueOf(split[0]));
		split = numberB.split("\\^");
		double numB = Integer.valueOf(split[1]) * Math.log10(Integer.valueOf(split[0]));
		if (numA<numB){
			return numberB;
		}else{
			return numberA;
		}
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MassiveNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MassiveNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MassiveNumbersHarness {
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
			String numberA = "3^100";
			String numberB = "2^150";
			String expected__ = "3^100";

			return verifyCase(casenum__, expected__, new MassiveNumbers().getLargest(numberA, numberB));
		}
		case 1: {
			String numberA = "1^1000";
			String numberB = "2^1";
			String expected__ = "2^1";

			return verifyCase(casenum__, expected__, new MassiveNumbers().getLargest(numberA, numberB));
		}
		case 2: {
			String numberA = "893^605";
			String numberB = "396^906";
			String expected__ = "396^906";

			return verifyCase(casenum__, expected__, new MassiveNumbers().getLargest(numberA, numberB));
		}
		case 3: {
			String numberA = "999^1000";
			String numberB = "1000^999";
			String expected__ = "999^1000";

			return verifyCase(casenum__, expected__, new MassiveNumbers().getLargest(numberA, numberB));
		}

		// custom cases

		/*
		 * case 4: {
		 * String numberA = ;
		 * String numberB = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MassiveNumbers().getLargest(numberA, numberB));
		 * }
		 */
		/*
		 * case 5: {
		 * String numberA = ;
		 * String numberB = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MassiveNumbers().getLargest(numberA, numberB));
		 * }
		 */
		/*
		 * case 6: {
		 * String numberA = ;
		 * String numberB = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MassiveNumbers().getLargest(numberA, numberB));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
