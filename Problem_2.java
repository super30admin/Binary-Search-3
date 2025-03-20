// Time Complexity : O(n) 
// Space Complexity :O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//658. Find K Closest Elements

// Binary Search
// TC: O(log(n - k))
// SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0 || k == 0) return result;
        int left = 0;
        int right = arr.length - k;
        while(left < right){
            int mid = left + (right - left) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        for(int i = left; i < left + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

// // 2 pointer
// // TC: O(n)
// // SC: O(1)
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> result = new ArrayList<>();
//         if(arr == null || arr.length == 0 || k == 0) return result;
//         int left = 0;
//         int right = arr.length - 1;
//         while((right - left + 1) > k){
//             if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
//                 left++;
//             }
//             else{
//                 right--;
//             }
//         }
//         for(int i = left; i <= right; i++){
//             result.add(arr[i]);
//         }
//         return result;
//     }
// }
