// Time Complexity : O(log N - k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class findKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        //set bounds
        int low  = 0;
        int high = arr.length - k;
        
        //binary search
        while(low < high) {
            int mid = (low + high) / 2;
            
            if(x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            }
            else
                high = mid;
        }
        
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        
        return result;
        
    }
}
