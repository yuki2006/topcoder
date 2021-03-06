class SlimeXSlimonadeTycoon:
	def sell(self, morning, customers, stale_limit):
		morning = list(morning)
		customers = list(customers)
		stack = [0] * stale_limit
		sell = 0
		for i in range(len(morning)):
			stack.pop(0)
			stack.append(morning[i])
			nextStack = []
			for s in stack:
				tmp = min(s, customers[i])
				nextStack.append(s - tmp)
				customers[i] -= tmp
				sell += tmp
			stack = nextStack
		return sell

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
	obj = SlimeXSlimonadeTycoon()
	startTime = time.clock()
	answer = obj.sell(p0, p1, p2)
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
p0 = (5, 1, 1)
p1 = (1, 2, 3)
p2 = 2
p3 = 5
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (10, 20, 30)
p1 = (30, 20, 10)
p2 = 1
p3 = 40
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = (1, 2, 3, 4, 5)
p1 = (5, 5, 5, 5, 5)
p2 = 5
p3 = 15
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, p2, True, p3) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = (10000, 0, 0, 0, 0, 0, 0)
p1 = (1, 2, 4, 8, 16, 32, 64)
p2 = 4
p3 = 15
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, p2, True, p3) ) and all_right
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
