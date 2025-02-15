public class Problem1 {
    class Solution {
        //t.c -> O(logn)
        //s.c - > O(logn) -> recurssive stack space

        public double myPow(double x, int n) {
            //base case when power become 0
            if(n==0){
                return 1.0;
            }
            double y = myPow(x,n/2);
            if(n%2 ==0){
                //if n is even
                return y * y;
            }
            else{//if n is off
                if(n>0){
                    //power is greater than 0
                    return y * y * x;
                }
                else{//power is smaller than 0
                    return y * y * 1/x;
                }
            }
        }
    }
}
