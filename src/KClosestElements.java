// Time Complexity :  brute force nlogn, using heap for optimized sorting- nlog k, 2 pointers - O(n), binary search for sorted non duplicate input- log(n-k)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * https://leetcode.com/problems/find-k-closest-elements/submissions/
 *
 *
 */
class Solution {
    
    //Approach 1: O(n) solution using two pointers to find range of k elements
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0) return result;
        
        int low = 0, high = arr.length-1;
        
        //O(n-k)
        while(high - low + 1 > k) {
            
            //move towards less distance
            int lowDiff = Math.abs(arr[low] - x);
            int highDiff = Math.abs(arr[high] - x);
            
            if(lowDiff > highDiff){
                low++;
            }else {
                high--;
            }
        }
        
        //O(k)
        for(int i= low; i< low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    
    
    
    //approach 2 log(n-k) solution for sorted array and non duplicate elements using binary search to fix the window of length k
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0) return result;
        
        // keeping high at length-k so even if low reaches high, we still have k elements on right side to complete window of k
        //elements
        int low = 0, high = arr.length - k;
        
        //range finding using binary search
       while(low < high) { //log(n-k)
           int mid = (low + (high - low))/2;
           int distL = Math.abs(arr[mid] - x);
           int distR = Math.abs(arr[mid + k] - x);
           
           if(distL > distR){
               low = mid + 1;
           }else {
               high = mid;
           }
       }
        
        //O(k)
        for(int i= low; i< low + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}