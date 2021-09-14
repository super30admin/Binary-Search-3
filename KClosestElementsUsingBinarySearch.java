// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach
1) using binary search to achieve logN complexiety
2) here we assign right pointer to arr.length-k , such that we reduce the search space.


Explanation: 
In the last solution to the K closest terms, when we carry out a binary search to determine the left range or starting point of the range, we write arr[mid + k]. In case you are  still wondering where did the arr[mid + k] come from and why not arr[mid + k - 1] consider arr = [1, 2, 3, 4, 5], k = 4 and x = 3. The first iteration yields low = 0, high = 1 and mid = 0.
If we take arr[mid + k - 1] we are looking at index 3 and index 4 in case we are considering arr[mid + k]. Taking the difference between arr[mid + k - 1] - x we will get 4 - 3 = 1 and 5 - 3 = 2 otherwise. Now the left part gives us 3 - arr[mid] { arr[0] } which gives 2. Now in case I was considering mid + k - 1, I will move my low which will be incorrect. In case two elements are equidistant then as per the problem the smaller one should be picked.

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