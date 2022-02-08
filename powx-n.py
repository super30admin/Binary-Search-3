class Solution:
    def myPow(self, x: float, n: int) -> float:
        return self.powerOf(x, n, {})
		
    def powerOf(self, x, n, cache):
        if n in cache:
            return cache[n]
        
        if n == 1:
            return x
        if n == -1:
            return 1/x
        if n == 0:
            return 1
        
        if n % 2 == 0:
            cache[n] = self.powerOf(x, n//2, cache) * self.powerOf(x, n//2, cache)
        else:
            cache[n] = self.powerOf(x, (n//2)+1, cache) * self.powerOf(x, n//2, cache)
        return cache[n]