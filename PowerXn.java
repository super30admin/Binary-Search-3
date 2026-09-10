// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//TimeComplexity - O(log(n)) as we are recursively reducing the number of operations
//SpaceComplexity - O(1) since we are not using any extra space
class Solution {
    public double myPow(double x, int n) {
        
        //base
        if(n == 0) return 1.0;
        
        //logic
        double temp = myPow(x, n/2);
        if(n%2 == 0){
            return temp * temp;
        }
        else{
            if(n > 0){
                return temp * temp * x;
            }
            else{
                return temp * temp * 1/x;
            }
        }
    }
}