import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class InterestingNumber
{
	public String isInteresting(String x)
	{
		char[] charArray = x.toCharArray();
		for (int num = 0; num < 10; num++) {
			int count = 0;
			for (int i = 0; i < charArray.length; i++) {
				final int c = (charArray[i] - '0');
				if (c != num) {
					continue;
				}
				count++;
			}
			if (!(count == 0 || count == 2)) {
				return "Not interesting";
			}
		}
		for (int i = 0; i < charArray.length; i++) {
			final int c = (charArray[i] - '0');
			int j = i + c + 1;
			int k = i - c - 1;
			boolean hit = false;
			if (x.length() > j && charArray[i] == charArray[j]) {
				hit ^= true;
			}
			if (k >= 0 && charArray[i] == charArray[k]) {
				hit ^= true;
			}
			if (!hit)
				return "Not interesting";
		}
		return "Interesting";

	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		InterestingNumber obj;
		String answer;
		obj = new InterestingNumber();
		long startTime = System.currentTimeMillis();
		answer = obj.isInteresting(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer.equals(p1);
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + "\"" + p1 + "\"");
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

		String p0;
		String p1;

		// ----- test 0 -----
		disabled = false;
		p0 = "2002";
		p1 = "Interesting";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = "1001";
		p1 = "Not interesting";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = "41312432";
		p1 = "Interesting";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = "611";
		p1 = "Not interesting";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = "64200246";
		p1 = "Interesting";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 5 -----
		disabled = false;
		p0 = "631413164";
		p1 = "Not interesting";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 6 -----
		disabled = false;
		p0 = "00";
		p1 = "Interesting";
		all_right = (disabled || KawigiEdit_RunTest(6, p0, true, p1)) && all_right;
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
