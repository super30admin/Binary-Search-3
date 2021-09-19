class Solution:
    def __init__(self):
        self.dict_pow = dict()
        
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            return self.myPow(1/x, n*-1)
        if n in self.dict_pow:
            return self.dict_pow[n]
        if n == 0:
            return 1
        elif n%2 == 0:
            self.dict_pow[n] = self.myPow(x, n//2) * self.myPow(x, n//2)
            return self.dict_pow[n]
        else:
            self.dict_pow[n] =  x * self.myPow(x, n-1)
            return self.dict_pow[n]


#TC : O(nlogn)
#SC : O(nlogn)