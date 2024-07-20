/*
    LC - 658. Find K Closest Elements
    TC - O(log n-k) + O(k)
    SC - O(1)
    Approach -
        Using binary Search calculate the distance of start & end and move pointer to get the start.
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int low = 0; 
        int high = arr.length - k;
        while(low < high) {
            int mid = low + (high - low) / 2; // prevent integer overflow
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        } 
        for(int i=low; i < low+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}