
// Time Complexity : O(n log k) where n is the number of elements in the input array and k is the number of closest elements to find.
// Space Complexity : O(k) as we are using a priority queue to store k closest elements.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This is intermdiate solution using a max heap (priority queue) to find the k closest elements to x in the input array.
// We will iterate through the input array and add elements to the priority queue based on their distance from x.
// If the size of the priority queue exceeds k, we will remove the element with the largest distance from x (the root of the max heap).
// After iterating through the array, we will have the k closest elements in the priority queue.
// We will then poll the elements from the priority queue and add them to the result list, which we will sort before returning.
import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        // Max heap: larger distance first,
        // if same distance, larger value first
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int distA = Math.abs(a - x);
                int distB = Math.abs(b - x);

                if (distA == distB) {
                    return b - a;
                }

                return distB - distA;
            }
        );

        for (int num : arr) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result);

        return result;
    }
}