// Time Complexity : O(N) 
// Space Complexity : O(K) result arraylist
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Add pointer and compare the difference and change the pointers
*/


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0; int high = arr.length - 1;
        
       while(high - low + 1 > k) {
           int distL = x - arr[low];
           int distH = arr[high] - x;
           if(distL > distH) {
               low++;
           } else {
               high--;
           }
       }
        for(int i=low;i<=high;i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
