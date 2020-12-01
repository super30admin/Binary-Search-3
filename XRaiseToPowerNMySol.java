package Nov30;

class XRaiseToPowerNMySol {
    
    boolean isNegative;
    
    public double myPow(double x, int n) {
        
        /*
        Time Complexity: O(log n) because we are dividing the input set into half at every recursive call.
        Space Complexity: O(1) because no extra space used.
        Approach: Recursion used.
        */
        
        if (n < 0) {
            isNegative = true;
        }
        
       double res = helper(x, n);
        
       if (isNegative == true) {
           return 1/res;
       } 
        
       return res;
        
    }
    
    public double helper(double x, int n) {
        
         // base
        if (n == 0) {
            return 1;
        }
    
        // logic
        double temp = helper(x, n/2);
        // check if n is even 
        // if yes: it doesn't matter if n is positive or negative
        if (n % 2 == 0) {
            return temp*temp;
        }
        // check if n is odd
        // if yes: check if n is positive or negative
        //          if n is +ve: multiply by n.
        //          if n is -ve: multiply by 1/n.
        else {
            
                return temp*temp*x;
        
        }
    }
}