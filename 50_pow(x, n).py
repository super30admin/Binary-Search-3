'''

## Problem 50: Pow(x, n)

## Author: Neha Doiphode
## Date:   06-11-2022

## Description:
    Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

## Examples:
    Example 1:
        Input: x = 2.00000, n = 10
        Output: 1024.00000

    Example 2:
        Input: x = 2.10000, n = 3
        Output: 9.26100

    Example 3:
        Input: x = 2.00000, n = -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25

## Notes:
    2^6(even): x = 2, n = 6
          y2 = 2^6 = 2^3 * 2^3       = y1 * y1   -------> Final expression
          y1 = 2^3 = 2^1 * 2^1 * 2   = y0 * y0 * x
          y0 = 2^1 = 2^0 * 2^0 * 2^1

    2^7(odd): x = 2, n = 7
          y2 = 2^7 = 2^3 * 2^3 * 2   = y1 * y1 * x  ----> Final expression
          y1 = 2^3 = 2^1 * 2^1 * 2   = y0 * y0 * x
          y0 = 2^1 = 2^0 * 2^0 * 2^1

## Constraints:
    -100.0 < x < 100.0
    -231 <= n <= 231-1
    -104 <= xn <= 104

## Time complexity: O(log N) where N is the power to which a number is supposed to be raised
                    As we are taking squares, at each iteration, product will keep getting accumulated in the powers of 2.

## Space complexity: O(1), at the max the recursion stack can have 2 calls. So it will be constant space asympotoically.

'''


class Solution:
    def myPow(self, x, n) -> float:

        # if n is 0 then return 1.
        if n == 0:
            return 1.0

        # We are taking absolute because, we want to consider negative powers also later on.
        N = abs(n)
        # Start by storing the number into the result
        result = x
        # we would want to take squares of number to achieve the final power.
        index = 2

        # Start looping by taking squares
        while N > 1 and index <= N:
            # Take squares
            result *= result

            index *= 2

        # Now start over and multiply rest of the power
        if N - int(index / 2) > 0:
            result *= self.myPow(x, N - int(index / 2))

        if n < 0:
            result = 1/result

        return result

# Driver code
print("Enter x, n(floats) with spaces to calculate x raised to power n: ")
inp = input()
x, n = float(inp.split()[0]), int(inp.split()[1])
solution = Solution()
print(f"Output: {x} raised to power {n} = {solution.myPow(x, n)}")
