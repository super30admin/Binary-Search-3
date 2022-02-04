/**
 * Tc  - O(log n)
 * sc - and O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        //base
        if(n==0){
            return 1; //if n which is the power is 0, we return 1.
        }
        //logic
        double result = myPow(x,n/2); //we compute the result with getting the power method
        if(n%2 == 0){
            return result * result; // If n is even we return result square
        }
        else if(n>0){ // if n is odd 
            return result * result * x; // if n is positive we return result square * x
        }
    else{
        return result * result * 1 / x; // if n is negative we retun result squrae *1/x
    }
        
    }
}
