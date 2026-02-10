class Solution:
    def myPow(self, x: float, n: int) -> float:
        res=1
        power=abs(n)

        while power>0:
            if power%2==1:
                res=res*x
            x=x*x
            power=power//2

        if n>0:
            return res
        else:
            return 1/res   
    