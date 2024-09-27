class Solution {
    public double myPow(double x, int n) {
       //base case
        if(n == 0) return 1;
        double half = myPow(x,n/2);  // x^n = x^n/2 * x^n/2
        if(n%2 == 0 ){
            return half*half;
        }
        else{//old
            if(n < 0){
                return half*half*1/x;// power positive and odd
            }
            else{
                return half*half*x; //power negative
            }
        }
    }
}

/*
Time complexity: O(logN)
Space Complexity:O(1)
*/