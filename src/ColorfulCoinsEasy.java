public class ColorfulCoinsEasy {
    public String isPossible(int[] values) {
        int[] mul = new int[values.length - 1];
        int[] map = new int[20001];
        for (int i = 0; i < values.length - 1; i++) {
            mul[i] = values[i + 1] / values[i];
            map[mul[i] - 1]++;
        }
        for (int i = map.length - 1; i >= 1; i--) {
            while (map[i] > 1) {
                map[i]--;
                if (i == 1) {
                    return "Impossible";
                }
                map[i - 1]++;
            }
        }
        return "Possible";

    }

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ColorfulCoinsEasy obj;
		String answer;
		obj = new ColorfulCoinsEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.isPossible(p0);
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
		
		int[] p0;
		String p1;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new int[]{1};
		p1 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new int[]{1,3};
		p1 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new int[]{1,2,4};
		p1 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new int[]{1,5,15,90};
		p1 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new int[]{1,4,20,60,180,1440,5760};
		p1 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new int[]{1,7,21,105,630,3150,18900};
		p1 = "Possible";
		all_right = (disabled || KawigiEdit_RunTest(5, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 6 -----
		disabled = false;
		p0 = new int[]{1,10,30,300,900,9000,18000};
		p1 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(6, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 7 -----
		disabled = false;
		p0 = new int[]{1,2,10,40,200,1000,4000,20000};
		p1 = "Impossible";
		all_right = (disabled || KawigiEdit_RunTest(7, p0, true, p1) ) && all_right;
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

//Powered by KawigiEdit-pf 2.3.0!
