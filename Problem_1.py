'''
50 Pow(x, n)
https://leetcode.com/problems/powx-n/description/

Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).


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

Constraints:
-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

Solution:
1. Brute Force: Use recursion decreasing the exponent by 1 in each recursive call.
Time: O(N), Space: O(N)

2. Binary exponentiation:
Compute x^n as
a) x^n = x^(n/2) * x^(n/2) (if n = even)
b) x^n = x^(n/2) * x^(n/2) * x (if n = odd)

if n < 0, replace x by 1/x.

In a) or b), we compute x^(n/2) only once and save the result. We use the saved result to multiply by itself to get x^n. Thus, we halve n each time until we get to n=0. Thus, the recursion takes place only for n/2, n/4, ..., until n = 0.
There are O(log n) such steps.

https://youtu.be/v9qSBrFRFho?t=3859

Time: O(log N), Space: O(log N)
'''
def pow(x, n):
    is_neg = False
    if n < 0:
        n = -n
        is_neg = True

    if n == 0:
        return 1
    elif n == 1:
        return x if not is_neg else 1/x

    result = pow(x, n//2)

    if n % 2 == 0: # even
        result = result*result
    else: # odd
        result = result*result*x

    return result if not is_neg else 1/result

def run_pow():
    tests = [(2,0,1), (2,1,2), (2,5,32), (2,6,64),
             (3,0,1), (3,-1,1/3), (3,-5,1/(3**5)), (3,-6,(1/(3**6))),]
    for test in tests:
        x, n, ans = test[0], test[1], test[2]
        result = pow(x, n)
        print(f"\nx = {x}, n = {n}")
        print(f"x ^ n = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            return

run_pow()