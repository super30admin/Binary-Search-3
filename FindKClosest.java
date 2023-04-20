/*
    Time Complexity - O(log (N) + k) -> Log (N) to perform binary search on input array. k steps to copy the result.
    Space Complexity - O(1) excluding the data structure used to store the result. 
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;
        
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }       
        
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++)
            result.add(arr[i]);
        
        return result;
    }
}
