// Time complexity - O(log n)
// Space Complexity - O(1)
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double temp = myPow(x, n/2);
        if(n%2 == 0) { // even
            return temp*temp;
        } else {
            if(n < 0) return (temp*temp)*1/x; // power negative
            else return (temp*temp)*x; // power positive and n = odd
        }
    }
}