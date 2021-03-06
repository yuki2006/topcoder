import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class ColorfulCards:
    def theCards(self, N, colors):
        tmp=[1,2,3]
        kind=["B","R","R"]
        primes=[2,3]
        pointer=0
        NPcount=0
        Pcount=0
        oldPrime=False
        for x in range(4,N+1):
            hit=False
            for y in primes:
                if (x %y==0):
                    hit=True

            if (hit==False):
                primes.append(x)
            if (oldPrime!=hit):
                tmp.append(x)
                if (hit==False):
                    kind.append("R")
                else:
                    kind.append("B")
            oldPrime=hit
        print (tmp)
        print (kind)
        result=[]
        pointer=len(colors)-1
        for p in range(len(kind)-1,-1,-1):
            if (colors[pointer]==kind[p]):
                if (p==0):
                    result.insert(0,tmp[p])
                    continue
                pointer-=1
                if (tmp[p]-1==tmp[p-1]):
                    result.insert(0,tmp[p])
                else:
                    result.insert(0,-1)   
        return result
    


# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, p1, hasAnswer, p2):
	sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str(p0) + str(",") + str("\"") + str(p1) + str("\""))
	print(str("]"))
	obj = ColorfulCards()
	startTime = time.clock()
	answer = obj.theCards(p0, p1)
	endTime = time.clock()
	res = True
	print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
	if (hasAnswer):
		if (len(answer) != len(p2)):
			res = False
		else:
			for i in range(len(answer)):
				if (answer[i] != p2[i]):
					res = False
				
			
		
	
	if (not res):
		print(str("DOESN'T MATCH!!!!"))
		if (hasAnswer):
			print(str("Desired answer:"))
			sys.stdout.write(str("\t") + str("{"))
			for i in range(len(p2)):
				if (i > 0):
					sys.stdout.write(str(","))
				
				sys.stdout.write(str(p2[i]))
			
			print(str("}"))
		
		print(str("Your answer:"))
		sys.stdout.write(str("\t") + str("{"))
		for i in range(len(answer)):
			if (i > 0):
				sys.stdout.write(str(","))
			
			sys.stdout.write(str(answer[i]))
		
		print(str("}"))
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
p0 = 5
p1 = "RRR"
p2 = (2,3,5)
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = 7
p1 = "BBB"
p2 = (1,4,6)
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = 6
p1 = "RBR"
p2 = (-1,4,5)
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = 58
p1 = "RBRRBRBBRBRRBBRRBBBRRBBBRR"
p2 = (-1,-1,-1,-1,-1,-1,-1,-1,17,18,19,23,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,47,53)
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = 495
p1 = "RBRRBRBBRBRRBBRRBBBRRBBBRR"
p2 = (-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
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
