import java.util.ArrayList;
import java.util.List;

//Multiple approach problem. Current approach : Two Pointers
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return result;
        }

        int start = 0, end = arr.length-1;

        while(end - start + 1 > k) {

            int diffS = Math.abs(x - arr[start]);
            int diffE = Math.abs(arr[end] - x);

            if(diffS > diffE) {
                start++;
            } else {
                end--;
            }
        }

        for(int i=start; i<=end; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}