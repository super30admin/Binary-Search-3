// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Time Com: O(n)
// Space Com: O(log n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.ArrayList;
import java.util.List;

public class findKClosestTwoPointers {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int s = 0;
        int e = arr.length - 1;

        while (e - s >= k) {
            if (Math.abs(arr[s] - x) > Math.abs(arr[e] - x)) {
                s++;
            } else {
                e--;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4; // Closest
        int x = 3; // value
        System.out.println(findClosestElements(arr, k, x)); // o/p: [1, 2, 3, 4]
    }
}
