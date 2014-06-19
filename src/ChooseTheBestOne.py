import math, string, itertools, fractions, heapq, collections, re, array, bisect, random


class ChooseTheBestOne:
    def countNumber(self, N):
        i = 1;
        emp = range(1, N + 1)
        index = 0;
        while len(emp) > 1:
            index = (index + (i ** 3) - 1) % len(emp)
            emp.pop(index)
            i += 1;
        return emp[0]

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time


def KawigiEdit_RunTest(testNum, p0, hasAnswer, p1):
    sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str(p0))
    print(str("]"))
    obj = ChooseTheBestOne()
    startTime = time.clock()
    answer = obj.countNumber(p0)
    endTime = time.clock()
    res = True
    print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
    if (hasAnswer):
        print(str("Desired answer:"))
        print(str("\t") + str(p1))

    print(str("Your answer:"))
    print(str("\t") + str(answer))
    if (hasAnswer):
        res = answer == p1

    if (not res):
        print(str("DOESN'T MATCH!!!!"))
    elif ((endTime - startTime) >= 2):
        print(str("FAIL the timeout"))
        res = False
    elif (hasAnswer):
        print(str("Match :-)"))
    else:
        print(str("OK, but is it right?"))

    print(str(""))
    return res


all_right = True
tests_disabled = False


# ----- test 0 -----
disabled = True
p0 = 3
p1 = 2
all_right = (disabled or KawigiEdit_RunTest(0, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = True
p0 = 6
p1 = 6
all_right = (disabled or KawigiEdit_RunTest(1, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = 10
p1 = 8
all_right = (disabled or KawigiEdit_RunTest(2, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = True
p0 = 1234
p1 = 341
all_right = (disabled or KawigiEdit_RunTest(3, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

if (all_right):
    if (tests_disabled):
        print(str("You're a stud (but some test cases were disabled)!"))
    else:
        print(str("You're a stud (at least on given cases)!"))

else:
    print(str("Some of the test cases had errors."))

# END KAWIGIEDIT TESTING
# Powered by KawigiEdit-pf 2.3.0!