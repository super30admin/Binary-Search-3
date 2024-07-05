// Time Complexity : nlog(n) or O(log(n-k))+O(k) for range search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. had to learn 
/*
 * 658. Find K Closest Elements
 * 
 * Finding range is more efficient, the idea is to find the start index where the range might lie, and find it using
 * the binary search so the start will be from 0 -> n-k so binary search of start index within the range is O(log(n-k))
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * Brute force approach
 */

public class FindKClosest {
    /*
     * Most efficent; we are only concerned about the starting range.
     * Time: O(log(n-k)); Space: O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid]; // the order of the x & arr[mid] matters
            int distE = arr[mid + k] - x; // the order of the x & arr[mid+k] matters

            if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    /*
     * HeapSort O(nlogk)
     */

    public List<Integer> findClosestElements_1(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });

        for (int i : arr) {
            pq.add(new int[] { i, Math.abs(i - x) });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            result.add(temp[0]);
        }

        return result;
    }

}