// Time Complexity: O(log n)
// Space Complexit: O(log n)
public class Pow {
    public double myPow(double x, int n) {
        // base
        if(n == 0)
            return 1;
    
        // recursion
        double result = myPow(x, n/2);
        
        if(n%2 == 0) // even
        {
            return result * result;
        }
        else if(n > 0) // odd
        {
             return result * result * x;
        }
        
        return result * result * 1/ x;  // -ve n
    }
}
