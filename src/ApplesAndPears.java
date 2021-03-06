import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ApplesAndPears {
    public int getArea(String[] board, int K) {
        int eSize = 0;
        int aSize = 0;
        int pSize = 0;

        int N = board.length;
        for (int i = 0; i < board.length; i++) {
            for (char c : board[i].toCharArray()) {
                if (c == ' ') {
                    eSize++;
                } else if (c == 'A') {
                    aSize++;
                } else if (c == 'P') {
                    pSize++;
                }
            }
        }
        int maxScore = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < N; k++) {
                    for (int l = 0; j < N; l++) {
                        int e = 0, p = 0, a = 0;

                        for (int k2 = 0; k2 < k; k++) {
                            for (int l2 = 0; l < l; l++) {
                                char v = board[i + k2].charAt(j + l2);
                                if (v == ' ') {
                                    e++;
                                } else if (v == 'P') {
                                    p++;
                                } else if (v == 'A') {
                                    a++;
                                }
                            }
                        }
                        {
                            //p
                            int rk = K;
                            int re = e;
                            int subP = pSize - p;
                            if (e > 0 && 0 < subP) {
                                re -= Math.min(subP, e);
                                rk -= Math.min(subP, e);
                            }

                            if (a == 0 || a >= rk * 2 && 0 < eSize - re) {
                                System.out.println(e);
                                System.out.println(p);
                                System.out.println(a);
                                System.out.println((k + 1) * (l + 1));
                                System.out.println();

                                maxScore = Math.max(maxScore, (k + 1) * (l + 1));
                            }

                        }

                        {
                            // a
                            int rk = K;
                            int re = e;
                            int subP = pSize - p;
                            if (e > 0 && 0 < subP) {
                                re -= Math.min(subP, e);
                                rk -= Math.min(subP, e);
                            }
                            if (p == 0 || p >= rk * 2 && 0 < eSize - re) {
                                maxScore = Math.max(maxScore, (k + 1) * (l + 1));
                            }
                        }
                    }
                }
            }
        }
        return maxScore;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0

    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}" + "," + p1);
        System.out.println("]");
        ApplesAndPears obj;
        int answer;
        obj = new ApplesAndPears();
        long startTime = System.currentTimeMillis();
        answer = obj.getArea(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p2);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p2;
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
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

        String[] p0;
        int p1;
        int p2;

        // ----- test 0 -----
        disabled = false;
        p0 = new String[]{".A", "P."};
        p1 = 0;
        p2 = 1;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = true;
        p0 = new String[]{".A", "P."};
        p1 = 1;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = true;
        p0 = new String[]{".PP", "PPA", "PAP"};
        p1 = 3;
        p2 = 6;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = true;
        p0 = new String[]{"A.P.PAAPPA", "PPP..P.PPP", "AAP.A.PAPA", "P.PA.AAA.A", "...PA.P.PA", "P..A.A.P..", "PAAP..A.A.", "PAAPPA.APA", ".P.AP.P.AA", "..APAPAA.."};
        p1 = 10;
        p2 = 21;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
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
