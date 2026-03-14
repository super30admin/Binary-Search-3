/*
Brute force way is to multiply the base n times.
Optimized Approach: recursively reduce value of N by half
when we reach the base case we start returning result back to parent
if n is odd:
    return re * re * num
else return re * re --> means n is even

 */

/*
Time: O(logn)
Space: O(logn)
 */


class Solution {
    public double myPow(double x, int n) {

        if(n == 0) return 1;

        double re = myPow(x, n/2);

        if(n % 2 == 0){
            return re * re; // when n == even
        }else{
            if(n > 0){ // when pow is positive
                return re * re * x;
            }else{ // when pow is negative
                return re * re * 1/x;
            }
        }
        
    }
}