//time complexity- O(log(n-k))

//space complexity- O(1)
import java.util.*;
public class FindKClosestElements {
    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;

        while(low < high) {
            int mid = low + (high - low) /2;
            int start = x - arr[mid];
            int end = arr[mid + k] - x;

            if(start > end) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for(int i = low; i < low+k; i++) {
            li.add(arr[i]);
        }

        return li;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5};
        int k = 4;
        int x = -1;

        System.out.println(findClosestElements(arr, k, x));
    }
}
