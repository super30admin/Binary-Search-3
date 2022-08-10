//Time Complexity: O(log(n))
//Space Complexity: O(log(n))
//Code run successfully on LeetCode.

public class Problem1 {

    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        
        double result = myPow(x, n/2);
        
        if(n%2 == 0)
            return result * result;
        
        else if(n > 0)
                return result*result*x;
            
         return result*result*(1/x);
    }
}
