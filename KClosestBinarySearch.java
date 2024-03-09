import java.util.ArrayList;
import java.util.List;

// TC - O(log N)
// SC - O(1)

public class KClosestBinarySearch {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> closestElementsList = new ArrayList<>();
            int low = 0;
            int high = arr.length - k;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int startDistance = x - arr[mid];
                int endDistance = arr[mid + k] - x;
                if (startDistance > endDistance) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            for (int i = low; i < low + k; i++) {
                closestElementsList.add(arr[i]);
            }

            return closestElementsList;
        }
    }
}
