import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class WinterAndReindeers
{
	public int getNumber(String[] allA, String[] allB, String[] allC)
	{
		String A = "";
		String B = "";
		String C = "";

		for (String string : allA) {
			A += string;
		}
		for (String string : allB) {
			B += string;
		}
		for (String string : allC) {
			C += string;
		}
		String newA = checkCto(C, A);
		String newB = checkCto(C, B);
		if (newA == null || newB == null) {
			return 0;
		}
		int atob = checkMap(newA, newB);
		int btoa = checkMap(newB, newA);
		return Math.max(atob, btoa) + C.length();
	}

	int checkMap(String A, String B) {
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < b.length; j++) {
				if (a[i] == b[j]) {
					b[j] = 0;
					count++;
					break;
				}
			}
		}
		return count;
	}

	String checkCto(String C, String n) {
		char[] cArray = C.toCharArray();
		char[] nArray = n.toCharArray();
		int j = nArray.length - 1;
		int count = 0;
		for (int i = cArray.length - 1; i >= 0; i--) {
			while (j >= 0) {
				if (cArray[i] == nArray[j]) {
					nArray[j] = 0;
					count++;
					j--;
					break;
				}
				j--;
			}

		}
		if (count == C.length()) {
			String ret = "";
			for (int i = 0; i < nArray.length; i++) {
				if (nArray[i] != 0) {
					ret += nArray[i];
				}
			}
			return ret;
		} else {
			return null;
		}
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, String[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p2[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		WinterAndReindeers obj;
		int answer;
		obj = new WinterAndReindeers();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			res = answer == p3;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
			if (hasAnswer) {
				System.out.println("Desired answer:");
				System.out.println("\t" + p3);
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
		
		String[] p0;
		String[] p1;
		String[] p2;
		int p3;
		
		// ----- test 0 -----
		disabled = true;
		p0 = new String[]{"X"};
		p1 = new String[]{"X","Y"};
		p2 = new String[]{"X"};
		p3 = 1;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{"ABCXD"};
		p1 = new String[]{"BCDEF"};
		p2 = new String[]{"CD"};
		p3 = 3;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"WE","LOVE"};
		p1 = new String[]{"WORKING","FOR","SANTA"};
		p2 = new String[]{"JK"};
		p3 = 0;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"ABCDE"};
		p1 = new String[]{"CDEAB"};
		p2 = new String[]{"B"};
		p3 = 2;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{"ABCABDEGAXAHDJBAAHFJDXBB","ABHFHCDALFDJDBBA","BABBAXAXXX"};
		p1 = new String[]{"ABLOCBAXBAHAJDXBIJKA","JBABCDAHKFIUDALPJAH","AABACX"};
		p2 = new String[]{"AXBADXBBAB","CDD"};
		p3 = 23;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, true, p3) ) && all_right;
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
