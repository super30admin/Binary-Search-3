// Time Complexity : O(logn + k) logn for binary search and k denotes the frame of k elements 
// Space Complexity : O(k) to store the k elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //base case
        if(arr == null || arr.length == 0)  return new ArrayList();
        
        int left = 0, right = arr.length - k, mid = 0;
        List<Integer> output = new ArrayList();
        
        while(left < right){
            mid = left + (right - left)/2;
            
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        
        while(k-- > 0){
            output.add(arr[left++]);            
        }
        
        return output;
    }
}
