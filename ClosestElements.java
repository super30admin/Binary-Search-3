
// Time Complexity : O(log(n-k)+k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Binary Search
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if (distS > distE) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

