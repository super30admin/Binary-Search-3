// Time Complexity :O(N logN) where N is the number of element
// Space Complexity :O(K) K is the number number of closest element
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        List<Integer> result = new ArrayList();
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        } 
        for(int i = left; i< left + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
