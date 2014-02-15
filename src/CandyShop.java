// Paste me into the FileEdit configuration dialog
// SRM 508 DIV 2 - 250.0
public class CandyShop {
	private static final int CENTER = 200;

	public int countProbablePlaces(int[] X, int[] Y, int[] R) {
		int[][] map = new int[CENTER * 2 + 1][CENTER * 2 + 1];
		for (int i = 0; i < X.length; i++) {
			check(map, X[i], Y[i], R[i]);
		}

		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == R.length) {
					count++;
				}
			}
		}
		return count;
	}

	private int abs(int k) {
		return Math.abs(k);
	}

	private void check(int[][] map, int x, int y, int r) {
		for (int i = -r; i <= r; i++) {
			for (int j = -r; j <= r; j++) {
				if (abs(i + x) <= CENTER && abs(j + y) <= CENTER) {
					if (abs(i) + abs(j) <= r) {
						map[i + x + CENTER][j + y + CENTER]++;
					}
				}
			}
		}
	}

}
