// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach
1) using binary search to achieve logN complexiety
2) here we assign right pointer to arr.length-k , such that we reduce the search space.
*/


import java.util.*;
class KClosestElementsUsingBinarySearch {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      
        // Using Binary search Technique
        
        List<Integer> result = new ArrayList<>();
        
        if(arr==null || arr.length==0)
        {
            return result;
        }
        
        int left = 0;
        int right = arr.length-k;
       
        while(left<right)
        {
            int mid = left+(right-left)/2;
            
            int distLeft = x-arr[mid];
            int distRight = arr[mid+k]-x;
            
            if(distLeft>distRight)
            {
                left = mid+1;
            }
            else
            {
                right = mid;
            }
            
            
        }
        
        
        
        
        
        for(int i=left;i<left+k;i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
}