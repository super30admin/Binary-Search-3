//brute force

/*
Time Complexity (TC): O(∣n∣) – The loop runs |n| times, where |n| is the absolute value of the exponent n.

Space Complexity (SC): O(1) – Only a few variables (result and exp) are used, and no additional space is required that grows with the input size.

Code Explanation in Three Lines:
The code converts the negative exponent n to positive by storing its absolute value in exp.
A loop multiplies x by itself exp times, resulting in x^exp.
If n was negative, the code returns the reciprocal of the result (1/result), otherwise returns the result directly.
 */

 public double myPow(double x, int n) {
    double result = 1.0;
    int exp = n; // Store original exponent

    // Convert negative exponent to positive
    if (n < 0) {
        exp = -n;
    }

    // Multiply x, exp times
    for (int i = 0; i < exp; i++) {
        result *= x;
    }

    // If original n was negative, take the reciprocal
    if (n < 0) {
        return 1 / result;
    }
    return result;
}

//Recursive solution
/*
Time Complexity (TC):
O(logn) – The recursion depth is proportional to logn, as the exponent is halved in each recursive call.

Space Complexity (SC): O(logn) – Due to the recursive call stack, the space complexity is proportional to the depth of recursion, which is logn.

Code Explanation in Three Lines:
The function recursively computes x ^ n/2 by dividing the exponent n in half at each step.
When n is even, it squares the result (re * re).
When n is odd, it multiplies the squared result by x (re * re * x), or by 1/x if n is negative.
 */

 public double myPow(double x, int n) {
    //base
    if (n == 0) return 1;
    //logic 
    double re = myPow(x, n / 2);
    if (n % 2 != 0) {
        if (n > 0) {
            return re * re *x;
        } else {
            return re * re * 1/x;
        }
    }    
    {
        return re * re;
    }
    }

//Iterative soln
/*
Time Complexity (TC):
O(logn) – The exponent n is halved in each iteration (n = n / 2), and the number of iterations is proportional to the logarithm of n in base 2.
Space Complexity (SC):
O(1) – The space complexity is constant because we only use a few extra variables (re, x, n), and there is no recursion or additional data structures used.

Explanation in Three Lines:
The function handles negative exponents by inverting the base x and making the exponent positive.
It uses an iterative approach with exponentiation by squaring to compute the power, reducing the problem size by half in each step.
The result is calculated efficiently by multiplying the result when the exponent is odd and squaring the base in each iteration.
 */

 public double myPow(double x, int n) {
    // Initialize result as 1 (this will store the final answer)
    double re = 1;
    
    // If the exponent is negative, invert the base (x = 1/x) and make the exponent positive
    if (n < 0) {
        x = 1 / x;  // Take reciprocal of x
        n *= -1;    // Convert exponent to positive
    }
    
    // While n is not zero, keep reducing the exponent by half
    while (n != 0) {
        // If the exponent is odd, multiply result by current base x
        if (n % 2 != 0) {
            re = re * x;
        }
        
        // Square the base (x = x * x) to handle the next power of 2 in the exponent
        x = x * x;
        
        // Divide the exponent by 2 (this reduces the problem size in each iteration)
        n = n / 2;
    }
    
    // Return the final result after all iterations
    return re;
}