
public class EmoticonsDiv2 {
    public int check(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return i;
        }
        return n;
    }

    public int printSmiles(int smiles) {
        int result = 0;
        while (smiles != 1) {
            int sd = check(smiles);
            if (sd == smiles) return result + smiles;
            result += sd;
            smiles = smiles / sd;
        }
        return result;
    }
    //	public int printSmiles(int smiles) {
//		int         emotions = 1;
//		int turn = 0;
//		int clipboard = 0;
//		int result = dfs(smiles, emotions, turn, clipboard);
//		return result;
//	}
//
//	int dfs(int smiles, int emotions, int turn, int clipboard) {
//		if (emotions == smiles) {
//			return turn;
//		}
//		if (emotions > smiles) {
//			return -1;
//		}
//		// copy
//		int a = -1, b = -1;
//		if (emotions != clipboard) {
//			a = dfs(smiles, emotions, turn + 1, emotions);
//		}
//		// paste
//		if (clipboard > 0) {
//			b = dfs(smiles, emotions + clipboard, turn + 1, clipboard);
//		}
//		if (a != -1 && b != -1) {
//			int result = Math.min(a, b);
//			return result;
//		}
//		return Math.max(a, b);
//	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0,
			boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		EmoticonsDiv2 obj;
		int answer;
		obj = new EmoticonsDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.printSmiles(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0
				+ " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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

		int p0;
		int p1;

		// ----- test 0 -----
		disabled = false;
		p0 = 2;
		p1 = 2;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1))
				&& all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = 6;
		p1 = 5;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1))
				&& all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = 11;
		p1 = 11;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1))
				&& all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = 16;
		p1 = 8;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1))
				&& all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = 1000;
		p1 = 21;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1))
				&& all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		if (all_right) {
			if (tests_disabled) {
				System.out
						.println("You're a stud (but some test cases were disabled)!");
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
