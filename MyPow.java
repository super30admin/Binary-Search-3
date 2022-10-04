/*
## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

Time Complexity :   O (log n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (50. Pow(x, n))
Any problem you faced while coding this :       No
 */
// Input: x = 2.00000, n = 10
// Output: 1024.00000

class MyPow {
    public double myPow(double x, int n) {
        if( n == 0)
            return 1.0;
        
        // logic
        double result = myPow(x, n/2);
        if( n % 2 == 0){    // even n
            return result*result;
        }
        else{              // odd n
            if(n > 0){     // positive n
                return result * result * x;
            }else{         // negative n
                return result * result * (1/x);
            }
        }
    }
}