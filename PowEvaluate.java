public class PowEvaluate {
    //Time Complexity : O(log(n)) since we're halving the problem each time
    // Space Complexity :O(1) as no auxiliary space is used
    // Did this code successfully run on Leetcode :yes
    public double myPowIterative(double x, int n) {
        if(n < 0){
            n = n * -1;
            x = 1/x;
        }
        double result = 1.0;
        while(n != 0){
            if(n%2 != 0){
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }
        return result;
    }

    //recursive
    //Time Complexity : O(log(n)) since we're halving the problem each time
    // Space Complexity :O(log(n)) for the recursive stack
    // Did this code successfully run on Leetcode :yes
    public double myPow(double x, int n) {
        //base
        if(n == 0){
            return 1.0;
        }
        double temp = myPow(x, n/2);
        //logic
        if(n%2 == 0){
            return temp * temp;
        }
        else{
            if(n < 0){
                return temp * temp  * (1/x);
            }
            return temp * temp * x;
        }
    }
}
