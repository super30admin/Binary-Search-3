// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Time Com: O(n)
// Space Com: O(log (n - k))
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.ArrayList;
import java.util.List;

public class findKClosestTwoBS {
    public static List<Integer> getfindKClosestTwoBS(int[] arr, int k, int x) {
        int s = 0;
        int e = arr.length - k;

        while (s < e) {
            int mid = s + (e - s) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if (distS > distE) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = s; i < s + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4; // Closest
        int x = 3; // value
        System.out.println("Output: " + getfindKClosestTwoBS(arr, k, x)); // o/p: [1, 2, 3, 4]
    }
}
