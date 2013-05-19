// Paste me into the FileEdit configuration dialog

public class GogoXCake {
	public String solve(String[] cake, String[] cutter) {
		boolean[][] cakeB = new boolean[cake.length][cake[0].length()];
		int count = 0;
		for (int i = 0; i < cake.length; i++) {
			for (int j = 0; j < cake[i].length(); j++) {
				if (cake[i].charAt(j) == '.') {
					cakeB[i][j] = false;
					count++;
				} else
				{
					cakeB[i][j] = true;
				}
			}
		}
		for (int i = 0; i <= cakeB.length - cutter.length; i++) {
			for (int j = 0; j <= cakeB[i].length - cutter[0].length(); j++) {
				boolean putFlag = false;

				SECOND: for (int ic = 0; ic < cutter.length; ic++) {
					for (int jc = 0; jc < cutter[0].length(); jc++) {

						if (cutter[ic].charAt(jc) == '.' && cakeB[i + ic][j + jc] == false) {
							cakeB[i + ic][j + jc] = true;
							count--;
							putFlag = true;
						} else if (putFlag && cutter[ic].charAt(jc) == '.' && cakeB[i + ic][j + jc]) {
							// 初めはおけたのに次が置けてない
							return "NO";
						} else if (cutter[ic].charAt(jc) == '.' && cakeB[i + ic][j + jc]) {
							// 初めも置けてない
							break SECOND;
						}

					}
				}
			}
		}
		if (count == 0) {
			return "YES";
		}
		return "NO";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			GogoXCakeHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				GogoXCakeHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class GogoXCakeHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i = 0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100)
					break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected));
			System.err.println("    Received: " + formatResult(received));
			return 0;
		}
	}

	static int runTestCase(int casenum) {
		switch (casenum) {
		case 0: {
			String[] cake = { "X.X", "...", "...", "X.X" };
			String[] cutter = { ".X", "..", "X." };
			String expected__ = "YES";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}
		case 1: {
			String[] cake = { "..XX", "...X", "X...", "XX.." };
			String[] cutter = { "..", ".." };
			String expected__ = "NO";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}
		case 2: {
			String[] cake = { "...X..." };
			String[] cutter = { "..." };
			String expected__ = "YES";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}
		case 3: {
			String[] cake = { ".X.", "X.X", ".X." };
			String[] cutter = { "." };
			String expected__ = "YES";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}
		case 4: {
			String[] cake = { "XXXXXXX", "X.....X", "X.....X", "X.....X", "XXXXXXX" };
			String[] cutter = { ".X.", "XXX", ".X." };
			String expected__ = "NO";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}
		case 5: {
			String[] cake = { "..", "X.", ".X" };
			String[] cutter = { "..", ".X", "X." };
			String expected__ = "NO";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}
		case 6: {
			String[] cake = { "X..", ".XX", ".XX" };
			String[] cutter = { ".XX", ".XX", "X.." };
			String expected__ = "NO";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake, cutter));
		}

		// custom cases

		case 7: {
			String[] cake = { "XXX.X.XXX.XX.XXXXX..XXX.XXXXXX.XXXXXXXXX.XXX.X.XXX",
					"X..X..XX.X..X.X.X....X..XXXXX.XXXXXX.XX.XXX...XXX.",
					".XXX.X.XX..X...XXX..XX.XXXX..X.X.XX.XX.XXXX...XX.X",
					"X.XXX.XXX.XX..XX.XXXXX...X..X.X.XXXXX..XX....XX..X",
					".XXXXX.XX.XX.XX.X.X.X...X.XXXXXXX.XXX.X...XX.....X",
					"XXX.X.X..XX..X.X.X.XXXX..XXXXX.X.XXXXX.XXXX..XX...",
					"XX..XX.X.X..X.XXX.XXXX.X.X.XX.X.X.X.XXXXX.X.X.X..X",
					"X...XXX.XXXXXXX..XXX.XX.X.XXX..X.X.XXXX..X......XX",
					"...XXXXXXX.XXX....X....X.XXX.XXXX.XX.X..XX.X.....X",
					"...XXX.XX.XX......X...X.X..XXXX..XX..X...XXXXX..XX",
					"..XXX.XXXXX..XX..XXXXXXX..XXXX..XX...X...XXXXXXXX.",
					"XXXXXX.X.XXXXX.XXXXXXXX.XXXX...XX.X.XXX...XXXXX...",
					"XX.XX.X.XX.X.X.XXXXXX..X..X..XXX....XXX..XXXXX.X..",
					"X.X.XX.X..X.X.XXXXXX..X....X.XX....XXXXXXXX...XX..",
					"XX.XX.X.XXXXXXX.XXXX.XXX..X.XXXX..XXXXXXX....XXX.X",
					"XX.XX...X..XXX.XX.XXXXX.XXXXXXX...XXXXX..XXXXXXXXX",
					"X.XX...X..XXXXXX.XXXXX.XXXXXXX.X.X.XXX.XXX.XX.XX.X",
					"XXXXXXXXX..XXXX.XXXXXXXX.XXX...XX.XXX.XX........XX",
					"X.XXXXXX..XXXX..XXXXXXX.XX....XXXX...XX.X......XXX",
					".XXXXXXXX.X.XX.X.XXX.XXXX.X.X..XX...XXXXXX.XX.XX.X",
					"XXXX.XX..X.XXXX.XXX.XX..XXXX..XXXX.XXXXXXX.XXX..X.",
					"X.X..X.XX.XXX.XXXXXXX...XXXXXXXXXX.XX..X..X...XX.X",
					".XX..X.X..X..X.X.XXXXX..XXXXXX....XX..X..X..XXXXXX",
					"XXX...X..X....X.XXX.XX..X..XX...XXX.XX..XXXXXX.XXX",
					"X.X..X.XXX..XXXX.X.XXX....XXXX.XXX..X..XXX.XX.XXXX",
					".XX..XXXX.XX..X.XXXXXX.X..XXX.X.XX..X.XX..XXXXXX.X",
					"XXX.X.X......XXXXX...XX..XXXXX.XXX.X..X..XXXXX....",
					"XXXX.X.X...X.XXXX....XX.XXX.X.XXXXX...X...XXX.X..X",
					"XX.X.XXXX...XXXXXXX....X.X.X.XX..XX...X..XX.XX...X",
					"X.X.XX..X.XXXX.X.XX..XX..X...X..XX.X.XXX........XX",
					"XXXXX.....XXX.X.XX.XXX..X....XXXXXXXXXX..X...X.XXX",
					"XXX.X......XXXXXX.XX..XXXXX.X.XXXXXX.XX..XX...X.XX",
					"XX.X.XXX..XXXXXXX...X.XXX..X.XXX..X.X...X.X.....XX",
					"XXXXXXX....XXXXX..XX.XX...XX..X..XX...XX.XX..X..XX",
					"XX.XX.....XXXXXXXXXXXX..XXX...X....X.XX..X.XX..XXX",
					"X.X...XX..XXXXXXX.XXXX.X.XXX.X...X..XX..X.XX..XXXX",
					"XX.X..X....X.X.X..XXXXX.X.X.XX.XX....XXXXXXX.XXXX.",
					"XX.....X..X.X..X.XXXXXXX...X..XXXX...X.XX.X.XXXX.X",
					"X..X..XXXXXXX.X.XX..XX...XX.XXXXXXX.X.XX.X...XXX.X",
					"XXX......XXXXX.X...X....X..XX..XX.XXXX...X...X...X",
					"XX......X.XXX.X.XXX.XX.X...X..XX.XX.....X.X.X.X.XX",
					"X.XXXXXX.XXX.XXX.XXXXXXXX...XX..XX...XX...X.X.XXXX",
					".XX.XX.XXX.X.X..XXXXXXXXX.......XX..X....X.X.XXXX.",
					"XX.XX...X.X.X..XXX.X..XXXX..XX.XX.XX.X.X.X..X.X...",
					"X.XXX..X.XXXX.XXX....XXXXXXXXXXXXXXXX.X....X.X....",
					".XX.XX..XXXXXX.XX.XX.XX.XXX.X..XX..X..X.X.XXX....X",
					"X..X..XX.XX.X..XXXX.XX.XXX.X..XX..XX.XXX.XXX...XXX",
					".XX.XXX.XX.X..XXX.XX.XX.XXX.XXXX.XXXXX..XXXX.XXXXX",
					"XX.XXX..XXX...XX.XX.X..XXX.XX....X.XX..XXX.X.XXXXX",
					"X.XXX..XXXX..XXXXXXX.XXXXXXX..X.X.XXXXXXX.X.XXXXXX" };
			String[] cutter = { "X.", ".X" };
			String expected__ = "YES";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake,
					cutter));
		}

		case 8: {
			String[] cake = {
					".X.XX....X..XX...X.XX....X.X......X....XXX.XXX.X.X",
					"..................................................",
					"..X.X...X...........X...X...X...XX...X............",
					".......X.......XX......X......X......X......X.X...",
					".........X.........X............X....X............",
					"......X.X.............X....X.......X....X........X",
					"X.........X...............X..X.....X....X...X....X",
					"....X..X..............X...........................",
					"X.................X.X...X...................X....X",
					"..............X.............X.....X.....X......X.X",
					".....X.X.............X..X...............X.........",
					"X..X...................X...X...X.....X.........X..",
					"...................X.......X.....X.....X.......X.X",
					"..........X......X........................X.......",
					"X.XX......X.X.............X...XX..X.X.X.......X...",
					"X.X...X...............X..X..........X.....X..X...X",
					"X............................X.....X.........X....",
					"......X.....X..........X..X....X.......X.........X",
					".....X.................X..X.................X....X",
					"X............X.................X..XXXXXX..........",
					"..X..X....X.........XX..X.X..XX..........XX..X....",
					"X...X...X...........X.....X..X..X............X...X",
					"..XX..........X....X.................X...........X",
					"X......X.....X.....X.......X.................X...X",
					"X............X....X........X...X...X..X.X.........",
					"......X....X.X...X....XX...X.......X..........X...",
					".........X.......X................................",
					"...X.....X..X.......XX..............X...XX........",
					".....X.........X..X....X..X.....XX...........X.X.X",
					".........X....................X.X.................",
					"X.....X.X.............X.X..................X......",
					"....X.........X...X...X...X..X............X...XX..",
					"...........X........X....X.....X..XX.....XX.......",
					".......................X.X.X......................",
					"X.....XX......X..X.......X.....X.................X",
					".....................................X.X....X.....",
					"X.....................X.........X...........X.....",
					"...X........X..XX...X.....................X.......",
					".........................X....X.X......XX.X....X.X",
					"....X.....X........X........X.X.......X..........X",
					"..X...X.......X........X.X...................X....",
					"X.............X..........................X...X...X",
					"X................X......X.X......X.......X........",
					"X...XX.X..X......X.XX........X......X............X",
					".......................X.X.......X..........X.....",
					"...X.......X...X.............XX..X..........X.....",
					".....X..X.X.........X.X................X..........",
					"..........................X..X....X.X....X.XX....X",
					"..................................................",
					"X.X.X...X..XXX....X..X.XXX....X.X.......XXX......X" };
			String[] cutter = { ".X", "X." };
			String expected__ = "NO";

			return verifyCase(casenum, expected__, new GogoXCake().solve(cake,
					cutter));
		}

		/*
		 * case 9: {
		 * String[] cake = ;
		 * String[] cutter = ;
		 * String expected__ = ;
		 *
		 * return verifyCase(casenum, expected__, new GogoXCake().solve(cake,
		 * cutter));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
