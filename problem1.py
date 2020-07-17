# brute force solution
class Solution:
    def myPow(self, x: float, n: int) -> float:
        inv = False
        answer = 1
        if n<0: 
            inv = True
            n = -n
        while n:
            answer *= x
            n -= 1
        if inv:
            answer = 1/answer
        return answer


# recursion O(log n) time | O(1) space
# Binary search
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        temp = self.myPow(x, int(n/2)) ** 2
        if n%2!=0:
            if n>0:     return x * temp
            else:       return 1/x * temp
        return temp
        

# recursion O(log n) time 
# Binary search
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n<0:
            return self.myPow(1/x, -n)
        temp = self.myPow(x*x, n//2)
        if n%2!=0:
            return x * temp
        return temp 