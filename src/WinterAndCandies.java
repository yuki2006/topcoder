import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class WinterAndCandies
{
	public int getNumber(int[] type)
	{
		Arrays.sort(type);
		int now = 1;
		int[] his = new int[50+1];
		int count = 0;
		for (int i = 0; i < type.length; i++) {
			if (type[i] == now) {
				count++;
			} else if (type[i] == now + 1) {
				his[now] = count;
				count = 1;
				now++;
			} else {
				break;
			}
		}
		//last
		his[now] = count;
		
		int sum = 0;
		int mul = 1;
		for (int i = 1; i < his.length; i++) {
			mul = his[i] * mul;
			sum += mul;
		}
		return sum;
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
		WinterAndCandies obj;
		int answer;
		obj = new WinterAndCandies();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0);
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
		p0 = new int[]{1,3,2};
		p1 = 3;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1,1,2};
		p1 = 4;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{1,3,2,5,7,4,5,4};
		p1 = 9;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{1,1,2,2,3,3,4,4,5,5};
		p1 = 62;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{2};
		p1 = 0;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new int[]{1,2,3,4,5,6,7,8,9,9};
		p1 = 10;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
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
