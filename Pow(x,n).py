class Solution:
    # Time Complexity: O(logn)
    # Space Complexity: O(logn) For the recursive stack
    def myPow(self, x: float, n: int) -> float:
        # Recursive Solution
        # Base Case
        if n == 0:
            return 1.0
        # Logic
        result = float(self.myPow(x, int(n / 2)))
        print(result)
        if n % 2 == 0:
            return result * result
        else:
            if n > 0:
                return result * result * x
            else:
                return (result * result * 1 / x)


