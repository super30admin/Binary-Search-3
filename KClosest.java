import java.util.ArrayList;
import java.util.List;

public class KClosest {

    // 2 Pointer solution
    // TC: O(n) + O(k)
    // SC: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        // This will stop as soon as we have only k element from an array
        while(right - left + 1 > k) {
            int distLeft = Math.abs(x - arr[left]);
            int distRight = Math.abs(x - arr[right]);
            if(distLeft > distRight){
                left++;
            }else {
                right--;
            }
        }

        for(int i=left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
