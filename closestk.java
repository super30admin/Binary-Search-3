
// Time Complexity : O(log (n-k)) + O(k) -> to output the window;
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int n = arr.length;
        int low = 0;
        int high = n - k; //  can pick k elements
        while (low < high) {
            int mid = low + (high - low) / 2;
            int start = x - arr[mid];
            int end = arr[mid + k] - x; // mid+k to set the window size to k
            if(start > end){
                low = mid + 1; 
            }else{
                high = mid; // bring end closer to x
            }
        }
        // aim is to set low index from where we can pick 4 elemens closest to x
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(arr[low+i]); 
        }

        return res;
    }
}