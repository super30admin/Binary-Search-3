// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we don't multiply the input number n times but only n/2 times
// which brings down the total computation to log n.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public double myPow(double x, int n) {
      
      if(n == 0)
        return 1;
      
      
      double ans = myPow(x , n/2);
      
      if(n%2 == 0)
      {
        return ans * ans;
      }
      
      else
      {
        if(n<0)
        {
          return ans * ans * (1/x);
        }
        else
        {
          return ans * ans * x;
        }
      }
        
    }
 
}