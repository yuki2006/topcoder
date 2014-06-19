class Family:
	def isFamily(self, parent1, parent2):
		N = 101
		POSSIBLE = "Possible"
		IMPOSSIBLE = "Impossible"
		table = [[None for i in range(N)] for i in range(N)]
		for p1, p2 in zip(parent1, parent2):
			if p1 != -1:
				table[p1][p2] = table[p2][p1] = 1

		for k in range(N):
			for i in range(N):
				for j in range(N):
					if table[i][k] == None or table[k][j] == None:
						continue

					tmp = table[i][k] + table[k][j]
					if table[i][j] == None:
						table[i][j] = tmp
					elif (table[i][j] + tmp) % 2 == 1:
						return IMPOSSIBLE

		return POSSIBLE
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
	
	sys.stdout.write(str("}") + str(",") + str("{"))
	for i in range(len(p1)):
		if (i > 0):
			sys.stdout.write(str(","))
		
		sys.stdout.write(str(p1[i]))
	
	sys.stdout.write(str("}"))
	print(str("]"))
	obj = Family()
	startTime = time.clock()
	answer = obj.isFamily(p0, p1)
	endTime = time.clock()
	res = True
	print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
	if (hasAnswer):
		res = answer == p2
	
	if (not res):
		print(str("DOESN'T MATCH!!!!"))
		if (hasAnswer):
			print(str("Desired answer:"))
			print(str("\t") + str("\"") + str(p2) + str("\""))
		
		print(str("Your answer:"))
		print(str("\t") + str("\"") + str(answer) + str("\""))
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
p0 = (-1,-1,0)
p1 = (-1,-1,1)
p2 = "Possible"
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (-1,-1,-1,-1,-1)
p1 = (-1,-1,-1,-1,-1)
p2 = "Possible"
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = (-1,-1,0,0,1)
p1 = (-1,-1,1,2,2)
p2 = "Impossible"
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6)
p1 = (-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1)
p2 = "Possible"
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = (-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11)
p1 = (-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13)
p2 = "Impossible"
all_right = (disabled or KawigiEdit_RunTest(4, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 5 -----
disabled = False
p0 = (-1,-1,-1,-1,-1)
p1 = (-1,-1,-1,-1,-1)
p2 = "Possible"
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
# Powered by KawigiEdit-pf 2.3.0!
