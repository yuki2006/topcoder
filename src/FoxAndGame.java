// Paste me into the FileEdit configuration dialog
// SRM 571 DIV 2 - 250.0

public class FoxAndGame {
   public int countStars(String[] result) {
		int total=0;
		for (String s : result) {
			for (char c : s.toCharArray()) {
				if (c=='o'){
					total++;
				}
			}
		}
		return total;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndGameHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FoxAndGameHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndGameHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
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
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
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
		switch(casenum__) {
		case 0: {
			String[] result           = {"ooo",
 "ooo"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}
		case 1: {
			String[] result           = {"ooo",
 "oo-",
 "o--"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}
		case 2: {
			String[] result           = {"ooo",
 "---",
 "oo-",
 "---",
 "o--"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}
		case 3: {
			String[] result           = {"o--",
 "o--",
 "o--",
 "ooo",
 "---"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}
		case 4: {
			String[] result           = {"---",
 "o--",
 "oo-",
 "ooo",
 "ooo",
 "oo-",
 "o--",
 "---"};
			int expected__            = 12;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}
		case 5: {
			String[] result           = {"---",
 "---",
 "---",
 "---",
 "---",
 "---"};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}
		case 6: {
			String[] result           = {"oo-"};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}

		// custom cases

/*      case 7: {
			String[] result           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}*/
/*      case 8: {
			String[] result           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}*/
/*      case 9: {
			String[] result           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FoxAndGame().countStars(result));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
