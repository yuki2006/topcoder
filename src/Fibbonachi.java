public class Fibbonachi {

	static long memo[] = new long[51];

	static long fibbonachi(int n) {
		memo[0]=1;
		memo[1]=1;

		for (int i = 2; i <= n; i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		return memo[n];

	}

	public static void main(String[] args) {

		System.out.println(fibbonachi(50));

	}

}
