// Paste me into the FileEdit configuration dialog

public class MirroredClock {

	public String whatTimeIsIt(String time) {
		String[] split = time.split(":");
		int hour = Integer.valueOf(split[0]);
		int second = Integer.valueOf(split[1]);
		if (second > 0) {
			hour++;
		}
		hour = (12 - hour) % 12;
		second = (60 - second) % 60;

		// String out = "";
		// if (hour < 10) {
		// out += "0";
		// }
		// out += hour;
		// out += ":";
		//
		// if (second < 10) {
		// out += "0";
		// }
		// out += second;
		// return out;

		return String.format("%02d:%02d", hour, second);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			MirroredClockHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				MirroredClockHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class MirroredClockHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

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
		switch (casenum__) {
		case 0: {
			String time = "10:00";
			String expected__ = "02:00";

			return verifyCase(casenum__, expected__,
					new MirroredClock().whatTimeIsIt(time));
		}
		case 1: {
			String time = "01:15";
			String expected__ = "10:45";

			return verifyCase(casenum__, expected__,
					new MirroredClock().whatTimeIsIt(time));
		}
		case 2: {
			String time = "03:40";
			String expected__ = "08:20";

			return verifyCase(casenum__, expected__,
					new MirroredClock().whatTimeIsIt(time));
		}
		case 3: {
			String time = "00:00";
			String expected__ = "00:00";

			return verifyCase(casenum__, expected__,
					new MirroredClock().whatTimeIsIt(time));
		}
		case 4: {
			String time = "11:53";
			String expected__ = "00:07";

			return verifyCase(casenum__, expected__,
					new MirroredClock().whatTimeIsIt(time));
		}

		// custom cases

		/*
		 * case 5: { String time = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MirroredClock().whatTimeIsIt(time)); }
		 */
		/*
		 * case 6: { String time = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MirroredClock().whatTimeIsIt(time)); }
		 */
		/*
		 * case 7: { String time = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * MirroredClock().whatTimeIsIt(time)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
