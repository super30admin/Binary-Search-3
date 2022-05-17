class Solution {

    //Time Complexity: 0(logn) where n is the power
    //Space Complexity: o(a) where a is the space occupied by recursive stack
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In Short explain your approach:

    public double myPow(double x, int n) {
        //base case
        if(n == 0){ //we know that anything to the power 0 is 1. Hence putting it as base case.
            return 1.0;
        }
        //logic
        double result = myPow(x, n/2);  //calling my function recursively till we have broken down n to be 0 whose value is known
        if(n % 2 == 0){     //checking if the power is even or odd
            return result * result;     //if its even, then we just need to multiply x raise to the power n twice
        }
        else{
            if(n > 0){  //if the power is odd, we can have 2 cases, if the power is positive or negative
                return result * result * x; //if it is positive, we will just multiply x raise to the power n twice and then multiply it by x
            }
            return result = result * result * 1/x;  //if it is negative, then we just do 1/x;
        }
    }
}