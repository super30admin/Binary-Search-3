// Time Complexity : O(log(n-k)) + O(k) 
// Space Complexity : O(1) auxilary list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int low = 0, high = arr.length - k - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            int sideL = x - arr[mid];
            int sideH = arr[mid + k ] - x;
            if(sideL <= sideH){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        for( int i = low; i < low + k ; i ++){
            res.add(arr[i]);
        }
        return res;
    }
}