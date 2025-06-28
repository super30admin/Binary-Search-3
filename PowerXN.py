# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         #bases
#         if n == 0 : return 1.0
#         if n<0:
#             n=-n
#             x = 1/x
#         #logic
#         res = self.myPow(x,n//2)
#         if n%2 == 0:
#             return res*res
#         else:
#             return x*res*res

class Solution:
    def myPow(self, x: float, n: int) -> float:
        re = 1.0
        if n<0:
            n= -n
            x=1/x
        while n!=0:
            if n%2!=0:
                re = re*x
            x=x*x
            n=n//2
        return re


        


        