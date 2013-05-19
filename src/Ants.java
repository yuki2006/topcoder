public class Ants {
	public int solve(int L, int[] x) {
		int[] maxa = new int[x.length], between = new int[x.length];
		int max = 0, maxb = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < L - x[i])
				maxa[i] = L - x[i];
			else
				maxa[i] = x[i];
		}
		for (int i = 0; i < maxa.length; i++) {
			if (maxa[i] > max)
				max = maxa[i];

		}
		return max;
	}

	public static void main(String[] args) {
		{
			boolean bool = new Ants().solve(10, new int[] { 2, 6, 7 }) == 8;
			System.err.println(bool ? "OK" : "NG");
		}
		{
			boolean bool = new Ants().solve(10, new int[] { 5, 10 }) == 10;
			System.err.println(bool ? "OK" : "NG");
		}
		{
			boolean bool = new Ants().solve(10, new int[] { 1,2,3,4,5,6,7,8,9,10 }) == 10;
			System.err.println(bool ? "OK" : "NG");
		}
		{
			boolean bool = new Ants().solve(10, new int[] { 1,2,3,4,5 }) == 9;
			System.err.println(bool ? "OK" : "NG");
		}
		{
			boolean bool = new Ants().solve(10, new int[] { 1,9 }) == 9;
			System.err.println(bool ? "OK" : "NG");
		}


	}
}
