// Time Complexity: O(log(n - k) + k) n is the length of arr and k is the size of the result.
// Space Complexity: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;  // We ensure to always have a window of size k

        // Binary search to find the correct starting point
        while (left < right) {
            int mid = (left + right) / 2;
            
            // Check if the left side is better or the right side
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;  // Move right
            } else {
                right = mid;  // Stay or move left
            }
        }

        // We have found the left boundary, return the subarray of size k
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
