
// approch 1
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(LOG(N-K))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {
    // approch 1 using maxHeap
    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        // customized priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // if diffrence is same we want to remove max element so we add max element
            // first
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                // else we add max diffrence first
                return b[1] - a[1];
            }
        });

        // for loop for traverse through all the nums in array
        for (int a : arr) {
            // add diffrence and corresponding element in pq
            pq.add(new int[] { a, Math.abs(a - x) });
            // if pq size is greater than k we poll from the queue
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        // add remaining element in pq in the result list
        while (!pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }
        // sort the result
        Collections.sort(result);
        return result;
    }

    // approch 2 using two pointers
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        // till window size greater than k
        while (r - l + 1 > k) {
            int diffL = Math.abs(arr[l] - x);
            int diffR = Math.abs(x - arr[r]);
            // if left diffrence is greater than the right diffrence we move left pointer or
            // move right pointer
            // here edge case is also covered if both difference is same than move right
            // pointer
            if (diffL > diffR) {
                l++;
            } else {
                r--;
            }
        }
        // add this window into result array
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // approch 3 using window with binarySearch
    // find first index of the window
    public static List<Integer> findClosestElements3(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        // right pointer should be at most possible index of the starting index
        int r = n - k;

        // while loop for finding first index
        while (l < r) {
            // find the mid
            int mid = l + (r - l) / 2;
            // find left side diff
            int diffL = x - arr[mid];
            // find right side +1 diff as we checking if bpth left and right diff is same we
            // consider left element
            int diffR = arr[mid + k] - x;
            if (diffL > diffR) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        int k = 4; // k closest element
        int x = 3; // closest to x

        System.out.println(findClosestElements1(arr, k, x));
        System.out.println(findClosestElements2(arr, k, x));
        System.out.println(findClosestElements3(arr, k, x));

    }
}