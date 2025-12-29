## Problem1 
# Pow(x,n) (https://leetcode.com/problems/powx-n/)

# Method-1: Using Brute Force of Linear For Loop
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Calculating pow(x, n) -- using for loop from 0 to n. 


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if(x == 0):
            return 0
        if(n == 0):
            return 1
        if(n < 0):
            return self.myPow(1/x, -n)

        res = 1
        for i in range(n):
            res *= x

        return res

print("Method-1: Using Brute Force of Linear For Loop")
sol = Solution()
print(sol.myPow(2.00000, 10))
print(sol.myPow(2.10000, 3))
print(sol.myPow(2.00000, -2))
print(sol.myPow(2.00, -200000000))

# Method-2: Using recursion to break down powers equally into two halves
# Time Complexity : O(Log(base2)N)
# Space Complexity : O(Log(base2)N) -- recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we are using the power of recursion. We are breaking the large power into two equal halves if it is even or two equal halves
# and one extra if power is odd. We keep on doing half of the power till it reaches 0, and then we could return 1 as anything
# raised to power 0 is 1. Once we reach our base case we return 1 to the parent of it. This is where the recursion unfolds. We
# calculate the value and return to the parent. As any particular level when the value has come from the child, we just use it to
# multiply with itself. Since we had halved the power, so we dont need to calculate the other half again. For negative power, just
# just use (1/X) in place of X.

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if(x == 0):
            return 0.00
        if(n == 0):
            return 1.00
        if(n < 0):
            # return self.myPow(1/x, -n)
            x = 1/x
            n = -n

        repeat = self.myPow(x, n//2)

        if(n % 2 == 0):
            # even power
            return (repeat * repeat)
        else:
            # odd power
            return (repeat * repeat * x)
        

print("Method-2: Using recursion to break down powers equally into two halves")
sol = Solution()
print(sol.myPow(2.00000, 10))
print(sol.myPow(2.10000, 3))
print(sol.myPow(2.00000, -2))
print(sol.myPow(2.00, -200000000))


# Method-3: Using recursion to break down powers equally into two halves
# Time Complexity : O(Log(base2)N)
# Space Complexity : O(Log(base2)N) -- recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here logic is same as above. Just for the case of n < 0, everything remains same just when power is odd we multiply (1/x) instead
# of X. So in the base case when 1 is returned to the parent call of 2^-1, we multiply it with (1/2). This (1/2) is returned to the
# call of (2^-2).

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if(x == 0):
            return 0.00
        if(n == 0):
            return 1.00
        # if(n < 0):
        #     return self.myPow(1/x, -n)

        # -3//2 = -2
        # int(-3/2) = -1, we want this
        # print(int(n/2))
        repeat = self.myPow(x, int(n/2.00))

        if(n % 2 == 0):
            # even power
            return (repeat * repeat)
        else:
            # odd power
            if(n > 0):
                return (repeat * repeat * x)
            else:
                return (repeat * repeat * (1/x))
        

print("Method-3: Using recursion to break down powers equally into two halves")
sol = Solution()
print(sol.myPow(2.00000, 10))
print(sol.myPow(2.10000, 3))
print(sol.myPow(2.00000, -2))
print(sol.myPow(2.00, -200000000))



# Method-4: Solving iteratively to avoid extra space
# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here the logic is that we are squaring x at each level. This is keeping track of even powers of x. We are also keeping a 
# result variable that keeps track of extra powers of x when n is odd. So when n is odd we multiply the res with x.
# When we reach n = 1, our x would have all the square terms multiplied and res would have the extra odd powers multiplied.
# This iterative approach helps us to avoid the extra space used in recursion stack.

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        # using iteration
        if(x == 0):
            return 0

        if(n == 0):
            return 1

        if(n < 0):
            x = 1/x
            n = -n # this could give me integer overflow in some languages such as Java

        res = 1.00

        while(n != 0):
            if(n % 2 != 0):
                # n is odd, update res. It is used to consider the extra power of x
                # Also at n = 1, it would multiply the square terms contained in x and the extra powers contained in res
                res = res * x
            # n is even, keep the res same and update the x
            # it is used to consider even power of x
            x = x * x
            n = n // 2

        return res
    
print("Method-4: Solving iteratively to avoid extra space")
sol = Solution()
print(sol.myPow(2.00000, 10))
print(sol.myPow(2.10000, 3))
print(sol.myPow(2.00000, -2))
print(sol.myPow(2.00, -200000000))


# Method-5: Solving iteratively with different logic to handle negative powers
# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here the logic is same as above. Just we are handling the negative powers differently. It would work for both positive and
# negative powers.

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        # using iteration
        if(x == 0):
            return 0

        if(n == 0):
            return 1

        if(n < 0):
            x = 1/x

        res = 1.00

        while(n != 0):
            if(n % 2 != 0):
                # n is odd, update res. It is used to consider the extra power of x
                # Also at n = 1, it would multiply the square terms contained in x and the extra powers contained in res
                res = res * x
            # n is even, keep the res same and update the x
            # it is used to consider even power of x
            x = x * x
            n = n / 2.0
            n = int(n)

        return res
    
print("Method-5: Solving iteratively with different logic to handle negative powers")
sol = Solution()
print(sol.myPow(2.00000, 10))
print(sol.myPow(2.10000, 3))
print(sol.myPow(2.00000, -2))
print(sol.myPow(2.00, -200000000))
