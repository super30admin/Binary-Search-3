// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // return heleprPQ(arr, k, x);
        // return heleprTwoPtr(arr, k, x);
        return heleprBinarySearch(arr, k, x);
    }

    private List<Integer> heleprBinarySearch(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length - k;

        while (l < h) {
            int mid = l + (h - l) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if (distS > distE) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }

        return result;

    }

    private List<Integer> heleprTwoPtr(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (high - low >= k) {
            int distL = Math.abs(x - arr[low]);
            int distH = Math.abs(x - arr[high]);

            if (distL > distH) {
                low++;
            } else {
                high--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }

        return result;

    }

    private List<Integer> heleprPQ(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distAFromX = Math.abs(a - x);
            int distBFromX = Math.abs(b - x);
            if (distAFromX == distBFromX) {
                return b - a;
            }
            return distBFromX - distAFromX;
        });

        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}