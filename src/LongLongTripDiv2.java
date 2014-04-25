import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class LongLongTripDiv2 {
	
	public String isAble(long D, int T, int B) {
		long remain = D-T;
		if (remain == 0) {
			return "Possible";
		}
		if (remain < 0) {
			return "Impossible";
		}
		int diff = B - 1;
		if (remain % diff == 0 && remain / diff <= T) {
			return "Possible";
		}
		return "Impossible";

	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, long p0, int p1, int p2, boolean hasAnswer, String p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		LongLongTripDiv2 obj;
		String answer;
		obj = new LongLongTripDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.isAble(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p3 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p3);
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
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
		
		long p0;
		int p1;
		int p2;
		String p3;
		
		// ----- test 0 -----
		disabled = false;
		p0 = 10L;
		p1 = 6;
		p2 = 3;
		p3 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = 10L;
		p1 = 5;
		p2 = 3;
		p3 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = 50L;
		p1 = 100;
		p2 = 2;
		p3 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = 120L;
		p1 = 10;
		p2 = 11;
		p3 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = 10L;
		p1 = 10;
		p2 = 9999;
		p3 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = 1000L;
		p1 = 100;
		p2 = 10;
		p3 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 6 -----
		disabled = false;
		p0 = 1000010000100001L;
		p1 = 1100011;
		p2 = 1000000000;
		p3 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(6, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		// ----- test 7 -----
		disabled = false;
		p0 = 100L;
		p1 = 1;
		p2 = 99;
		p3 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(7, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 8 -----
		disabled = false;
		p0 = 100L;
		p1 = 2;
		p2 = 99;
		p3 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(8, p0, p1, p2, true, p3) ) && all_right;
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