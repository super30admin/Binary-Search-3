// Time Complexity : O(Log n) we divide the number by 2 and calculate the power of n/2
// Space Complexity : O(Log n) we need to store results for n/2 computations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Three line explanation of solution in plain english: Bruteforce way of calculating the power by multiplying the number x
// with itself n times was giving TLE. So the other way was to calculate the result for power of n/2 and multiplying it twice for even powers and
// for odd multiplying the result for power of n/2 twice and with itself(if positive) if negative multiply with 1/itself.

// Your code here along with comments explaining your approach
class PowOfXAndN {

    public double myPow(double x, int n) {
        // TC: O(log n)

        //base
        if(n == 0){
            return 1;
        }

        //logic
        double halfresult = myPow(x,n/2);
        if(n % 2 == 0){
            return halfresult * halfresult; // for even powers
        }else{
            if( n < 0){
                return halfresult * halfresult * 1/x; // for odd and negative powers
            }else{
                return halfresult * halfresult * x; // for odd and positive powers
            }
        }

    }


}