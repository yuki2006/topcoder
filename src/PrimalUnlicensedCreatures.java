import java.util.Arrays;

// Paste me into the FileEdit configuration dialog
// Single Round Match 579 - Round 1250.0

public class PrimalUnlicensedCreatures {
   public int maxWins(int initialLevel, int[] grezPower) {
		Arrays.sort(grezPower);
		int count=0;
		for (int p : grezPower) {
			if (initialLevel>p){
				initialLevel+=p/2;
				count++;
			}
		}
		return count;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			PrimalUnlicensedCreaturesHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PrimalUnlicensedCreaturesHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class PrimalUnlicensedCreaturesHarness {
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
			int initialLevel          = 31;
			int[] grezPower           = {10, 20, 30};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}
		case 1: {
			int initialLevel          = 20;
			int[] grezPower           = {24, 5, 6, 38};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}
		case 2: {
			int initialLevel          = 20;
			int[] grezPower           = {3, 3, 3, 3, 3, 1, 25 };
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}
		case 3: {
			int initialLevel          = 4;
			int[] grezPower           = {3, 13, 6, 4, 9};
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}
		case 4: {
			int initialLevel          = 7;
			int[] grezPower           = {7, 8, 9, 10};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}

		// custom cases

/*      case 5: {
			int initialLevel          = ;
			int[] grezPower           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}*/
/*      case 6: {
			int initialLevel          = ;
			int[] grezPower           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}*/
/*      case 7: {
			int initialLevel          = ;
			int[] grezPower           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PrimalUnlicensedCreatures().maxWins(initialLevel, grezPower));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
