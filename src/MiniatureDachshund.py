import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class MiniatureDachshund:
    def maxMikan(self, mikan, weight):
        total=weight
        count=0
        for m in sorted(mikan):
            total+=m
            if (total>5000):
                break;
            count+=1
        return count

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, p1, hasAnswer, p2):
    sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str("{"))
    for i in range(len(p0)):
        if (i > 0):
            sys.stdout.write(str(","))
        
        sys.stdout.write(str(p0[i]))
    
    sys.stdout.write(str("}") + str(",") + str(p1))
    print(str("]"))
    obj = MiniatureDachshund()
    startTime = time.clock()
    answer = obj.maxMikan(p0, p1)
    endTime = time.clock()
    res = True
    print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
    if (hasAnswer):
        print(str("Desired answer:"))
        print(str("\t") + str(p2))
    
    print(str("Your answer:"))
    print(str("\t") + str(answer))
    if (hasAnswer):
        res = answer == p2
    
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
p0 = (100,100,100,100,100)
p1 = 4750
p2 = 2
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (100,100,100,100,50)
p1 = 4750
p2 = 3
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = (120,90,130,100,110,80)
p1 = 3000
p2 = 6
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (50,)
p1 = 5000
p2 = 0
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = (200,50,200,50,200,50,200,50)
p1 = 4800
p2 = 4
all_right = (disabled or KawigiEdit_RunTest(4, p0, p1, True, p2) ) and all_right
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
