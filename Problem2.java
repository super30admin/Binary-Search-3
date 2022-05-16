import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    // Two pointer
    // TC : O(n-k)
    // Sc : O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            int leftVal = x - arr[left];
            int rightVal = arr[right] - x;
            if (leftVal > rightVal) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    //binary search
    // TC : O(log(n-k)) + log(k)
    // SC : O(1)
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        int left = 0;
        int right = arr.length - k ;
        while (left < right){
            int mid = left + (right-left)/2;
            int midVal = x - arr[mid];
            int highVal = arr[mid + k] - x;
            if (midVal > highVal){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        for (int i= left; i < left + k ; i ++){
            result.add(arr[i]);
        }
        return result;
    }
}
