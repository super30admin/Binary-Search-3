// TC: O(log n)
// SC:  O(1)

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int low = 0;
        int high = arr.length - k;
        while (low < high) {
            int mid = low + (high-low)/2;
            int s = x - arr[mid];
            int e = arr[mid+k] - x;

            if (s > e) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
