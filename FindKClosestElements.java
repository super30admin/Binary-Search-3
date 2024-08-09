/**
 * Time Complexity (TC): O(log n + k)
 * - The binary search to find the closest element to x takes O(log n) time.
 * - The while loop that finds the k closest elements runs in O(k) time.
 * - Therefore, the overall time complexity is O(log n + k).
 *
 * Space Complexity (SC): O(k)
 * - The space complexity is O(k) because we store the k closest elements in the result list.
 * - Other than the result list, only a constant amount of extra space is used.
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;

        // Binary search to find the closest element to x
        while(low < high) {
            int mid = low + (high - low)/2;
            if(arr[mid] >= x) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        int index = low;
        low = index - 1;
        high = index;

        // Find the k closest elements
        while (k > 0) {
            if (low < 0) {
                high++;
            } else if (high >= arr.length) {
                low--;
            } else if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
                low--;
            } else {
                high++;
            }
            k--;
        }

        // Add the k closest elements to the result list
        for(int i = low + 1; i < high; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
