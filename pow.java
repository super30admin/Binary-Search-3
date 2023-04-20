/*
 Time Complexity - O (log n) 
 Space Complexity - O(log n) where log n is the size of the stack space used for recursive call.
                                   n is the input value n.
 */
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)  return 1;
        double temp = myPow(x, n/2);
        
        if(n % 2 == 0)
            return temp*temp;
        else
            if(n > 0)
                return temp*temp*x;
            else
                return (temp*temp)/x; 
    }
}
