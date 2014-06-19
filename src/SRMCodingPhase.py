import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class SRMCodingPhase:
    def countScore(self, points, skills, luck):
        
        return

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, p1, p2, hasAnswer, p3):
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
	
	sys.stdout.write(str("}") + str(",") + str(p2))
	print(str("]"))
	obj = SRMCodingPhase()
	startTime = time.clock()
	answer = obj.countScore(p0, p1, p2)
	endTime = time.clock()
	res = True
	print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
	if (hasAnswer):
		res = answer == p3
	
	if (not res):
		print(str("DOESN'T MATCH!!!!"))
		if (hasAnswer):
			print(str("Desired answer:"))
			print(str("\t") + str(p3))
		
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
p0 = (250,500,1000)
p1 = (10,25,40)
p2 = 0
p3 = 1310
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (300,600,900)
p1 = (30,65,90)
p2 = 25
p3 = 680
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = (250,550,950)
p1 = (10,25,40)
p2 = 75
p3 = 1736
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (256,512,1024)
p1 = (35,30,25)
p2 = 0
p3 = 1216
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = (300,600,1100)
p1 = (80,90,100)
p2 = 4
p3 = 0
all_right = (disabled or KawigiEdit_RunTest(4, p0, p1, p2, True, p3) ) and all_right
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