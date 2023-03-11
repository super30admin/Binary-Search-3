/*
Power of a number
approach: divide the power into lower order and use recursion to calculate sub-problems
time: O(log power)
stack space: O(log power)
 */
public class Problem1 {
    public double myPow(double x, int n) {
        return dfs(x, n);
    }

    private double dfs(double x, int n) {
        if(n==0) return 1.00;

        double y = dfs(x, n/2);
        if(n%2==0) {
            return y*y;
        }
        else {
            if(n<0) return y*y*(1/x);
            else return y*y*x;
        }
    }
}
