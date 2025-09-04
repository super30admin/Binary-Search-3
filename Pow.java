/* 
Time Complexity: O(log n)
Space Complexity: O(log n)
Did this code successfully run on Leetcode: Yes
*/
// Approach:
// - Use fast exponentiation (divide-and-conquer).
// - Base case: any number to the power of 0 is 1.
// - Recursively compute x^(n/2):
//     * If n is even: result = half * half
//     * If n is odd: result = half * half * x (or * 1/x if n < 0)

public class Pow {
    public double myPow(double x, int n){
        if(n == 0) return 1;

        double result = myPow(x, n/2);
        if(n % 2 == 0){
            return result * result;
        }else{
            if(n < 0){
                return result * result * 1/x;
            }else{
                return result * result * x;
            }
        }
    }
}
