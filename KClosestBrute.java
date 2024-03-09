import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TC - O(N logN)
// SC - O(N)

public class KClosestBrute {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> closestElementsList = new ArrayList<>();

            List<Integer> auxiliaryList = new ArrayList<>();
            for (int val : arr) { // O(N)
                auxiliaryList.add(val);
            }

            Collections.sort(auxiliaryList, (a, b) -> { // O(N logN)
                return Math.abs(a - x) - Math.abs(b - x);
            });

            for (int i = 0; i < k; i++) { // O(k)
                closestElementsList.add(auxiliaryList.get(i));
            }

            Collections.sort(closestElementsList); // O(k logk)

            return closestElementsList;
        }
    }
}
