import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 658. Find K Closest Elements
 * Link: https://leetcode.com/problems/find-k-closest-elements/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class FindKClosest {
    /**
     * Logic is to calculate the absolute distance/diff between each element and x and sort them
     * and give out first k elements. We can instead find the k elements which has the lowest diff
     * using max heap and later sort the k result values coming from max heap.
     *
     * TC: O(nlogk + klogk) SC: O(k)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distA = Math.abs(x - a);
            int distB = Math.abs(x - b);

            if (distA == distB) {
                return b - a;
            } else {
                return distB - distA;
            }
        });

        for (int num: arr) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>(pq);
        Collections.sort(result);
        return result;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class FindKClosest2 {
    /**
     * Two pointer solution - start at each end of the array and narrow the window till it is
     * k elements wide. Logic to shrink window is to calculate absolute distance of the low/high from
     * x, whichever is higher needs to move towards the other pointer. Remaining k elements are the result
     *
     * TC: O(n) SC: O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;

        while(high - low >= k) {
            int lowDistance = Math.abs(x - arr[low]);
            int highDistance = Math.abs(x - arr[high]);

            if (lowDistance > highDistance) {
                low++;
            } else {
                high--;
            }
        }

        while(low <= high) {
            result.add(arr[low]);
            low++;
        }

        return result;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class FindKClosest3 {
    /**
     * Binary Search Solution - we will apply the logic of binary search to find the matching range
     * which is our answer instead of finding one element. To execute this logic we will calculate the mid
     * for the range and consider it the starting point for the range of k elements and end will be mid + k
     * among both values at mid and mid + k which ever is more away from target x we will move that pointer/side
     * towards the other one. At the end low and high will meet the same point which will be our starting
     * point for result k elements
     *
     * TC: O(log(n-k)) SC: O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int start = low + (high - low) / 2;
            int end = start + k;
            int startDistance = x - arr[start];
            int endDistance = arr[end] - x;

            if (startDistance > endDistance) {
                low  = start + 1;
            } else {
                high = start;
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}