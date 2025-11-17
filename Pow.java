// 50. Pow(x, n)
// https://leetcode.com/problems/powx-n/

/**
 * Time Complexity: O(log n) since we divide n by 2 till it reaches 0
 * Space Complexity:  O(log n) since ther will be at max log n calls till n reaches 0
 */

/**
 * Approach: We keep reducing n i.e power to half till it reaches 0
 * Anything raise to 0 is 1. So, when our n reaches 0 we return 1
 * If n is odd, we multiply squares with x (or 1/x if n is -ve)
 * else if n is even we return squares 
 */

class Solution {
    public double myPow(double x, int n) {
        // base
        if(n == 0){
            return 1;
        }

        //logic

        double calc = myPow(x, n / 2);
        
        if(n % 2 == 0){
            calc = calc * calc;
        }else{
            if(n < 0){
                calc = calc * calc * (1/x);
            }else{
                calc = calc * calc * x;
            }
        }

        return calc;
    }
}