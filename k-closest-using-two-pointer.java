import java.util.*;

class Solution {
    // Two pointer solution
    // Time complexity is O(n-k)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        // Edge case
        if(arr == null || arr.length == 0) return result;
        int len = arr.length;
        int low = 0;
        int high = len -1;
        while(high- low +1 > k) {
            int distL = Math.abs(arr[low]-x);
            int distH = Math.abs(arr[high]-x);
            if(distL> distH) low++;
            else high--;
        }
        for(int i = low; i<=high; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}