// 1: Iterative Approach
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

// Approach: 
// 1. If n is 0, return 1.
// 2. If n is negative, convert it to positive and store it in a long long variable power.
// 3. Initialize result as 1.
// 4. Iterate until power is greater than 0.
// 5. If power is odd, multiply result with x.
// 6. Multiply x with x and divide power by 2.
// 7. If n is negative, return 1 / result. Else, return result.

class Solution {
    public:
        double myPow(double x, int n) {
            if(n == 0){
                return 1;
            }
            long long power = abs((long long) n);
            double result = 1;
    
            while(power > 0){
                if(power % 2 == 1){
                    result *= x;
                }
                x *= x;
                power /= 2;
            }
            if(n < 0){
                return 1 / result;
            }
            return result;
        }
    };

// 2: Recursive Approach
// Time Complexity: O(log n)
// Space Complexity: O(log n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. If n is 0, return 1.
// 2. If n is negative, convert it to positive and store it in a long variable.
// 3. Calculate half of the power by recursively calling the function with n/2.
// 4. If n is even, return half * half.
// 5. If n is odd, return x * half * half.

class Solution {
    public:
        double myPow(double x, long n) {
            if(n == 0){
                return 1;
            }
            if(n < 0){
                x = 1/x;
                n = -n;
            }
            double half = myPow(x, n/2);
            if(n % 2 == 0){
                return half * half;
            }
            return x * half * half;
        }
    };