import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Approach 1 - Heap
public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    int dist1 = Math.abs(a - x);
                    int dist2 = Math.abs(b - x);

                    if (dist1 == dist2) {
                        return b - a; //higher num on top to pop it out
                    } else {
                        return dist2 - dist1; //higher dist on top to pop it out
                    }
                });

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (maxHeap.isEmpty()) {
            res.add(maxHeap.poll());
        }
        Collections.sort(res);
        return res;
    }

}

//TC: O(nlogk) + O(k log k) - for sorting ~ O(nlogk)
//SC: O(k)

//Approach 2 - Two pointers
class KClosestElements1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high] - x)) {
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
}

//TC: O(n-k) + O(k) - for copying elements to result
//SC: O(1)

//Approach - 3 : Binary Search to find the start range
class KClosestElements2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - k;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}

//TC: O(log(n-k)) + O(k) - for copying elements to result
//SC: O(1)