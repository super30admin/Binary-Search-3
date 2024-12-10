// time complexity : O( log (n-k) + K ) O(k)is for result list extraction and O(log(n-k) is by reducing the binary search in half 
// Space complexity: O(k) because of result list
import java.util.ArrayList;
import java.util.List;

public class kClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int n = arr.length;
        int left =0;
        int right = n - k;

        while (left < right){
            int mid = left + (right - left)/2;
            if(x - arr[mid] > arr[mid + k] - x ){
                left = mid + 1;
            } else{
                right = mid;
            }

        }
        // extract k to find the closest elements

        List<Integer> result = new ArrayList<>();
        for ( int i = left; i < left +k; i ++){
            result.add(arr[i]);

        }
        return result;

    }

    public static void main (String [] args){
        kClosestElements kce = new kClosestElements();

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(kce.findClosestElements(arr, k, x)); // Output: [1, 2, 3, 4]

        arr = new int[]{1, 1, 2, 3, 4, 5};
        k = 4; x = -1;
        System.out.println(kce.findClosestElements(arr, k, x)); // Output: [1, 2, 3, 4]

    }

}
