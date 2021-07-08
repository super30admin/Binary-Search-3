// Time Complexity : O(log(n - k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binarySearch3;

import java.util.*;

public class KClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        int low = 0;
        int high = arr.length - k;

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
            res.add(arr[i]);
        }
        return res;
    }

// Time Complexity : O((n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No    
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> res = new ArrayList<>();
//        if (arr == null || arr.length == 0) {
//            return res;
//        }
//        int low = 0;
//        int high = arr.length - 1;
//
//        while (high - low + 1 > k) {
//            int distL = x - arr[low];
//            int distH = arr[high] - x;
//
//            if (distL > distH) {
//                low++;
//            } else {
//                high--;
//            }
//        }
//
//        for (int i = low; i < low + k; i++) {
//            res.add(arr[i]);
//        }
//        return res;
//    }
}
