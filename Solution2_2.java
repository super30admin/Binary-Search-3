//Time complexity: O(logn+k), where n is the number of elements in arr.
//Space complexity: O(1)

import java.util.*;
class Solution2_2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> output = new ArrayList<>(); 
        
        //base case
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                output.add(arr[i]);
            }
            return output;
        }
        
        
        //binary search
        int low = 0, high = arr.length-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(x > arr[mid]) low = mid+1;
            else high = mid-1; 
        }
                        
        int start = Math.max(0, low-k); 
        int end = Math.min(arr.length-1, low+k); 
        
        //two-pointers
        while(end - start + 1 > k) {
            if(x-arr[start] <= arr[end] - x) {
                end--;
            }
            else {
                start++;
            }
        }
        
        for(int i=start; i<=end; i++) {
            output.add(arr[i]);
        }
                    
        return output; 
    
    }
}