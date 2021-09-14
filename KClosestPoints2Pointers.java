
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach
1) we want to find the K closest elements from x, it might happen x would exist or not. Thus we use 2 pointer technique on this.
2) we assign 2 pointers left and right at start and end of array. 
3) We calculate distance Left and distance right. 
-> if distanceLeft is more we know its far away and we want to reduce the distance, (array is sorted), thus as we move to the right the elements would increase and distance would decrease.
-> same for distance right, if distance right is more than distance left, we reduce distance right by moving to left <-
4) finally while loop will run from (right-left+k)
5) we just print out the final elements from left to right
*/



import java.util.*;
class KClosestPoints2Pointers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      
        // using the 2 pointer technique
        
        List<Integer> result = new ArrayList<>();
        
        if(arr==null || arr.length==0)
        {
            return result;
        }
        
        int left = 0;
        int right = arr.length-1;
        
        
        // only execute till we have the difference n-k times
        while(right-left+1>k)
        {
            int distLeft = x-arr[left];
            int distRight = arr[right]-x;
            
            if(distLeft>distRight)
            {
                left++;
            }
            else
            {
                right--;
            }
            
        }
        
        for(int i=left;i<=right;i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
}