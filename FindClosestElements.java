// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0) return result;
        
        int low = binarySearch(arr, k, x, 0, arr.length - k);
        
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    
    private int binarySearch(int[] arr, int k, int x, int low, int high) {
        while(low <= high) {
            
            int first = low + (high - low)/2;
            int last = first + k - 1;
            
            if(first - 1 >= 0 && x - arr[first - 1] <= arr[last] - x) {
                high = first - 1;
            }
            else if(last + 1 < arr.length && x - arr[first] > arr[last + 1] - x) {
                low = first + 1;
            }
            else {
                return first;
            }
            
        }
        return low;
    }
}
