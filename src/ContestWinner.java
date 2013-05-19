import java.util.HashMap;

// Paste me into the FileEdit configuration dialog

public class ContestWinner {
	public int getWinner(int[] events) {
		int[] data = new int[1000000001];
		int max = 0;
		int tmp = 0;
		for (int event : events) {
			data[event]++;
			if (max < data[event]) {
				max = data[event];
				tmp = event;
			}
		}

		return tmp;
	}







	public int getWinner2(int[] events) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		int tmp = 0;
		for (int event : events) {
			int count = 0;
			if (map.containsKey(event)) {
				count = map.get(event);
			}
			count++;
			map.put(event, count);
			if (max < count) {
				max = count;
				tmp = event;
			}
		}
		return tmp;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {

		if (args.length == 0) {
			ContestWinnerHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ContestWinnerHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}


// END CUT HERE
//BEGIN CUT HERE
class ContestWinnerHarness {
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
			int[] events              = {4,7,4,1};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}
		case 1: {
			int[] events              = {10,20,30,40,50};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}
		case 2: {
			int[] events              = {123,123,456,456,456,123};
			int expected__            = 456;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}
		case 3: {
			int[] events              = {1,2,2,3,3,3,4,4,4,4};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}

		// custom cases

/*      case 4: {
			int[] events              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}*/
/*      case 5: {
			int[] events              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}*/
/*      case 6: {
			int[] events              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ContestWinner().getWinner(events));
		}*/
		default:
			return -1;
		}
	}
}

//END CUT HERE
