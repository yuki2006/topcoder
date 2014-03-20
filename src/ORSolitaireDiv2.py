import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class ORSolitaireDiv2:
    def getMinimum(self, numbers, goal):
        bits=[]
        mx=max(numbers)
        bitIndex=0
        while(1<<bitIndex <=goal):
           bit=1<<bitIndex
           count=0
           if (goal & bit==0):
               count=100
           else :
               for number in numbers:
                    if( number & bit>0 and number|goal==goal):
                        count+=1
           bits.append(count)
           bitIndex+=1
        print bits
        return min(bits)
            
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
	obj = ORSolitaireDiv2()
	startTime = time.clock()
	answer = obj.getMinimum(p0, p1)
	endTime = time.clock()
	res = True
	print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
	if (hasAnswer):
		res = answer == p2
	
	if (not res):
		print(str("DOESN'T MATCH!!!!"))
		if (hasAnswer):
			print(str("Desired answer:"))
			print(str("\t") + str(p2))
		
		print(str("Your answer:"))
		print(str("\t") + str(answer))
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
p0 = (1,2,4)
p1 = 7
p2 = 1
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (1,2,4,7,8)
p1 = 7
p2 = 2
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = (12571295,2174218,2015120)
p1 = 1
p2 = 0
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (5,2,4,52,62,9,8,3,1,11,6)
p1 = 11
p2 = 3
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = (503,505,152,435,491,512,1023,355,510,500,502,255,63,508,509,511,60,250,254,346)
p1 = 510
p2 = 5
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