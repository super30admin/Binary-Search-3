// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length - 1;
        
        while(high - low + 1 > k){
            // find difference between x and element at low and high pointer
            int distL = Math.abs(arr[low] - x);
            int distH = Math.abs(arr[high] - x);
            
            // if low pointer's distance is more than high pointer's distance, then increment low pointer
            if(distL > distH){
                low++;
            }
            // if high pointer's distance is equal or more than low pointer's distance, then decrement high pointer
            else{
                high--;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        // traverse from low to high to get closest elements
        for(int i = low; i <= high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}