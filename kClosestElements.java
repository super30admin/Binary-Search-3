// Time Complexity : O(log(n-k)), where n is the length of the array and k is the number of closest elements to be returned
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Find the start index of the k closest elements using binary search
 * 2. Check the distance of x from the start and end of the k elements
 * 3. If start distance is greater than end distance, move low pointer to mid + 1, else move high pointer to mid
 * 4. Return the k elements starting from low pointer
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - k;

        while(low < high){
            int mid = low + (high - low)/2;
            int startDist = x - arr[mid];
            int endDist = arr[mid + k] - x;
            if(startDist > endDist){
                low = mid + 1;
            }else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i<low+k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}