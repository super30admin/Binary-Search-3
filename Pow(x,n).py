def myPow(self, x: float, n: int) -> float:
    #Time Complexity: O(logN)
    #Space Complexity: O(logN)
    if n==0:
        return 1
    def helper(power,val):
        if power == 1:
            return val
        left = helper(power//2,val)
        if power%2!=0:
            return val*left*left
        return left*left
    if n<0:
        return 1/helper(abs(n),x)
    return helper(abs(n),x)