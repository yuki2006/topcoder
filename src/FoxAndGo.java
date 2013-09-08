import java.util.ArrayList;
import java.util.HashSet;

// Paste me into the FileEdit configuration dialog
// Single Round Match 590 - Round 1500.0
public class FoxAndGo {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	static class Tuple {
		public HashSet<Point> empty;
		public int length;

		public Tuple(HashSet<Point> empty, int length) {
			super();
			this.empty = empty;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Tuple [empty=" + empty.toArray() + ", length=" + length
					+ "]";
		}

	}

	private int[][] checked;
	private ArrayList<Tuple> map = new ArrayList<Tuple>();

	public int maxKill(String[] board) {
		checked = new int[board.length][board[0].length()];
		int count = 0;
		int id = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (checked[i][j] > 0) {
					continue;
				}
				char cell = board[i].charAt(j);
				if (cell == 'o') {
					checked[i][j] = id;
					Tuple tuple = checkAroundEmptyCell(board, i, j, id);
					map.add(tuple);
					if (tuple.empty.size() == 0) {
						// おかなくても既に取れるところ
						count += tuple.length;
					}
					id++;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				char cell = board[i].charAt(j);
				if (cell == '.') {
					int c = checkAroundCell(board, i, j);
					max = Math.max(c, max);
				}
			}
		}

		return count + max;
	}

	private boolean checkRange(int v, int i, int j) {
		return v >= i && v <= j;
	}

	private int checkAroundCell(String[] board, int x, int y) {
		int count = 0;
		ArrayList<Integer> picked = new ArrayList<Integer>();
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (checkRange(x + i, 0, board.length - 1)
						&& checkRange(y + j, 0, board[0].length() - 1)) {
					if (Math.abs(i) + Math.abs(j) != 1) {
						continue;
					}
					if (board[x + i].charAt(y + j) == 'o') {
						int pick = checked[x + i][y + j] - 1;
						if (picked.contains(pick)) {
							continue;
						}
						picked.add(pick);
						// あと一個で取れるものを選択
						if (map.get(pick).empty.size() == 1) {
							count += map.get(pick).length;
						}
					}
				}
			}
		}
		return count;
	}

	private Tuple checkAroundEmptyCell(String[] board, int x, int y, int id) {
		Tuple ret = new Tuple(new HashSet<Point>(), 1);

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (checkRange(x + i, 0, board.length - 1)
						&& checkRange(y + j, 0, board[0].length() - 1)) {
					if (Math.abs(i) + Math.abs(j) != 1) {
						continue;
					}
					if (checked[x + i][y + j] > 0) {
						continue;
					}
					if (board[x + i].charAt(y + j) == '.') {
						Point point = new Point(x + i, y + j);
						ret.empty.add(point);
					} else if (board[x + i].charAt(y + j) == 'o') {
						// 再起的にチェックする箇所のチェック
						checked[x + i][y + j] = id;

						Tuple tmp = checkAroundEmptyCell(board, x + i, y + j,
								id);
						ret.empty.addAll(tmp.empty);
						ret.length += tmp.length;

					}

				}
			}
		}

		return ret;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndGoHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FoxAndGoHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class FoxAndGoHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
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
			String[] board = { ".....", "..x..", ".xox.", ".....", "....." };
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 1: {
			String[] board = { "ooooo", "xxxxo", "xxxx.", "xxxx.", "ooooo" };
			int expected__ = 6;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 2: {
			String[] board = { ".xoxo", "ooxox", "oooxx", "xoxox", "oxoox" };
			int expected__ = 13;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 3: {
			String[] board = { ".......", ".......", ".......", "xxxx...",
					"ooox...", "ooox...", "ooox..." };
			int expected__ = 9;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 4: {
			String[] board = { ".......", ".xxxxx.", ".xooox.", ".xo.ox.",
					".xooox.", ".xxxxx.", "......." };
			int expected__ = 8;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 5: {
			String[] board = { "o.xox.o", "..xox..", "xxxoxxx", "ooo.ooo",
					"xxxoxxx", "..xox..", "o.xox.o" };
			int expected__ = 12;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 6: {
			String[] board = { ".......", "..xx...", ".xooox.", ".oxxox.",
					".oxxxo.", "...oo..", "......." };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 7: {
			String[] board = { ".ox....", "xxox...", "..xoox.", "..xoox.",
					"...xx..", ".......", "......." };
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}
		case 8: {
			String[] board = { "...................", "...................",
					"...o..........o....", "................x..",
					"...............x...", "...................",
					"...................", "...................",
					"...................", "...................",
					"...................", "...................",
					"...................", "...................",
					"................o..", "..x................",
					"...............x...", "...................",
					"..................." };
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}

		// custom cases

		case 9: {
			String[] board = { "xxxxxxxx.xox.", "xoxoxxo.xoxx.",
					".xx.oxxx.xxx.", "ox.xx.xoxx.xx", "x.xx.xx.oxx.o",
					"xxxxooxxxxxxx", "xoxxoxxxxx.x.", "xxoooxxxoxx.x",
					"xoxxxxxoxxoxx", "xxoxx.x.xxxxx", "xxxxxxxxx.xx.",
					"xxxx.x...xxxx", "xxxx.oxxxxxxx" };
			int expected__ = 14;

			return verifyCase(casenum__, expected__,
					new FoxAndGo().maxKill(board));
		}

		/*
		 * case 10: { String[] board = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndGo().maxKill(board)); }
		 */
		/*
		 * case 11: { String[] board = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FoxAndGo().maxKill(board)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
