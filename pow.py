#Problem 1: Pow(x,n)
#Time Complexity: log(n)
#Space Complexity: O(log(n)) at most for recursive stack
'''
Brute force is obvious. We notice that 
(x^2)^2=x^4. This means that if we multiply
our result with itself, k times,
it's the same as x^(2^k). So instead of n operations,
we can have k operations, which is at most log(n)
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,n):
            if n==0:
                return 1
            if n==1:
                return x
            if x==0 or x==1:
                return x
            if n<0:
                x=(1/x)
                n=(-n)

            power=1
            value=x
            while 2*power<=n:
                value*=value
                power=2*power

            rest=n-power
            value*=helper(x,rest)    
            return value
        return helper(x,n)
'''
Same solution, a bit more efficient, since we take
care of the odd as we go along
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,p):
            if p==0:
                return 1
            previous=helper(x,p//2)
            if p%2==0:
                return previous*previous
            return previous*previous*x
        
        if n<0: x,n =(1/x), (-n)
        return helper(x,n)
         
'''
It begs the question, what is the fastest logarithm to do this?
Wy not do (x^3)^3=x^(9) instead? if we multiply the results by itself
and again by itself (x^3), k times, it's the same as x^(3^n). So
which one is faster? would it be faster if we multiply 3 times at each 
iteration instead of 2 times? what about 4?

Basically the number of iteration we're doing is
p*log_p(n), p being the number we chose as base (2 times, 3 times)
if we try to minimize as a function of p, we find that the
optimal p is e=2.71... , and the closest is 3. So using 3 is indeed
the fastest solution.
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,p):
            if p==0:
                return 1
            previous=helper(x,p//3)
            if p%3==0:
                return previous*previous*previous
            if p%3==1:
                return previous*previous*previous*x
            if p%3==2:
                return previous*previous*previous*x*x
        
        if n<0: x,n =(1/x), (-n)
        return helper(x,n)
