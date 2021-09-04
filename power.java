//Time Complexity: O(log(n))
//Space Complexity:O(log(n))
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double ans=1;
        ans=myPow(x,n/2);
        if(n%2!=0){
            if(n<0){
                return ans*ans*(1/x);
            }
            else{
                return ans*ans*x;
            }
        }
        else{
            return ans*ans;
        }
    }
}