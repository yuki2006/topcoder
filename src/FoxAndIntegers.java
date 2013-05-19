// Paste me into the FileEdit configuration dialog

public class FoxAndIntegers {
   public int[] get(int AminusB, int BminusC, int AplusB, int BplusC) {
		int a = (AminusB + AplusB);
		int b = (BminusC + BplusC);
		int c = (BplusC - BminusC);

		if ((a % 2 != 0) || (b % 1 != 0) || (c % 1 != 0)) {
			return new int[] {};
		}
		if (a - b == AminusB * 2 && b - c == BminusC * 2 && a + b == AplusB * 2
				&& b + c == BplusC * 2) {
			return new int[] { a / 2, b / 2, c / 2 };
		}
		return new int[] {};

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndIntegersHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FoxAndIntegersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndIntegersHarness {
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

	static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, int[] expected, int[] received) {
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
		switch(casenum) {
		case 0: {
			int AminusB               = 1;
			int BminusC               = -2;
			int AplusB                = 3;
			int BplusC                = 4;
			int[] expected__          = {2, 1, 3 };

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}
		case 1: {
			int AminusB               = 0;
			int BminusC               = 0;
			int AplusB                = 5;
			int BplusC                = 5;
			int[] expected__          = { };

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}
		case 2: {
			int AminusB               = 10;
			int BminusC               = -23;
			int AplusB                = -10;
			int BplusC                = 3;
			int[] expected__          = {0, -10, 13 };

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}
		case 3: {
			int AminusB               = -27;
			int BminusC               = 14;
			int AplusB                = 13;
			int BplusC                = 22;
			int[] expected__          = { };

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}
		case 4: {
			int AminusB               = 30;
			int BminusC               = 30;
			int AplusB                = 30;
			int BplusC                = -30;
			int[] expected__          = {30, 0, -30 };

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}

		// custom cases

      case 5: {
			int AminusB               =-18 ;
			int BminusC               =5 ;
			int AplusB                =1 ;
			int BplusC                =14 ;
			int[] expected__          ={} ;

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}
/*      case 6: {
			int AminusB               = ;
			int BminusC               = ;
			int AplusB                = ;
			int BplusC                = ;
			int[] expected__          = ;

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}*/
/*      case 7: {
			int AminusB               = ;
			int BminusC               = ;
			int AplusB                = ;
			int BplusC                = ;
			int[] expected__          = ;

			return verifyCase(casenum, expected__, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
