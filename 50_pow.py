class Solution:
    def myPow(self, x: float, n: int) -> float:
        """
            https://leetcode.com/problems/powx-n/
            Time Complexity - O(logn)
            Space Complexity - O(logn)
            Three lines explnation-
                - Keep dividing n by 2
                - If n is zero, base case
                    return 0
                - n is even or n is odd (positive, negative)
        """
        # base
        if n == 0:
            return 1
        # logic
        temp = self.myPow(x, int(n / 2))
        # if n is even
        if n % 2 == 0:
            return temp * temp
        # else n is odd
        else:
            # if n is negative
            if n < 0:
                return (temp * temp) * (1 / x)
            else:
                return (temp * temp) * x


if __name__ == '__main__':
    print(int(-1.0 / 2.0))
    print(-1 // 2)
    Solution().myPow(2, -2)
