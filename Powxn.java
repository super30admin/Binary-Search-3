public class Powxn {
    public double myPow(double x, int n) {
        // base
        if(n==0) return 1.00;
        
        // logic
        double result = myPow(x,n/2);
        // even
        if(n%2==0) return result*result;
        // odd
        else{
            if(n>0) return result*result*x; // postive number
            else return result*result*(1/x); // negative number
        }
    }
}

// Time Complexity - O(logn)

