
class Solution:
    """
    keyIdea:
    # x=2, n=8
    # 2^8 = 2^4*2^4
    # 2^4 = 2^2*2^2
    # 2^2 = 2^1*2^1
    # 2^1 = 2^0*2^0*1 (when n is odd, multiply by extra x)
    TC:O(logn)
    SC:O(n//2) for recursive stack
    """
    if x==0.00 and n>0: return 0
    if x==0.00 and n<0: return None
        # base
    if n==0: return 1
        
        # logic
    if n<0:
        x=1/x
        n=-n
    res=self.myPow(x, n//2)
    if n%2==0:
        return res * res
    else:
        return res*res*x






## Below solution gives time limit exceed for some of test cases where x is very small number

# class Solution:
#     """
#     TC:O(n)
#     SC:O(1)
#     """
#     def myPow(self, x: float, n: int) -> float:
#         if x==0.00 and n>0: return 0
#         if x==0.00 and n<0: return None
#         poww = 1
#         for i in range(abs(n)):
#             if n>0:
#                 poww=poww*x
#             else:
#                 poww=poww/x
#         return poww