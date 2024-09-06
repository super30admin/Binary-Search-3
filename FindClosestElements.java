// Problem 658. Find K Closest Elements
// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        // Shrink the window to size k
        while (right - left >= k) {
            // Compare elements closer to x
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++; // Move left pointer
            } else {
                right--; // Move right pointer
            }
        }
        // Collect and return the closest k elements
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
