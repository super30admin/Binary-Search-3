import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

    /*
    TC : O(N + klogk)
    SC : O(N)
    leetcode : yes
    problems faced : No
     */

    /**
     * Use a min heap and all elements in the heap and remove top k elements and sort them at the end
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x));

        for (int num : arr) {
            minHeap.add(num);
        }
        List res = new ArrayList<>();
        int i = 0;
        while (k != 0) {
            res.add(minHeap.remove());
            k--;
        }
        Collections.sort(res);
        return res;
    }


    public List<Integer> findClosestElements_BinarySearch(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int distF = x - arr[mid];
            int distL = arr[mid + k] - x;

            if (distF > distL)
                low = mid + 1;
            else
                high = mid;


        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }


    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = BinarySearch(arr, x, 0, arr.length - 1);
            int right = left + 1;
            List<Integer> list = new ArrayList();
            int count = 0;
            while (left >= 0 && right < arr.length && count < k) {
                if (x - arr[left] <= arr[right] - x)
                    list.add(arr[left--]);
                else
                    list.add(arr[right++]);
                count++;
            }
            while (count < k && left >= 0) {
                list.add(arr[left--]);
                count++;
            }
            while (count < k && right < arr.length) {
                list.add(arr[right++]);
                count++;
            }
            Collections.sort(list);
            return list;
        }

        public int BinarySearch(int arr[], int key, int left, int right) {
            if (key <= arr[left])
                return left;
            if (key >= arr[right])
                return right;
            int mid = left + (right - left) / 2;
            if (mid < arr.length - 1 && key >= arr[mid] && key < arr[mid + 1])
                return mid;
            if (mid > 0 && key < arr[mid] && key >= arr[mid - 1])
                return mid - 1;
            if (key < arr[mid])
                return BinarySearch(arr, key, left, mid - 1);
            else
                return BinarySearch(arr, key, mid + 1, right);
        }
    }
}
