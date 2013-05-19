
// Paste me into the FileEdit configuration dialog

public class TheJediTestDiv2 {
	public static int[] copyOf(int[] students, int newLength) {
		int[] copy = new int[newLength];

		System.arraycopy(students, 0, copy, 0,
				Math.min(students.length, newLength));
		return copy;
	}

	public int countSupervisors(int[] students, int Y, int J) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < students.length; i++) {
			int[] copy = copyOf(students, students.length);
			// copy[i] = Math.max(copy[i] - Y, 0);
			copy[i] -= Math.min(copy[i], Y);
			int count = 0;
			for (int j = 0; j < students.length; j++) {
				count += (copy[j] % J > 0 ? 1 : 0) + copy[j] / J;
			}
			min = Math.min(min, count);

		}
		return min;

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TheJediTestDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheJediTestDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class TheJediTestDiv2Harness {
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

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			int[] students = { 10, 15 };
			int Y = 12;
			int J = 5;
			int expected__ = 3;

			return verifyCase(casenum, expected__,
					new TheJediTestDiv2().countSupervisors(students, Y, J));
		}
		case 1: {
			int[] students = { 11, 13, 15 };
			int Y = 9;
			int J = 5;
			int expected__ = 7;

			return verifyCase(casenum, expected__,
					new TheJediTestDiv2().countSupervisors(students, Y, J));
		}
		case 2: {
			int[] students = { 10 };
			int Y = 100;
			int J = 2;
			int expected__ = 0;

			return verifyCase(casenum, expected__,
					new TheJediTestDiv2().countSupervisors(students, Y, J));
		}
		case 3: {
			int[] students = { 0, 0, 0, 0, 0 };
			int Y = 145;
			int J = 21;
			int expected__ = 0;

			return verifyCase(casenum, expected__,
					new TheJediTestDiv2().countSupervisors(students, Y, J));
		}
		case 4: {
			int[] students = { 4, 7, 10, 5, 6, 55, 2 };
			int Y = 20;
			int J = 3;
			int expected__ = 26;

			return verifyCase(casenum, expected__,
					new TheJediTestDiv2().countSupervisors(students, Y, J));
		}

		// custom cases

		/*
		 * case 5: { int[] students = ; int Y = ; int J = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TheJediTestDiv2().countSupervisors(students, Y, J)); }
		 */
		/*
		 * case 6: { int[] students = ; int Y = ; int J = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TheJediTestDiv2().countSupervisors(students, Y, J)); }
		 */
		/*
		 * case 7: { int[] students = ; int Y = ; int J = ; int expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new
		 * TheJediTestDiv2().countSupervisors(students, Y, J)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
