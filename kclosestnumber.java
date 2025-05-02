// Time Complexity : O(log(n-k)+k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length - k;

        while (l < h) {
            int m = l + (h - l) / 2;
            int distS = x - arr[m];
            int distE = arr[m + k] - x;
            if (distS > distE) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int j = l; j < l + k; j++) {
            res.add(arr[j]);
        }
        return res;
    }
}