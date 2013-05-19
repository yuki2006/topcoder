import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Paste me into the FileEdit configuration dialog

public class KingSort implements Comparator<String> {
	class Maps {
		public Maps(String str, int number) {
			super();
			this.key = str;
			this.value = number;
		}

		String key;
		int value;
	}

	ArrayList<Maps> mChars = new ArrayList<Maps>() {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new Maps("IV", 4));
			add(new Maps("V", 5));
			add(new Maps("IX", 9));
			add(new Maps("XL", 40));

			add(new Maps("X", 10));
			add(new Maps("L", 50));
			add(new Maps("I", 1));
		}

	};

	public String[] getSortedList(String[] kings) {
		Arrays.sort(kings, this);
		return kings;

	}

	public int compare(String o1, String o2) {
		String[] split1 = o1.split(" ");
		String[] split2 = o2.split(" ");

		if (split1[0].compareTo(split2[0]) == 0) {
			int i1 = getRomaNumber(split1[1]);
			int i2 = getRomaNumber(split2[1]);
			return i1 == i2 ? 0 : i1 > i2 ? 1 : -1;
		}

		return split1[0].compareTo(split2[0]);
	}

	private int getRomaNumber(String split1) {
		int number = 0;
		for (int i = 0; i < split1.length();) {
			for (Maps hash : mChars) {
				if (split1.substring(i).matches("^" + hash.key + ".*")) {
					number += hash.value;
					i += hash.key.length();
					break;
				}
			}
		}
		return number;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			KingSortHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				KingSortHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class KingSortHarness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String[] kings = { "Louis IX", "Louis VIII" };
			String[] expected__ = { "Louis VIII", "Louis IX" };

			return verifyCase(casenum, expected__, new KingSort().getSortedList(kings));
		}
		case 1: {
			String[] kings = { "Louis IX", "Philippe II" };
			String[] expected__ = { "Louis IX", "Philippe II" };

			return verifyCase(casenum, expected__, new KingSort().getSortedList(kings));
		}
		case 2: {
			String[] kings = { "Richard III", "Richard I", "Richard II" };
			String[] expected__ = { "Richard I", "Richard II", "Richard III" };

			return verifyCase(casenum, expected__, new KingSort().getSortedList(kings));
		}
		case 3: {
			String[] kings = { "John X", "John I", "John L", "John V" };
			String[] expected__ = { "John I", "John V", "John X", "John L" };

			return verifyCase(casenum, expected__, new KingSort().getSortedList(kings));
		}
		case 4: {
			String[] kings = { "Philippe VI", "Jean II", "Charles V", "Charles VI", "Charles VII", "Louis XI" };
			String[] expected__ = { "Charles V", "Charles VI", "Charles VII", "Jean II", "Louis XI", "Philippe VI" };

			return verifyCase(casenum, expected__, new KingSort().getSortedList(kings));
		}
		case 5: {
			String[] kings = { "Philippe II", "Philip II" };
			String[] expected__ = { "Philip II", "Philippe II" };

			return verifyCase(casenum, expected__, new KingSort().getSortedList(kings));
		}

		// custom cases

		case 6: {
			String[] kings = { "Richard III", "Richard I", "Richard II" };
			String[] expected__ = { "Richard I", "Richard II", "Richard III" };

			return verifyCase(casenum, expected__, new
					KingSort().getSortedList(kings));
		}
		case 7: {
			String[] kings = { "Carlos XIV", "Carlos XV" };
			String[] expected__ = { "Carlos XIV", "Carlos XV" };;

			return verifyCase(casenum, expected__, new
					KingSort().getSortedList(kings));	
		}
		case 10: {
			String[] kings = { "Carlos XXI", "Carlos IX", "Carlos XLIX", "Carlos XLIV", "Carlos XXXV", "Carlos XXIX",
					"Carlos XXXIII", "Carlos XXVI", "Carlos XIII", "Carlos XLVIII", "Carlos XL", "Carlos XXXVIII",
					"Carlos XI", "Carlos XXIII", "Carlos XXXVII", "Carlos XXVIII", "Carlos XXV", "Carlos XXX",
					"Carlos XLII", "Carlos XVIII", "Carlos III", "Carlos XV", "Carlos VIII", "Carlos XXIV",
					"Carlos XLVI", "Carlos II", "Carlos XIV", "Carlos VI", "Carlos L", "Carlos I", "Carlos XXXIX",
					"Carlos XLVII", "Carlos XXXVI", "Carlos XXVII", "Carlos XX", "Carlos XXII", "Carlos XIX",
					"Carlos XII", "Carlos XXXIV", "Carlos XVII", "Carlos XVI", "Carlos XXXII", "Carlos X", "Carlos V",
					"Carlos XXXI", "Carlos IV", "Carlos XLIII", "Carlos XLI", "Carlos XLV", "Carlos VII" };
			String[] expected__ = { "Carlos I", "Carlos II", "Carlos III", "Carlos IV", "Carlos V", "Carlos VI",
					"Carlos VII", "Carlos VIII", "Carlos IX", "Carlos X", "Carlos XI", "Carlos XII", "Carlos XIII",
					"Carlos XIV", "Carlos XV", "Carlos XVI", "Carlos XVII", "Carlos XVIII", "Carlos XIX", "Carlos XX",
					"Carlos XXI", "Carlos XXII", "Carlos XXIII", "Carlos XXIV", "Carlos XXV", "Carlos XXVI",
					"Carlos XXVII", "Carlos XXVIII", "Carlos XXIX", "Carlos XXX", "Carlos XXXI", "Carlos XXXII",
					"Carlos XXXIII", "Carlos XXXIV", "Carlos XXXV", "Carlos XXXVI", "Carlos XXXVII", "Carlos XXXVIII",
					"Carlos XXXIX", "Carlos XL", "Carlos XLI", "Carlos XLII", "Carlos XLIII", "Carlos XLIV",
					"Carlos XLV", "Carlos XLVI", "Carlos XLVII", "Carlos XLVIII", "Carlos XLIX", "Carlos L" };

			return verifyCase(casenum, expected__, new
					KingSort().getSortedList(kings));
		}

		/*
		 * case 8: {
		 * String[] kings = ;
		 * String[] expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * KingSort().getSortedList(kings));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
