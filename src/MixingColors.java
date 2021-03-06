import java.util.Arrays;


public class MixingColors {
    public int minColors(int[] colors) {
        if (colors.length == 1) {
            return 1;
        }
        Arrays.sort(colors);
        int max = colors[colors.length - 1];
        int[] bits = new int[32];
        colors[colors.length - 1] = 0;
        for (int c : colors) {
            for (int i = 0; (1 << i) <= c; i++) {
                if ((c & (1 << i)) > 0) {
                    bits[i]++;
                }
            }
        }
        int[] bits1 = new int[32];
        for (int i = 0; (1 << i) <= max; i++) {
            if ((max & (1 << i)) > 0) {
                bits1[i]++;
            }
        }
        int count = 0;
        System.out.println(Arrays.toString(bits1));

        System.out.println(Arrays.toString(bits));
        for (int i = 0; i < bits.length; i++) {
            if (0 == bits[i]) {
                if ((max & (1 << i)) > 0) {
                    count++;
                }
            } else if (bits[i] < colors.length) {
                count++;
            }
        }
        return count;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0

    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}");
        System.out.println("]");
        MixingColors obj;
        int answer;
        obj = new MixingColors();
        long startTime = System.currentTimeMillis();
        answer = obj.minColors(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            res = answer == p1;
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
            if (hasAnswer) {
                System.out.println("Desired answer:");
                System.out.println("\t" + p1);
            }
            System.out.println("Your answer:");
            System.out.println("\t" + answer);
        } else if ((endTime - startTime) / 1000.0 >= 2) {
            System.out.println("FAIL the timeout");
            res = false;
        } else if (hasAnswer) {
            System.out.println("Match :-)");
        } else {
            System.out.println("OK, but is it right?");
        }
        System.out.println("");
        return res;
    }

    public static void main(String[] args) {
        boolean all_right;
        boolean disabled;
        boolean tests_disabled;
        all_right = true;
        tests_disabled = false;

        int[] p0;
        int p1;

        // ----- test 0 -----
        disabled = false;
        p0 = new int[]{1, 7, 3};
        p1 = 3;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = new int[]{10};
        p1 = 1;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        p1 = 4;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = new int[]{534, 251, 76, 468, 909, 410, 264, 387, 102, 982, 199, 111, 659, 386, 151};
        p1 = 10;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = new int[]{4, 8, 16, 32, 64, 128, 256, 512, 1024};
        p1 = 9;
        all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        if (all_right) {
            if (tests_disabled) {
                System.out.println("You're a stud (but some test cases were disabled)!");
            } else {
                System.out.println("You're a stud (at least on given cases)!");
            }
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
