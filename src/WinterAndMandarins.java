import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class WinterAndMandarins
{
	public int getNumber(int[] bags, int K)
	{
		Arrays.sort(bags);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + (K - 1) < bags.length; i++) {
			int diff = bags[i + K - 1] - bags[i];
			min = Math.min(diff, min);
		}
		return min;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		WinterAndMandarins obj;
		int answer;
		obj = new WinterAndMandarins();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer == p2;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + p2);
			}
			System.out.println("Your answer:");
			System.out.println("\t" + answer);
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
		int p2;

		// ----- test 0 -----
		disabled = false;
		p0 = new int[] { 10, 20, 30 };
		p1 = 2;
		p2 = 10;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = new int[] { 4, 7, 4 };
		p1 = 3;
		p2 = 3;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = new int[] { 4, 1, 2, 3 };
		p1 = 3;
		p2 = 2;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = new int[] { 5, 4, 6, 1, 9, 4, 2, 7, 5, 6 };
		p1 = 4;
		p2 = 1;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = new int[] { 47, 1000000000, 1, 74 };
		p1 = 2;
		p2 = 27;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
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
