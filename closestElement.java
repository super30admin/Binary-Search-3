// time complexity: O(log(n - k) + k)
// space complexity: O(k)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0) return result;

        int low = 0, high = arr.length - k;

        // Binary search to find the best starting point
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Calculate distances from x to arr[mid] and arr[mid + k]
            int distL = x - arr[mid];  // Distance from x to the left boundary
            int distR = arr[mid + k] - x;  // Distance from x to the right boundary

            // Move the window based on the comparison of distances
            // We compare the actual values instead of abs since the array is sorted
            if (distL > distR) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Collect the k closest elements
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 1, 2, 2, 2, 2, 2, 3, 3};
        int k = 4;
        int x = 2;
        List<Integer> res = sol.findClosestElements(arr, k, x);
        System.out.println(res);  // Expected output: [2, 2, 2, 2]
    }
}
