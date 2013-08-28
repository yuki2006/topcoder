// Paste me into the FileEdit configuration dialog
// Single Round Match 587 - Round 1250.0

public class InsertZ {
   public String canTransform(String init, String goal) {
		if (init.equals(goal.replace("z", ""))){
			return "Yes";
		}
		return "No";
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			InsertZHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				InsertZHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class InsertZHarness {
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
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
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
		switch(casenum__) {
		case 0: {
			String init               = "fox";
			String goal               = "fozx";
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}
		case 1: {
			String init               = "fox";
			String goal               = "zfzoxzz";
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}
		case 2: {
			String init               = "foon";
			String goal               = "foon";
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}
		case 3: {
			String init               = "topcoder";
			String goal               = "zopzoder";
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}
		case 4: {
			String init               = "aaaaaaaaaa";
			String goal               = "a";
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}
		case 5: {
			String init               = "mvixrdnrpxowkasufnvxaq";
			String goal               = "mvizzxzzzrdzznzrpxozzwzzkazzzszzuzzfnvxzzzazzq";
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}
		case 6: {
			String init               = "opdlfmvuicjsierjowdvnx";
			String goal               = "zzopzdlfmvzuicjzzsizzeijzowvznxzz";
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}

		// custom cases

/*      case 7: {
			String init               = ;
			String goal               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}*/
/*      case 8: {
			String init               = ;
			String goal               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}*/
/*      case 9: {
			String init               = ;
			String goal               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new InsertZ().canTransform(init, goal));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
