public class CompositeSmash {
	public static void main(String[] args) {
		CompositeSmash smash = new CompositeSmash();
		System.out.println(smash.thePossible(81461, 2809));
	}

	public String thePossible(int a, int b) {
		if (a % b > 0) {
			return "No";
		}
		boolean x = checkPrime(b);
		boolean y = checkPrime(a / b);

		if (x ^ y) {
			return "Yes";
		}

		return "No";

	}

	private boolean checkPrime(int i) {
		if (i == 2) {
			return true;
		}
		if (i % 2 == 0) {
			return false;
		}
		for (int k = 3; k * k <= i; k += 2) {
			if (i % k == 0) {
				return false;
			}
		}
		return true;
	}
}
