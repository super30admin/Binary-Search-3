/**
 * Time Complexity:
 * The time complexity of the solution is O(log(n)) as we have reduced the computations
 * by half.
 */

/**
 * Space Complexity:
 * The space complexity is O(log(n)) as we are not creating any extra space 
 * for calculations. It is the space used by the stack for the recursive 
 * calculations.
 */

/**
 * Approach:
 * We are using recursion to reduce the time complexity. The approach can be explained
 * using an example:
 * We have 2^6 =  2^3 *2^3;
 *         2^3 =  2^1*2^1*x  where x = 1/2
 * and if 2^-3 = 2^1*2^1*1/x
 * 
 * So here we cans ee we can recursively find the power of a particular number by 
 * taking the power of number where power value is half of the former power value.
 */


// The code ran perfectly on leetcode.

class Solution {
public:
    double myPow(double x, int n) {
        //base
        if(n==0) return 1.000;
        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0){
            return result*result;
        } else {
            if( n > 0){
                return result*result*x;
            } else {
                return result*result*1/x;
            }
        }
        
    }
};