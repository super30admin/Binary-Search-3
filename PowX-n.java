
class Solution {
    public double myPow(double x, int n) {
        //base case
        if(n == 0){
            return 1;
        }
        //recursive call
        double temp = myPow(x, n /2);
        if(n%2 == 0){//handling even number
            return temp * temp;
        }else{//handling odd number
            if(n < 0){
                return temp * temp * (1/x);
            }else{
                return temp * temp * x;
            }
        }
    }
}

// Time Complexity: O(log n)
// Space Complexity : O(1)