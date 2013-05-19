//SRM150 DIV2 250
public class WidgetRepairsOno {
	public int days(int[] arrivals, int numPerDay) {
		int day = 0;
		for (int i = 0; i < arrivals.length - 1; i++) {
			if (arrivals[i] > 0) {
				day++;
				arrivals[i + 1] +=Math.max(arrivals[i] - numPerDay,0);
			}
		}
		day += arrivals[arrivals.length - 1] / numPerDay;
		if (arrivals[arrivals.length - 1] % numPerDay > 0) {
			day++;
		}
		return day;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			WidgetRepairsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				WidgetRepairsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

