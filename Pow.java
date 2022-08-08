// Time Complexity : O(log(n))
// Space Complexity :O(log(n))
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public double myPow(double x, int n) {
    //base case
    if(n == 0) return 1.0; // for case when myPow(2,0) to calculate 2^0
    
    double result = myPow(x,n/2); // using recursion
    
    //if it is odd then just return its square
    if(n%2 == 0){
        return result*result;
    }else { // otherwise return its square * number
        if(n >0){ // checking for positive square
            return result * result * x;
        }else{ // for negative squares
            return result * result * 1/x;
            
        }
    }
}