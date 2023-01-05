// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode :yes

public class Solution {
    public double MyPow(double x, int n) {
        if(x == 0.00) return 0.00;
        if(n == 0) return 1;
        double res = MyPow(x, n/2);
        if(n%2 == 0){
            return res * res;
        }
        else{
            if(n < 0){
                return res * res * 1/x;
            }
            else{
                return res * res * x;
            }
        }
       return res; 
    }
}
