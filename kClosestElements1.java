
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//this is the two pointers approach
import java.util.*;

class kClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0)
            return result;
        
        int lo = 0;
        int hi = arr.length - 1;
        
        while(hi - lo + 1 > k){
            
            //calculate distance of low and high from target element
            int distLeft = x - arr[lo];
            int distRight = arr[hi] - x;
            
            //whichever distance is bigger moves closer to target
            if(distLeft > distRight){
                lo++;
            }
            else{
                hi--;
            }
        }
        
        //k elements from low pointer are the result values
        for(int i = lo; i < lo + k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}