// Time Complexity : O(log(n - k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//this is the range binary search approach
import java.util.*;
class findClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0)
            return result;
        
        int lo = 0;
        int hi = arr.length - k;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            //calc distance of midpoint from target
            int distLeft = x - arr[mid];
            int distRight = arr[mid + k] - x;
            
            //if left distance is greater it means the target value is after the midpoint
            if(distLeft > distRight){
                lo = mid + 1;
            }
            //if high distance is greater it means the target value is before the midpoint
            else{
                hi = mid;
            }
        }
        
        for(int i = lo; i < lo + k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}