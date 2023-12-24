// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {

    public double myPow(double x, int n) {

        return div(x,n);
    }

    private Double div( Double num, Integer pow ){
        // base case
        if(pow == 0){
            return 1.0;
        }
        
        Double val = div(num , pow/2);

        if(pow%2 == 1){ // positive odd
        return val * val * num;
        }
        else if (pow %2 == -1) // negative odd 
        {
            return val * val * (1/num);
        }
        // Otherwise for any even, multiply both
        return val * val;
    }

}