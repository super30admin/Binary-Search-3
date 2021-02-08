//TC: O(logN)
//SC: O(1)
class Solution {
    public double myPow(double x, int n) {
       //base
        if ( n == 0) 
            return 1;
       //logic
        double temp = myPow(x, n/2);
        //stack.pop() happens
        if ( n % 2 == 0)      //n is even 
        {
            return temp * temp;
        }
        else //n is odd 
        {
            if ( n < 0 ) // if n is negative,  multiply it by 1/x
            {
                return temp * temp * (1/x);
            }
            else // if n is positive, just multiply it by x
            {
                return temp * temp * x;
            }
        }
    }
}

// TC: O(N)
//SC: O(1)
// class Solution {
//     public double myPow(double x, int n) {
//         long N = n;
//         if ( n < 0)
//         {
//             x = 1/x;
//             N = -N;
//         }
//         double ans = 1;
//         for ( int i = 1; i <= N; i++)
//         {          
//               ans = ans * x;         
//         }
//         return ans;
//     }
// }
