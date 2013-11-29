public class GCD {
	public int gcd(int x, int y) {
		while (true) {
			int z = x % y;
			if (z == 0) {
				// yの値が上書きされるため、ここでyを返す。
				return y;
			}
			x = y;
			y = z;
		}
	}

	public static void main(String[] args) {
		int[][] result = { { 3, 2, 1 }, { 10, 5, 5 }, { 4, 3, 1 },
				{ 3, 10, 1 }, { 12, 18, 6 }, { 693, 728, 7 } };
		for (int i = 0; i < result.length; i++) {
			System.err.print("Test case " + i + " ");
			int r = new GCD().gcd(result[i][0], result[i][1]);
			if (r == result[i][2]) {
				System.err.println("passed");
			} else {
				System.err.println("not passed");
				System.err.println("\t expected " + result[i][2]);
				System.err.println("\t result " + r);

			}
		}
	}
}
