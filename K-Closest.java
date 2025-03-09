// In this problem, using two pointers, one at the start and one at the end, calc absolute diff of both with x, whichever is greater
// moving that pointer. Doing this till there are k elements between left and right

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Base Case
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        // Initialize left and right
        int left = 0;
        int right = arr.length - 1;
        // Declare result list
        List<Integer> result = new ArrayList<>();
        // Loop till there are k elements between left and right
        while (right - left + 1 > k) {
            // Calc abs diff of element at left and right pointers
            int startDiff = x - arr[left];
            int endDiff = arr[right] - x;
            // Compare is leftdiff is greater
            if (startDiff > endDiff) {
                // Move left pointer
                left++;
            } else {
                // Else right pointer
                right--;
            }
        }
        // Then add the elements to result list
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        // Return result
        return result;
    }
}

// Binary search solution - In this approach, we are trying to find the start
// point of our resultant elements, and once found running a loop k times to add
// values in result. Keeping low as zero and high as n-k, since we want atleast
// k elements in our result. Then computing mid and calc start element distance
// which is at mid and end element distance, which is at mid+k, then we move to
// the side which is having lesser distance.

// Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Base Case
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        // Initialize low and high
        int low = 0;
        int n = arr.length;
        int high = n - k;
        // While low is less than high
        while (low < high) {
            // Calc mid
            int mid = low + (high - low) / 2;
            // Calc start and end distance
            int startD = x - arr[mid];
            int endD = arr[mid + k] - x;
            // Compare which is smaller, move to that side
            if (startD > endD) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // Now low is at correct position, that start point, so run a loop from low to
        // low+k and add elements to result list
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        // Return result
        return result;
    }
}