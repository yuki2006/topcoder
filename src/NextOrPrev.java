// Paste me into the FileEdit configuration dialog

public class NextOrPrev {
	public int getMinimum(int nextCost, int prevCost, String start, String goal) {
		char[] startArray = start.toCharArray();
		char[] goalArray = goal.toCharArray();
		int score = 0;
		for (int i = 0; i < goalArray.length; i++) {
			for (int j = 0; j < goalArray.length; j++) {
				if (startArray[j] < startArray[i]
						&& goalArray[j] < goalArray[i]) {
					return -1;
				}
				if (startArray[i] < startArray[j] &&
						goalArray[i] < goalArray[j]) {
					return -1;
				}
			}
			int diff = startArray[i] - goalArray[i];
			if (diff < 0) {
				score += -diff * nextCost;
			} else {
				score += diff * prevCost;
			}

		}
		return score;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			NextOrPrevHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				NextOrPrevHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}
