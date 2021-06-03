import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result=new ArrayList<>();
        
        if(arr.length==0 || arr==null)
            return result;
        
        int low=0;
        int high=arr.length-1;
        
        while(high-low+1 > k){
            int highD = Math.abs(arr[high]-x);
            int lowD = Math.abs(arr[low]-x);
            
            if(highD<lowD){
                low++;
            }else {
                high--; 
            }
                
        }
        
        for(int i=low; i<=high;i++)
            result.add(arr[i]);
        
        return result;
    }
}
