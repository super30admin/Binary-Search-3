/**
 * Time Complexity : O(n-k) where n= size of arr
 * Space Complexity :O(1)
 */

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr==null || arr.length==0) return result;
        int low = 0; int high = arr.length-1;
        
        while(high-low+1>k){
            int distL = Math.abs(arr[low]-x);
            int distR = Math.abs(arr[high]-x);
            if(distL>distR) low++;
            else high--;
        }
        for(int i=low;i<low+k;i++){
                result.add(arr[i]);
            }
        return result;
    }
}