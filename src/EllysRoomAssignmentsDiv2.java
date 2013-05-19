import java.util.Arrays;

// Paste me into the FileEdit configuration dialog

public class EllysRoomAssignmentsDiv2 {
	public double getProbability(String[] ratings) {
		StringBuilder builder = new StringBuilder();
		for (String string : ratings) {
			builder.append(string);
		}
		String[] split = builder.toString().split(" ");
		int[] data = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			data[i] = Integer.valueOf(s);
		}

		int mypoint = data[0];
		Arrays.sort(data);

		int N = data.length;
		int R = N / 20;
		if (N % 20 > 0) {
			R++;
		}
		int myRank = 0;
		for (int i = 0; i < N; i++) {
			if (mypoint == data[i]) {
				myRank = N - i;
				break;
			}
		}
		if (myRank == 0) {
			return 1.0;
		}
		if (myRank < R) {
			return 0;
		}
		return 1.0 / R;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			EllysRoomAssignmentsDiv2Harness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				EllysRoomAssignmentsDiv2Harness.run_test(Integer
						.valueOf(args[i]));
		}
	}
	// END CUT HERE
}

// BEGIN CUT HERE
class EllysRoomAssignmentsDiv2Harness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
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
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
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
			double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected
					* (1.0 + MAX_DOUBLE_ERROR));
			double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected
					* (1.0 + MAX_DOUBLE_ERROR));
			return result > min && result < max;
		}
	}

	static double relativeError(double expected, double result) {
		if (Double.isNaN(expected) || Double.isInfinite(expected)
				|| Double.isNaN(result) || Double.isInfinite(result)
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
			String[] ratings = {
					"724 42 13 17 1199 577 1001 1101 483 845 196 1163 3",
					"60 985 296 1044 917 1007 898 119 1016 23 56 1159 1",
					"194 372 951 991 947 1053 433 1017 1011 391 110 9 2",
					"30 245 788 830 747 2 3" };
			double expected__ = 0.3333333333333333;

			return verifyCase(casenum__, expected__,
					new EllysRoomAssignmentsDiv2().getProbability(ratings));
		}
		case 1: {
			String[] ratings = { "42 911 666 17 13 1 1155 1094 815 5 1000 540" };
			double expected__ = 1.0;

			return verifyCase(casenum__, expected__,
					new EllysRoomAssignmentsDiv2().getProbability(ratings));
		}
		case 2: {
			String[] ratings = {
					"1168 196 440 643 227 1194 1149 372 878 23 767 296 ",
					"110 52 840 367 790 884 620 676 380 1007 304 262 10",
					"63 917 230 951 635 898 894 319 724 597 470 1143 62",
					"7 1175 436 484 457 991 433 747 8 94 830 1044 1053 ",
					"360 1167 391 364 1120 192 56 528 366 712 480 83 11",
					"59 483 949 356 1163 9 845 750 781 784 1016 985 346",
					" 466 947 73 911 690 630 609 866 788 98 1017 410 11",
					"9 617 245 801 205" };
			double expected__ = 0.0;

			return verifyCase(casenum__, expected__,
					new EllysRoomAssignmentsDiv2().getProbability(ratings));
		}
		case 3: {
			String[] ratings = {
					"470 840 410 1168 637 464 498 1118 276 1013 989 874",
					" 64 192 296 611 44 999 583 365 1195 20 838 274 425",
					" 236 960 1116 857 630 664 98 1046 807 1111 529 47 ",
					"31 676 1112 42 376 56 1105 814 6 871 364 319 1145 ",
					"491 199 1121 713 353 956 579 445 1031 627 618 202 ",
					"763 271 188 1140 1044 311 895 1175 74 465 454 708 ",
					"1181 866 387 99 784 700 308 853 977 253 62 782 371",
					" 8 908 1151 83 932 55 1077 897 517 767 990 567 869",
					" 607 603 499 356 772 310 332 357 845 1159 1128 104",
					"2 783 953 315 1020 360 696 793 847 1 716 731 1097 ",
					"660 302 761 484 23 89 609 161 978 312 87 363 879 6",
					"02 635 409 749 475 106 632 961 1053 414 422 1146 6",
					"51 970 907 719 110 118 218 471 334 747 645 575 757",
					" 156 137 101 150 1084 48 859 1016 396 779 791 195 ",
					"1148 138 141 304 523 1129 940 569 1058 113 949 967",
					" 261 1017 433 126 205 679 998 325 831 239 774 245 ",
					"992 407 991 667 489 580 628 1055 383 924 706 369 8",
					"37 380 596 392 734 183 397 1165 911 657 1028 617 1",
					"45 105 870 707 447 281 841 526 367 297 66 851 643 ",
					"1142 168 480 3 347 1101 737 1025 647 588 1049 458 ",
					"508 759 654 927 744 937 402 440 1158 620 1067 528 ",
					"1001 1186 705 124 511 597 395 1063 399 753 1093 10",
					"05 717 1173 278 81 762 71 51 801 890 1185 413 674 ",
					"252 805 775 52 612 1075 1187 131 559 72 1141 298 8",
					"5 640 1184 290 1127 423 925 1108 114 864 605 802 1",
					"39 962 104 817 289 816 359 323 1068 368 477 1022 2",
					" 377 512 688 1029 340 28 1193 910 417 984 1163 385",
					" 858 212 119 898 9 473 180 140 346 262 971 170 564",
					" 226 123 698 196 10 466 1174 446 248 1194 227 94 3",
					"09 850 1179 1035 680 750 67 650 765 61 982 412 736",
					" 149 822 933 621 117 1062 678 929 693 125 836 852 ",
					"694 711 275 358 524 825 997 372 781 873 725 818 57",
					"1 1041 460 796 287 723 142 322 691 220 830 778 116",
					"7 68 1059 1011 958 324 200 947 29 216 57 443 488 9",
					"85 666 690 1182 230 1114 153 73 1086 191 1010 586 ",
					"250 96 211 40 217 1155 82 641 1066 1131 896 154 22",
					"4 5 951 917 1189 709 777 1034 724 436 626 270 1052",
					" 593 50 926 901 634 1082 943 894 721 945 366 391 4",
					"27 646 1076 712 496 868 435 1120 177 1149 330 483 ",
					"1152 351 176 457 1126 235 1143 790 780 1166 686 80",
					" 121 222 305 355 581 476 34 533 147 316 881 539 45",
					" 146 263 22 788 527 519 1069 710 59 148 234 661 81",
					"3 1081 133 884 548 405 344 451 887 789 1007 295 39",
					"8 728 553 642 878 77 293 684 877 554 478" };
			double expected__ = 0.037037037037037035;

			return verifyCase(casenum__, expected__,
					new EllysRoomAssignmentsDiv2().getProbability(ratings));
		}

		// custom cases

		/*
		 * case 4: { String[] ratings = ; double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EllysRoomAssignmentsDiv2().getProbability(ratings)); }
		 */
		/*
		 * case 5: { String[] ratings = ; double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EllysRoomAssignmentsDiv2().getProbability(ratings)); }
		 */
		/*
		 * case 6: { String[] ratings = ; double expected__ = ;
		 *
		 * return verifyCase(casenum__, expected__, new
		 * EllysRoomAssignmentsDiv2().getProbability(ratings)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
