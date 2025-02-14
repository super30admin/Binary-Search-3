// TC: O(logn)
// SC: O(logn)

public class LC50 {
    public double myPow(double x, int n) {
        // BC
        if(n==0) return 1;
        // Logic
        double b = myPow(x, n/2);
        double ans = b * b;
        if((n%2) == 0) return ans;
        else if(n<0) return ans * (1/x);
        return ans * x;
    }
}