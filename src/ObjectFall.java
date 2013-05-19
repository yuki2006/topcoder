import java.util.ArrayList;
import java.util.Collections;

// Paste me into the FileEdit configuration dialog
// $METADATA$
public class ObjectFall {
	private class Obj implements Comparable<Obj> {
		int y;
		int x1;
		int x2;
		/*
		 * (非 Javadoc)
		 *
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Obj o) {
			return y < o.y ? 1 : -1;
		}

		/* (非 Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Obj [y=" + this.y + ", x1=" + this.x1 + ", x2=" + this.x2 + "]";
		}

	}

	public int howLong(int x, int y, String[] obstacles) {
		ArrayList<Obj> list = new ArrayList<Obj>();
		for (String tmp : obstacles) {
			String[] split = tmp.split(" ");
			Obj e = new Obj();
			list.add(e);
			e.y = Integer.valueOf(split[0]);
			e.x1 = Integer.valueOf(split[1]);
			e.x2 = Integer.valueOf(split[2]);
		}
		Collections.sort(list);
		int time = 0;
		for (Obj obj : list) {
			if (obj.y <= y && obj.x1 <= x && x <= obj.x2) {
				x = obj.x2;
				time += 5 + (y - obj.y);
				y= obj.y;
			}
		}
		time += y;
		return time;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			ObjectFallHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ObjectFallHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class ObjectFallHarness {
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

	static boolean compareOutput(int expected, int result) {
		return expected == result;
	}

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
		switch (casenum__) {
		case 0: {
			int x = 15;
			int y = 10;
			String[] obstacles = { "005 010 020" };
			int expected__ = 15;

			return verifyCase(casenum__, expected__, new ObjectFall().howLong(x, y, obstacles));
		}
		case 1: {
			int x = 15;
			int y = 12;
			String[] obstacles = { "010 010 020", "015 010 020", "005 020 050" };
			int expected__ = 22;

			return verifyCase(casenum__, expected__, new ObjectFall().howLong(x, y, obstacles));
		}
		case 2: {
			int x = 50;
			int y = 85;
			String[] obstacles = { "020 001 100", "010 100 100", "005 100 200" };
			int expected__ = 100;

			return verifyCase(casenum__, expected__, new ObjectFall().howLong(x, y, obstacles));
		}
		case 3: {
			int x = 10;
			int y = 1000;
			String[] obstacles = {};
			int expected__ = 1000;

			return verifyCase(casenum__, expected__, new ObjectFall().howLong(x, y, obstacles));
		}
		case 4: {
			int x = 500;
			int y = 800;
			String[] obstacles = { "800 001 500", "400 001 499", "401 501 999" };
			int expected__ = 805;

			return verifyCase(casenum__, expected__, new ObjectFall().howLong(x, y, obstacles));
		}
		case 5: {
			int x = 645;
			int y = 802;
			String[] obstacles = { "739 038 799", "916 169 791", "822 372 911", "162 125 992", "261 307 545",
					"510 031 765", "592 723 742", "477 315 676", "566 143 617", "337 114 664",
					"986 648 883", "116 230 680", "254 746 943", "742 948 988", "060 117 401",
					"634 035 433", "288 741 864", "819 626 730", "906 071 222", "554 100 121",
					"573 051 551", "949 528 915", "562 151 223", "857 135 243", "621 115 474",
					"588 405 615", "895 812 919", "052 378 836", "858 116 505", "285 428 469",
					"792 244 250", "109 265 637", "714 804 885", "625 150 410", "518 593 921",
					"282 235 339", "081 212 659", "663 047 982", "556 194 345", "798 150 938",
					"391 026 813", "886 348 796", "975 007 743", "053 854 895", "243 561 875" };
			int expected__ = 817;

			return verifyCase(casenum__, expected__, new ObjectFall().howLong(x, y, obstacles));
		}

		// custom cases

		/*
		 * case 6: {
		 * int x = ;
		 * int y = ;
		 * String[] obstacles = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new ObjectFall().howLong(x,
		 * y, obstacles));
		 * }
		 */
		/*
		 * case 7: {
		 * int x = ;
		 * int y = ;
		 * String[] obstacles = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new ObjectFall().howLong(x,
		 * y, obstacles));
		 * }
		 */
		/*
		 * case 8: {
		 * int x = ;
		 * int y = ;
		 * String[] obstacles = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new ObjectFall().howLong(x,
		 * y, obstacles));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
