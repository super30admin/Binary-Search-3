//Time Complexity:O(logn)
//Space Complexity:O(logn)
//amazon
//Breaking n large problem into small problems based on logarithmic for example person standing in queue then count how many or every persons ask about their position.establish a base case and compute based on the knowledge of recursion.


class Solution {
    public double myPow(double x, int n) {
        if(n == 0)return 1.0;
        
        double result = myPow(x,n/2);
        if(n%2 == 0){
            return result *result;
        }
        else{
            if(n>0){
                return result*result*x;
            }
            else{
                return result*result*1/x;
            }
        }
    }
}