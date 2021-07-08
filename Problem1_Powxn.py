'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 50. Pow(x, n)


# https://leetcode.com/problems/powx-n/

#-----------------
# Time Complexity: 
#-----------------
# O(LogN) - Where N is the input power

#------------------
# Space Complexity: 
#------------------
# O(1): Constant space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        n = long(n)
        if n < 0:
            x = 1/x
            n = -n
        return self.myPowHelper(x, n)
    
    def myPowHelper(self, x, n):
        if n == 0:
            return 1
        half = self.myPowHelper(x, n//2)
        if n % 2 == 0:
            return half * half 
        else:
            return half * half * x