
/*
 * Bruteforce approach: Linear time. Multipy x by n times
 */

/*
- Every component n can be broken down into binary. So instead of multiplying x by n times, we only compute the powers of two by squaring and pick the one that we need
TC: O(logn) -> at each step the processing time is reduced by half
SC: O(1) -> no additional space required
*/ 

class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        // handle negative power
        if(n < 0)
            x = 1.0 / x;

        while(n != 0){
            // check at each n if the bit is set, that is if n is odd, then multiply result by x. Which basically means multiply this power of 2 in the product
            if( n % 2 != 0)
                result *= x;
            // divide n into half
            n /= 2;

            //multiply x with x to move x to the next power of 2
            x *= x;
        }
        return result;
    }
}

/*
* Recursive approach: 
TC: O(logn) -> processing half of n times
SC: O(logn) -> recursive stack space
*/
class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0)
            return 1.0;
        double res = myPow(x, n/2);
        //logic
        if(n % 2 == 0){
            return res * res;
        }
        else{
            // if n is negative case
            if(n < 0){
                return 1/x * res * res;
            }
            else 
                return x * res * res;
        }
        
    }
}