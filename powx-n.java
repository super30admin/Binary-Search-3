// Time Complexity :
Time Complexity would be o(log n to the base 2) as we are dividing the n
by 2 when it is even and when it's odd , it's reduced by 1
// Space Complexity :
Space complexity is  O(1)
// Did this code successfully run on Leetcode :
YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



//x can be anything, it can be an Integer or a double

class Solution {
    public double myPow(double x, int n) {
       //define a variable for final result
        double result = 1.0;
        //define a Long varible that will store my n and this is a duplicate copy of n
        long duplicate = n;
        //use above copy to handle negative n by converting to positive n
        if(duplicate < 0 ) duplicate = -1 * duplicate;
        
        //now until my power becomes zero I have to perform my operations to calculate result
        while(duplicate > 0 ){
            //if modified duplicate in each iteration is odd
            if(duplicate % 2 == 1){
               result = result * x;
               duplicate = duplicate-1;  
            }else{
                x = x*x;
                duplicate = duplicate/2 ;
            }
        
        }
        if(n < 0 ) {
            result = (double) (1.0)/(double) (result);
        }
        
        return result;
        
    }
}