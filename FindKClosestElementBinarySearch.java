// Time Complexity : O(log(n-k)) + O(k) where logaithmic is for the binary search and O(k) to finally collect the k elemenys
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using Binary Search. Start with low pointer as 0 and high as n - k as we want to collect k elements. Then calculate mid pointer and then startDist and endDist and accordingly move high and low pointer. Then finally collect k elements.
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        int n = arr.length;
        int low = 0;
        int high = n - k;

        List<Integer> result = new ArrayList<>();

        while(low < high){
            int mid = low + (high - low)/2; //To prevent integer overflow

            int startDist = x - arr[mid];
            int endDist = arr[mid+k] - x;

            if(startDist > endDist){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}