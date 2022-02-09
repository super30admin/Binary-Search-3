import java.util.ArrayList;
import java.util.List;
    /*
         // Time Complexity : O(2^n)
         // Space Complexity : O(n)
    */

public class findClosestElements {
    class Solution {
        //Finding the low of range
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int low = 0;
            int high = arr.length - k;

            while(low<high) {
                int mid=low+(high-low)/2;
                if((x-arr[mid]) > (arr[mid+k]-x)) {
                    low= mid+1;
                }
                else {
                    high = mid;
                }
            }
            ArrayList<Integer> lists =new ArrayList<>();
            for(int i=low; i<low+k;i++){
                lists.add(arr[i]);
            }
            return lists;
        }
    }
}
