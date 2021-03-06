import java.util.ArrayList;

public class TwoLLogo {
    private static class Point {
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    private static class LTuple {
        Point s;

        public LTuple(Point s, int upLen, int rightLen) {
            super();
            this.s = s;
            this.upLen = upLen;
            this.rightLen = rightLen;
        }

        int upLen;
        int rightLen;
    }

    public long countWays(String[] grid) {
        ArrayList<LTuple> lTuples = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == '.') {
                    int upLen = 0, rightLen = 0;
                    for (int i2 = i - 1; i2 >= 0; i2--) {
                        if (grid[i2].charAt(j) == '.') {
                            upLen = i - i2;
                        } else {
                            break;
                        }
                    }
                    for (int j2 = j + 1; j2 < grid[0].length(); j2++) {
                        if (grid[i].charAt(j2) == '.') {
                            rightLen = j2 - j;
                        } else {
                            break;
                        }
                    }
                    if (upLen > 0 && rightLen > 0) {
                        LTuple lTuple = new LTuple(new Point(i, j), upLen, rightLen);
                        lTuples.add(lTuple);
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < lTuples.size(); i++) {
            for (int j = i + 1; j < lTuples.size(); j++) {
                if (i == j) {
                    continue;
                }
                final LTuple a = lTuples.get(i);
                final LTuple b = lTuples.get(j);
                long tmp = getValue(a, b);
                if (tmp < 0) {
                    tmp = getValue(b, a);
                }
                if (tmp < 0) {
                    sum += (a.upLen * a.rightLen) * (b.upLen * b.rightLen);
                } else {
                    sum += tmp;
                }
            }
        }
        return sum;

    }

    private long getValue(LTuple a, LTuple b) {

        int diffX = a.s.x - a.upLen - b.s.x;
        int diffY = b.s.y + b.rightLen - a.s.y;
        if (diffX >= 0 && diffY >= 0) {
            return (a.upLen - diffX - 1) * (a.rightLen - diffY ) *
                    (b.upLen - diffX) * (b.rightLen - diffY - 1) + 2;
        }
        return -1;
    }

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, long p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		TwoLLogo obj;
		long answer;
		obj = new TwoLLogo();
		long startTime = System.currentTimeMillis();
		answer = obj.countWays(p0);
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
		
		String[] p0;
		long p1;
		
		// ----- test 0 -----
		disabled = false;
		p0 = new String[]{"....","...."};
		p1 = 1L;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 1 -----
		disabled = false;
		p0 = new String[]{".##..","...#.",".#.#.","#...#"};
		p1 = 3L;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 2 -----
		disabled = false;
		p0 = new String[]{"..#.","#.#.","....","..#."};
		p1 = 4L;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 3 -----
		disabled = false;
		p0 = new String[]{"..",".."};
		p1 = 0L;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 4 -----
		disabled = false;
		p0 = new String[]{".#.#","....",".#.#","...."};
		p1 = 34L;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 5 -----
		disabled = false;
		p0 = new String[]{"##############","##############","#.############","#.############","#.############","#.############","#.############","#.############","#.#####.######","#.#####.######","#.#####.######","#....##.######","#######.######","#######.######","#######.######","#######.######","#######.######","#######.######","#######......#","##############"};
		p1 = 1350L;
		all_right = (disabled || KawigiEdit_RunTest(5, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 6 -----
		disabled = false;
		p0 = new String[]{"#......",".#....#",".#.#...","#....#.",".##..#.",".#.....",".....#.",".#.#...",".#...#.","..##..."};
		p1 = 2386L;
		all_right = (disabled || KawigiEdit_RunTest(6, p0, true, p1) ) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------
		
		// ----- test 7 -----
		disabled = false;
		p0 = new String[]{"...#..........................","..............................","..............................","..................#...#.......","..................#...........","..............................","...........#..................","..............................",".....#..#.....................",".......................#......","..................#.....#.....","..............................","..............................","..............................","..............................","..#...........................","..............................","..............................","..............................","#............................#","..............................",".....#.........#............#.","..............................",".........................#....",".#............................",".............#................","..............................","..............................",".......................#......",".............#................"};
		p1 = 5020791386L;
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

// Powered by KawigiEdit-pf 2.3.0!
