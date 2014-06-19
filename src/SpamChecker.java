public class SpamChecker {
    public String spamCheck(String judgeLog, int good, int bad) {
        int score = 0;
        for (char c : judgeLog.toCharArray()) {
            if (c == 'o') {
                score += good;
            } else {
                score -= bad;
                if (score < 0) {
                    return "SPAM";
                }
            }
        }
        return "NOT SPAM";

    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, String p0, int p1, int p2, boolean hasAnswer, String p3) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1 + "," + p2);
        System.out.println("]");
        SpamChecker obj;
        String answer;
        obj = new SpamChecker();
        long startTime = System.currentTimeMillis();
        answer = obj.spamCheck(p0, p1, p2);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            res = answer.equals(p3);
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
            if (hasAnswer) {
                System.out.println("Desired answer:");
                System.out.println("\t" + "\"" + p3 + "\"");
            }
            System.out.println("Your answer:");
            System.out.println("\t" + "\"" + answer + "\"");
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

        String p0;
        int p1;
        int p2;
        String p3;

        // ----- test 0 -----
        disabled = false;
        p0 = "ooooxxxo";
        p1 = 2;
        p2 = 3;
        p3 = "SPAM";
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = "ooooxxxo";
        p1 = 3;
        p2 = 4;
        p3 = "NOT SPAM";
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = "xooooooooooooooooooooooooooo";
        p1 = 1000;
        p2 = 1;
        p3 = "SPAM";
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = "oxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        p1 = 1000;
        p2 = 1;
        p3 = "NOT SPAM";
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = "ooxoxoxooxoxxoxoxooxoxoxoxxoxx";
        p1 = 15;
        p2 = 17;
        p3 = "SPAM";
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, true, p3)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 5 -----
        disabled = false;
        p0 = "oooxoxoxoxoxoxooxooxoxooxo";
        p1 = 16;
        p2 = 18;
        p3 = "NOT SPAM";
        all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, p2, true, p3)) && all_right;
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