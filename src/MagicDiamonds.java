import java.math.BigInteger;
import java.util.ArrayList;

public class MagicDiamonds {
	public static void main(String[] args) {
		MagicDiamonds magicDiamonds = new MagicDiamonds();
		System.out.println(magicDiamonds.minimalTransfer(2147483647L));

	}

	public long minimalTransfer(long n) {
		if (t.size() == 0) {
			setPrime(n);
		}
		if (isPrime(n) == false) {
			return 1;
		}
		BigInteger a=new BigInteger("2");
		long min = n;
		for (long i = 3; i < n / 2; i += 2) {
			if (isPrime(n - i) == false) {
				long minimalTransfer = minimalTransfer(i);
				if (minimalTransfer > 0) {
					if (min > minimalTransfer + 1) {
						min = minimalTransfer + 1;
						if (min == 2) {
							break;
						}
					}

				}
			}
		}
		return min;

	}

	ArrayList<Long> t = new ArrayList<Long>();

	private boolean setPrime(long n) {
		t.add(2L);
		double sqrt = Math.sqrt(n);
		M: for (long k = 3; k < sqrt; k++) {
			for (Long l : t) {
				if (n % l == 0) {
					continue M;
				}
			}
			t.add(k);
		}
		return true;

	}

	private boolean isPrime(long n) {

		if (n <= 2) {
			return false;
		}
		for (Long l : t) {
			if (n % l == 0) {
				return false;
			}
		}
		t.add(n);
		return true;

	}
}
