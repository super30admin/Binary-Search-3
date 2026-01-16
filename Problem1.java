//TC = O(logn)
//SC = O(logn)

/*
The function uses divide and conquer, computing xⁿ by recursively calculating xⁿ⁄².
Each step reduces the exponent by half, leading to logarithmic recursive calls.
The recursion stack grows to log n depth, which determines the space complexity.
*/


public class Problem1 {
    public double myPow(double x, int n) {
        //base 
        if(n == 0) {
            return 1.0;
        }

        double re = myPow(x, n/2);
        if(n % 2 == 0) {
            return re * re;
        } else {
            if(n < 0) {
                return re * re * 1/x;
            } else {
                return re * re * x;
            }
        }
    }
}