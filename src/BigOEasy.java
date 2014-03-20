import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BigOEasy
{
	public String isBounded(String[] graph)
	{
		int[] c = new int[100];
		int n = graph.length;
		for (int i = 0; i < n; i++) {
			int f = -1;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);

			while (!q.isEmpty()) {
				int now = q.poll();
				c[now] = 1;
				if (now == i) {
					f++;
					c[now] = 0;
					if (f >= 2)
						return "Unbounded";
				}
				for (int j = 0; j < n; j++) {
					if (c[j] == 0 && graph[now].charAt(j) == 'Y') {
						q.add(j);
					}
				}
			}
		}
		return "Bounded";

	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		BigOEasy obj;
		String answer;
		obj = new BigOEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.isBounded(p0);
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

		String[] p0;
		String p1;

		// ----- test 0 -----
		disabled = true;
		p0 = new String[] { "NYY", "YNY", "YYN" };
		p1 = "Unbounded";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = true;
		p0 = new String[] { "NYYN", "NNNY", "NNNY", "NNNN" };
		p1 = "Bounded";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = new String[] { "NYN", "NNY", "YNN" };
		p1 = "Bounded";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = new String[] { "NYYN", "YNNN", "NNNY", "NNYN" };
		p1 = "Bounded";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = new String[] { "NYY", "YNN", "YNN" };
		p1 = "Unbounded";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 5 -----
		disabled = false;
		p0 = new String[] { "NYNYN", "NNYNY", "YNNNN", "NNNNN", "YNNNN" };
		p1 = "Unbounded";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 6 -----
		disabled = false;
		p0 = new String[] { "NYYN", "NNYN", "NNNY", "YNNN" };
		p1 = "Unbounded";
		all_right = (disabled || KawigiEdit_RunTest(6, p0, true, p1)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 7 -----
		disabled = false;
		p0 = new String[] { "NYYNNNNYNNYNYNNNNYYNNYNYNNNNNNNNNNYNNNNNNNYYNYNNNN",
				"NNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
				"NNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYNYYYYYNYYN",
				"YYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNNNN",
				"YYYNYNNYNNYYYNNNYYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"YYYYYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYYN",
				"NYYNNNNNNNYNYNNNNYNNNNNYNNNNNNNNNNNNNNNNNNYNNYNNNN",
				"YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYYYYYYYYNYNYYYNYNYNN",
				"YYYNYNNYNNYYYNNNNYYNYYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"NNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYYNNNNNNYYNYNNNN",
				"NNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
				"YYYNYNNYYNYYYNNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"YYYNYNNYNNYYYNNNNYYYNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"YYYNYNNYNNYYYNNNNYYNNYYYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"YYYNYNNYNYYYYNNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"NNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "NYYNNNNNNNYNYNNNNYNNNNNYNNNNNNNNNNYNNNNNNNNNNY" +
						"NNNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNYYYYYYYYNYYYNYNYNN",
				"YYYNYNNYNNYYYNNNNYYNNYNYYNYNYYYNYYYYYYNYNYYYNYNYNN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNYNNNYNNNNNNNYYNYNNNN",
				"YYYNYYNYNNYYYNNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNN",
				"YYYNYNNYNNYYYYNNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYYY",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNYNNNNNYNNNNNNNYYNYNNNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYYYYYYYNYYN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNYNN",
				"NYYNNNNYNNYYYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNNNN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNYNNNNNNNYNNNNNNNYYNYNNNN",
				"YYYNYNNYNNYYYNYNNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNNYYYNYNYNYYYNYNYNN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNYNNYYNYNNNN",
				"NYYNNNNYNNYNYNNNNYNNNNNYNNNNNNNNNNNNNNNNNNNNNYNNNN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNYYNNNNNNNYYNYNNNN",
				"YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNYYYYNNNYNYYYNYNYNN", "YYYNYNNYNNYYYNNNNYYNNYNYNNYNYYYNNYYYYNNY" +
						"NYYYNYNYNN", "YYYNYNNYNNYYYNNYNYYNNYNYNNYNYYYNYYYYYYNYNYYYNYNYNN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNYYYNYNNNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYYYYN",
				"NYYNYNNYNNYNYNNNNYYNNNNYNNNNNNNNNNYNNNNNNNYYNYNNNN",
				"NYYNNNNNNNYNYNNNNYNNNNNYNNNNNNNNNNNNNNNNNNNYNYNNNN",
				"NYYNNNNNNNYNYNNNNYYNNNNYNNNNNNNNNNNNNNNNNNNNNYNNNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYNYNYNN",
				"NYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYNYYYYYNYYN",
				"NYYNNNNYNNYNYNNNNYYNNNNYNNNNNYNNNNYNNNNNNNYYNYNNNN",
				"YYYNYYNYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYNN",
				"YYYNYYYYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYNYYYYYNYYN" };
		p1 = "Bounded";
		all_right = (disabled || KawigiEdit_RunTest(7, p0, true, p1)) && all_right;
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
