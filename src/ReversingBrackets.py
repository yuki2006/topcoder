import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class ReversingBrackets:
    def removeBrackets(self, s):
        pattern=re.compile(r'(.*)\[(.*)\](.*)')
        iterator = pattern.finditer(s)
        out=""
        hit=False
        for match in iterator:
            out+=match.group(1) 
            out+=match.group(2)[::-1]
            out+=match.group(3)
            hit=True
        return out if hit else s

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, hasAnswer, p1):
    sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str("\"") + str(p0) + str("\""))
    print(str("]"))
    obj = ReversingBrackets()
    startTime = time.clock()
    answer = obj.removeBrackets(p0)
    endTime = time.clock()
    res = True
    print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
    if (hasAnswer):
        print(str("Desired answer:"))
        print(str("\t") + str("\"") + str(p1) + str("\""))
    
    print(str("Your answer:"))
    print(str("\t") + str("\"") + str(answer) + str("\""))
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
disabled = False
p0 = "he[row oll]ld"
p1 = "hello world"
all_right = (disabled or KawigiEdit_RunTest(0, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = "ab[edc]f"
p1 = "abcdef"
all_right = (disabled or KawigiEdit_RunTest(1, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = "topcoder"
p1 = "topcoder"
all_right = (disabled or KawigiEdit_RunTest(2, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = "[desrever lla]"
p1 = "all reversed"
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
#Powered by KawigiEdit-pf 2.3.0!
