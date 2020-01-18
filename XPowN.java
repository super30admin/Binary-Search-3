// Time Complexity: O(logN)  
// Space Complexity: O(logN)
// Accepted on Leetcode: Yes

class Solution {
    public double myPow(double x, int n) {
        //base case
        if(n==0){ 
            return 1.0;
        }
		//logic
        double temp = myPow(x, n/2);
        if(n%2==0){
            return temp*temp;
        }
        else{
            if(n<0){
                return temp*temp*(1/x);
            }
            return temp*temp*x;
        }
    }
}