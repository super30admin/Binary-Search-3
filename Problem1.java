// Time Complexity - O(logn)
// Space Complexity - O(1)
// This solution worked on LeetCode


class Solution {
    public double myPow(double x, int n) {
        // Base Case
        if(n ==0)   return 1.0;         // When x^0 = 1.0
        // Logic
        double temp = myPow(x, n/2);    // Recursively calculate for n/2 
        if(n %2 == 0){
            return temp * temp;    // if n is even then mutiply result from n/2 * result from n/2
        }
        else{                           // if n is even then mutiply result from n/2 * result from n/2 * x
            if(n < 0)   
                return temp * temp * 1/x;   // if n is less than 0 then reciprocal of x should be multiplied
            else 
                return temp * temp * x;        // otherwise x should be multiplied with temp in case of odd n
        }
    }    
}
