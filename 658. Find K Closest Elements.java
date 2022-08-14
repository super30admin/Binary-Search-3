// Time Complexity: O(log (n - k)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        
        
        int n = arr.length;
        int low = 0;
        int high = n - k;
        int mid = 0;
        
        while(low < high){
            mid = low + (high - low) / 2;
            int disStart = x - arr[mid];
            int disEnd = arr[mid + k] - x;
            if(disStart > disEnd){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}   