# Time Complexity: O(log(n))
# Space Complexity: O(log(n)) for recursion
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n >=0:
            return self.helper(x,n)
        else:
            return self.helper(1/x, -n)
    def helper(self, x, n):
        print(x,n)
        if n == 0:
            return 1
        if n%2 == 1:
            return ((self.helper(x, (n-1)//2))**2)*x
        else:
            return ((self.helper(x, (n)//2))**2)
            
        
