// Time Complexity : O(log(n-k) + O(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int lo = 0; int hi = n - k;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            int start = x - arr[mid];
            int end = arr[mid+k] - x;
            if(start > end)
                lo = mid + 1;
            else
                hi = mid;

        }
        List<Integer> res = new ArrayList<>();
        for(int i = lo; i < lo + k; i++)
            res.add(arr[i]);
        return res;
    }
}