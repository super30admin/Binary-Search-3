// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We use Binary search approach on finding start and end indices where the range of closest elements lies
//we then compare the distance of start and end indices and move low and high pointer accordingly
//when high and low cross each other we have the closest element range from low pointer to k 

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        while(low < high) {
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS <= distE) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        List<Integer> result = new ArrayList();
        for(int i = low; i < (low + k); i++) {
            result.add(arr[i]);
        }

        return result;
        
    }
}
