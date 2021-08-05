// 658. Find K Closest Elements - https://leetcode.com/problems/find-k-closest-elements/
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if(arr == null ||  arr.length == 0) 
            return result;
        
        List<Integer> result = new ArrayList<>();
        int low =0, high = arr.length-1;
        
        while(high-low+1 > k){

            int distLeft = x - arr[low];
            int distRight = arr[high] - x;
            
            if(distLeft > distRight) 
                low++;
            else 
                high --;
        }
        
        for( int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}