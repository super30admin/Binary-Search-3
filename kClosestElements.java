// Time Complexity : O(n - k) where n is the length of the array arr
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class kClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if (arr.length < k) return ans;
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            int lDis = Math.abs(arr[left] - x);
            int rDis = Math.abs(arr[right] - x);
            if (rDis >= lDis) {
                right--;
            } else {
                left++;
            }
        }
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}