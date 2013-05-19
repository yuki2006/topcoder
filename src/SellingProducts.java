// Paste me into the FileEdit configuration dialog
// SRM 379 DIV 2 - 500.0

public class SellingProducts {
	/**
	 * @param price
	 * @param cost
	 * @return
	 */
	public int optimalPrice(int[] price, int[] cost) {
		int max = 0;
		int max_price = 0;
		for (int i = 0; i < price.length; i++) {
			int sumGain = 0;
			for (int j = 0; j < price.length; j++) {
				if (price[j] >= price[i]) {
					int gain = price[i] - cost[j];
					if (gain >= 0) {
						sumGain += gain;
					}
				}
			}
			if (max < sumGain || max == sumGain && max_price > price[i]) {
				max = sumGain;
				max_price = price[i];
			}
		}

		return max_price;
	}



	public int optimalPrice2(int[] price, int[] cost) {
		int maxGain = 0;
		int max_price = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i : price) {
			min = Math.min(i, min);
			max = Math.max(i, max);
		}
		for (int profit = min; profit <= max; profit++) {
			int sumGain = 0;
			for (int j = 0; j < price.length; j++) {
				if (price[j] >= profit) {
					int gain = profit - cost[j];
					if (gain >= 0) {
						sumGain += gain;
					}
				}
			}
			if (maxGain < sumGain || maxGain == sumGain && max_price > profit) {
				maxGain = sumGain;
				max_price = profit;
			}
		}

		return max_price;
	}
	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SellingProductsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SellingProductsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class SellingProductsHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
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
			int[] price = { 13, 22, 35 };
			int[] cost = { 0, 0, 0 };
			int expected__ = 22;

			return verifyCase(casenum__, expected__, new SellingProducts().optimalPrice(price, cost));
		}
		case 1: {
			int[] price = { 13, 22, 35 };
			int[] cost = { 5, 15, 30 };
			int expected__ = 13;

			return verifyCase(casenum__, expected__, new SellingProducts().optimalPrice(price, cost));
		}
		case 2: {
			int[] price = { 13, 22, 35 };
			int[] cost = { 15, 30, 40 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__, new SellingProducts().optimalPrice(price, cost));
		}
		case 3: {
			int[] price = { 10, 10, 20, 20, 5 };
			int[] cost = { 1, 5, 11, 15, 0 };
			int expected__ = 10;

			return verifyCase(casenum__, expected__, new SellingProducts().optimalPrice(price, cost));
		}
		case 4: {
			int[] price = { 13, 17, 14, 30, 19, 17, 55, 16 };
			int[] cost = { 12, 1, 5, 10, 3, 2, 40, 19 };
			int expected__ = 17;

			return verifyCase(casenum__, expected__, new SellingProducts().optimalPrice(price, cost));
		}

		// custom cases

		case 5: {
			int[] price = { 603875, 216153, 220035, 500054, 793572, 724531, 897981, 7609, 599878, 430889, 444382,
					991458, 321402, 229627, 584934, 781473, 179044, 252396, 800867, 263880, 707055, 253905, 911167,
					689308, 668959, 850939, 671027, 198120, 949934, 644711, 75549, 450678, 523576, 655894, 773878,
					408913, 674886, 161884, 178978, 398677, 624052, 265836, 765308, 79916, 102813, 452849, 599214,
					927097, 14077, 120382 };
			int[] cost = { 591991, 443889, 579916, 906579, 770798, 587746, 569253, 311106, 178865, 169759, 646510,
					758444, 148407, 7905, 662700, 73065, 787007, 222692, 838841, 374393, 809822, 390961, 894289,
					716049, 768959, 427118, 223893, 498945, 761190, 301931, 688418, 834297, 625187, 270144, 662449,
					609710, 147868, 22657, 102137, 47825, 445377, 175455, 483864, 966080, 227521, 308711, 815605,
					751818, 505979, 876484 };
			int expected__ = 599878;

			return verifyCase(casenum__, expected__, new
					SellingProducts().optimalPrice(price, cost));
		}

		/*
		 * case 6: {
		 * int[] price = ;
		 * int[] cost = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SellingProducts().optimalPrice(price, cost));
		 * }
		 */
		/*
		 * case 7: {
		 * int[] price = ;
		 * int[] cost = ;
		 * int expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * SellingProducts().optimalPrice(price, cost));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
