// Time Complexity : O(logn)
// Space Complexity : O(logn)

// Your code here along with comments explaining your approach: 

class Solution {
  public double myPow(double x, int n) {
    // base
    if (n == 0)
      return 1;

    // logic
    double ans = myPow(x, n / 2);

    if (n % 2 == 0) {
      return ans * ans;
    } else {
      if (n < 0)
        return ans * ans * 1 / x;
      return ans * ans * x;
    }

  }
}