package s30.Binary-Search-3;

public class problem1 {
    class Solution {
        public double myPow(double x, int n) {
            //TC:-O(logn)
            //SC:- O(logn)
            
            //base
            if(n == 0) return 1.0;
            
            //logic
            double ans = myPow(x, n/2);
            
            if(n % 2 == 0){
                return ans * ans;
            }else{
                if(n > 0){
                    return ans * ans * x;
                }else{
                    return ans * ans * 1/x;
                }
            }
        }
    }
}
