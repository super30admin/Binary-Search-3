import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // return findClosestElementsUsingMaxHeap(arr, k, x);
        // return findClosestElementsUsingTwoPointers(arr, k, x);
        return findClosestElementsUsingBinarySearch(arr, k, x);
    }

    // TC: O(log (n - k)) where n is length of array
    // SC: O(1)
    private List<Integer> findClosestElementsUsingBinarySearch(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int startDist = x - arr[mid];
            int endDist = arr[mid + k] - x;
            if (startDist > endDist) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    // TC: O(n - k) where n is length of array
    // SC: O(1)
    private List<Integer> findClosestElementsUsingTwoPointers(int[] arr, int k, int x) {
        int low = 0, high = arr.length - 1;
        while (high - low >= k) {
            int lDiff = Math.abs(arr[low] - x);
            int rDiff = Math.abs(arr[high] - x);
            if (lDiff == rDiff) {
                high--;
            } else if (lDiff > rDiff) {
                low++;
            } else {
                high--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            res.add(arr[i]);
        }
        return res;
    }


    // TC: O(n log k) where n is length of array
    // SC: O(k)
    private List<Integer> findClosestElementsUsingMaxHeap(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            maxHeap.add(new int[]{i, diff});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            res.add(arr[maxHeap.poll()[0]]);
        }
        Collections.sort(res);
        return res;
    }
}
