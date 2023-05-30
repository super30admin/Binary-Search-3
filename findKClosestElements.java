// Time Complexity : O(log(n) + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a binary search to find the starting point of the subset that we want.
 * Once the starting point is found (via finding the difference and then moving
 * left or right based on how small the difference is), we add the k elements
 * from that point to the result list.
 */

import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int low = 0, high = arr.length - k;

        // binary search for the starting of the subset
        while(low < high) {
            int mid = low + (high - low) / 2; // prevent overflow
            int sdiff = x - arr[mid]; // diff of x with start of subset
            int ediff = arr[mid+k] - x; // diff of x with end of subset

            if(sdiff > ediff) { // starting is farther than ending
                low = mid+1;
            } else {
                high = mid; // otherwise starting is closer than ending, and don't skip last value
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=low; i<low+k; i++) { // finally, add all elements
            res.add(arr[i]);
        }

        return res;
    }
}
