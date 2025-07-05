class Solution:
    # Approach: Divide-and-Conquer
    # Explanation:
    # We recursively reduce the power n by half:
    # - If n is even, x^n = (x^(n/2))^2
    # - If n is odd, x^n = (x^(n//2))^2 * x
    # This reduces repeated multiplications by using results from subproblems.
    #
    # Time Complexity: O(log n)
    # Space Complexity: O(log n) due to recursion stack
    def myPow_recursion(self, x, n):
        if n == 0:
            return 1
        if n == 1:
            return x
        isPos = True
        if n < 0:
            isPos = False
            n = abs(n)
        def helper(x, n):
            if n == 0:
                return 1
            res = helper(x, n // 2)
            return res * res if n % 2 == 0 else res * res * x
        res = helper(x,n) if isPos else 1 / helper(x,n)
        return res
    
    # Approach: Binary-Exponentiation
    # Explanation:
    # We iteratively compute x^n by checking the binary representation of n.
    # - If the current bit is 1, multiply the result by current x
    # - Square x in each iteration, and shift n to right (n = n // 2)
    # This ensures only O(log n) operations.
    #
    # Time Complexity: O(log n)
    # Space Complexity: O(1)
    def myPow_iterative(self, x, n):
        if n == 0:
            return 1
        if n == 1:
            return x
        isPos = True
        if n < 0:
            isPos = False
            n = abs(n)
        res = 1
        while n != 0:
            if n % 2 == 1:
                res = res * x
            x = x * x
            n = n // 2
        return res if isPos else 1 / res

def main():
    sol = Solution()
    x_values = range(-4, 5)
    n_values = [-3, -1, 0, 1, 2, 3]

    print("Testing myPow_recursion and myPow_iterative for x in -4 to 4 and n in -3 to 3:")
    for x in x_values:
        for n in n_values:
            try:
                rec = sol.myPow_recursion(x, n)
                itr = sol.myPow_iterative(x, n)
                print(f"x = {x}, n = {n}, recursion = {rec}, iterative = {itr}")
            except ZeroDivisionError:
                print(f"x = {x}, n = {n}, recursion = undefined (division by zero), iterative = undefined (division by zero)")


if __name__ == "__main__":
    main()