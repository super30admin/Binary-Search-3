// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Recursively calling pow function by dividing the n by half

public class Powxn {
    public double myPow(double x, int n) {
        //base case
        if(n == 0){
            return 1;
        }

        //logic
        double temp = myPow( x, n/2);
        if(n%2 ==0){
            return temp*temp;
        }else{
            if(n<0){
                return temp*temp*1/x;
            }else{
                return temp*temp*x;
            }
        }

    }
}
