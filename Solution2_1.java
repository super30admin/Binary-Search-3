//Time complexity: O(log(n−k)+k), where n is the number of elements in arr.
//Space complexity: O(1)

import java.util.*;

class Solution2_1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //range binary search
        List<Integer> output = new ArrayList<>(); 
        int left = 0, right = arr.length -k;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(x - arr[mid] > arr[mid+k] - x) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        
        for(int i=left; i<left+k; i++) {
            output.add(arr[i]); 
        }
        
        return output;
    }
}
