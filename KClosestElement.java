// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Binary Search Initialization: The search range is defined from 0 to n - k to find the starting index of the k closest elements.
//Binary Search Loop: Use binary search to find the smallest index such that the subarray of length k starting at that index has the smallest possible difference with x.
//Result Construction: After finding the starting index, construct the result list with the k closest elements.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int n = arr.length;
        int low = 0;
        int high = n - k;
        List<Integer> result = new ArrayList<>();

        while (low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
