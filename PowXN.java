package binarySearch3;

public class PowXN {
	//Time Complexity : O(log n)
	//Space Complexity : O(n) for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public double myPow(double x, int n) {
        // base
        if(n == 0)
            return 1.0;
        
        double result = myPow(x, n / 2);
        if(n % 2 == 0)
            result *= result;
        else {
            if(n < 0)
                result *= result * (1/x);
            else
                result *= result * x;
        }
        
        return result;
    }
	
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes - TLE
	//Any problem you faced while coding this : No
	public double myPow1(double x, int n) {
        double result = 1.0;
        boolean negative = false;
        
        if(n < 0) {
            negative = true;
            n = -n;
        }
        
        for(int i=0; i<n; i++)
            result *= x;
        
        if(negative)
            result = 1/result;
        
        return result;
    }
}
