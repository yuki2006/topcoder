// Paste me into the FileEdit configuration dialog
// SRM 576 DIV 2 - 576.0
public class ArcadeManao {

    private String[] level;
    private int L;

    public int shortestLadder(String[] level, int coinRow, int coinColumn) {
        for (int i = 0; i < 50; i++) {
            boolean[][] visited = new boolean[level.length][level[0].length()];
            this.level = level;
            L = i;
            dfs(visited, 0, level.length - 1);
            if (visited[coinRow - 1][coinColumn - 1]) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[][] visited, int x, int y) {
        if (visited[y][x]) {
            return;
        }
        if (level[y].charAt(x) != 'X') {
            return;
        }
        visited[y][x] = true;
        // 左に移動
        if (0 < x) {
            dfs(visited, x - 1, y);
        }
        // 右に移動
        if (x < level[0].length() - 1) {
            dfs(visited, x + 1, y);
        }
        // 上下
        for (int i = 0; i < level.length; i++) {
            if (Math.abs(i - y) <= L) {
                dfs(visited, x, i);
            }
        }
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            ArcadeManaoHarness.run_test(-1);
        } else {
            for (int i = 0; i < args.length; ++i) {
                ArcadeManaoHarness.run_test(Integer.valueOf(args[i]));
            }
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class ArcadeManaoHarness {

    public static void run_test(int casenum) {
        if (casenum != -1) {
            if (runTestCase(casenum) == -1) {
                System.err.println("Illegal input! Test case " + casenum + " does not exist.");
            }
            return;
        }

        int correct = 0, total = 0;
        for (int i = 0;; ++i) {
            int x = runTestCase(i);
            if (x == -1) {
                if (i >= 100) {
                    break;
                }
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

    static boolean compareOutput(int expected, int result) {
        return expected == result;
    }

    static String formatResult(int res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, int expected, int received) {
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

    static int runTestCase(int casenum__) {
        switch (casenum__) {
            case 0: {
                String[] level = {"XXXX....",
                    "...X.XXX",
                    "XXX..X..",
                    "......X.",
                    "XXXXXXXX"};
                int coinRow = 2;
                int coinColumn = 4;
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
            }
            case 1: {
                String[] level = {"XXXX",
                    "...X",
                    "XXXX"};
                int coinRow = 1;
                int coinColumn = 1;
                int expected__ = 1;

                return verifyCase(casenum__, expected__, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
            }
            case 2: {
                String[] level = {"..X..",
                    ".X.X.",
                    "X...X",
                    ".X.X.",
                    "..X..",
                    "XXXXX"};
                int coinRow = 1;
                int coinColumn = 3;
                int expected__ = 4;

                return verifyCase(casenum__, expected__, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
            }
            case 3: {
                String[] level = {"X"};
                int coinRow = 1;
                int coinColumn = 1;
                int expected__ = 0;

                return verifyCase(casenum__, expected__, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
            }
            case 4: {
                String[] level = {"XXXXXXXXXX",
                    "...X......",
                    "XXX.......",
                    "X.....XXXX",
                    "..XXXXX..X",
                    ".........X",
                    ".........X",
                    "XXXXXXXXXX"};
                int coinRow = 1;
                int coinColumn = 1;
                int expected__ = 2;

                return verifyCase(casenum__, expected__, new ArcadeManao().shortestLadder(level, coinRow, coinColumn));
            }

            // custom cases

            /*
             * case 5: {
             * String[] level = ;
             * int coinRow = ;
             * int coinColumn = ;
             * int expected__ = ;
             *
             * return verifyCase(casenum__, expected__, new
             * ArcadeManao().shortestLadder(level, coinRow, coinColumn));
             * }
             */
            /*
             * case 6: {
             * String[] level = ;
             * int coinRow = ;
             * int coinColumn = ;
             * int expected__ = ;
             *
             * return verifyCase(casenum__, expected__, new
             * ArcadeManao().shortestLadder(level, coinRow, coinColumn));
             * }
             */
            /*
             * case 7: {
             * String[] level = ;
             * int coinRow = ;
             * int coinColumn = ;
             * int expected__ = ;
             *
             * return verifyCase(casenum__, expected__, new
             * ArcadeManao().shortestLadder(level, coinRow, coinColumn));
             * }
             */
            default:
                return -1;
        }
    }
}
// END CUT HERE
