import math,string,itertools,fractions,heapq,collections,re,array,bisect,random

class CoinsGameEasy:
    def minimalSteps(self, board):
        board=list(board)
        coin1=[];coin2=[]
        for x,row in enumerate(board):
            for y,cell in enumerate(row):
                if (cell=="o"):
                    if (len(coin1)==0):
                        coin1=coin1+[x];coin1=coin1+[y]
                    else:
                        coin2=coin2+[x];coin2=coin2+[y]
        result=self.dfs(board,coin1,coin2,1)
        return result if result<=10 else -1
    def dfs(self,board,_coin1,_coin2,depth):
        if (depth==11):
           return 100        
        vecx=[-1,1,0,0]
        vecy=[0,0,-1,1]
        coin1=[0,0];coin2=[0,0]
        mn=100
        for vec in xrange(4):
                     coin1[0]=_coin1[0]+vecx[vec]
                     coin1[1]=_coin1[1]+vecy[vec]
                     coin2[0]=_coin2[0]+vecx[vec]
                     coin2[1]=_coin2[1]+vecy[vec]
                     count=0
                     if (coin1[0]<0 or coin1[0]>=len(board)
                         or  coin1[1]<0 or coin1[1]>=len(board[0])) :
                         count+=1
                     else:
                         if (board[coin1[0]][coin1[1]]=="#"):
                            coin1[0]=_coin1[0]
                            coin1[1]=_coin1[1]  
                     if (coin2[0]<0 or coin2[0]>=len(board)
                         or  coin2[1]<0 or coin2[1]>=len(board[0])) :
                         count+=1
                     else:
                          if (board[coin2[0]][coin2[1]]=="#"):
                            coin2[0]=_coin2[0]
                            coin2[1]=_coin2[1]  
                     if (count==0):
                         result=self.dfs(board,coin1,coin2,depth+1)
                         mn=min(mn,result)
                     elif (count==1):
                         return depth
                     elif (count==2):
                         pass
        return mn
# BEGIN KAWIGIEDIT TESTING
# Generated by KawigiEdit-pf 2.3.0
import sys
import time
def KawigiEdit_RunTest(testNum, p0, hasAnswer, p1):
	sys.stdout.write(str("Test ") + str(testNum) + str(": [") + str("{"))
	for i in range(len(p0)):
		if (i > 0):
			sys.stdout.write(str(","))
		
		sys.stdout.write(str("\"") + str(p0[i]) + str("\""))
	
	sys.stdout.write(str("}"))
	print(str("]"))
	obj = CoinsGameEasy()
	startTime = time.clock()
	answer = obj.minimalSteps(p0)
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
p0 = ("oo",)
p1 = 1
all_right = (disabled or KawigiEdit_RunTest(0, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 1 -----
disabled = False
p0 = (".#",".#",".#","o#","o#","##")
p1 = 4
all_right = (disabled or KawigiEdit_RunTest(1, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 2 -----
disabled = False
p0 = ("..","..","..","o#","o#","##")
p1 = 3
all_right = (disabled or KawigiEdit_RunTest(2, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 3 -----
disabled = False
p0 = ("###",".o.","###",".o.","###")
p1 = -1
all_right = (disabled or KawigiEdit_RunTest(3, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 4 -----
disabled = False
p0 = ("###",".o.","#.#",".o.","###")
p1 = 3
all_right = (disabled or KawigiEdit_RunTest(4, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 5 -----
disabled = False
p0 = ("###########","........#o#","###########",".........o#","###########")
p1 = 10
all_right = (disabled or KawigiEdit_RunTest(5, p0, True, p1) ) and all_right
tests_disabled = tests_disabled or disabled
# ------------------

# ----- test 6 -----
disabled = False
p0 = ("############",".........#o#","############","..........o#","############")
p1 = -1
all_right = (disabled or KawigiEdit_RunTest(6, p0, True, p1) ) and all_right
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
