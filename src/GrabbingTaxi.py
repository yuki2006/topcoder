import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class GrabbingTaxi:
    def getTime(self,x,y,time):
        return (abs(x)+abs(y))*time

    def minTime(self, tXs, tYs, gX, gY, walkTime, taxiTime):
        lst=[]
        lst.append(self.getTime(gX,gY,walkTime))
        for i in xrange(len(tXs)):
          lst.append(
                self.getTime(tXs[i],tYs[i],walkTime)
                +self.getTime(tXs[i]-gX,tYs[i]-gY,taxiTime)
            )
            
        return min(lst)
# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, p1, p2, p3, p4, p5, hasAnswer, p6):
    sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str("{"))
    for i in range(len(p0)):
        if (i > 0):
            sys.stdout.write(str(","))
        
        sys.stdout.write(str(p0[i]))
    
    sys.stdout.write(str("}") + str(",") + str("{"))
    for i in range(len(p1)):
        if (i > 0):
            sys.stdout.write(str(","))
        
        sys.stdout.write(str(p1[i]))
    
    sys.stdout.write(str("}") + str(",") + str(p2) + str(",") + str(p3) + str(",") + str(p4) + str(",") + str(p5))
    print(str("]"))
    obj = GrabbingTaxi()
    startTime = time.clock()
    answer = obj.minTime(p0, p1, p2, p3, p4, p5)
    endTime = time.clock()
    res = True
    print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
    if (hasAnswer):
        print(str("Desired answer:"))
        print(str("\t") + str(p6))
    
    print(str("Your answer:"))
    print(str("\t") + str(answer))
    if (hasAnswer):
        res = answer == p6
    
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
p0 = ()
p1 = ()
p2 = 3
p3 = 2
p4 = 10
p5 = 2
p6 = 50
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, True, p6) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (-2,-2)
p1 = (0,-2)
p2 = -4
p3 = -2
p4 = 15
p5 = 3
p6 = 42
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, True, p6) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = (3,)
p1 = (0,)
p2 = 5
p3 = 0
p4 = 10
p5 = 20
p6 = 50
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, True, p6) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (34,-12,1,0,21,-43,-98,11,86,-31)
p1 = (11,5,-68,69,-78,-49,-36,-2,1,70)
p2 = -97
p3 = -39
p4 = 47
p5 = 13
p6 = 2476
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, True, p6) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = (82,-60,57,98,30,-67,84,-42,-100,62)
p1 = (-7,90,53,-56,-15,-87,22,-3,-61,-30)
p2 = 21
p3 = 15
p4 = 53
p5 = 2
p6 = 1908
all_right = (disabled or KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, True, p6) ) and all_right
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
