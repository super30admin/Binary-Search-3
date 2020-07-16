// Time Complexity : O(logn)
// Space Complexity : O(logn) // REcursive stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1.recurse by dividing in half each time and if power is negative convert the number accordingly
//2. if the power is even just multiply the recursion result from previous stage
//3. if the power is odd multiply the recursion result from previous stage with "x"
class Solution {
public:
    double myPow(double x, int n) {
        //edge case
        if(n==0) return 1;
        
        //recurse by dividing in half each time
        double temp = myPow(x, n/2);
        //if power is negative convert the number accordingly
        if(n<0) x= (1/x);
        //if the power is even just multiply the recursion result from previous stage
        if(n%2==0) return (temp*temp);
        //if the power is odd multiply the recursion result from previous stage with "x"
        else return(temp*temp*x);
    }
};
