import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity : O(1)

public class FindKClosestElements {
    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int low =0;
            int high = arr.length-1;

            while(high-low +1 >k ){

                int left = x - arr[low];
                int right = arr[high] -x;

                if(left > right){
                    low++;
                }
                else
                    high--;

            }

            List<Integer> result = new ArrayList<>();

            for(int i=low; i<=high; i++){
                result.add(arr[i]);

            }

            return result;
        }
    }
}
