import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class TypoCoderDiv2
{
	public int count(int[] rating)
	{
		int count = 0;
		for (int i = 1; i < rating.length; i++) {
			int old=rating[i-1];
			int rat=rating[i];
			if (rat >= 1200 && old < 1200) {
				count++;
			} else if (rat < 1200 && old >= 1200) {
				count++;
			}
			old = rat;			
		}
		return count;
	}
	
	
	public int count2(int[] rating)
	{
		int count = 0;
		int old = 0;
		for (int rat : rating) {
			if (rat >= 1200 && old < 1200) {
				count++;
			} else if (rat < 1200 && old >= 1200) {
				count++;
			}
			old = rat;
		}
		return count;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		TypoCoderDiv2 obj;
		int answer;
		obj = new TypoCoderDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer == p1;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + p1);
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

		// ----- test 0 -----
		disabled = false;
		p0 = new int[] { 1000, 1200, 1199 };
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = new int[] { 1500, 2200, 900, 3000 };
		p1 = 3;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = new int[] { 600, 700, 800, 900, 1000, 1100, 1199 };
		p1 = 0;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = new int[] { 0, 4000, 0, 4000, 4000, 0, 0 };
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = new int[] { 575, 1090, 3271, 2496, 859, 2708, 3774, 2796, 1616, 2552, 3783, 2435, 1111, 526, 562 };
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1)) && all_right;
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