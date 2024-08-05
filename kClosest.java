//Time Complexity: O(logN+k), where N is the length of the array and k is the number of closest elements to return.
//SC - o(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Handle edge case where array length is smaller than k
        if (arr.length <= k) {
            List<Integer> result = new ArrayList<>();
            for (int num : arr) {
                result.add(num);
            }
            return result;
        }

        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;
        
        // Binary search against the criteria described
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Create output in correct format
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
