import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class PastingPaintingDivTwo:
    def check(self,clipboard,t,x,y):
        for tt in range(1,t+1):
               if (y+tt<len(clipboard) and x+tt<len(clipboard[0])):
                   if ("B"==clipboard[y][x]==clipboard[y+tt][x+tt]):
                       return 1
        return 0
    def countColors(self, clipboard, T):
        same=[0]*(len(clipboard))
        for y in range(len(clipboard)):
           for x in range(len(clipboard[y])):
               for t in range(1,len(clipboard)):        
                same[t]+=self.check(clipboard,t,x,y)
        total=0
        black=0
        for y in range(len(clipboard)):
            black+=sum(i=="B" for i in clipboard[y])
        for t in range(min(len(same),T)):
            total+=black-same[t]
        if T>len(same):
            total+=(black-same[-1])*(T-len(same))    
        return total
# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, p1, hasAnswer, p2):
	sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str("{"))
	for i in range(len(p0)):
		if (i > 0):
			sys.stdout.write(str(","))
		
		sys.stdout.write(str("\"") + str(p0[i]) + str("\""))
	
	sys.stdout.write(str("}") + str(",") + str(p1))
	print(str("]"))
	obj = PastingPaintingDivTwo()
	startTime = time.clock()
	answer = obj.countColors(p0, p1)
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
p0 = ("..B","B..","BB.")
p1 = 3
p2 = 10
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = ("B...","....","....","...B")
p1 = 2
p2 = 4
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = ("BBB",)
p1 = 10000
p2 = 30000
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (".",)
p1 = 1000000000
p2 = 0
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = ("BB.",".B.")
p1 = 100
p2 = 201
all_right = (disabled or KawigiEdit_RunTest(4, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 5 -----
disabled = False
p0 = ("..........B..........",".........B.B.........","........B...B........",".......B.....B.......","......B..B.B..B......",".....B...B.B...B.....","....B...........B....","...B...B.....B...B...","..B.....BBBBBB....B..",".B..........BB.....B.","BBBBBBBBBBBBBBBBBBBBB")
p1 = 1000000000
p2 = 21000000071
all_right = (disabled or KawigiEdit_RunTest(5, p0, p1, True, p2) ) and all_right
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
