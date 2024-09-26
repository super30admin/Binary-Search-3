// Time Complexity : O(log(n-k)) n is array length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        if(arr == null || arr.length == 0) 
            return result;

        int low = 0; 
        int high = arr.length - k;

        while(low < high){ 

            int mid = low  + (high - low) / 2;
            int distL = Math.abs(x - arr[mid]);
            int distR = Math.abs(x - arr[mid + k]);
            if(distL > distR) 
                low = mid +1;
            else 
                high = mid;

        }  
        
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        return result;

    }

}