//Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int l = 0, r = arr.length-1;
        List<Integer> list = new ArrayList<>();

        while (r-l+1 > k) {
            int distLeft = x - arr[l];
            int distRight = arr[r] - x;
            if(distLeft > distRight) l++;
            else r--;
        }

        for(int i=l; i<l+k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
