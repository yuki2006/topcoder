import java.util.HashSet;

// Paste me into the FileEdit configuration dialog
// Single Round Match 584 - Round 1250.0
public class TopFox {
   public int possibleHandles(String familyName, String givenName) {
	HashSet<String> set=new HashSet<String>();
	for (int i = 0; i < familyName.length(); i++) {
		for (int j = 0; j < givenName.length(); j++) {
			set.add(familyName.substring(0, i+1)
					+givenName.substring(0,j+1)
					);
			
		}
	}
	return set.size();

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			TopFoxHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TopFoxHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class TopFoxHarness {
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
			String familyName         = "ab";
			String givenName          = "cd";
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}
		case 1: {
			String familyName         = "abb";
			String givenName          = "bbc";
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}
		case 2: {
			String familyName         = "fox";
			String givenName          = "ciel";
			int expected__            = 12;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}
		case 3: {
			String familyName         = "abbbb";
			String givenName          = "bbbbbbbc";
			int expected__            = 16;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}
		case 4: {
			String familyName         = "abxy";
			String givenName          = "xyxyxc";
			int expected__            = 21;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}
		case 5: {
			String familyName         = "ababababab";
			String givenName          = "bababababa";
			int expected__            = 68;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}

		// custom cases

/*      case 6: {
			String familyName         = ;
			String givenName          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}*/
/*      case 7: {
			String familyName         = ;
			String givenName          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}*/
/*      case 8: {
			String familyName         = ;
			String givenName          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TopFox().possibleHandles(familyName, givenName));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
