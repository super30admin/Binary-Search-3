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

            //left should be compared first
                // because of the constraints saying if both are matching then left should get precedence
                // If we compare right to left first then else block will do left++, which is not correct
            if(distLeft > distRight){
                left++;
            }else {
                right--;
            }
        }

        for(int i=left; i < right + 1; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    // Binary search approach
    // TC: O(log n)
    //SC: O(1)
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - k;

        while(left < right) {
            int mid = left + (right - left) / 2;
            int distLeft = x - arr[mid];
            int distRight = arr[mid+k] - x;

            if(distLeft > distRight) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        for(int i=left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
