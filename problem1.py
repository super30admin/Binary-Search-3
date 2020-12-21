#timecomplexity log(n)
#spacecomplexity ???
#https://leetcode.com/problems/powx-n/submissions/
class Solution:
    res=0
    def myPow(self, x: float, n: int) -> float:
        if n==0: return 1
        res=self.myPow(x,int(n/2))
        print(res)
        print(n)
        if n%2==0:
            res=res*res
        elif n<0:
            res=res*res*(1/x)
        else:
            res=res*res*(x)
        
        return res
        