//Time Complexity: o(k) + O(logn) 
//Space Complexity: O(k) 

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
​        // base case array
        if(arr == null || arr.length == 0) {
            return result;
        }
        
        // binary search
        int low = 0;
        int high = arr.length - k;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            if(Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        for(int i = 0; i < k; i++) {
            result.add(arr[low + i]);
        }
        
        return result;
    }
}