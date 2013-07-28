import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// SRM 357 DIV 2 - 250.0

public class MnemonicMemory {
	public String getPhrase(String number, String[] dictionary) {
		Arrays.sort(dictionary);
		String result = "";
		for (char n : number.toCharArray()) {
			int size = Integer.valueOf(n + "");
			for (int i = 0; i < dictionary.length; i++) {
				if (dictionary[i].length() == size) {
					if (result.length() > 0) {
						result += " ";
					}
					result += dictionary[i];
					dictionary[i] = "";
					break;
				}
			}
		}
		return result;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MnemonicMemoryHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MnemonicMemoryHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MnemonicMemoryHarness {
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
			String number = "25735";
			String[] dictionary = { "is", "there", "anybody", "out", "there" };
			String expected__ = "is there anybody out there";

			return verifyCase(casenum__, expected__, new MnemonicMemory().getPhrase(number, dictionary));
		}
		case 1: {
			String number = "31415926";
			String[] dictionary = { "may", "i", "have", "a", "large", "container", "of", "coffee" };
			String expected__ = "may a have i large container of coffee";

			return verifyCase(casenum__, expected__, new MnemonicMemory().getPhrase(number, dictionary));
		}
		case 2: {
			String number = "1212";
			String[] dictionary = { "a", "aa", "a", "aa" };
			String expected__ = "a aa a aa";

			return verifyCase(casenum__, expected__, new MnemonicMemory().getPhrase(number, dictionary));
		}
		case 3: {
			String number = "11111111122";
			String[] dictionary = { "a", "b", "d", "c", "a", "e", "f", "z", "zz", "za", "az", "e" };
			String expected__ = "a a b c d e e f z az za";

			return verifyCase(casenum__, expected__, new MnemonicMemory().getPhrase(number, dictionary));
		}
		case 4: {
			String number = "2222";
			String[] dictionary = { "ab", "cd", "ef", "a", "b", "ab" };
			String expected__ = "ab ab cd ef";

			return verifyCase(casenum__, expected__, new MnemonicMemory().getPhrase(number, dictionary));
		}

		// custom cases

		/*
		 * case 5: {
		 * String number = ;
		 * String[] dictionary = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MnemonicMemory().getPhrase(number, dictionary));
		 * }
		 */
		/*
		 * case 6: {
		 * String number = ;
		 * String[] dictionary = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MnemonicMemory().getPhrase(number, dictionary));
		 * }
		 */
		/*
		 * case 7: {
		 * String number = ;
		 * String[] dictionary = ;
		 * String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MnemonicMemory().getPhrase(number, dictionary));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
