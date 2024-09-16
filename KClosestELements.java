//TC: O(Logn)
//SC: O(1)
import java.util.*;

public class KClosestELements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0;
        int high = arr.length-1;
        // System.out.println(low +" "+high);
        
        //Getting the start index 
        while(high - low + 1 > k){
            int ld = Math.abs(x-arr[low]);
            int rd = Math.abs(x-arr[high]);

            if(ld > rd){
                low++;
            }
            else{
                high--;
            }   
            System.out.println(ld +" "+rd);
        } 
        
        List<Integer> y = new ArrayList<>();
        
        for(int i=low; i<low+k; i++){
            y.add(arr[i]);
        }
        
        return y;
    }
}