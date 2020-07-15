// Time Complexity : O(n - k) --> where n is the size of input array and k is input numbers
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (658): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result; // edge case
 
        int low = 0;
        int high = arr.length - 1;
        while(high - low > k - 1) {
            int distL = Math.abs(arr[low] - x);
            int distH = Math.abs(arr[high] - x);
            if (distL > distH) low++;
            else high--;
        }
        for (int i = low; i < low + k; i++) result.add(arr[i]);
        return result;
    }
}