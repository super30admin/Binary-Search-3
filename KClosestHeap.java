import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// TC - O(N logk)
// SC - O(k)

public class KClosestHeap {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> closestElementsList = new ArrayList<>();
            Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
                if (Math.abs(arr[a] - x) == Math.abs(arr[b] - x)) {
                    return b - a; // Sort in order of indices - Descending for max heap
                }
                return Math.abs(arr[b] - x) - Math.abs(arr[a] - x); // Sort by distance from x - Descending for max heap
            });

            for (int i = 0; i < arr.length; i++) {
                maxHeap.add(i);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }

            while (!maxHeap.isEmpty()) {
                closestElementsList.add(arr[maxHeap.poll()]);
            }

            Collections.sort(closestElementsList);

            return closestElementsList;
        }
    }
}
