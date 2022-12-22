// Time Complexity : O(n) 
// Space Complexity :O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//658. Find K Closest Elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(right - left + 1 > k){
            if(Math.abs(x - arr[left]) > Math.abs(x - arr[right])){
                left++;
            }
            else{
                right--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }
        return result;
    }
}