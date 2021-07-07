class Solution {
// Time Complexity : O(N)  N-K: to find low position, k: to add result from right low location
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. As the array is sorted, Idea is to get the correct start location of result using two pointer technique
 */
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null || arr.length == 0) return result;
        
        int lo = 0;
        int hi = arr.length-1;
        
        while( hi-lo >= k){
            int left = Math.abs(x-arr[lo]);
            int right = Math.abs(x-arr[hi]);
            if(left <= right){
                hi = hi-1;
            }
            else{
                lo = lo+1;
            }
        }
        
        for(int i =lo; i<(lo+k); i++){
            result.add(arr[i]);
        }
        return result;
    }
}