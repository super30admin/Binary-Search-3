import java.util.*;

// Time complexity: O(log(N-k)) where N is the length of the array and k is the number of closest elements to find.
// space complexity: O(1) as we are using only a constant amount of space.
public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid + k] - x < x - arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;

    }
}