class SilverbachConjecture:
	def solve(self, n):
		for x in xrange(2, n):
			for y in range(2, x):
				if x % y == 0:
					for z in range(2, x):
						if (n - x) % z == 0:
							return (x, n - x)
		return None

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, hasAnswer, p1):
	sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str(p0))
	print(str("]"))
	obj = SilverbachConjecture()
	startTime = time.clock()
	answer = obj.solve(p0)
	endTime = time.clock()
	res = True
	print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
	if (hasAnswer):
		if (len(answer) != len(p1)):
			res = False
		else:
			for i in range(len(answer)):
				if (answer[i] != p1[i]):
					res = False
				
			
		
	
	if (not res):
		print(str("DOESN'T MATCH!!!!"))
		if (hasAnswer):
			print(str("Desired answer:"))
			sys.stdout.write(str("\t") + str("{"))
			for i in range(len(p1)):
				if (i > 0):
					sys.stdout.write(str(","))
				
				sys.stdout.write(str(p1[i]))
			
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
p0 = 20
p1 = (8,12)
all_right = (disabled or KawigiEdit_RunTest(0, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = 30
p1 = (15,15)
all_right = (disabled or KawigiEdit_RunTest(1, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = 999
p1 = (699,300)
all_right = (disabled or KawigiEdit_RunTest(2, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = 45
p1 = (15,30)
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
