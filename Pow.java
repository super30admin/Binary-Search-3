// Time Complexity : O(log n)
// Space Complexity : O(h), h = log n , height of the recursive stack.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Keep squaring x and reducing n/2

//Bottom up recursive approach

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.0;

        double re = myPow(x,n/2);
        if(n % 2 == 0){
            return re * re;
        }
        else{
            if( n > 0){
                return x * re * re;
            }
            else{
                return re * re * 1/x;
            }
        }
    }
}


//Iterative approach
// Multiply result by x once if n is odd, this will make n even and then we can continuously keep squaring x and halving n. Then multiply final x with result because final n = 1.
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) {
            n *= -1;
            x = 1/x;
        }

        double result = 1;
        
        while(n!=0){
            if(n % 2 == 1){
                result *= x;
                n -= 1;
            }
            x *= x;
            n /= 2;           
        }
        return result;
        }
}