package Nov30;

import java.util.ArrayList;
import java.util.List;

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        Time complexity: O(n-k) ~= O(n) solution
        Space complexity: O(1) because no extra space used.
        Approach: Two pointer approach used.
        */
        List<Integer> result = new ArrayList<>();
        
        // edge
        if (arr == null || arr.length == 0) {
            return result;
        }
        
        int low = 0;
        int high = arr.length-1;
        
        // loop runs till the no.of elements between high and low are at least equal to k because only then we can get k no.of elements 
        while (high-low >= k) {
            
            int distOfLowFromX = Math.abs(arr[low] - x);
            int distOfHighFromX = Math.abs(arr[high] - x);
            // Pointer for the array element which is closer to X needs to be retained as is. Only the pointer for array element farther from X needs to be moved by one position.
            if (distOfLowFromX > distOfHighFromX) {
                low++;
            } else {
                high--;
            }
            
        }
        
        // now low and high pointers are at the correct positions of the range of k no.of elements which are closest to x, so just add them to result list
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }
        
        return result;
        
    }
}