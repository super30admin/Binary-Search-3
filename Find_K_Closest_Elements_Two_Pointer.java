// 658. Find K Closest Elements - https://leetcode.com/problems/find-k-closest-elements/
// Time complexity - O(N)
// Space complexity - O(1)
// Any problem? No
// Submitted on leetcode? Yes

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null ||  arr.length == 0) return result;
        
        int low =0, high = arr.length-1;
        
        while(high-low+1 > k){
            int distLeft = x - arr[low];
            int distRight = arr[high] - x;
            
            if(distLeft > distRight) low++;
            else high --;
        }
        
        for( int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}