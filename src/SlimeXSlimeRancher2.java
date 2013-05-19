// Paste me into the FileEdit configuration dialog
// SRM 506 DIV 2 - 250.0

public class SlimeXSlimeRancher2 {
   public int train(int[] attributes) {
		int max=0;
		for (int i : attributes) {
			max=Math.max(max, i);
		}
		int sum=0;
		for (int i : attributes) {
			sum+=max-i;
		}
		return sum;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SlimeXSlimeRancher2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SlimeXSlimeRancher2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SlimeXSlimeRancher2Harness {
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
			int[] attributes          = {1,2,3};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new SlimeXSlimeRancher2().train(attributes));
		}
		case 1: {
			int[] attributes          = {5,5};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new SlimeXSlimeRancher2().train(attributes));
		}
		case 2: {
			int[] attributes          = {900,500,100};
			int expected__            = 1200;

			return verifyCase(casenum__, expected__, new SlimeXSlimeRancher2().train(attributes));
		}

		// custom cases

/*      case 3: {
			int[] attributes          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SlimeXSlimeRancher2().train(attributes));
		}*/
/*      case 4: {
			int[] attributes          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SlimeXSlimeRancher2().train(attributes));
		}*/
/*      case 5: {
			int[] attributes          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SlimeXSlimeRancher2().train(attributes));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
