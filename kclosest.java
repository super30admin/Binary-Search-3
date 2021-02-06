/**
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        
        List<Integer> output = new ArrayList<>();
        
        if( arr == null || arr.length == 0)
            return output;
            
        int low =0;
        int high = arr.length -1;
        
        while ( high - low >= k)
        {
            
            int left = Math.abs( x - arr[low]);
            int right = Math.abs( x - arr[high]);
            
            if( left > right)
            {
                low++;
            }
            else
            {
                high--;
            }
        
        }
        
        for( int i =low; i <= high; i++)
        {
            output.add(arr[i]);
        }
        
        return output;
    }
}