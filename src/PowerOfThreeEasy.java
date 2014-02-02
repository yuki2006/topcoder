
public class PowerOfThreeEasy
{
	private static final String POSSIBLE = "Possible";
	private static final String IMPOSSIBLE = "Impossible";

	public String ableToGet(int x, int y)
	{
		int bitsX = get3adic(x);
		int bitsY = get3adic(y);
		if (bitsX == -1 || bitsY == -1) {
			return IMPOSSIBLE;
		}
		if ((bitsX & bitsY) > 0) {
			return IMPOSSIBLE;
		}
		int orBits = bitsX | bitsY;
		while (orBits > 0) {
			if ((orBits & 1) == 0) {
				return IMPOSSIBLE;
			}
			orBits >>= 1;
			
		}
		return POSSIBLE;
	}

	int get3adic(int num) {
		int p = 0;
		int result = 0;
		while (num > 0) {
			if (num % 3 == 2) {
				return -1;
			}
			result |= (num % 3) << p;
			num /= 3;
			p++;
		}
		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		PowerOfThreeEasy obj;
		String answer;
		obj = new PowerOfThreeEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.ableToGet(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer.equals(p2);
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + "\"" + p2 + "\"");
			}
			System.out.println("Your answer:");
			System.out.println("\t" + "\"" + answer + "\"");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		boolean disabled;
		boolean tests_disabled;
		all_right = true;
		tests_disabled = false;
		
		int p0;
		int p1;
		String p2;
		
		// ----- test 0 -----
		disabled = true;
		p0 = 1;
		p1 = 3;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = true;
		p0 = 1;
		p1 = 1;
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = true;
		p0 = 3;
		p1 = 0;
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = true;
		p0 = 1;
		p1 = 9;
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = true;
		p0 = 3;
		p1 = 10;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = true;
		p0 = 1093;
		p1 = 2187;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 6 -----
		disabled = true;
		p0 = 0;
		p1 = 0;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(6, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 7 -----
		disabled = true;
		p0 = 15;
		p1 = 1;
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(7, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 8 -----
		disabled = true;
		p0 = 27;
		p1 = 13;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(8, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 8 -----
		disabled = false;
		p0 = 68070;
		p1 = 820;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(8, p0, p1, true, p2) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		if (all_right) {
			if (tests_disabled) {
				System.out.println("You're a stud (but some test cases were disabled)!");
			} else {
				System.out.println("You're a stud (at least on given cases)!");
			}
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}

// Powered by KawigiEdit-pf 2.3.0!
