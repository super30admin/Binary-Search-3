//  Time Complexity = O(log(n - k))
//  Space Complexity = O(1)

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int distStart = x - arr[mid];
            int distEnd = arr[mid + k] - x;

            if (distStart > distEnd) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; ++i) {
            result.add(arr[i]);
        }

        return result;
    }
}
