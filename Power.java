//Time Complexity: O(log n) where n is the exponent value, we are reducing the n value by half in each recursive call
//Space Complexity: O(n/2) - stack space
//Did this code run successfully on leetcode: yes
class Power {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        double result = myPow(x,n/2);
        if(n < 0)
            x = 1/x;
        if(n % 2 != 0) {
            result = result*result*x;
        } else {
            result = result*result;
        }
        return result;
    }
    
}
