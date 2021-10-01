// Time Complexity :O(log(n-k) )
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

//1. using binary search find mid now check where should we keep low pointer so that exact 
window start

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0; // pointer 1
        int high = arr.length - k; // pointer 2
        
        while(low < high)
        {
            int mid = low + (high-low)/2;
            int dp1= x - arr[mid];  
            int dp2= arr[mid+k] - x; 
         
            if(dp1 > dp2)
                low = mid + 1;
            else 
                high = mid;
            
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low+k ;i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
}