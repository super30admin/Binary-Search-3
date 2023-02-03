// 658. Find K Closest Elements
// Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;

        int low = 0;
        int high = arr.length-k;

        while(low < high){
            int mid = low + ((high-low)/2);
            int Ldist = x - arr[mid];
            int Rdist = arr[mid+k] -x;
            if(Ldist <= Rdist) {
                high = mid;

            }
            else {
                low = mid+1;
            }
        }
        for(int i =low; i<low+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}