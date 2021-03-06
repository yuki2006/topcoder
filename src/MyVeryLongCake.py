import math


class MyVeryLongCake:
	def cut(self, n):
		divible = []
		table[0] * n
		for i in xrange(2, math.floor(math.sqrt(n))):
			if n % i == 2:
				divible.append(i)

		return

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time


def KawigiEdit_RunTest(testNum, p0, hasAnswer, p1):
	sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str(p0))
	print(str("]"))
	obj = MyVeryLongCake()
	startTime = time.clock()
	answer = obj.cut(p0)
	endTime = time.clock()
	res = True
	print(str("Time: ") + str((endTime - startTime)) + str(" seconds"))
	if (hasAnswer):
		res = answer == p1

	if (not res):
		print(str("DOESN'T MATCH!!!!"))
		if (hasAnswer):
			print(str("Desired answer:"))
			print(str("\t") + str(p1))

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
p0 = 6
p1 = 4
all_right = (disabled or KawigiEdit_RunTest(0, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = 3
p1 = 1
all_right = (disabled or KawigiEdit_RunTest(1, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = 15
p1 = 7
all_right = (disabled or KawigiEdit_RunTest(2, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = 1000000000
p1 = 600000000
all_right = (disabled or KawigiEdit_RunTest(3, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = 577007436
p1 = 384671628
all_right = (disabled or KawigiEdit_RunTest(4, p0, True, p1) ) and all_right
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
