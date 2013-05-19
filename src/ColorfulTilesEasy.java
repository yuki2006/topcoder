// Paste me into the FileEdit configuration dialog

public class ColorfulTilesEasy {
   public int theMin(String room) {
		byte[] bytes = room.getBytes();
		int count=0;
		for (int i = 1; i < bytes.length; i++) {
			if (bytes[i-1]==bytes[i]){
				count++;
				bytes[i]='L';
			}
		}
		return count;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ColorfulTilesEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ColorfulTilesEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ColorfulTilesEasyHarness {
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
			String room               = "RRRRRR";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}
		case 1: {
			String room               = "GGGGGGG";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}
		case 2: {
			String room               = "BBBYYYYYY";
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}
		case 3: {
			String room               = "BRYGYBGRYR";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}
		case 4: {
			String room               = "RGGBBBRYYB";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}

		// custom cases

/*      case 5: {
			String room               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}*/
/*      case 6: {
			String room               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}*/
/*      case 7: {
			String room               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ColorfulTilesEasy().theMin(room));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
