class FizzBuzzTurbo:
	def firstLast(self, diffA, diffB):
		if diffA == 0:
			return 1
		return 0

	def counts(self, A, B):
		diffA15 = A % 15
		diffA5 = A % 5
		diffA3 = A % 3
		diffB15 = B % 15
		diffB5 = B % 5
		diffB3 = B % 3

		ans15 = (B - A) / 15 + (1 if diffA15 > diffB15 else 0)
		ans5 = (B - A) / 5 + (1 if diffA5 > diffB5 else 0)
		ans3 = (B - A) / 3 + (1 if diffA3 > diffB3 else 0)

		ans15 += self.firstLast(diffA15, diffB15)
		ans5 += self.firstLast(diffA5, diffB5)
		ans3 += self.firstLast(diffA3, diffB3)

		ans5 -= ans15
		ans3 -= ans15

		return (ans3, ans5, ans15)

# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, p1, hasAnswer, p2):
	sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str(p0) + str(",") + str(p1))
	print(str("]"))
	obj = FizzBuzzTurbo()
	startTime = time.clock()
	answer = obj.counts(p0, p1)
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
p0 = 1
p1 = 4
p2 = (1,0,0)
all_right = (disabled or KawigiEdit_RunTest(0, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = 2
p1 = 6
p2 = (2,1,0)
all_right = (disabled or KawigiEdit_RunTest(1, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = 150
p1 = 165
p2 = (4,2,2)
all_right = (disabled or KawigiEdit_RunTest(2, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = 474747
p1 = 747474
p2 = (72728,36363,18182)
all_right = (disabled or KawigiEdit_RunTest(3, p0, p1, True, p2) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = 15
p1 = 30
p2 = (4,2,2)
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
# Powered by KawigiEdit-pf 2.3.0!
