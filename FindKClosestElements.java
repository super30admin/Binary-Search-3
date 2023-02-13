public class FindKClosestElements {

// Time Complexity : O(N-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


    class TwoPointerSolution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int start = 0;
            int end = arr.length - 1;
            List<Integer> res = new ArrayList<>();
            while (end - start + 1 > k) {
                if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                    start++;
                } else {
                    end--;
                }
            }
            for (int i = start; i <= end; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

// Time Complexity : O(log(N-K))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class BinarySearchSolution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();
            int low = 0;
            int high = arr.length - k;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            for (int i = low; i < low + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
