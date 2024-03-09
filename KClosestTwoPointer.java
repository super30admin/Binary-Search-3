import java.util.ArrayList;
import java.util.List;

// TC - O(N)
// SC - O(1)

public class KClosestTwoPointer {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> closestElementsList = new ArrayList<>();
            int low = 0;
            int high = arr.length - 1;
            while (low < high && high - low >= k) {
                int lowDistance = Math.abs(arr[low] - x);
                int highDistance = Math.abs(arr[high] - x);
                if (lowDistance > highDistance) {
                    low++;
                } else {
                    high--;
                }
            }

            for (int i = low; i <= high; i++) {
                closestElementsList.add(arr[i]);
            }

            return closestElementsList;
        }
    }
}