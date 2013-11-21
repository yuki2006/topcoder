import java.util.Arrays;
import java.util.Comparator;

// Paste me into the FileEdit configuration dialog
// SRM 271 DIV 2 - 600.0

public class BlackWhitePlane {
	static class Circle {
		int X, Y, R;

		public Circle(int x, int y, int r) {
			this.X = x;
			this.Y = y;
			this.R = r;
		}
	}

	public double area(String[] circles) {
		Circle[] cir = new Circle[circles.length];
		for (int i = 0; i < cir.length; i++) {
			String[] split = circles[i].split(" ");
			cir[i] = new Circle(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
		}
		// 半径が小さい順にソート
		Arrays.sort(cir, new Comparator<Circle>() {
			public int compare(Circle o1, Circle o2) {
				return Integer.valueOf(o2.R).compareTo(o1.R);
			}
		});
		int whiteR = 0;
		for (int i = 0; i < cir.length; i++) {
			int hitCount = 0;
			Circle c = cir[i];
			for (int j = 0; j < i; j++) {
				// 以前のところに含まれているかチェック
				Circle other = cir[j];
				int powX = (c.X - other.X) * (c.X - other.X);
				int powY = (c.Y - other.Y) * (c.Y - other.Y);
				int powR = other.R * other.R;
				if (powX + powY <= powR) {
					hitCount++;
				}
			}
			// 偶数なら白
			if (hitCount % 2 == 0) {
				whiteR += c.R * c.R;
			} else {
				whiteR -= c.R * c.R;
			}
		}

		double sum = Math.PI * whiteR;
		return sum;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BlackWhitePlaneHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BlackWhitePlaneHarness.run_test(Integer.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class BlackWhitePlaneHarness {
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

	static final double MAX_DOUBLE_ERROR = 1E-9;

	static boolean compareOutput(double expected, double result) {
		if (Double.isNaN(expected)) {
			return Double.isNaN(result);
		} else if (Double.isInfinite(expected)) {
			if (expected > 0) {
				return result > 0 && Double.isInfinite(result);
			} else {
				return result < 0 && Double.isInfinite(result);
			}
		} else if (Double.isNaN(result) || Double.isInfinite(result)) {
			return false;
		} else if (Math.abs(result - expected) < MAX_DOUBLE_ERROR) {
			return true;
		} else {
			double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
			double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR));
			return result > min && result < max;
		}
	}

	static double relativeError(double expected, double result) {
		if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result)
				|| expected == 0)
			return 0;
		return Math.abs(result - expected) / Math.abs(expected);
	}

	static String formatResult(double res) {
		return String.format("%.10g", res);
	}

	static int verifyCase(int casenum, double expected, double received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0)
				System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			String[] circles = { "1 1 1" };
			double expected__ = 3.141592653589793;

			return verifyCase(casenum__, expected__, new BlackWhitePlane().area(circles));
		}
		case 1: {
			String[] circles = { "4 3 1", "3 2 3", "8 1 1" };
			double expected__ = 28.274333882308138;

			return verifyCase(casenum__, expected__, new BlackWhitePlane().area(circles));
		}
		case 2: {
			String[] circles = { "15 15 4", "15 25 4", "25 25 4", "25 15 4", "25 25 100" };
			double expected__ = 31214.86460606818;

			return verifyCase(casenum__, expected__, new BlackWhitePlane().area(circles));
		}
		case 3: {
			String[] circles = { "2549 8482 11", "9175 5927 35", "2747 6177 93", "5512 8791 81", "4487 8456 60",
					"6899 610 77", "9716 2202 3", "9312 5625 79", "4020 9851 85", "1640 7179 54",
					"5761 4348 51", "5917 3436 88", "6547 386 33", "182 7676 1", "6329 4496 89" };
			double expected__ = 194250.95695676407;

			return verifyCase(casenum__, expected__, new BlackWhitePlane().area(circles));
		}

		// custom cases

		/*
		 * case 4: {
		 * String[] circles = ;
		 * double expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BlackWhitePlane().area(circles));
		 * }
		 */
		/*
		 * case 5: {
		 * String[] circles = ;
		 * double expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BlackWhitePlane().area(circles));
		 * }
		 */
		/*
		 * case 6: {
		 * String[] circles = ;
		 * double expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BlackWhitePlane().area(circles));
		 * }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
