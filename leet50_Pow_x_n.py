# Solution

# // Time Complexity : recursion solution and iterative solution: O(logn)
# // Space Complexity : recurion solution: O(N), iterative solution: O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to find a solution which works while we constantly divide the power(n) by 2 so that final soltuion should be O(logn)
# time complexity

def myPow(x, n):
    # iterative approach
    # O(logn)
    result = 1
    if n<0:
        n *= -1
        x = 1/x
    while n>0:
        if n%2 != 0:
            result = result*x
        
        x = x*x
        n = n//2

    
    return result

    # recursive solution
    # O(logn)
    # if n == 0:
    #     return 1
    
    # if n<0:
    #     n *= -1
    #     x = 1/x

    # result = self.myPow(x,n//2)

    # if n%2 == 0:
    #     result = (result*result)
    #     return result
    # else:
    #     if n<0:
    #         result = result*result*(1/x)
    #         return result
    #     else:
    #         result = result*result*x        
    #         return result
    
    # return result

if __name__ == "__main__":
    x = 2
    n = 10
    print(myPow(x,n))