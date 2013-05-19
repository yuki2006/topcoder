import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM255 DIV2 EASY
public class SequenceOfNumbers {
	public String[] rearrange(String[] sequence) {
		int[] tmp = new int[sequence.length];
		for (int i = 0; i < sequence.length; i++) {
			tmp[i] = Integer.valueOf(sequence[i]);
		}
		Arrays.sort(tmp);
		String[] a=new String[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			a[i]=tmp[i]+"";
		}
		return a;
		// Comparator<String> c=new Comparator<String>() {
		// public int compare(String o1, String o2) {
		// if (o1.length()<o2.length()){
		// return -1;
		// }else if (o1.length()>o2.length()){
		// return 1;
		// }
		// return o1.compareTo(o2);
		// }
		// };
		// Arrays.sort(sequence, c);
//		return sequence;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SequenceOfNumbersHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SequenceOfNumbersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SequenceOfNumbersHarness {
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

	static boolean compareOutput(String[] expected, String[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (!expected[i].equals(result[i]))
				return false;
		return true;
	}

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, String[] expected, String[] received) {
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
			String[] sequence = { "1", "174", "23", "578", "71", "9" };
			String[] expected__ = { "1", "9", "23", "71", "174", "578" };

			return verifyCase(casenum__, expected__, new SequenceOfNumbers().rearrange(sequence));
		}
		case 1: {
			String[] sequence = { "172", "172", "172", "23", "23" };
			String[] expected__ = { "23", "23", "172", "172", "172" };

			return verifyCase(casenum__, expected__, new SequenceOfNumbers().rearrange(sequence));
		}
		case 2: {
			String[] sequence = { "183", "2", "357", "38", "446", "46", "628", "734", "741", "838" };
			String[] expected__ = { "2", "38", "46", "183", "357", "446", "628", "734", "741", "838" };

			return verifyCase(casenum__, expected__, new SequenceOfNumbers().rearrange(sequence));
		}

		// custom cases

		/*
		 * case 3: {
		 * String[] sequence = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SequenceOfNumbers().rearrange(sequence));
		 * }
		 */
		/*
		 * case 4: {
		 * String[] sequence = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SequenceOfNumbers().rearrange(sequence));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] sequence = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SequenceOfNumbers().rearrange(sequence));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
