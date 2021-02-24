package Binary-Search-3;
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Pow {
    class Solution {
        public double myPow(double x, int n) {
            
            if(n<0)
            {
                x = 1/x;
                n = -n;
            }
            
            double ans = 1;
            double curr_product = x;
            for(int i=n;i>0;i/=2)
            {
                if(i%2 == 1)
                {
                    ans = ans * curr_product;
                }
                curr_product = curr_product*curr_product;
                System.out.println("Ans:"+ans+" "+"Curr Product:"+curr_product);
            }
            return ans;
        }
    }
    
}
