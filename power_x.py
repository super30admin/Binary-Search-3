#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution:
    def myPow(self, x: float, n: int) -> float:
        N = n
        def fastmyPow(x,n):
            if n==0:
                return 1
            ans = fastmyPow(x,n//2)
            prod = ans*ans
            if n%2 == 0:
                return prod

            else:
                return prod * x

        result = fastmyPow(x,abs(N))
        if n<0:
            return 1/result
        else:
            return result
        