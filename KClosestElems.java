// Time Complexity : O(log(n-k) + k) as we are fionding the start of the range.
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int len = arr.length;
        int low = 0;
        int high = len - k;
        while(low < high)
        {
            int mid = low + (high-low)/2;

            int start_dist = x - arr[mid];
            int end_dist = arr[mid + k] - x;

            if(start_dist > end_dist)
                low = mid+1;
            else
                high = mid;
        }
        for(int i=low; i<low+k; i++)
            result.add(arr[i]);
        return result;
    }
}