public class CountingSeries {
	public long countThem(long a, long b, long c, long d, long upperBound) {
		long contains = 0;

		contains = (upperBound - a) / b;
		if (upperBound >= a) {
			contains++;
		}
		System.out.println(contains);
		for (long j = c; j <= upperBound; j *= d) {
			if (j >= a && (j - a) % b == 0) {
				contains--;
			}
			contains++;
			if (d == 1) {
				break;
			}
		}

		return contains;

	}
}
