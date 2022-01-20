// Time Complexity : O(n-k) +O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approach

// Used two pointers
// calculated the distance from low and high
// based on the result changed low and high
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;

        int low = 0, high = arr.length - 1;
        while (high - low + 1 > k) {
            int distL = Math.abs(x - arr[low]);
            int distH = Math.abs(x - arr[high]);

            if (distL > distH) {
                low++;
            } else {
                high--;
            }
        }
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);

        }
        return result;
    }
}

// Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approach

// Used binary seaach
// found the mid and calculated the distance from mid and mid +k
// based on the result changed low and high

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;

        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int distL = x - arr[mid];
            int distH = arr[mid + k] - x;

            if (distL > distH) {
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