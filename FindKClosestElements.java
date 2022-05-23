// Time Complexity :  O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int low = 0, high = n - k;
        
        if(arr == null || arr.length  == 0) return new ArrayList<>();
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            int leftDistance = x - arr[mid];
            int rightDistance = arr[mid + k] - x;
            
            if(leftDistance <= rightDistance) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}