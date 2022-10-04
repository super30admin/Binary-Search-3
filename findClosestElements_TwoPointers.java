import java.util.ArrayList;
import java.util.List;

/*
## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

Time Complexity :   O(n)
Space Complexity :  O(k)
Did this code successfully run on Leetcode :    Yes (658. Find K Closest Elements)
Any problem you faced while coding this :       No
 */
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]

// Two Pointer approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length - 1;
        
        while(high - low + 1 > k){
            int distL = Math.abs(x - arr[low]);
            int distR = Math.abs(arr[high] - x);
            
            if(distL > distR){
                low++;
            }else{
                high--;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=low; i<=high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}