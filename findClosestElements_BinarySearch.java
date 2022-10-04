import java.util.ArrayList;
import java.util.List;

/*
## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

Time Complexity :   O(n-k) + O(k)
Space Complexity :  O(k)
Did this code successfully run on Leetcode :    Yes (658. Find K Closest Elements)
Any problem you faced while coding this :       No
 */
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]

// Binary Search approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0; 
        int high = arr.length - k;
        
        while(low < high){                   // O(log(n-k))
            int mid = (low  + high) / 2;
            int distL = x - arr[mid];
            int distR = arr[mid + k] - x;

            if ( distL > distR)
                low = mid +1;
            else 
                high = mid;
        }

        for(int i = low; i < low + k; i++){    // O(k)
            result.add(arr[i]);
        }
        return result;
    }
}