// Time: O(logN + k) where N = length of array
// Space: O(1)
// Approach: Binary search with sliding window

import java.util.*;

class Find_K_Closest_elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList();
        if (arr.length == k) {
            for (int i = 0; i<k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        // binary search to find closest elements
        int left = 0, right = arr.length-1, mid = 0;
        while (left < right) {
            mid = (left + right)/2;
            if (arr[mid] >= x) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        // initiailize sliding window bounds
        left -= 1;
        right = left + 1;

        // while window size < k
        while (right - left - 1 < k) {
            // to not go out of bounds
            if (left == -1) {
                right++;
                continue;
            }

            // expand window towards the side with the closer number without going out of bounds
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            }
            else right++;
        }

        // Build and return the window
        for (int i = left+1; i <= right-1; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
