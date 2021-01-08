/*
Time COmplexity : O(log n)
Space COmplexity : O(n)
Idea divide and conquer like Binary Search.
*/
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double temp = myPow(x,n/2);
        if(n%2 == 0){
            return temp*temp;
        }else{
            if(n<0){
                return temp*temp*1/x;
            }
            return temp*temp*x;
        }
    }
}