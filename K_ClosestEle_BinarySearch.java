// 658. Find K Closest Elements - https://leetcode.com/problems/find-k-closest-elements/
// Time Complexity : O(log(N-k) +k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(arr == null ||  arr.length == 0) 
            return result;

        List<Integer> result = new ArrayList<>();

        int low =0, high = arr.length-k;
        
        while(low < high){
            int mid = low + (high-low)/2;

            int distLeft = x - arr[mid];
            int distRight = arr[mid+k] - x;
            
            if(distLeft > distRight) 
                low = mid+1;
            else 
                high = mid;
        }
        
        for( int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}