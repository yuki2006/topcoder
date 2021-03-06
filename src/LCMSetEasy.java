import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class LCMSetEasy
{
	int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	public String include(int[] S, int x)
	{
		int l = 1;
		for (int s : S) {
			if (x % s == 0) {
				l = lcm(l, s);
				if (l>x){
					return "?";
				}
			}
		}
		return l == x ? "Possible" : "Impossible";
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		LCMSetEasy obj;
		String answer;
		obj = new LCMSetEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.include(p0, p1);
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

		int[] p0;
		int p1;
		String p2;

		// ----- test 0 -----
		disabled = false;
		p0 = new int[] { 2, 3, 4, 5 };
		p1 = 20;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = new int[] { 2, 3, 4 };
		p1 = 611;
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = new int[] { 2, 3, 4 };
		p1 = 12;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		p1 = 24;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = new int[] { 100, 200, 300, 400, 500, 600 };
		p1 = 2000;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 5 -----
		disabled = false;
		p0 = new int[] { 100, 200, 300, 400, 500, 600 };
		p1 = 8000;
		p2 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 6 -----
		disabled = false;
		p0 = new int[] { 1000000000, 999999999, 999999998 };
		p1 = 999999999;
		p2 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(6, p0, p1, true, p2)) && all_right;
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
