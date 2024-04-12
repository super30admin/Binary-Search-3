// TC: O(logn)
//SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double re = myPow(x,n/2);
        if(n%2 != 0){
            if(n < 0){
                return re*re*1/x;
            }else{
                return re*re*x;
            }
            
        }else{
            return re*re;
        } 
    }
}