#Time and Space Compelxity 
  # Recursion: O(Logn),O(LogN)
  # While loop: O(Logn),O(1)
#Approach: in recurion we cut n by 2 always if its even and multiply with each other if nis odd , we just multiply x and n-=1
# In loop based we change val x(muliply by itself) if its even , else we update result 
#In Python we should always reduce val of n If n is negative and you don’t flip it, the loop decreases n endlessly or goes into a cycle.
# Python integers can go negative infinitely — there's no lower limit like in C.


#Recursion, After each recursion cut n by 2
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,n):
            # print(x,n)
            #base
            if n==0:return 1
            #logic
            p=helper(x,n//2)
            if n%2==0: 
                return p*p
            if n%2!=0:
                n-=1
                return p*x*p
        if n>=0:
            return helper(x,n)
        else:
            x=1/x
            n=abs(n)
            return helper(x,n)
#while loop , update res when its odd(no matter what n will come to 1 if n>=1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        res=1
        if n<0:
            x=1/x
            n=-1*n
        while(n!=0):
            print(n,x,res)
            if n%2==0:
                
                x=x*x
                
                n=n//2
            else:
                n-=1
                res=res*x
        return res
