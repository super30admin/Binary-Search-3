// Time Complexity : O(log(n - k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null || arr.length == 0)
            return result;
        int bS = 0, bL = 0;
        int low = 0, high = arr.length - k; 
        while(low < high) {
            int mid = low + ((high - low) / 2);
            bS = x - arr[mid];
            bL = arr[mid + k] - x;
            if(bS > bL)
                low = mid + 1;
            else
                high = mid;
        }
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}